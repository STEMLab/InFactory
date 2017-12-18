

import java.util.List;

import Binder.IndoorGMLMap;
import Binder.docData;


public class Nodes {
	/**
	 * Create Nodes feature instance 
	 * @param ID ID of Nodes feature
	 * @param parentID ID of parent which will hold this feature
	 * @param sl list of states which are related by this Nodes relationship
	 * @return created Nodes feature
	 */
	public FeatureClass.Nodes createNodes(String ID, String parentID, List<State> sl) {
		return null;
	}
	public FeatureClassReference.Nodes createNodes(String docId, String parentId, String Id, List<String>stateMember){
		FeatureClassReference.Nodes newFeature = null;
		if (docData.docs.hasDoc(docId)) {
			newFeature.setID(Id);
			if(stateMember != null){
				newFeature.setStateMember(stateMember);
			}
			else{
				System.out.println("Error at createNodes : there is no StateMember");
			}
			
			docData.docs.setFeature(docId, Id, "Nodes", newFeature);
		}
		
		return newFeature;
	}

	/**
	 * Search Nodes feature in document
	 * @param ID ID of target
	 * @return searched feature
	 */
	public FeatureClass.Nodes readNodes(String ID) {
		return null;
	}

	/**
	 * Search Nodes feature and edit it as the parameters
	 * @param ID ID of target
	 * @param sl list of states which are related by this Nodes relationship 
	 * @return edited Nodes feature
	 */
	public FeatureClassReference.Nodes updateNodes(String docId, String Id, String attributeType,
			String updateType, List<String>object, Boolean deleteDuality) {
		FeatureClassReference.Nodes target = null;
		if (docData.docs.hasFeature(docId, Id)) {
			target = (FeatureClassReference.Nodes)docData.docs.getFeature(docId, Id);
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
	public void deleteNodes(String docId, String Id, Boolean deleteDuality) {
		if (docData.docs.hasFeature(docId, Id)) {
			IndoorGMLMap doc = docData.docs.getDocument(docId);
			FeatureClassReference.Nodes target = (FeatureClassReference.Nodes) docData.docs.getFeature(docId,
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
