package edu.pnu.IndoorGMLAPI;

import edu.pnu.stemlab.IndoorGMLFeatureClass.FeatureClass.typeOfTopoExpressionCode;

public class InterLayerConnection {
	/**
	 * @param ID ID of InterLayerConnection feature
	 * @param parentID ID of parent which will hold this feature
	 * @param teCode instance of typeOfTopoExpressionCode
	 * @param comment explanation of this feature
	 * @param sl list of states which are related by this InterLayerConnection
	 * @return created InterLayerConnection
	 */
	public InterLayerConnection createInterLayerConnection(String ID, String parentID, typeOfTopoExpressionCode teCode,
			String comment, State[] sl) {
		return null;
	};

	/**
	 * @param ID ID of target
	 * @return searched feature
	 */
	public InterLayerConnection readInterLayerConnection(String ID) {
		return null;
	}

	/**
	 * @param ID ID of target
	 * @param teCode instance of typeOfTopoExpressionCode
	 * @param comment comment explanation of this feature
	 * @param sl list of states which are related by this InterLayerConnection
	 * @return edited feature
	 */
	InterLayerConnection updateInterLayerConnection(String ID, typeOfTopoExpressionCode teCode, String comment,
			State[] sl) {
		return null;
	};

	/**
	 * @param ID ID of target
	 */
	public void deleteInterLayerConnection(String ID) {
	};

}	
