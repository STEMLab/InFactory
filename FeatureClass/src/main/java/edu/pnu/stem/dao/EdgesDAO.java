package edu.pnu.stem.dao;


import java.util.ArrayList;
import java.util.List;

import edu.pnu.stem.binder.Container;
import edu.pnu.stem.binder.IndoorGMLMap;
import edu.pnu.stem.feature.Edges;
import edu.pnu.stem.feature.Transition;


public class EdgesDAO {

	public Edges createNodes(String docId, String parentId, String id, List<String>transitionMember){
		Edges newFeature = null;
		if (Container.getInstance().hasDoc(docId)) {
			IndoorGMLMap map = Container.getInstance().getDocument(docId);
			newFeature = new Edges(map);
			newFeature.setId(id);
			if(transitionMember != null){
				List<Transition>transitionMembers = new ArrayList<Transition>();
				for(int i = 0 ; i < transitionMember.size() ; i++){
					Transition temp = new Transition(map);
					temp.setId(transitionMember.get(i));
					transitionMembers.add(temp);
				}
				newFeature.setTransitionMembers(transitionMembers);
			}
			else{
				System.out.println("Error at createNodes : there is no StateMember");
			}
			
			Container.getInstance().setFeature(docId, id, "Edges", newFeature);
		}
		
		return newFeature;
	}
	public Edges readEdges(String docId, String id) {
		Edges target = null;
		target = (Edges)Container.getInstance().getDocument(docId).getFeature(id);
		return target;
	};
	
	public Edges updateNodes(String docId, String id, String attributeType,
			String updateType, List<String>object, Boolean deleteDuality) {
		Edges target = null;
		if (Container.getInstance().hasFeature(docId, id)) {
			IndoorGMLMap map = Container.getInstance().getDocument(docId);
			target = (Edges)map.getFeature(id);
			if(attributeType.equals("transitionMember")){
				List<Transition>transitionMember = target.getTransitionMember();
				List<Transition>newTransitionMember = new ArrayList<Transition>();
				for(int i = 0 ; i < object.size() ; i++){
					Transition temp = new Transition(map);
					temp.setId(id);
					newTransitionMember.add(temp);
				}
				if(updateType != null){				
					if(updateType.equals("add")){						
						transitionMember.addAll(newTransitionMember);
					}
					else if(updateType.equals("remove")){
						for(int i = 0 ; i < object.size();i++){
							if(transitionMember.contains(newTransitionMember.get(i))){
								transitionMember.remove(newTransitionMember.get(i));
								TransitionDAO.deleteTransition(docId, object.get(i),deleteDuality);
							}
							
						}
					}
				}
				target.cleanTransitionMember();
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
			for(int i = 0 ; i < target.getTransitionMember().size();i++){
				StateDAO.deleteState(docId, target.getTransitionMember().get(i).getId(), deleteDuality);
			}
			
		}
	};

}	
