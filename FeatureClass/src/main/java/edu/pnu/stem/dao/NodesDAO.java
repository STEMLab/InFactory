package edu.pnu.stem.dao;


import java.util.List;

import edu.pnu.stem.binder.Container;
import edu.pnu.stem.binder.IndoorGMLMap;
import edu.pnu.stem.feature.Nodes;


public class NodesDAO {
	/**
	 * Create Nodes feature instance 
	 * @param ID ID of Nodes feature
	 * @param parentID ID of parent which will hold this feature
	 * @param sl list of states which are related by this Nodes relationship
	 * @return created Nodes feature
	 */
	public Nodes createNodes(String ID, String parentID, List<StateDAO> sl) {
		return null;
	}
	public Nodes createNodes(String docId, String parentId, String Id, List<String>stateMember){
		Nodes newFeature = null;
		if (Container.getInstance().hasDoc(docId)) {
			newFeature.setId(Id);
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
	public Nodes readNodes(String ID) {
		return null;
	}

	/**
	 * Search Nodes feature and edit it as the parameters
	 * @param ID ID of target
	 * @param sl list of states which are related by this Nodes relationship 
	 * @return edited Nodes feature
	 */
	public Nodes updateNodes(String docId, String Id, String attributeType,
			String updateType, List<String>object, Boolean deleteDuality) {
		Nodes target = null;
		if (Container.getInstance().hasFeature(docId, Id)) {
			target = (Nodes)Container.getInstance().getFeature(docId, Id);
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
								StateDAO.deleteState(docId, object.get(i),deleteDuality);
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
			Nodes target = (Nodes) Container.getInstance().getFeature(docId,
					Id);
			// String duality = target.getd;
			doc.getFeatureContainer("Nodes").remove(Id);
			doc.getFeatureContainer("ID").remove(Id);
			for(int i = 0 ; i < target.getStateMember().size();i++){
				StateDAO.deleteState(docId, target.getStateMember().get(i), deleteDuality);
			}
			
		}
	}

}
