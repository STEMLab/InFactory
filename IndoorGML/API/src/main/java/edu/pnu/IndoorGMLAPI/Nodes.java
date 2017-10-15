package edu.pnu.IndoorGMLAPI;

import java.util.List;

public class Nodes {
	/**
	 * @param ID ID of Nodes feature
	 * @param parentID ID of parent which will hold this feature
	 * @param sl list of states which are related by this Nodes relationship
	 * @return created Nodes feature
	 */
	public Nodes createNodes(String ID, String parentID, List<State> sl) {
		return null;
	}

	/**
	 * @param ID ID of target
	 * @return searched feature
	 */
	public Nodes readNodes(String ID) {
		return null;
	}

	/**
	 * @param ID ID of target
	 * @param sl list of states which are related by this Nodes relationship 
	 * @return edited Nodes feature
	 */
	public Nodes updateNodes(String ID, List<State> sl) {
		return null;
	}

	/**
	 * @param ID ID of target
	 */
	public void deleteNodes(String ID) {
	}

}
