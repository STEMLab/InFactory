import Binder.docData;
import FeatureClass.CellSpaceBoundaryGeometry;
import FeatureClass.ExternalReference;
import FeatureClass.Transition;

/**
 * @author jungh
 *	
 */
public class CellSpaceBoundary {
	
	public static FeatureClassReference.CellSpaceBoundary createCellSpaceBoundary(String docId, String ID, String parentID){
		FeatureClassReference.CellSpaceBoundary newFeature = null;
		if(docData.docs.hasDoc(docId)){
			newFeature = new FeatureClassReference.CellSpaceBoundary();
			newFeature.setID(ID);
			newFeature.setParentID(ID);
			docData.docs.setFeature(docId, ID, "CellSpaceBoundary", newFeature);
		}
		return newFeature;
	}
	public static FeatureClassReference.CellSpaceBoundary createCellSpaceBoundary(String docId, String parentID, String ID, String name, String description, String duality, String cellSpaceBoundaryGeometry, String externalReference){
		FeatureClassReference.CellSpaceBoundary newFeature = null;
		if(docData.docs.hasDoc(docId)){
			newFeature = new FeatureClassReference.CellSpaceBoundary();
			newFeature.setDuality(duality);
			newFeature.setParentID(parentID);
			if(name != null){
				newFeature.setName(name);
			}
			if(duality != null){
				newFeature.setDuality(duality);
			}
			if(externalReference != null){
				newFeature.setExternalReference(externalReference);
			}
			if(cellSpaceBoundaryGeometry != null){
				newFeature.setCellSpaceBoundaryGeometry(cellSpaceBoundaryGeometry);
			}
			docData.docs.setFeature(docId, ID, "CellSpaceBoundary", newFeature);
			return newFeature;
		}
	}
	/**
	 * Create CellSpaceBoundary feature instance 
	 * @param ID ID of CellSpaceBoundary
	 * @param parentID 
	 * @param duality transition which has duality relationship with this CellSpaceBonudary
	 * @param csbGeometry geometry of CellSpaceBoundary
	 * @param er ExternalReference of this feature
	 * @return created CellSpaceBoundary
	 */
	public static FeatureClassReference.CellSpaceBoundary createCellSpaceBoundary(String ID, String parentID, Transition duality,
			CellSpaceBoundaryGeometry csbGeometry, ExternalReference er) {
		return null;
	};

	/**
	 * search CellSpaceBoundary feature instance in document
	 * @param ID ID of target
	 * @return searched feature
	 */
	public static FeatureClassReference.CellSpaceBoundary readCellSpaceBoundary(String ID) {
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
	public static FeatureClassReference.CellSpaceBoundary updateCellSpaceBoundary(String ID, Transition duality, CellSpaceBoundaryGeometry csbGeometry,
			ExternalReference er) {
		return null;
	};

	/**
	 * search the CellSpaceBoundary feature and delete it
	 * @param ID ID of target
	 */
	public static void deleteCellSpaceBoundary(String ID) {
	};


}
