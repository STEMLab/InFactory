package edu.pnu.stem.dao;


import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import edu.pnu.stem.binder.IndoorGMLMap;
import edu.pnu.stem.feature.Edges;
import edu.pnu.stem.feature.SpaceLayer;
import edu.pnu.stem.feature.State;
import edu.pnu.stem.feature.Transition;


public class EdgesDAO {

	public static Edges createEdges(IndoorGMLMap map, String parentId, String id){
		if(id == null) {
			id = UUID.randomUUID().toString();
		}
		
		Edges newFeature = null;
		
		if(map.hasFutureID(id)){
			newFeature = (Edges)map.getFeature(id);
			map.removeFutureID(id);
		}
		else{
			newFeature = new Edges(map, id);
		}
		
		SpaceLayer parent = null;
		
		if(map.hasFutureID(parentId)){
			parent = (SpaceLayer)map.getFutureFeature(parentId);
			//map.removeFutureID(parentId);
		}
		else{
			parent = (SpaceLayer) map.getFeature(parentId);
		}
		
		parent.addEdges(newFeature);
		newFeature.setParent(parent);		
		map.setFeature(id, "Edges", newFeature);
		
		return newFeature;
	}
	
	public static Edges updateEdges(IndoorGMLMap map, String parentId, String id, String name, String description, List<String>transitionMember) {
		Edges result = new Edges(map, id);
		Edges target = (Edges)map.getFeature(id);
		
		SpaceLayer parent = target.getParent();
		if(parent.getId() != parentId) {
			SpaceLayer newParent = new SpaceLayer(map, parentId);
			parent.deleteEdges(target);
			result.setParent(newParent);
		}
		
		
		if(name != null) {
			result.setName(name);
		}
	
		
		if(description != null) {
			result.setDescription(description);
		}
		
		if(transitionMember != null) {
			List<Transition> oldChild = target.getTransitionMember();
			List<Transition> newChild = new ArrayList<Transition>();
			
			for(String si : transitionMember) {
				newChild.add(new Transition(map, si));
			}
			
			for(Transition s : oldChild) {
				if(!newChild.contains(s)) {
					oldChild.remove(s);
				}
			}
			
			for(Transition s : newChild) {
				if(!oldChild.contains(s)) {
					oldChild.add(s);
				}
			}
						
			for(Transition s : oldChild) {
				result.setTransitionMembers(oldChild);
			}
			
		}
		else {
			if(target.getTransitionMember().size() != 0) {
				for(Transition child : target.getTransitionMember()) {
					child.resetParent();
				}
			}
		}
		
		map.getFeatureContainer("Edges").remove(id);
		map.getFeatureContainer("Edges").put(id, result);
		
		return result;
		
	}
}	
