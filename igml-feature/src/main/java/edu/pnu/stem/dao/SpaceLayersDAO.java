package edu.pnu.stem.dao;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import edu.pnu.stem.binder.IndoorGMLMap;
import edu.pnu.stem.feature.MultiLayeredGraph;
import edu.pnu.stem.feature.Nodes;
import edu.pnu.stem.feature.SpaceLayer;
import edu.pnu.stem.feature.SpaceLayers;

public class SpaceLayersDAO {
	
	public static SpaceLayers createSpaceLayers(IndoorGMLMap map, String parentId, String id) {
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
		
		MultiLayeredGraph parent = (MultiLayeredGraph) map.getFeature(parentId);
		if(parent == null){
			if(map.hasFutureID(parentId)){
				parent = (MultiLayeredGraph)map.getFutureFeature(parentId);
			}
			else{
				parent = new MultiLayeredGraph(map,parentId);
			}
		}
		
		ArrayList<SpaceLayers> spaceLayers = new ArrayList<SpaceLayers>();
		spaceLayers.add(newFeature);
		parent.setSpaceLayers(spaceLayers);
		newFeature.setParent(parent);
		
		map.removeFutureID(id);
		
		return newFeature;
	}
	
	public static SpaceLayers updateSpaceLayers(IndoorGMLMap map, String parentId, String id, String name, String description, List<String>spacelayer) {
		SpaceLayers result = new SpaceLayers(map, id);
		SpaceLayers target = (SpaceLayers)map.getFeature(id);
		
		MultiLayeredGraph parent = target.getParent();
		if(parent.getId() != parentId) {
			MultiLayeredGraph newParent = new MultiLayeredGraph(map, parentId);
			parent.deleteSpaceLayers(target);
			result.setParent(newParent);
		}
		
		
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
			
			for(SpaceLayer n : oldChild) {
				if(!newChild.contains(n)) {
					oldChild.remove(n);
				}
			}
			
			for(SpaceLayer n : newChild) {
				if(!oldChild.contains(n)) {
					oldChild.add(n);
				}
			}
			
			result.setSpaceLayerMember(oldChild);
		}
		else {
			if(target.getSpaceLayerMember().size() != 0) {
				for(SpaceLayer s : target.getSpaceLayerMember()) {
					s.resetParent();
				}
			}
		}
		
		return result;
	}
}
