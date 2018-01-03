package edu.pnu.stem.api;
import edu.pnu.stem.binder.Container;
import edu.pnu.stem.binder.IndoorGMLMap;

public class IndoorFeatures {
	/**
	 * Create IndoorFeatures feature instance
	 * @param ID ID of feature
	 * @param psf feature instance of primalSpaceFeatures
	 * @param mlg feature instance of MultiLayeredFeatures
	 * @return created IndoorFeatures feature
	 */
	public edu.pnu.stem.feature.IndoorFeatures createIndoorFeatures(String ID, PrimalSpaceFeatures psf, MultiLayeredGraph mlg) {
		return null;
	};
	public static edu.pnu.stem.feature.IndoorFeatures createIndoorFeatures(String docID, String parentID, String ID,
			String primalSpaceFeatures, String multiLayeredGraph) {
		edu.pnu.stem.feature.IndoorFeatures newFeature = null;
		if (Container.getInstance().hasDoc(docID)) {
			newFeature.setID(ID);
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
	public edu.pnu.stem.feature.IndoorFeatures readIndoorFeatures(String ID) {
		return null;
	};

	/**
	 * Search IndoorFeatures feature instance and edit it as the parameters
	 * @param ID ID of target
	 * @param psf feature instance of PrimalSpaceFeatures
	 * @param mlg feature instance of MultiLayeredFeatures
	 * @return edited feature
	 */
	public edu.pnu.stem.feature.IndoorFeatures updateIndoorFeatures(String ID, PrimalSpaceFeatures psf, MultiLayeredGraph mlg) {
		return null;
	};
	public edu.pnu.stem.feature.IndoorFeatures updateIndoorFeatures(String docId, String Id, String attributeType,
			String object ) {
		edu.pnu.stem.feature.IndoorFeatures target = null;
		if (Container.getInstance().hasFeature(docId, Id)) {
			target = (edu.pnu.stem.feature.IndoorFeatures) Container.getInstance().getFeature(docId, Id);
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
			edu.pnu.stem.feature.IndoorFeatures target = (edu.pnu.stem.feature.IndoorFeatures) Container.getInstance().getFeature(docId,
					Id);
			// String duality = target.getd;
			doc.getFeatureContainer("IndoorFeatures").remove(Id);
			doc.getFeatureContainer("ID").remove(Id);
			
			
		}
	};

}
