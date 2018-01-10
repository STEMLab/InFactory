package edu.pnu.stem.dao;
import edu.pnu.stem.binder.Container;
import edu.pnu.stem.binder.IndoorGMLMap;
import edu.pnu.stem.feature.InterEdges;
import edu.pnu.stem.feature.InterLayerConnection;
import edu.pnu.stem.feature.SpaceLayer;
import edu.pnu.stem.feature.State;
public class InterLayerConnectionDAO {

	public static InterLayerConnection createInterLayerConnection(String docId, String parentId, String id, String typeOfTopoExpression, String comment, String[] interConnects, String[] ConnectedLayers){
		InterLayerConnection newFeature = null;
		if(Container.getInstance().hasDoc(docId)){
			IndoorGMLMap map = Container.getInstance().getDocument(docId);
			newFeature = new InterLayerConnection(map);
			InterEdges parent = new InterEdges(map);
			parent.setId(parentId);
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
						tempInterLayerConnectionList[0] = new State(map);
						tempInterLayerConnectionList[1] = new State(map);
						tempInterLayerConnectionList[0].setId(interConnects[0]);
						tempInterLayerConnectionList[1].setId(interConnects[1]);
						newFeature.setInterConnects(tempInterLayerConnectionList);
						
						SpaceLayer[] tempConnectedLayers = new SpaceLayer[2];
						tempConnectedLayers[0] = new SpaceLayer(map);
						tempConnectedLayers[1] = new SpaceLayer(map);
						tempConnectedLayers[0].setId(ConnectedLayers[0]);
						tempConnectedLayers[1].setId(ConnectedLayers[1]);
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
		}
		
		return newFeature;
		
	}
	/**
	 * Search InterLayerConnection feature in document
	 * @param ID ID of target
	 * @return searched feature
	 */
	public static InterLayerConnection readInterLayerConnection(String docId, String id) {
		InterLayerConnection target = null;
		target = (InterLayerConnection)Container.getInstance().getFeature(docId, id);
		return target;
	}

	/**
	 * Search InterLayerConnection feature and edit it as the parameters
	 * @param ID ID of target
	 * @param teCode instance of typeOfTopoExpressionCode
	 * @param comment comment explanation of this feature
	 * @param sl list of states which are related by this InterLayerConnection
	 * @return edited feature
	 */
	public static InterLayerConnection updateInterLayerConnection(String docId, String id, String attributeType, Object o){
		InterLayerConnection target = null;
		if (Container.getInstance().hasFeature(docId, id)) {
			IndoorGMLMap map = Container.getInstance().getDocument(docId);
			target = (InterLayerConnection) map.getFeature(id);
			if(attributeType.equals("typeOfTopoExpression")){
				//TODO: need to set typeOfTopoExpression Code
			}
			else if(attributeType.equals("comment")){
				target.setComment((String)o);
			}
			else if(attributeType.equals("interConnects")){
				String[]interConnects = (String[])o;
				if(interConnects.length == 2){
					State[] tempInterConnects = new State[2];
					tempInterConnects[0] = new State(map);
					tempInterConnects[1] = new State(map);
					tempInterConnects[0].setId(interConnects[0]);
					tempInterConnects[1].setId(interConnects[1]);
					target.setInterConnects(tempInterConnects);
				}
				else{
					System.out.println("Error at updateInterConnection : there is no enough interConnects");
				}
			}
			else if(attributeType.equals("ConnectedLayers")){
				String[]connectedLayers = (String[])o;
				if(connectedLayers.length == 2){
					SpaceLayer[] tempConnectedLayers = new SpaceLayer[2];
					tempConnectedLayers[0] = new SpaceLayer(map);
					tempConnectedLayers[1] = new SpaceLayer(map);
					tempConnectedLayers[0].setId(connectedLayers[0]);
					tempConnectedLayers[1].setId(connectedLayers[1]);
					target.setConnectedLayers(tempConnectedLayers);
				}
				else{
					System.out.println("Error at updateInterConnection : there is no enough ConnectedLayers");
				}
			}
			else{
				System.out.println("Error at updateInterConnection : there is no such kind of attribute");
			}
			map.setFeature(id, "InterLayerConnection", target);
		}
		return target;
	}

	/**
	 * Search InterLayerConnection feature and delete it
	 * @param ID ID of target
	 */
	public static void deleteInterLayerConnection(String docId, String id) {
		if(Container.getInstance().hasDoc(docId)){
			IndoorGMLMap doc = Container.getInstance().getDocument(docId);
			doc.deleteFeature(id, "InterLayerConnection");		
		}
		
	};

}	
