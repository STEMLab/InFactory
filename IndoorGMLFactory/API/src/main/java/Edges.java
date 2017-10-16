

import java.util.List;

public class Edges {
	/**
	 * @param ID of Edges
	 * @param parentID ID of parent which will hold this feature
	 * @param tl list of transitions which will be held by SpaceLayer(parent)
	 * @return created Edges feature
	 */
	public Edges createEdges(String ID, String parentID, List<Transition> tl) {
		return null;
	};

	/**
	 * @param ID ID of target
	 * @return searched target feature
	 */
	public Edges readEdges(String ID) {
		return null;
	};

	/**
	 * @param ID ID of target
	 * @param tl list of transitions which will be held by SpaceLayer(parent)
	 * @return edited feature
	 */
	public Edges updateEdges(String ID, List<Transition> tl) {
		return null;
	};

	/**
	 * @param ID ID of target
	 */
	public void deleteEdges(String ID) {
	};

}	
