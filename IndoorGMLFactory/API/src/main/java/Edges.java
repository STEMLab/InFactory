

import java.util.List;

import Binder.docData;
import FeatureClass.Transition;

public class Edges {
	/**
	 * Create Edges feature instance 
	 * @param ID of Edges
	 * @param parentID ID of parent which will hold this feature
	 * @param tl list of transitions which will be held by SpaceLayer(parent)
	 * @return created Edges feature
	 */
	public FeatureClass.Edges createEdges(String ID, String parentID, List<Transition> tl) {
		return null;
	};

	/**
	 * Search the Edges feature in document
	 * @param ID ID of target
	 * @return searched target feature
	 */
	
	public FeatureClassReference.Edges createNodes(String docId, String parentId, String Id, List<String>transitionMember){
		FeatureClassReference.Edges newFeature = null;
		if (docData.docs.hasDoc(docId)) {
			newFeature.setID(Id);
			if(transitionMember != null){
				newFeature.setTransitionMember(transitionMember);
			}
			else{
				System.out.println("Error at createNodes : there is no StateMember");
			}
			
			docData.docs.setFeature(docId, Id, "Edges", newFeature);
		}
		
		return newFeature;
	}
	public FeatureClass.Edges readEdges(String ID) {
		return null;
	};

	/**
	 * Search the Edges feature and edit it as the parameters
	 * @param ID ID of target
	 * @param tl list of transitions which will be held by SpaceLayer(parent)
	 * @return edited feature
	 */
	public FeatureClass.Edges updateEdges(String ID, List<Transition> tl) {
		return null;
	};

	/**
	 * Search the Edges feature and delete it
	 * @param ID ID of target
	 */
	public void deleteEdges(String docId, String ID, Boolean deleteDuality) {
	};

}	
