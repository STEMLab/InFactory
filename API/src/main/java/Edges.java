

import java.util.List;

import Binder.Container;
import Binder.IndoorGMLMap;


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
		if (Container.getInstance().hasDoc(docId)) {
			newFeature.setID(Id);
			if(transitionMember != null){
				newFeature.setTransitionMember(transitionMember);
			}
			else{
				System.out.println("Error at createNodes : there is no StateMember");
			}
			
			Container.getInstance().setFeature(docId, Id, "Edges", newFeature);
		}
		
		return newFeature;
	}
	public FeatureClass.Edges readEdges(String ID) {
		return null;
	};
	
	public FeatureClassReference.Edges updateNodes(String docId, String Id, String attributeType,
			String updateType, List<String>object, Boolean deleteDuality) {
		FeatureClassReference.Edges target = null;
		if (Container.getInstance().hasFeature(docId, Id)) {
			target = (FeatureClassReference.Edges)Container.getInstance().getFeature(docId, Id);
			if(attributeType.equals("transitionMember")){
				List<String>transitionMember = target.getTransitionMember();
				if(updateType != null){
					
					if(updateType.equals("add")){
						transitionMember.addAll(object);
					}
					else if(updateType.equals("remove")){
						for(int i = 0 ; i < object.size();i++){
							if(transitionMember.contains(object.get(i))){
								transitionMember.remove(object.get(i));
								Transition.deleteTransition(docId, object.get(i),deleteDuality);
							}
							
						}
					}
				}
				target.setTransitionMember(transitionMember);
			}
		}
		return target;
	}

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
	public static void deleteEdges(String docId, String Id, Boolean deleteDuality) {
		
		if (Container.getInstance().hasFeature(docId, Id)) {
			IndoorGMLMap doc = Container.getInstance().getDocument(docId);
			FeatureClassReference.Edges target = (FeatureClassReference.Edges) Container.getInstance().getFeature(docId,
					Id);
			// String duality = target.getd;
			
			doc.getFeatureContainer("Nodes").remove(Id);	
			doc.getFeatureContainer("ID").remove(Id);
			for(int i = 0 ; i < target.getTransitionMember().size();i++){
				State.deleteState(docId, target.getTransitionMember().get(i), deleteDuality);
			}
			
		}
	};

}	
