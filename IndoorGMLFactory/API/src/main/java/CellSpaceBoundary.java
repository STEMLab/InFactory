import FeatureClass.CellSpaceBoundaryGeometry;
import FeatureClass.ExternalReference;
import FeatureClass.Transition;

/**
 * @author jungh
 *	
 */
public class CellSpaceBoundary {
	/**
	 * Create CellSpaceBoundary feature instance 
	 * @param ID ID of CellSpaceBoundary
	 * @param parentID 
	 * @param duality transition which has duality relationship with this CellSpaceBonudary
	 * @param csbGeometry geometry of CellSpaceBoundary
	 * @param er ExternalReference of this feature
	 * @return created CellSpaceBoundary
	 */
	public FeatureClass.CellSpaceBoundary createCellSpaceBoundary(String ID, String parentID, Transition duality,
			CellSpaceBoundaryGeometry csbGeometry, ExternalReference er) {
		return null;
	};

	/**
	 * search CellSpaceBoundary feature instance in document
	 * @param ID ID of target
	 * @return searched feature
	 */
	public FeatureClass.CellSpaceBoundary readCellSpaceBoundary(String ID) {
		return null;
	};

	/**
	 * search the CellSpaceBoundaryfeature and edit it as parameters
	 * @param ID ID of target
	 * @param duality 
	 * @param csbGeometry Geometry of CellSpaceBoundary
	 * @param er ExternalReference of this feature
	 * @return edited feature
	 */
	public FeatureClass.CellSpaceBoundary updateCellSpaceBoundary(String ID, Transition duality, CellSpaceBoundaryGeometry csbGeometry,
			ExternalReference er) {
		return null;
	};

	/**
	 * search the CellSpaceBoundary feature and delete it
	 * @param ID ID of target
	 */
	public void deleteCellSpaceBoundary(String ID) {
	};


}
