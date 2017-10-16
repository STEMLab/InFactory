


/**
 * @author jungh
 *	
 */
public class CellSpaceBoundary {
	/**
	 * @param ID ID of CellSpaceBoundary
	 * @param parentID 
	 * @param duality transition which has duality relationship with this CellSpaceBonudary
	 * @param csbGeometry geometry of CellSpaceBoundary
	 * @param er ExternalReference of this feature
	 * @return created CellSpaceBoundary
	 */
	CellSpaceBoundary createCellSpaceBoundary(String ID, String parentID, Transition duality,
			CellSpaceBoundaryGeometry csbGeometry, ExternalReference er) {
		return null;
	};

	/**
	 * @param ID ID of target
	 * @return searched feature
	 */
	public CellSpaceBoundary readCellSpaceBoundary(String ID) {
		return null;
	};

	/**
	 * @param ID ID of target
	 * @param duality 
	 * @param csbGeometry Geometry of CellSpaceBoundary
	 * @param er ExternalReference of this feature
	 * @return edited feature
	 */
	public CellSpaceBoundary updateCellSpaceBoundary(String ID, Transition duality, CellSpaceBoundaryGeometry csbGeometry,
			ExternalReference er) {
		return null;
	};

	/**
	 * @param ID ID of target
	 */
	void deleteCellSpaceBoundary(String ID) {
	};


}
