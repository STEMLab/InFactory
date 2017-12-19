

import java.util.List;

import Binder.IndoorGMLMap;
import Binder.docData;



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
	public FeatureClassReference.MultiLayeredGraph updateMultiLayeredGraph(String docId, String Id, String attributeType,
			String updateType, List<String>object ) {
		FeatureClassReference.MultiLayeredGraph target = null;
		if (docData.docs.hasFeature(docId, Id)) {
			target = (FeatureClassReference.MultiLayeredGraph) docData.docs.getFeature(docId, Id);
			if (attributeType.equals("spaceLayers")) {
				List<String>spaceLayers = target.getSpaceLayers();
				if(updateType.equals("add")){
					spaceLayers.addAll(object);
				}
				//TODO : add cellSpace to cellSpace container and ID container
				else if(updateType.equals("delete")){
					for(int i = 0 ; i < object.size();i++){
						if(spaceLayers.contains(object.get(i))){
							spaceLayers.remove(object.get(i));
						}
					}
				//TODO : remove cellSpace at cellSpace container and ID container?
				}
				if(spaceLayers.size()!= 0){
					target.setSpaceLayers(spaceLayers);
				}
				else{
					System.out.println("Error at updateMultiLayeredGraph : there is no enough Spacelayers instance");
				}
			} else if (attributeType.equals("InterEdges")) {
				List<String>interEdges = target.getInterEdges();
				if(updateType.equals("add")){
					interEdges.addAll(object);
				}
				//TODO : add cellSpace to cellSpace container and ID container
				else if(updateType.equals("delete")){
					for(int i = 0 ; i < object.size();i++){
						if(interEdges.contains(object.get(i))){
							interEdges.remove(object.get(i));
						}
					}
				//TODO : remove cellSpace at cellSpace container and ID container?
					//answer : because relationship is aggregation, so do not have.
				}
				target.setInterEdges(interEdges);
			}  else {
				System.out.println("update error in cellSpaceType : there is no such attribute name");
			}
		} else {
			System.out.println("there is no name with Id :" + Id + " in document Id : " + docId);
		}
		return target;
	}
	/**
	 * Search MultiLayeredGraph feature and delete it
	 * @param ID
	 */
	public void deleteMultiLayeredGraph(String docId, String Id, Boolean deleteALL, Boolean deleteDuality) {
		if (docData.docs.hasFeature(docId, Id)) {
			IndoorGMLMap doc = docData.docs.getDocument(docId);
			FeatureClassReference.MultiLayeredGraph target = (FeatureClassReference.MultiLayeredGraph) docData.docs.getFeature(docId,
					Id);
			// String duality = target.getd;
			if(deleteALL){
				doc.getFeatureContainer("MultiLayeredGraph").remove(Id);
				doc.getFeatureContainer("ID").remove(Id);
				Nodes.deleteNodes(docId, Id, deleteDuality);
				Edges.deleteEdges(docId, Id, deleteDuality);
			}	
			else if(target.getInterEdges().size()==0&&target.getSpaceLayers().size()==0){
				doc.getFeatureContainer("MultiLayeredGraph").remove(Id);
				doc.getFeatureContainer("ID").remove(Id);
			}
			else{
				System.out.println("Warning at deleteMultilayeredGraph : If you want to delete this MultiLayeredGraph, then please put deleteALL parameter as True");
			}
						
		}
	};

}
