import Binder.docData;

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
	public FeatureClassReference.InterLayerConnection createInterLayerConnection(String docId, String parentId, String Id, String typeOfTopoExpression, String comment, String[] interConnects, String[] ConnectedLayers){
		FeatureClassReference.InterLayerConnection newFeature = null;
		if(docData.docs.hasDoc(docId)){
			newFeature = new FeatureClassReference.InterLayerConnection();
			newFeature.setParentID(parentId);
			if(typeOfTopoExpression!= null){
				//newFeature.setTypeOfTopoExpression(typeOfTopoExpression);
			}
			if(comment != null){
				newFeature.setComment(comment);
			}
			if(interConnects.length == 2 && ConnectedLayers.length == 2){
				if(docData.docs.hasFeature(docId, interConnects[0])&&docData.docs.hasFeature(docId, interConnects[1])){
					if(docData.docs.hasFeature(docId, ConnectedLayers[0])&&docData.docs.hasFeature(docId, ConnectedLayers[0])){
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
	public FeatureClass.InterLayerConnection readInterLayerConnection(String ID) {
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
	public FeatureClass.InterLayerConnection updateInterLayerConnection(String ID, typeOfTopoExpressionCode teCode, String comment,
			State[] sl) {
		return null;
	};

	/**
	 * Search InterLayerConnection feature and delete it
	 * @param ID ID of target
	 */
	public void deleteInterLayerConnection(String ID) {
	};

}	
