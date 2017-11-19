

import java.util.List;

import FeatureClass.Transition;

public class Edges {
	/**
	 * Create Edges feature instance 
	 * @param ID of Edges
	 * @param parentID ID of parent which will hold this feature
	 * @param tl list of transitions which will be held by SpaceLayer(parent)
	 * @return created Edges feature
	 */
	public FeatureClass.Edges createEdges(String ID, String parentID, List<Transition> tl) {
		return null;
	};

	/**
	 * Search the Edges feature in document
	 * @param ID ID of target
	 * @return searched target feature
	 */
	public FeatureClass.Edges readEdges(String ID) {
		return null;
	};

	/**
	 * Search the Edges feature and edit it as the parameters
	 * @param ID ID of target
	 * @param tl list of transitions which will be held by SpaceLayer(parent)
	 * @return edited feature
	 */
	public FeatureClass.Edges updateEdges(String ID, List<Transition> tl) {
		return null;
	};

	/**
	 * Search the Edges feature and delete it
	 * @param ID ID of target
	 */
	public void deleteEdges(String ID) {
	};

}	
