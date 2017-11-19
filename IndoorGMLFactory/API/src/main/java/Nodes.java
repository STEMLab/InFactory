

import java.util.List;

import FeatureClass.State;

public class Nodes {
	/**
	 * Create Nodes feature instance 
	 * @param ID ID of Nodes feature
	 * @param parentID ID of parent which will hold this feature
	 * @param sl list of states which are related by this Nodes relationship
	 * @return created Nodes feature
	 */
	public FeatureClass.Nodes createNodes(String ID, String parentID, List<State> sl) {
		return null;
	}

	/**
	 * Search Nodes feature in document
	 * @param ID ID of target
	 * @return searched feature
	 */
	public FeatureClass.Nodes readNodes(String ID) {
		return null;
	}

	/**
	 * Search Nodes feature and edit it as the parameters
	 * @param ID ID of target
	 * @param sl list of states which are related by this Nodes relationship 
	 * @return edited Nodes feature
	 */
	public FeatureClass.Nodes updateNodes(String ID, List<State> sl) {
		return null;
	}

	/**
	 * Search Nodes feature and delete it
	 * @param ID ID of target
	 */
	public void deleteNodes(String ID) {
	}

}
