package edu.pnu.stem.dao;


import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import edu.pnu.stem.binder.IndoorGMLMap;
import edu.pnu.stem.feature.Edges;
import edu.pnu.stem.feature.Nodes;
import edu.pnu.stem.feature.SpaceLayer;
import edu.pnu.stem.feature.SpaceLayers;


public class SpaceLayerDAO {
	
	public static SpaceLayer createSpaceLayer(IndoorGMLMap map, String parentId, String id, String name, String description, List<String>nodes, List<String>edges) {
		if(id == null) {
			id = UUID.randomUUID().toString();
		}
		
		SpaceLayer newFeature = new SpaceLayer(map, id);
		List<Nodes> nl = new ArrayList<Nodes>();
		List<Edges> el = new ArrayList<Edges>();
		
		if(map.hasFutureID(id)){
			newFeature = (SpaceLayer)map.getFutureFeature(id);
		}
		else{
			map.setFutureFeature(id, newFeature);
		}
		map.setFeature(id, "SpaceLayer", newFeature);
		SpaceLayers parent = (SpaceLayers) map.getFeature(parentId);
		
		if(parent == null){
			if(map.hasFutureID(parentId)){
				parent = (SpaceLayers)map.getFutureFeature(parentId);
				//map.removeFutureID(parentId);
			}
			else{
				parent = new SpaceLayers(map, parentId);
			}
		}
		
		if(name != null) {
			newFeature.setName(name);
		}
		
		if(description != null) {
			newFeature.setDescription(description);
		}
		
		if(nodes != null) {
			for(String ni : nodes) {
				nl.add(new Nodes(map, ni));
			}
			newFeature.setNodes(nl);
		}
		if(edges != null) {
			for(String ei : edges) {
				el.add(new Edges(map, ei));
			}
			newFeature.setEdges(el);
		}
		
		ArrayList<SpaceLayer> spaceLayerMember = new ArrayList<SpaceLayer>();
		spaceLayerMember.add(newFeature);
		parent.setSpaceLayerMember(spaceLayerMember);
		newFeature.setParent(parent);
		
		map.removeFutureID(id);
		return newFeature;
	}
	public static SpaceLayer readSpaceLayer(IndoorGMLMap map, String id) {
		SpaceLayer target = null;
		try {
			target = (SpaceLayer)map.getFeature(id);
		}
		catch(NullPointerException e){
			e.printStackTrace();
		}
		return target;
	}
	public static SpaceLayer updateSpaceLayer(IndoorGMLMap map, String parentId, String id, String name, String description, List<String> nodes, List<String> edges) {
		SpaceLayer result = new SpaceLayer(map, id);
		SpaceLayer target = (SpaceLayer)map.getFeature(id);
		
		SpaceLayers parent = target.getParent();
		if(parent.getId() != parentId) {
			SpaceLayers newParent = new SpaceLayers(map, parentId);
			parent.deleteSpaceLayer(target);
			result.setParent(newParent);
		}
		
		
		if(name != null) {
			result.setName(name);
		}
	
		
		if(description != null) {
			result.setDescription(description);
		}
		
		if(nodes != null) {
			List<Nodes> oldChild = target.getNodes();
			List<Nodes> newChild = new ArrayList<Nodes>();
			
			for(String ni : nodes) {
				newChild.add(new Nodes(map,ni));
			}
			
			for(Nodes n : oldChild) {
				if(!newChild.contains(n)) {
					oldChild.remove(n);
				}
			}
			
			for(Nodes n : newChild) {
				if(!oldChild.contains(n)) {
					oldChild.add(n);
				}
			}
			
			result.setNodes(oldChild);
			
		}
		else {
			if(target.getNodes().size() != 0) {
				List<Nodes> oldChild = target.getNodes();
				
				for(Nodes child : oldChild) {
					child.resetParent();
				}
			}
		}
		
		if(edges != null) {
			List<Edges> oldChild = target.getEdges();
			List<Edges> newChild = new ArrayList<Edges>();
			
			
			for(String ei : edges) {
				newChild.add(new Edges(map,ei));
			}
			
			for(Edges n : oldChild) {
				if(!newChild.contains(n)) {
					oldChild.remove(n);
				}
			}
			
			for(Edges n : newChild) {
				if(!oldChild.contains(n)) {
					oldChild.add(n);
				}
			}

			
			result.setEdges(oldChild);
		}
		else {
			if(target.getEdges().size() != 0) {
				List<Edges> oldChild = target.getEdges();
				
				for(Edges child : oldChild) {
					child.resetParent();
				}
			}
		}
		
		map.getFeatureContainer("SpaceLayer").remove(id);
		map.getFeatureContainer("SpaceLayer").put(id, result);
		
		return result;
		
	}
	
	public static void deleteSpaceLayer(IndoorGMLMap map, String id) {
		SpaceLayer target = (SpaceLayer)map.getFeature(id);
		SpaceLayers parent = target.getParent();
		
		parent.deleteSpaceLayer(target);
		
		for(Nodes n : target.getNodes()) {
			n.resetParent();
		}
		for(Edges e : target.getEdges()) {
			e.resetParent();
		}
		
		map.removeFeature(id);
	}

}
