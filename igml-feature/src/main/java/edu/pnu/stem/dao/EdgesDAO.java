package edu.pnu.stem.dao;


import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import edu.pnu.stem.binder.IndoorGMLMap;
import edu.pnu.stem.feature.core.CellSpace;
import edu.pnu.stem.feature.core.Edges;
import edu.pnu.stem.feature.core.SpaceLayer;
import edu.pnu.stem.feature.core.State;
import edu.pnu.stem.feature.core.Transition;


public class EdgesDAO {

	public static Edges createEdges(IndoorGMLMap map, String parentId, String id, String name, String description, List<String>transitionMember){
		
		if(id == null) {
			id = UUID.randomUUID().toString();
		}
		
		Edges newFeature = new Edges(map, id);
		
		if(map.hasFutureID(id)){
			newFeature = (Edges)map.getFutureFeature(id);
		}
		
		map.setFutureFeature(id, newFeature);
		
		List<Transition> tm = newFeature.getTransitionMember();
		if(tm == null)
			tm = new ArrayList<Transition>();
		
		SpaceLayer parent = (SpaceLayer) map.getFeature(parentId);
		if(parent == null){
			if(map.hasFutureID(parentId)){
				parent = (SpaceLayer)map.getFutureFeature(parentId);
			}
			else{
				parent = new SpaceLayer(map,parentId);
			}
		}
		
		
		if(name != null) {
			newFeature.setName(name);
		}
		
		if(description != null) {
			newFeature.setDescription(description);
		}
		
		if(transitionMember != null) {
			for(String ti : transitionMember) {
				tm.add(new Transition(map, ti));
			}
			newFeature.setTransitionMembers(tm);
		}
		List<Edges>edges = parent.getEdges();
		if(edges == null)
			edges = new ArrayList<Edges>();
		
		edges.add(newFeature);
		
		parent.setEdges(edges);
		newFeature.setParent(parent);		
		map.removeFutureID(id);
		map.setFeature(id, "Edges", newFeature);
		
		return newFeature;
	}
	
	public static Edges readEdges(IndoorGMLMap map, String id) {
		Edges target = null;
		try {
			target = (Edges)map.getFeature(id);
		}
		catch(NullPointerException e){
			e.printStackTrace();
		}
		return target;
	}
	
	public static Edges updateEdges(IndoorGMLMap map, String parentId, String id, String name, String description, List<String>transitionMember) {
		Edges result = new Edges(map, id);
		Edges target = (Edges)map.getFeature(id);
		
		SpaceLayer parent = target.getParent();
		
		if(!parent.getId().equals(parentId)) {
			SpaceLayer newParent = (SpaceLayer)map.getFeature(parentId);
			if(newParent == null)
				newParent = new SpaceLayer(map, parentId);
			parent.deleteEdges(target);
			result.setParent(newParent);
		}
		
		result.setParent(parent);
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
			
			if(oldChild != null) {
				for(Transition s : oldChild) {
					if(!newChild.contains(s)) {
						oldChild.remove(s);
					}
				}
			}
			else
				oldChild = new ArrayList<Transition>();
			
						
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
			if(target.getTransitionMember()!= null && target.getTransitionMember().size() != 0) {
				for(Transition child : target.getTransitionMember()) {
					child.resetParent();
				}
			}
		}
		
		map.removeFeature(id);
		map.setFeature(id, "Edges", result);
		
		return result;
		
	}
	
	public static void deleteEdges(IndoorGMLMap map, String id) {
		Edges target = (Edges)map.getFeature(id);
		SpaceLayer parent = target.getParent();
		
		parent.deleteEdges(target);
		
		for(Transition t : target.getTransitionMember()) {
			t.resetParent();
		}
		
		map.removeFeature(id);
		
	}
}	
