package edu.pnu.IndoorGMLAPI;

import java.util.List;

/**
 * 
 * @author jungh
 *	This class implements PrimalSpaceFeaturestype of IndoorGML-1.0.3
 */
public class PrimalSpaceFeatures {
	/**
	 * @param ID ID of PrimalSpaceFeatures
	 * @param parentID parentID ID of parent which will hold this feature
	 * @param csl List of CellSpace 
	 * @param csb List of CellSpaceBoundary
	 * @return created PrimalSpaceFeatures
	 */
	public PrimalSpaceFeatures createPrimalSpaceFeatures(String ID, String parentID, List<CellSpace> csl,
			List<CellSpaceBoundary> csb) {
		return null;
	}

	/**
	 * @param ID ID of target
	 * @return searched PrimalSpaceFeatures
	 */
	public PrimalSpaceFeatures readPrimalSpaceFeatures(String ID) {
		return null;
	}

	/**
	 * @param ID ID of target
	 * @param csl List of CellSpace
	 * @param csbl List of CellSpaceBoundary
	 * @return edited feature instance
	 */
	public PrimalSpaceFeatures updatePrimalSpaceFeatures(String ID, List<CellSpace> csl, List<CellSpaceBoundary> csbl) {
		return null;
	}

	/**
	 * @param ID ID of target
	 * 
	 */
	public void deletePrimalSpaceFeatures(String ID) {
		
	}

}
