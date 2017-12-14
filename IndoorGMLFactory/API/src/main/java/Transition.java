

import Binder.IndoorGMLMap;
import Binder.docData;
import FeatureClass.CellSpaceBoundary;
import FeatureClass.State;
import net.opengis.gml.v_3_2_1.CurveType;

public class Transition {

	/**
	 * Create Transition feature instance
	 * @param ID ID of Transition
	 * @param parentID ID of parent which will hold this feature
	 * @param sl list of States which are connected with this Transition. Always size need to be 2.
	 * @param gc Geometry of this Transition. Represented as CurveType of GML-3.2.1
	 * @param csBoundary Feature instance of CellSpaceBoundary which has duality relationship with this Transition
	 * @param weight weight can be used for applications in order to deal with the impedance representing absolute barriers in transportation problems 
	 * @return
	 */
	public FeatureClass.Transition createTransition(String ID, String parentID, State[] sl, CurveType gc, CellSpaceBoundary csBoundary,
			double weight) {
		return null;
	}

	/**
	 * Search Transition feature in document
	 * @param ID ID of target
	 * @return searched Transition feature instance
	 */
	public FeatureClass.Transition readTransition(String ID) {
		return null;
	}

	/**
	 * Search Transition feature and edit it as the parameters
	 * @param ID ID of target
	 * @param gc Geometry of this Transition. Represented as CurveType of GML-3.2.1
	 * @param sl list of States which are connected with this Transition. Always size need to be 2.
	 * @param csBoundary Feature instance of CellSpaceBoundary which has duality relationship with this Transition
	 * @param weight weight can be used for applications in order to deal with the impedance representing absolute barriers in transportation problems 
	 * @return edited Transition feature instance 
	 */
	public FeatureClass.Transition updateTransition(String ID, CurveType gc, State[] sl, CellSpaceBoundary csBoundary, double weight) {
		return null;
	}

	/**
	 * Search Transition feature and delete it
	 * @param ID ID of target
	 */
	public static void deleteTransition(String docId, String Id) {
		if (docData.docs.hasFeature(docId, Id)) {
			IndoorGMLMap doc = docData.docs.getDocument(docId);
			FeatureClassReference.Transition target = (FeatureClassReference.Transition) docData.docs.getFeature(docId,
					Id);
			doc.getFeatureContainer("ExternalReference").remove(target.getExternalReference());			
			doc.getFeatureContainer("Transition").remove(Id);
			doc.getFeatureContainer("ID").remove(target.getExternalReference());
			doc.getFeatureContainer("ID").remove(Id);
		}
	}

}
