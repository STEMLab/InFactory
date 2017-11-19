import FeatureClass.State;
import FeatureClass.typeOfTopoExpressionCode;

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
	public FeatureClass.InterLayerConnection createInterLayerConnection(String ID, String parentID, typeOfTopoExpressionCode teCode,
			String comment, State[] sl) {
		return null;
	};

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
