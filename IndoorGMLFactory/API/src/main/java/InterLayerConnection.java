import Binder.Container;
import Binder.IndoorGMLMap;
public class InterLayerConnection {
	/**
	 * Create InterLayerConnection feature instance
	 * @param ID ID of InterLayerConnection feature
	 * @param parentID ID of parent which will hold this feature
	 * @param teCode instance of typeOfTopoExpressionCode
	 * @param comment explanation of this feature
	 * @param sl list of states which are related by this InterLayerConnection
	 * @return created InterLayerConnection
	 */
	public FeatureClass.InterLayerConnection createInterLayerConnection(String ID, String parentID, String typeOfTopoExpressionCode,
			String comment, State[] sl) {
		return null;
	};
	public static FeatureClassReference.InterLayerConnection createInterLayerConnection(String docId, String parentId, String Id, String typeOfTopoExpression, String comment, String[] interConnects, String[] ConnectedLayers){
		FeatureClassReference.InterLayerConnection newFeature = null;
		if(Container.getInstance().hasDoc(docId)){
			newFeature = new FeatureClassReference.InterLayerConnection();
			newFeature.setParentID(parentId);
			if(typeOfTopoExpression!= null){
				//newFeature.setTypeOfTopoExpression(typeOfTopoExpression);
			}
			if(comment != null){
				newFeature.setComment(comment);
			}
			if(interConnects.length == 2 && ConnectedLayers.length == 2){
				if(Container.getInstance().hasFeature(docId, interConnects[0])&&Container.getInstance().hasFeature(docId, interConnects[1])){
					if(Container.getInstance().hasFeature(docId, ConnectedLayers[0])&&Container.getInstance().hasFeature(docId, ConnectedLayers[0])){
						newFeature.setInterConnects(interConnects);
						newFeature.setConnectedLayers(ConnectedLayers);
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
			
		}
		
		return newFeature;
		
	}
	/**
	 * Search InterLayerConnection feature in document
	 * @param ID ID of target
	 * @return searched feature
	 */
	public static FeatureClass.InterLayerConnection readInterLayerConnection(String ID) {
		return null;
	}

	/**
	 * Search InterLayerConnection feature and edit it as the parameters
	 * @param ID ID of target
	 * @param teCode instance of typeOfTopoExpressionCode
	 * @param comment comment explanation of this feature
	 * @param sl list of states which are related by this InterLayerConnection
	 * @return edited feature
	 */
	public static FeatureClassReference.InterLayerConnection updateInterLayerConnection(String docId, String Id, String attributeType, String attributeId, Object o){
		FeatureClassReference.InterLayerConnection target = null;
		if (Container.getInstance().hasFeature(docId, Id)) {
			target = (FeatureClassReference.InterLayerConnection) Container.getInstance().getFeature(docId, Id);
			if(attributeType.equals("typeOfTopoExpression")){
				//TODO: need to set typeOfTopoExpression Code
			}
			else if(attributeType.equals("comment")){
				target.setComment((String)o);
			}
			else if(attributeType.equals("interConnects")){
				String[]interConnects = (String[])o;
				if(interConnects.length == 2){
					target.setInterConnects(interConnects);
				}
				else{
					System.out.println("Error at updateInterConnection : there is no enough interConnects");
				}
			}
			else if(attributeType.equals("ConnectedLayers")){
				String[]ConnectedLayers = (String[])o;
				if(ConnectedLayers.length == 2){
					target.setInterConnects(ConnectedLayers);
				}
				else{
					System.out.println("Error at updateInterConnection : there is no enough ConnectedLayers");
				}
			}
			else{
				System.out.println("Error at updateInterConnection : there is no such kind of attribute");
			}
			Container.getInstance().setFeature(docId, Id, "InterLayerConnection", target);
		}
		return target;
	}

	/**
	 * Search InterLayerConnection feature and delete it
	 * @param ID ID of target
	 */
	public static void deleteInterLayerConnection(String docId, String Id) {
		if(Container.getInstance().hasDoc(docId)){
			IndoorGMLMap doc = Container.getInstance().getDocument(docId);
			doc.getFeatureContainer("InterLayerConnection").remove(Id);
		}
		
	};

}	
