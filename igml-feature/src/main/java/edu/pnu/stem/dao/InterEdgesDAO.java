package edu.pnu.stem.dao;
import java.util.ArrayList;
import java.util.List;

import edu.pnu.stem.binder.IndoorGMLMap;
import edu.pnu.stem.feature.CellSpace;
import edu.pnu.stem.feature.InterEdges;
import edu.pnu.stem.feature.InterLayerConnection;
import edu.pnu.stem.feature.MultiLayeredGraph;
import edu.pnu.stem.feature.SpaceLayer;

public class InterEdgesDAO {
	public static InterEdges createInterEdges(IndoorGMLMap map, String parentId, String id, List<String>interLayerConnectionMember){
		InterEdges newFeature = new InterEdges(map, id);
		
		MultiLayeredGraph parent = (MultiLayeredGraph) map.getFeature(parentId);
		parent.addInterEdges(newFeature);
		newFeature.setParent(parent);
		
		if(interLayerConnectionMember != null){
			List<InterLayerConnection>tempList = new ArrayList<InterLayerConnection>();
			for(int i = 0 ; i < interLayerConnectionMember.size() ; i++){
				InterLayerConnection temp = new InterLayerConnection(map, interLayerConnectionMember.get(i));
				tempList.add(temp);
			}
			newFeature.setInterLayerConnectionMember(tempList);
		}
		else{
			System.out.println("Error at createInterEdges : there is no InterLayerConnectionMember");
		}
		map.setFeature(id, "InterEdges", newFeature);
	
		return newFeature;
	}
	public static InterEdges readInterEdges(IndoorGMLMap map, String id) {
		InterEdges target = null;
		try {
			target = (InterEdges)map.getFeature(id);
		}
		catch(NullPointerException e){
			e.printStackTrace();
		}
		return target;
	}
	public static InterEdges updateInterEdges(IndoorGMLMap map, String parentId, String id, String name, String description,List<String>interLayerConnectionMember) {
		InterEdges result = new InterEdges(map, id);
		InterEdges target = (InterEdges)map.getFeature(id);
		
		MultiLayeredGraph parent = target.getParent();
		if(parent.getId() != parentId) {
			MultiLayeredGraph newParent = new MultiLayeredGraph(map, parentId);
			parent.deleteInterEdges(target);
			result.setParent(newParent);
		}
		
		
		if(name != null) {
			result.setName(name);
		}
	
		
		if(description != null) {
			result.setDescription(description);
		}
		
		if(interLayerConnectionMember != null) {
			List<InterLayerConnection> oldChild = target.getInterLayerConnectionMember();
			List<InterLayerConnection> newChild = new ArrayList<InterLayerConnection>();
			
			for(String ni : interLayerConnectionMember) {
				newChild.add(new InterLayerConnection(map,ni));
			}
			
			for(InterLayerConnection n : oldChild) {
				if(!newChild.contains(n)) {
					oldChild.remove(n);
				}
			}
			
			for(InterLayerConnection n : newChild) {
				if(!oldChild.contains(n)) {
					oldChild.add(n);
				}
			}
			
			result.setInterLayerConnectionMember(oldChild);;
		}
		else {
			if(target.getInterLayerConnectionMember().size() != 0) {
				for(InterLayerConnection s : target.getInterLayerConnectionMember()) {
					s.resetParent();
				}
			}
		}
		
		map.getFeatureContainer("InterLayerConnection").remove(id);
		map.getFeatureContainer("InterLayerConnection").put(id,result);
		
		return result;
	}
}
