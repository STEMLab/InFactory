

import java.util.Date;
import java.util.List;

import Binder.docData;


public class SpaceLayer {
	/**
	 * Create SpaceLayer feature instance
	 * @param ID ID of SpaceLayer
	 * @param parentID ID of parent which will hold this feature
	 * @param usage Comment on usage
	 * @param function explanation about functionality of this SpaceLayer
	 * @param createDate the time when this SpaceLayer is created
	 * @param terminationDate the time when this SpaceLayer is expired
	 * @param n nodes which is contained in this SpaceLayer
	 * @param e	edges which is contained in this SpaceLayer
	 * @param ct SpaceLayerClassType of this SpaceLayer
	 * @return created SpaceLayer feature instance
	 */

	public static FeatureClassReference.SpaceLayer createSpaceLayer(String docID, String parentID, String ID,
			List<String>nodes, List<String>edges, Date creationDate, Date terminationDate, String function, String classType, String usage, List<String> codeType  ) {
		FeatureClassReference.SpaceLayer newFeature = null;
		if (docData.docs.hasDoc(docID)) {
			newFeature.setID(ID);
			newFeature.setParentID(parentID);
			if (nodes!= null) {
				newFeature.setNodes(nodes);
			}
			else if (nodes== null){
				System.out.println("Error in createSpaceLayer : no nodes");
			}
			if (edges != null) {
				newFeature.setEdges(edges);
			}
			
			if(creationDate != null){
				newFeature.setCreateDate(creationDate);
			}
			if(terminationDate != null){
				newFeature.setTerminationDate(terminationDate);
			}
			if(function != null){
				//newFeature.setFunction
				//TODO : check codeType at SpaceLayer
			}
			if(classType != null){
				//newFeature.setClassType(classType);
				//TODO : check classType at SpaceLayer
			}
			if(usage != null){
				newFeature.setUsage(usage);
			}
			if(codeType != null){
				//TODO : check codeType at SpaceLayer
			}
			docData.docs.setFeature(docID, ID, "SpaceLayer", newFeature);
		}
		return newFeature;
	}
	/**
	 * Search SpaceLayer feature in document
	 * @param ID ID of target
	 * @return searched SpaceLayer feature instance
	 */
	public FeatureClass.SpaceLayer readSpaceLayer(String ID) {
		return null;
	}

	/**
	 * Search SpaceLayer feature and edit it as the Parameters
	 * @param ID ID of target
	 * @param usage Comment on usage
	 * @param function explanation about functionality of this SpaceLayer
	 * @param createDate the time when this SpaceLayer is created
	 * @param terminationDate the time when this SpaceLayer is expired
	 * @param n nodes which is contained in this SpaceLayer
	 * @param e	edges which is contained in this SpaceLayer
	 * @param ct SpaceLayerClassType of this SpaceLayer
	 * @return edited SpaceLayer feature instance
	 */
	public FeatureClass.SpaceLayer updateSpaceLayer(String ID, String usage, String function, Date createDate, Date terminationDate,
			Nodes n, Edges e, SpaceLayerClassType ct) {
		return null;
	}
	
	/**
	 * Search SpaceLayer feature and delete it
	 * @param ID ID of target
	 */
	public void deleteSpaceLayer(String ID) {
	}

}
