

import net.opengis.gml.v_3_2_1.PointType;

public class State {
	
	/**
	 * Create State feature instance
	 * @param ID ID of State feature instance 
	 * @param parentID ID of parent which will hold this feature
	 * @param d feature instance of CellSpace which has duality relationship with this state
	 * @param t feature instance of Transition which is connected with this feature
	 * @param geo Geometry instance of Point which represent this state
	 * @return created State feature instance
	 */
	public State createState(String ID, String parentID, CellSpace d, Transition t, PointType geo) {
		return null;
	}

	/**
	 * Search State feature in document
	 * @param ID ID of target 
	 * @return searched State feature instance
	 */
	public State readState(String ID) {
		return null;
	};

	/**
	 * Search State feature and edit it as the parameters
	 * @param ID ID of target 
	 * @param d feature of CellSpace which has duality relationship with this state
	 * @param t feature instance of Transition which is connected with this feature
	 * @param geo Geometry instance of Point which represent this state
	 * @return edited State feature instance
	 */
	public State updateState(String ID, CellSpace d, Transition t, PointType geo) {
		return null;
	}

	/**
	 * Search State feature and delete it
	 * @param ID ID of target 
	 */
	public void deleteState(String ID) {
	}

}
