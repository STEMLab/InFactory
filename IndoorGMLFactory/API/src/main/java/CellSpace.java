

/**
 * @author jungh
 *
 */
public class CellSpace {
	/**
	 * create CellSpace feature instance
	 * @param ID ID of CellSpace
	 * @param parentID ID of parent which will hold this feature
	 * @param csGeometry Geometry of CellSpace
	 * @param csBoundary CellSpaceBoundary
	 * @param s State which has duality with this feature
	 * @param er ExternalReference of this feature
	 * @return created CellSpace
	 */
	public CellSpace createCellSpace(String ID, String parentID, CellSpaceGeometry csGeometry,
			CellSpaceBoundary csBoundary, State s, ExternalReference er) {
		return null;
	};

	/**
	 * search and get CellSpace feature in document
	 * @param ID ID of target
	 * @return edited feature
	 */
	public CellSpace readCellSpace(String ID) {
		return null;
	};

	/**
	 * search CellSpace feature and edit the feature as parameter 
	 * @param ID ID of feature
	 * @param csGeometry Geometry of CellSpace
	 * @param csGeometry Geometry of CellSpace
	 * @param s State which has duality with this feature
	 * @param er ExternalReference of this feature
	 * @return edited feature
	 */
	public CellSpace updateCellSpace(String ID, CellSpaceGeometry csGeometry, CellSpaceBoundary csBoundary, State s,
			ExternalReference er) {
		return null;
	};

	/**
	 * search CellSpace feature and delete the data 
	 * @param ID ID of target
	 */
	
	public void deleteCellSpace(String ID) {
	};

}
