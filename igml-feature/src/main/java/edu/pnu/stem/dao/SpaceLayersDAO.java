package edu.pnu.stem.dao;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import edu.pnu.stem.binder.IndoorGMLMap;
import edu.pnu.stem.feature.core.MultiLayeredGraph;
import edu.pnu.stem.feature.core.Nodes;
import edu.pnu.stem.feature.core.SpaceLayer;
import edu.pnu.stem.feature.core.SpaceLayers;

public class SpaceLayersDAO {
	
	public static SpaceLayers createSpaceLayers(IndoorGMLMap map, String parentId, String id, String name, String description, List<String>spaceLayerMember) {
		if(id == null) {
			id = UUID.randomUUID().toString();
		}
		SpaceLayers newFeature = new SpaceLayers(map, id);
		
		
		if(map.hasFutureID(id)){
			newFeature = (SpaceLayers)map.getFutureFeature(id);
		}
		else{
			map.setFutureFeature(id, newFeature);
		}
		map.setFeature(id, "SpaceLayers", newFeature);
		
		List<SpaceLayer> sl = newFeature.getSpaceLayerMember();
		if(sl == null)
			sl = new ArrayList<SpaceLayer>();
		
		MultiLayeredGraph parent = (MultiLayeredGraph) map.getFeature(parentId);
		if(parent == null){
			if(map.hasFutureID(parentId)){
				parent = (MultiLayeredGraph)map.getFutureFeature(parentId);
			}
			else{
				parent = new MultiLayeredGraph(map,parentId);
			}
		}
		
		if(name != null) {
			newFeature.setName(name);
		}
		
		if(description != null) {
			newFeature.setDescription(description);
		}
		
		if(spaceLayerMember != null) {
			for(String sli : spaceLayerMember) {
				sl.add(new SpaceLayer(map, sli));
			}
			newFeature.setSpaceLayerMember(sl);
		}
		
		List<SpaceLayers> spaceLayers = parent.getSpaceLayers();
		if(spaceLayers == null) {
			spaceLayers = new ArrayList<SpaceLayers>();
		}
		spaceLayers.add(newFeature);
		parent.setSpaceLayers(spaceLayers);
		newFeature.setParent(parent);
		
		map.removeFutureID(id);
		
		return newFeature;
	}
	public static  SpaceLayers readSpaceLayers(IndoorGMLMap map, String id) {
		 SpaceLayers target = null;
		try {
			target = ( SpaceLayers)map.getFeature(id);
		}
		catch(NullPointerException e){
			e.printStackTrace();
		}
		return target;
	}
	public static SpaceLayers updateSpaceLayers(IndoorGMLMap map, String parentId, String id, String name, String description, List<String>spacelayer) {
		SpaceLayers result = new SpaceLayers(map, id);
		SpaceLayers target = (SpaceLayers)map.getFeature(id);
		
		MultiLayeredGraph parent = target.getParent();
		
	
		if(!parent.getId().equals(parentId)) {
			MultiLayeredGraph newParent = (MultiLayeredGraph) map.getFeature(parentId);
			if(newParent == null)
				newParent = new MultiLayeredGraph(map, parentId);
			parent.deleteSpaceLayers(target);
			result.setParent(newParent);
		}
		result.setParent(parent);
		
		if(name != null) {
			result.setName(name);
		}
	
		
		if(description != null) {
			result.setDescription(description);
		}
		
		if(spacelayer != null) {
			List<SpaceLayer> oldChild = target.getSpaceLayerMember();
			List<SpaceLayer> newChild = new ArrayList<SpaceLayer>();
			
			for(String ni : spacelayer) {
				newChild.add(new SpaceLayer(map,ni));
			}
			
			if(oldChild != null) {
				for(SpaceLayer n : oldChild) {
					if(!newChild.contains(n)) {
						oldChild.remove(n);
					}
				}
			}
			else {
				oldChild = new ArrayList<SpaceLayer>();
			}
			
			
			for(SpaceLayer n : newChild) {
				if(!oldChild.contains(n)) {
					oldChild.add(n);
				}
			}
			
			result.setSpaceLayerMember(oldChild);
		}
		else {
			if(target.getSpaceLayerMember() != null && target.getSpaceLayerMember().size() != 0) {
				for(SpaceLayer s : target.getSpaceLayerMember()) {
					s.resetParent();
				}
			}
		}
		
		map.removeFeature(id);
		map.setFeature(id, "SpaceLayers", result);
		
		return result;
	}
	
	public static void deleteSpaceLayers(IndoorGMLMap map, String id) {
		SpaceLayers target = (SpaceLayers)map.getFeature(id);
		MultiLayeredGraph parent = target.getParent();
		
		parent.deleteSpaceLayers(target);
		
		for(SpaceLayer s : target.getSpaceLayerMember()) {
			s.resetParent();
		}
		
		map.removeFeature(id);
	}
}
