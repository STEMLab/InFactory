package edu.pnu.stem.dao;
import java.util.ArrayList;
import java.util.List;

import edu.pnu.stem.binder.IndoorGMLMap;
import edu.pnu.stem.feature.CellSpace;
import edu.pnu.stem.feature.InterEdges;
import edu.pnu.stem.feature.InterLayerConnection;
import edu.pnu.stem.feature.SpaceLayer;
import edu.pnu.stem.feature.State;
public class InterLayerConnectionDAO {

	public static InterLayerConnection createInterLayerConnection(IndoorGMLMap map, String parentId, String id, String name, String description, String typeOfTopoExpression, String comment, String[] interConnects, String[] connectedLayers){
		InterLayerConnection newFeature = new InterLayerConnection(map, id);
		
		
		if(map.hasFutureID(id)){
			newFeature = (InterLayerConnection)map.getFutureFeature(id);
			//map.removeFutureID(id);
		}
		else{
			map.setFutureFeature(id, newFeature);
		}
		
		InterEdges parent = (InterEdges)map.getFeature(parentId);
		if(parent == null) {
			if(map.hasFutureID(parentId)) {
				parent = (InterEdges)map.getFutureFeature(parentId);
			}
			else {
				parent = new InterEdges(map,parentId);
			}
		}
		
		newFeature.setParent(parent);
		
		
		parent.addInterLayerConnectionMember(newFeature);
		
		if(typeOfTopoExpression!= null){
			//newFeature.setTypeOfTopoExpression(typeOfTopoExpression);
		}
		if(comment != null){
			//TODO : comment is not defined
			//newFeature.setComment(comment);
		}
		
		if(name != null) {
			newFeature.setName(name);
		}
		
		if(description != null) {
			newFeature.setDescription(description);
		}
		if(interConnects.length == 2 && connectedLayers.length == 2){
			State[] tempInterLayerConnectionList = new State[2];
			tempInterLayerConnectionList[0] = new State(map, interConnects[0]);
			tempInterLayerConnectionList[1] = new State(map, interConnects[1]);
			newFeature.setInterConnects(tempInterLayerConnectionList);
			
			SpaceLayer[] tempConnectedLayers = new SpaceLayer[2];
			tempConnectedLayers[0] = new SpaceLayer(map, connectedLayers[0]);
			tempConnectedLayers[1] = new SpaceLayer(map, connectedLayers[1]);
			newFeature.setConnectedLayers(tempConnectedLayers);
		}
		else{
			System.out.println("Error at createInterLayerConnection : There is no enough instance of interConnects or ConnectedLayers");
		}
		
		map.removeFutureID(id);
		map.setFeature(id, "InterLayerConnection", newFeature);
		
		return newFeature;
		
	}
	public static InterLayerConnection readInterLayerConnection(IndoorGMLMap map, String id) {
		InterLayerConnection target = null;
		try {
			target = (InterLayerConnection)map.getFeature(id);
		}
		catch(NullPointerException e){
			e.printStackTrace();
		}
		return target;
	}
	
	public static InterLayerConnection updateInterLayerConnection(IndoorGMLMap map, String parentId, String id, String typeOfTopoExpression, String comment, String[] interConnects, String[] connectedLayers ) {
		InterLayerConnection target = (InterLayerConnection)map.getFeature(id);
		InterLayerConnection result = new InterLayerConnection(map,id);
		
		InterEdges parent = target.getParent();
		if(!parent.getId().equals(parentId)) {
			InterEdges newParent = (InterEdges)map.getFeature(parentId);
			if(newParent == null)
				newParent = new InterEdges(map, parentId);
			parent.deleteInterLayerConnectionMember(target);
			result.setParent(newParent);
		}
		result.setParent(parent);
		if(interConnects != null) {
			State[] newChild = new State[2];
			newChild[0] = new State(map, interConnects[0]);
			newChild[1] = new State(map, interConnects[1]);
			result.setInterConnects(newChild);
		}
		
		if(connectedLayers != null) {
			SpaceLayer[] newChild = new SpaceLayer[2];
			newChild[0] = new SpaceLayer(map, connectedLayers[0]);
			newChild[1] = new SpaceLayer(map, connectedLayers[1]);
			result.setConnectedLayers(newChild);
		}
		
		map.removeFeature(id);
		map.setFeature(id, "InterLayerConnection", result);
		return result;
		
	}
	
	public static void deleteInterLayerConnection(IndoorGMLMap map, String id) {
		InterLayerConnection target = (InterLayerConnection) map.getFeature(id);
		InterEdges parent = target.getParent();
		
		parent.deleteInterLayerConnectionMember(target);
		
		//reference problem : state and spacelayer
		
		map.removeFeature(id);
		
		
	}


}	
