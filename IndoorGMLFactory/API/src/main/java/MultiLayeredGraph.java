

import java.util.List;

import Binder.docData;
import FeatureClass.InterEdges;
import FeatureClass.SpaceLayer;


public class MultiLayeredGraph {
	/**
	 * Create MultiLayeredGraph feature instance
	 * @param ID
	 * @param parentID ID of parent which will hold this feature
	 * @param sl
	 * @param ie
	 * @return
	 */
	public FeatureClass.MultiLayeredGraph createMultilayeredGraph(String ID, String parentID, List<SpaceLayer> sl, InterEdges ie) {
		return null;
	}
	public FeatureClassReference.MultiLayeredGraph createMultiLayeredGraph(String docID, String parentID, String ID, List<String>spaceLayers, List<String>interEdges){
		FeatureClassReference.MultiLayeredGraph newFeature = null;
		if (docData.docs.hasDoc(docID)) {
			newFeature = new FeatureClassReference.MultiLayeredGraph();
			newFeature.setID(ID);
			newFeature.setParentID(parentID);
			if (spaceLayers!= null) {
				newFeature.setSpaceLayers(spaceLayers);
			}
			else if(spaceLayers == null){
				System.out.println("Error at createMultiLayeredGraph : there is no enough SpaceLayersType instance");
			}
			if (interEdges != null) {
				newFeature.setInterEdges(interEdges);
			}
			docData.docs.setFeature(docID, ID, "MultiLayeredGraph", newFeature);
		}
		return newFeature;
	}

	/**
	 * Search MultiLayeredGraph feature in document
	 * @param ID
	 * @return
	 */
	public FeatureClass.MultiLayeredGraph readMultilayeredGraph(String ID) {
		return null;
	}

	/**
	 * Search MultiLayeredGraph feature and edit it as the parameters
	 * @param ID
	 * @param sl
	 * @param ie
	 * @return
	 */
	public FeatureClass.MultiLayeredGraph updateMultilayeredGraph(String ID, List<SpaceLayer> sl, InterEdges ie) {
		return null;
	}

	/**
	 * Search MultiLayeredGraph feature and delete it
	 * @param ID
	 */
	public void deleteMultilayeredGraph(String ID) {
	};

}
