package edu.pnu.stem.api;


import java.util.List;

import edu.pnu.stem.binder.Container;
import edu.pnu.stem.binder.IndoorGMLMap;


public class Nodes {
	/**
	 * Create Nodes feature instance 
	 * @param ID ID of Nodes feature
	 * @param parentID ID of parent which will hold this feature
	 * @param sl list of states which are related by this Nodes relationship
	 * @return created Nodes feature
	 */
	public edu.pnu.stem.feature.Nodes createNodes(String ID, String parentID, List<State> sl) {
		return null;
	}
	public edu.pnu.stem.feature.Nodes createNodes(String docId, String parentId, String Id, List<String>stateMember){
		edu.pnu.stem.feature.Nodes newFeature = null;
		if (Container.getInstance().hasDoc(docId)) {
			newFeature.setID(Id);
			if(stateMember != null){
				newFeature.setStateMember(stateMember);
			}
			else{
				System.out.println("Error at createNodes : there is no StateMember");
			}
			
			Container.getInstance().setFeature(docId, Id, "Nodes", newFeature);
		}
		
		return newFeature;
	}

	/**
	 * Search Nodes feature in document
	 * @param ID ID of target
	 * @return searched feature
	 */
	public edu.pnu.stem.feature.Nodes readNodes(String ID) {
		return null;
	}

	/**
	 * Search Nodes feature and edit it as the parameters
	 * @param ID ID of target
	 * @param sl list of states which are related by this Nodes relationship 
	 * @return edited Nodes feature
	 */
	public edu.pnu.stem.feature.Nodes updateNodes(String docId, String Id, String attributeType,
			String updateType, List<String>object, Boolean deleteDuality) {
		edu.pnu.stem.feature.Nodes target = null;
		if (Container.getInstance().hasFeature(docId, Id)) {
			target = (edu.pnu.stem.feature.Nodes)Container.getInstance().getFeature(docId, Id);
			if(attributeType.equals("stateMember")){
				List<String>stateMember = target.getStateMember();
				if(updateType != null){
					
					if(updateType.equals("add")){
						stateMember.addAll(object);
					}
					else if(updateType.equals("remove")){
						for(int i = 0 ; i < object.size();i++){
							if(stateMember.contains(object.get(i))){
								stateMember.remove(object.get(i));
								State.deleteState(docId, object.get(i),deleteDuality);
							}
							
						}
					}
				}
				if(stateMember.size() != 0){
					target.setStateMember(stateMember);
				}
				else
					System.out.println("Error at updateNodes : empty stateMember cannot be submited");
				
			}
		}
		return target;
	}

	/**
	 * Search Nodes feature and delete it
	 * @param ID ID of target
	 */
	public static void deleteNodes(String docId, String Id, Boolean deleteDuality) {
		if (Container.getInstance().hasFeature(docId, Id)) {
			IndoorGMLMap doc = Container.getInstance().getDocument(docId);
			edu.pnu.stem.feature.Nodes target = (edu.pnu.stem.feature.Nodes) Container.getInstance().getFeature(docId,
					Id);
			// String duality = target.getd;
			doc.getFeatureContainer("Nodes").remove(Id);
			doc.getFeatureContainer("ID").remove(Id);
			for(int i = 0 ; i < target.getStateMember().size();i++){
				State.deleteState(docId, target.getStateMember().get(i), deleteDuality);
			}
			
		}
	}

}
