package edu.pnu.stem.dao;


import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import edu.pnu.stem.binder.IndoorGMLMap;
import edu.pnu.stem.feature.CellSpace;
import edu.pnu.stem.feature.Edges;
import edu.pnu.stem.feature.IndoorFeatures;
import edu.pnu.stem.feature.InterEdges;
import edu.pnu.stem.feature.MultiLayeredGraph;
import edu.pnu.stem.feature.SpaceLayers;



public class MultiLayeredGraphDAO {

	public static MultiLayeredGraph createMultiLayeredGraph(IndoorGMLMap map, String parentId, String id, String name, String description, List<String>spaceLayers, List<String> interEdges) {
		if(id == null) {
			id = UUID.randomUUID().toString();
		}
		
		MultiLayeredGraph newFeature = (MultiLayeredGraph) map.getFutureFeature(id);
		if(newFeature == null){
			//newFeature = new MultiLayeredGraph(map, id);
			if(map.hasFutureID(id)){
				newFeature = (MultiLayeredGraph)map.getFutureFeature(id);
				//map.removeFutureID(id);
			}
			else{
				newFeature = new MultiLayeredGraph(map,id);
				map.setFutureFeature(id, newFeature);
			}
		}
		
		map.setFutureFeature(id, newFeature);
		map.setFeature(id, "MultiLayeredGraph", newFeature);
		
		IndoorFeatures parent = (IndoorFeatures) map.getFeature(parentId);
		List<SpaceLayers> sls = new ArrayList<SpaceLayers>();
		List<InterEdges> iel = new ArrayList<InterEdges>();
		
		if(parent == null){
			if(map.hasFutureID(parentId)){
				parent = (IndoorFeatures)map.getFutureFeature(parentId);
			}
			else{
				parent = new IndoorFeatures(map,parentId);
			}
		}		
		
		if(name != null) {
			newFeature.setName(name);
		}
		
		if(description != null) {
			newFeature.setDescription(description);
		}
		
		if(spaceLayers != null) {
			for(String si : spaceLayers) {
				sls.add(new SpaceLayers(map, si));
			}
			newFeature.setSpaceLayers(sls);
		}
		
		if(interEdges != null) {
			for(String ii : interEdges) {
				iel.add(new InterEdges(map, ii));
			}
			newFeature.setInterEdges(iel);
		}
		
		parent.setMultiLayeredGraph(newFeature);
		newFeature.setParent(parent);
		map.removeFutureID(id);

		return newFeature;
	}
	
	public static MultiLayeredGraph readMultiLayeredGraph(IndoorGMLMap map, String id) {
		MultiLayeredGraph target = null;
		try {
			target = (MultiLayeredGraph)map.getFeature(id);
		}
		catch(NullPointerException e){
			e.printStackTrace();
		}
		return target;
	}
	
	public static MultiLayeredGraph updateMultiLayeredGraph(IndoorGMLMap map, String parentId, String id, String name, String description, List<String>spacelayers, List<String>interedges) {
		MultiLayeredGraph result = new MultiLayeredGraph(map, id);
		MultiLayeredGraph target = (MultiLayeredGraph)map.getFeature(id);
		
		IndoorFeatures parent = target.getParent();
		if(parent.getId() != parentId) {
			IndoorFeatures newParent = new IndoorFeatures(map, parentId);
			parent.resetMultiLayerdGraph();
			result.setParent(newParent);
		}
		
		
		if(name != null) {
			result.setName(name);
		}
	
		
		if(description != null) {
			result.setDescription(description);
		}
		
		if(spacelayers != null) {
			List<SpaceLayers> oldChild = target.getSpaceLayers();
			List<SpaceLayers> newChild = new ArrayList<SpaceLayers>();
			
			for(String ni : spacelayers) {
				newChild.add(new SpaceLayers(map,ni));
			}
			
			for(SpaceLayers n : oldChild) {
				if(!newChild.contains(n)) {
					oldChild.remove(n);
				}
			}
			
			for(SpaceLayers n : newChild) {
				if(!oldChild.contains(n)) {
					oldChild.add(n);
				}
			}
			
			result.setSpaceLayers(oldChild);
			
		}
		else {
			if(target.getSpaceLayers().size() != 0) {
				List<SpaceLayers> oldChild = target.getSpaceLayers();
				
				for(SpaceLayers child : oldChild) {
					child.resetParent();
				}
			}
		}
		
		if(interedges != null) {
			List<InterEdges> oldChild = target.getInterEdges();
			List<InterEdges> newChild = new ArrayList<InterEdges>();
			
			
			for(String ei :	interedges) {
				newChild.add(new InterEdges(map,ei));
			}
			
			for(InterEdges n : oldChild) {
				if(!newChild.contains(n)) {
					oldChild.remove(n);
				}
			}
			
			for(InterEdges n : newChild) {
				if(!oldChild.contains(n)) {
					oldChild.add(n);
				}
			}

			
			result.setInterEdges(oldChild);
		}
		else {
			if(target.getInterEdges().size() != 0) {
				List<InterEdges> oldChild = target.getInterEdges();
				
				for(InterEdges child : oldChild) {
					child.resetParent();
				}
			}
		}
		
		map.getFeatureContainer("SpaceLayer").remove(id);
		map.getFeatureContainer("SpaceLayer").put(id, result);
		
		return result;
	}
	
	public static void deleteMultiLayeredGraph(IndoorGMLMap map, String id) {
		MultiLayeredGraph target = (MultiLayeredGraph)map.getFeature(id);
		IndoorFeatures parent = target.getParent();
		
		parent.deleteMultiLayeredGraph(target);

		for(SpaceLayers s : target.getSpaceLayers()) {
			s.resetParent();
		}
		
		for(InterEdges i : target.getInterEdges())
			i.resetParent();
		
		map.removeFeature(id);
		
	}
}
