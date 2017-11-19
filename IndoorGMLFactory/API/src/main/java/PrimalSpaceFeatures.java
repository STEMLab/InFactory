

import java.util.List;

import FeatureClass.CellSpace;
import FeatureClass.CellSpaceBoundary;

/**
 * 
 * @author jungh
 *	This class implements PrimalSpaceFeaturestype of IndoorGML-1.0.3
 */
public class PrimalSpaceFeatures {
	/**
	 * Create PrimalSpaceFeatures feature instance
	 * @param ID ID of PrimalSpaceFeatures
	 * @param parentID parentID ID of parent which will hold this feature
	 * @param csl List of CellSpace 
	 * @param csb List of CellSpaceBoundary
	 * @return created PrimalSpaceFeatures
	 */
	public FeatureClass.PrimalSpaceFeatures createPrimalSpaceFeatures(String ID, String parentID, List<CellSpace> csl,
			List<CellSpaceBoundary> csb) {
		return null;
	}

	/**
	 * Search PrimalSpaceFeatures feature in document
	 * @param ID ID of target
	 * @return searched PrimalSpaceFeatures
	 */
	public FeatureClass.PrimalSpaceFeatures readPrimalSpaceFeatures(String ID) {
		return null;
	}

	/**
	 * Search PrimalSpaceFeatures feature and edit it as the parameters
	 * @param ID ID of target
	 * @param csl List of CellSpace
	 * @param csbl List of CellSpaceBoundary
	 * @return edited feature instance
	 */
	public FeatureClass.PrimalSpaceFeatures updatePrimalSpaceFeatures(String ID, List<CellSpace> csl, List<CellSpaceBoundary> csbl) {
		return null;
	}

	/**
	 * Search PrimalSpaceFeatures feature and delete it
	 * @param ID ID of target
	 * 
	 */
	public void deletePrimalSpaceFeatures(String ID) {
		
	}

}
