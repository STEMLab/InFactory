package edu.pnu.stem.api.dao;
import edu.pnu.stem.binder.Container;
import edu.pnu.stem.binder.IndoorGMLMap;
import edu.pnu.stem.feature.IndoorFeatures;

public class IndoorFeaturesDAO {

	/**
	 * @param docID
	 * @param parentID
	 * @param ID
	 * @param primalSpaceFeatures
	 * @param multiLayeredGraph
	 * @return
	 */
	public static IndoorFeatures createIndoorFeatures(String docID, String parentID, String ID,
			String primalSpaceFeatures, String multiLayeredGraph) {
		IndoorFeatures newFeature = null;
		if (Container.getInstance().hasDoc(docID)) {
			newFeature.setId(ID);
			//newFeature.setParentID(parentID);
			if (primalSpaceFeatures!= null) {
				newFeature.setPrimalSpaceFeatures(primalSpaceFeatures);
			}
			if (multiLayeredGraph != null) {
				newFeature.setMultiLayeredGraph(multiLayeredGraph);
			}
			Container.getInstance().setFeature(docID, ID, "IndoorFeatures", newFeature);
		}
		return newFeature;
	}
	
	/**
	 * Search IndoorFeatures feature instance in document
	 * @param ID ID of target
	 * @return searched feature
	 */
	public IndoorFeatures readIndoorFeatures(String ID) {
		return null;
	};

	/**
	 * Search IndoorFeatures feature instance and edit it as the parameters
	 * @param ID ID of target
	 * @param psf feature instance of PrimalSpaceFeatures
	 * @param mlg feature instance of MultiLayeredFeatures
	 * @return edited feature
	 */
	public IndoorFeatures updateIndoorFeatures(String ID, PrimalSpaceFeaturesDAO psf, MultiLayeredGraphDAO mlg) {
		return null;
	};
	public IndoorFeatures updateIndoorFeatures(String docId, String Id, String attributeType,
			String object ) {
		IndoorFeatures target = null;
		if (Container.getInstance().hasFeature(docId, Id)) {
			target = (IndoorFeatures) Container.getInstance().getFeature(docId, Id);
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
	 * @param id ID of target
	 */
	public void deleteIndoorFeatures(String docId, String Id) {
		if (Container.getInstance().hasFeature(docId, Id)) {
			IndoorGMLMap doc = Container.getInstance().getDocument(docId);
			IndoorFeatures target = (IndoorFeatures) Container.getInstance().getFeature(docId,
					Id);
			// String duality = target.getd;
			doc.getFeatureContainer("IndoorFeatures").remove(Id);
			doc.getFeatureContainer("ID").remove(Id);
			
			
		}
	};

}
