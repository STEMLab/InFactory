package edu.pnu.stem.dao;


import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import edu.pnu.stem.binder.IndoorGMLMap;
import edu.pnu.stem.feature.Nodes;
import edu.pnu.stem.feature.SpaceLayer;
import edu.pnu.stem.feature.State;


public class NodesDAO {
	
	public static Nodes readNodes(IndoorGMLMap map, String id) {
		Nodes target = null;
		try {
			target = (Nodes)map.getFeature(id);
		}
		catch(NullPointerException e){
			e.printStackTrace();
		}
		return target;
	}
	
	public static Nodes createNodes(IndoorGMLMap map, String parentId, String id, String name, String description, List<String> stateMember){
		if(id == null) {
			id = UUID.randomUUID().toString();
		}
		Nodes newFeature = new Nodes(map, id);
		
		List<State>sm = new ArrayList<State>();
		SpaceLayer parent = (SpaceLayer) map.getFeature(parentId);
		parent.addNodes(newFeature);
		
		if(name != null) {
			newFeature.setName(name);
		}
		
		if(description != null) {
			newFeature.setDescription(description);
		}
		
		if(stateMember != null) {
			for(String si : stateMember) {
				sm.add(new State(map, si));
			}
			newFeature.setStateMember(sm);
		}
		
		map.setFeature(id, "Nodes", newFeature);
		return newFeature;
	}

	public static Nodes updateNodes(IndoorGMLMap map, String parentId, String id, String name, String description, List<String>stateMembers) {
		Nodes result = new Nodes(map, id);
		Nodes target = (Nodes)map.getFeature(id);
		
		SpaceLayer parent = target.getParent();
		if(parent.getId() != parentId) {
			SpaceLayer newParent = new SpaceLayer(map, parentId);
			parent.deleteNodes(target);
			result.setParent(newParent);
		}
		
		
		if(name != null) {
			result.setName(name);
		}
	
		
		if(description != null) {
			result.setDescription(description);
		}
		
		if(stateMembers != null) {
			List<State> oldChild = target.getStateMember();
			List<State> newChild = new ArrayList<State>();
			
		
			for(String si : stateMembers) {
				newChild.add(new State(map, si));
			}
			
			for(State s : oldChild) {
				if(!newChild.contains(s)) {
					oldChild.remove(s);
				}
			}
			
			for(State s : newChild) {
				if(!oldChild.contains(s)) {
					oldChild.add(s);
				}
			}
							
			result.setStateMember(oldChild);
					
		}
		else {
			if(target.getStateMember().size() != 0) {
				List<State> oldChild = target.getStateMember();
				for(State child : oldChild) {
					child.resetParent();
				}
			}
		}
		
		map.getFeatureContainer("Nodes").remove(id);
		map.getFeatureContainer("Nodes").put(id, result);
		
		return result;
		
	}
	public void deleteNodes(IndoorGMLMap map, String id) {
		Nodes target = (Nodes)map.getFeature(id);
		SpaceLayer parent = target.getParent();
		parent.deleteNodes(target);
		
		for(State s : target.getStateMember()) {
			s.resetParent();
		}
		
		map.removeFeature(id);
		
	}
}
