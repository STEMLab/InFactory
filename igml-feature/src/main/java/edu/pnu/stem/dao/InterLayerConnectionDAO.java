package edu.pnu.stem.dao;
import edu.pnu.stem.binder.IndoorGMLMap;
import edu.pnu.stem.feature.InterEdges;
import edu.pnu.stem.feature.InterLayerConnection;
import edu.pnu.stem.feature.MultiLayeredGraph;
import edu.pnu.stem.feature.SpaceLayer;
import edu.pnu.stem.feature.State;
public class InterLayerConnectionDAO {

	public static InterLayerConnection createInterLayerConnection(IndoorGMLMap map, String parentId, String id, String typeOfTopoExpression, String comment, String[] interConnects, String[] ConnectedLayers){
		InterLayerConnection newFeature = new InterLayerConnection(map, id);
		InterEdges parent = new InterEdges(map, parentId);
		newFeature.setParent(parent);
		
		if(typeOfTopoExpression!= null){
			//newFeature.setTypeOfTopoExpression(typeOfTopoExpression);
		}
		if(comment != null){
			//TODO : comment is not defined
			//newFeature.setComment(comment);
		}
		if(interConnects.length == 2 && ConnectedLayers.length == 2){
			if(map.hasID(interConnects[0])&&map.hasID(interConnects[1])){
				if(map.hasID(ConnectedLayers[0])&&map.hasID(ConnectedLayers[0])){
					State[] tempInterLayerConnectionList = new State[2];
					tempInterLayerConnectionList[0] = new State(map, interConnects[0]);
					tempInterLayerConnectionList[1] = new State(map, interConnects[1]);
					newFeature.setInterConnects(tempInterLayerConnectionList);
					
					SpaceLayer[] tempConnectedLayers = new SpaceLayer[2];
					tempConnectedLayers[0] = new SpaceLayer(map, ConnectedLayers[0]);
					tempConnectedLayers[1] = new SpaceLayer(map, ConnectedLayers[1]);
					newFeature.setConnectedLayers(tempConnectedLayers);
				}
				else{
					System.out.println("Error at createInterLayerConnection : This SpaceLayer is not exist");
				}
			}
			else{
				System.out.println("Error at createInterLayerConnection : This State is not exist");
			}
		}
		else{
			System.out.println("Error at createInterLayerConnection : There is no enough instance of interConnects or ConnectedLayers");
		}
		map.setFeature(id, "interLayerConnection", newFeature);
		
		return newFeature;
		
	}


}	
