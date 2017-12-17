import Binder.IndoorGMLMap;
import Binder.docData;

public class IndoorFeatures {
	/**
	 * Create IndoorFeatures feature instance
	 * @param ID ID of feature
	 * @param psf feature instance of primalSpaceFeatures
	 * @param mlg feature instance of MultiLayeredFeatures
	 * @return created IndoorFeatures feature
	 */
	public FeatureClass.IndoorFeatures createIndoorFeatures(String ID, PrimalSpaceFeatures psf, MultiLayeredGraph mlg) {
		return null;
	};
	public static FeatureClassReference.IndoorFeatures createIndoorFeatures(String docID, String parentID, String ID,
			String primalSpaceFeatures, String multiLayeredGraph) {
		FeatureClassReference.IndoorFeatures newFeature = null;
		if (docData.docs.hasDoc(docID)) {
			newFeature.setID(ID);
			//newFeature.setParentID(parentID);
			if (primalSpaceFeatures!= null) {
				newFeature.setPrimalSpaceFeatures(primalSpaceFeatures);
			}
			if (multiLayeredGraph != null) {
				newFeature.setMultiLayeredGraph(multiLayeredGraph);
			}
			docData.docs.setFeature(docID, ID, "IndoorFeatures", newFeature);
		}
		return newFeature;
	}
	
	/**
	 * Search IndoorFeatures feature instance in document
	 * @param ID ID of target
	 * @return searched feature
	 */
	public FeatureClass.IndoorFeatures readIndoorFeatures(String ID) {
		return null;
	};

	/**
	 * Search IndoorFeatures feature instance and edit it as the parameters
	 * @param ID ID of target
	 * @param psf feature instance of PrimalSpaceFeatures
	 * @param mlg feature instance of MultiLayeredFeatures
	 * @return edited feature
	 */
	public FeatureClass.IndoorFeatures updateIndoorFeatures(String ID, PrimalSpaceFeatures psf, MultiLayeredGraph mlg) {
		return null;
	};
	public FeatureClassReference.IndoorFeatures updateIndoorFeatures(String docId, String Id, String attributeType,
			String object ) {
		FeatureClassReference.IndoorFeatures target = null;
		if (docData.docs.hasFeature(docId, Id)) {
			target = (FeatureClassReference.IndoorFeatures) docData.docs.getFeature(docId, Id);
			if (attributeType.equals("primalSpaceFeatures")) {
				target.setPrimalSpaceFeatures(object);
				//TODO : add cellSpace to cellSpace container and ID container
				
				
			} else if (attributeType.equals("multiLayeredGraph")) {
				target.setMultiLayeredGraph(object);
			}  else {
				System.out.println("update error in cellSpaceType : there is no such attribute name");
			}
		} else {
			System.out.println("there is no name with Id :" + Id + " in document Id : " + docId);
		}
		return target;
	}
	
	/**
	 * Search IndoorFeatures feature instance and delete it
	 * @param ID ID of target
	 */
	public void deleteIndoorFeatures(String docId, String Id) {
		if (docData.docs.hasFeature(docId, Id)) {
			IndoorGMLMap doc = docData.docs.getDocument(docId);
			FeatureClassReference.IndoorFeatures target = (FeatureClassReference.IndoorFeatures) docData.docs.getFeature(docId,
					Id);
			// String duality = target.getd;
			doc.getFeatureContainer("IndoorFeatures").remove(Id);
			doc.getFeatureContainer("ID").remove(Id);
			
			
		}
	};

}
