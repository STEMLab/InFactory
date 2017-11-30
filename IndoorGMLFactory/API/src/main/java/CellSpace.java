import java.util.List;

import FeatureClass.CellSpaceBoundary;
import FeatureClass.CellSpaceGeometry;
import FeatureClass.ExternalReference;
import FeatureClass.State;

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
	public FeatureClass.CellSpace createCellSpace(String ID, String parentID){
		FeatureClass.CellSpace newFeature = new FeatureClass.CellSpace();
		newFeature.setID(ID);
		//TODO : how to connect to its parent? 
		return newFeature;
	}
	
	public FeatureClass.CellSpace createCellSpace(String ID, String parentID, List<String> cellSpaceBoundary) {
		FeatureClass.CellSpace newFeature = createCellSpace(ID, parentID);
		newFeature.setPartialboundedBy(cellSpaceBoundary);		
		return newFeature;
	};
	
	public FeatureClass.CellSpace createCellSpace(String ID, String parentID, List<String> cellSpaceBoundary, String duality) {
		FeatureClass.CellSpace newFeature = createCellSpace(ID, parentID, cellSpaceBoundary);
		newFeature.setDuality(duality);		
		return newFeature;
	};
	
	public FeatureClass.CellSpace createCellSpace(String ID, String parentID, List<String> cellSpaceBoundary, String duality, CellSpaceGeometry csGeometry
			) {
		FeatureClass.CellSpace newFeature = createCellSpace(ID, parentID, cellSpaceBoundary ,duality, csGeometry);
		newFeature.setCellSpaceGeometry(csGeometry);		
		return newFeature;
	};
	
	public FeatureClass.CellSpace createCellSpace(String ID, String parentID, CellSpaceGeometry csGeometry,
			List<String> cellSpaceBoundary, String duality, ExternalReference er) {
		FeatureClass.CellSpace newFeature = createCellSpace(ID, parentID, cellSpaceBoundary ,duality, csGeometry);
		newFeature.setExternalReference(er);
		return newFeature;
	};

	/**
	 * search and get CellSpace feature in document
	 * @param ID ID of target
	 * @return edited feature
	 */
	public FeatureClass.CellSpace readCellSpace(String ID) {
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
	public FeatureClass.CellSpace updateCellSpace(String ID, CellSpaceGeometry csGeometry, CellSpaceBoundary csBoundary, State s,
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
