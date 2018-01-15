package edu.pnu.stem.dao;


import java.util.ArrayList;
import java.util.List;

import edu.pnu.stem.binder.IndoorGMLMap;
import edu.pnu.stem.feature.Nodes;
import edu.pnu.stem.feature.SpaceLayer;
import edu.pnu.stem.feature.State;


public class NodesDAO {

	public static Nodes createNodes(IndoorGMLMap map, String parentId, String Id, List<String>stateMember){
		Nodes newFeature = null;
		newFeature = new Nodes(map);
		newFeature.setId(Id);
		if(stateMember != null){
			List<State>tempStateMember = new ArrayList<State>();
			for(int i = 0 ; i < stateMember.size() ; i++){
				State temp = new State(map);
				temp.setId(stateMember.get(i));
				tempStateMember.add(temp);
			}
			newFeature.setStateMember(tempStateMember);
		}
		else{
			System.out.println("Error at createNodes : there is no StateMember");
		}		
		map.setFeature(Id, "Nodes", newFeature);
		
		return newFeature;
	}
	
	public static Nodes createNodes(IndoorGMLMap map, String parentId, String Id){
		Nodes newFeature = null;
		newFeature = new Nodes(map);
		newFeature.setId(Id);
		
		SpaceLayer parent = (SpaceLayer) map.getFeature(parentId);
		parent.addNodes(newFeature);
		
		map.setFeature(Id, "Nodes", newFeature);
		return newFeature;
	}

	/**
	 * Search Nodes feature in document
	 * @param ID ID of target
	 * @return searched feature
	 */
	/*
	public Nodes readNodes(String docId, String id) {
		Nodes target = null;
		target = (Nodes)Container.getInstance().getFeature(docId, id);
		return target;
	}
	*/
	
	/**
	 * Search Nodes feature and edit it as the parameters
	 * @param ID ID of target
	 * @param sl list of states which are related by this Nodes relationship 
	 * @return edited Nodes feature
	 */
	/*
	public Nodes updateNodes(String docId, String Id, String attributeType,
			String updateType, List<String>object, Boolean deleteDuality) {
		Nodes target = null;
		if (Container.getInstance().hasFeature(docId, Id)) {
			IndoorGMLMap map = Container.getInstance().getDocument(docId);
			target = (Nodes)map.getFeature(Id);
			if(attributeType.equals("stateMember")){
				List<State>stateMember = target.getStateMember();
				if(updateType != null){
					if(updateType.equals("add")){
						for(int i = 0 ; i < object.size(); i++){
							State temp = new State(map);
							temp.setId(object.get(i));
							stateMember.add(temp);
						}
						
					}
					else if(updateType.equals("remove")){
						for(int i = 0 ; i < object.size();i++){
							if(stateMember.contains(object.get(i))){
								stateMember.remove(object.get(i));
								StateDAO.deleteState(docId, object.get(i),deleteDuality);
							}
							
						}
						target.clearStateMember();
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
	*/
	
	/**
	 * Search Nodes feature and delete it
	 * @param ID ID of target
	 */
	/*
	public static void deleteNodes(String docId, String id, Boolean deleteDuality) {	
		if (Container.getInstance().hasFeature(docId, id)) {
			IndoorGMLMap doc = Container.getInstance().getDocument(docId);
			Nodes target = (Nodes) doc.getFeature(id);
			// String duality = target.getd;
			doc.deleteFeature(id, "Nodes");
			for(int i = 0 ; i < target.getStateMember().size();i++){
				StateDAO.deleteState(docId, target.getStateMember().get(i).getId(), deleteDuality);
			}
			
		}
	}
	*/

}
