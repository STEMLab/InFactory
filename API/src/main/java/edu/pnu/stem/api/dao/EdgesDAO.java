package edu.pnu.stem.api.dao;


import java.util.List;

import edu.pnu.stem.binder.Container;
import edu.pnu.stem.binder.IndoorGMLMap;
import edu.pnu.stem.feature.Edges;


public class EdgesDAO {
	/**
	 * Create Edges feature instance 
	 * @param ID of Edges
	 * @param parentID ID of parent which will hold this feature
	 * @param tl list of transitions which will be held by SpaceLayer(parent)
	 * @return created Edges feature
	 */
	public Edges createEdges(String ID, String parentID, List<TransitionDAO> tl) {
		return null;
	};

	/**
	 * Search the Edges feature in document
	 * @param ID ID of target
	 * @return searched target feature
	 */
	
	public Edges createNodes(String docId, String parentId, String Id, List<String>transitionMember){
		Edges newFeature = null;
		if (Container.getInstance().hasDoc(docId)) {
			newFeature.setID(Id);
			if(transitionMember != null){
				newFeature.setTransitionMembers(transitionMember);
			}
			else{
				System.out.println("Error at createNodes : there is no StateMember");
			}
			
			Container.getInstance().setFeature(docId, Id, "Edges", newFeature);
		}
		
		return newFeature;
	}
	public Edges readEdges(String ID) {
		return null;
	};
	
	public Edges updateNodes(String docId, String Id, String attributeType,
			String updateType, List<String>object, Boolean deleteDuality) {
		Edges target = null;
		if (Container.getInstance().hasFeature(docId, Id)) {
			target = (Edges)Container.getInstance().getFeature(docId, Id);
			if(attributeType.equals("transitionMember")){
				List<String>transitionMember = target.getTransitionMembers();
				if(updateType != null){
					
					if(updateType.equals("add")){
						transitionMember.addAll(object);
					}
					else if(updateType.equals("remove")){
						for(int i = 0 ; i < object.size();i++){
							if(transitionMember.contains(object.get(i))){
								transitionMember.remove(object.get(i));
								TransitionDAO.deleteTransition(docId, object.get(i),deleteDuality);
							}
							
						}
					}
				}
				target.setTransitionMembers(transitionMember);
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
	public Edges updateEdges(String ID, List<TransitionDAO> tl) {
		return null;
	};

	/**
	 * Search the Edges feature and delete it
	 * @param ID ID of target
	 */
	public static void deleteEdges(String docId, String Id, Boolean deleteDuality) {
		
		if (Container.getInstance().hasFeature(docId, Id)) {
			IndoorGMLMap doc = Container.getInstance().getDocument(docId);
			Edges target = (Edges) Container.getInstance().getFeature(docId,
					Id);
			// String duality = target.getd;
			
			doc.getFeatureContainer("Nodes").remove(Id);	
			doc.getFeatureContainer("ID").remove(Id);
			for(int i = 0 ; i < target.getTransitionMembers().size();i++){
				StateDAO.deleteState(docId, target.getTransitionMembers().get(i), deleteDuality);
			}
			
		}
	};

}	
