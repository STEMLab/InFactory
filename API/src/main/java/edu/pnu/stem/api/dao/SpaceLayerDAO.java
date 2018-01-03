package edu.pnu.stem.api.dao;


import java.util.Date;
import java.util.List;

import edu.pnu.stem.binder.Container;
import edu.pnu.stem.binder.IndoorGMLMap;
import edu.pnu.stem.feature.SpaceLayer;


public class SpaceLayerDAO {
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

	public static SpaceLayer createSpaceLayer(String docID, String parentID, String ID,
			List<String>nodes, List<String>edges, Date creationDate, Date terminationDate, String function, String classType, String usage, List<String> codeType  ) {
		SpaceLayer newFeature = null;
		if (Container.getInstance().hasDoc(docID)) {
			newFeature.setId(ID);
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
			Container.getInstance().setFeature(docID, ID, "SpaceLayer", newFeature);
		}
		return newFeature;
	}
	/**
	 * Search SpaceLayer feature in document
	 * @param ID ID of target
	 * @return searched SpaceLayer feature instance
	 */
	public SpaceLayer readSpaceLayer(String ID) {
		return null;
	}

	/**
	 * Search SpaceLayer feature and edit it as the Parameters
	 * @param id ID of target
	 * @param usage Comment on usage
	 * @param function explanation about functionality of this SpaceLayer
	 * @param createDate the time when this SpaceLayer is created
	 * @param terminationDate the time when this SpaceLayer is expired
	 * @param n nodes which is contained in this SpaceLayer
	 * @param e	edges which is contained in this SpaceLayer
	 * @param ct SpaceLayerClassType of this SpaceLayer
	 * @return edited SpaceLayer feature instance
	 */
	public SpaceLayer updatePrimalSpaceFeatures(String docId, String Id, String attributeType,
			String updateType, List<String>objectMember, Object object , Boolean deleteDuality ) {
		SpaceLayer target = null;
		if (Container.getInstance().hasFeature(docId, Id)) {
			target = (SpaceLayer) Container.getInstance().getFeature(docId, Id);
			if (attributeType.equals("nodes")) {
				List<String>nodes = target.getNodes();
				if(updateType.equals("add")){
					nodes.addAll(objectMember);
				}
				//TODO : add cellSpace to cellSpace container and ID container
				else if(updateType.equals("delete")){
					for(int i = 0 ; i < objectMember.size();i++){
						if(nodes.contains(objectMember.get(i))){
							nodes.remove(objectMember.get(i));
							edu.pnu.stem.feature.Nodes singleNodes= (edu.pnu.stem.feature.Nodes)Container.getInstance().getFeature(docId, objectMember.get(i));
							List<String>stateMember = singleNodes.getStateMember();
							for(int j = 0 ; j < stateMember.size();j++){
								StateDAO.deleteState(docId, stateMember.get(i), deleteDuality);
							}
						}
					}
				//TODO : remove cellSpace at cellSpace container and ID container?
				}
				if(nodes.size() == 0){
					System.out.println("Error at updateSpaceLayer : there should be at least on NodesType instance at SpaceLayer");
				}
				else
					target.setNodes(nodes);
			} else if (attributeType.equals("edges")) {
				List<String>edges = target.getEdges();
				if(updateType.equals("add")){
					edges.addAll(objectMember);
				}
				//TODO : add cellSpace to cellSpace container and ID container
				else if(updateType.equals("delete")){
					for(int i = 0 ; i < objectMember.size();i++){
						if(edges.contains(objectMember.get(i))){
							edges.remove(objectMember.get(i));
							edu.pnu.stem.feature.Edges singleEdges= (edu.pnu.stem.feature.Edges)Container.getInstance().getFeature(docId, objectMember.get(i));
							List<String> edgesMember = singleEdges.getTransitionMembers();
							for(int j = 0 ; j < edgesMember.size();j++){
								EdgesDAO.deleteEdges(docId, edgesMember.get(i), false);
							}
						}
					}
	
				//TODO : remove cellSpace at cellSpace container and ID container?
					//answer : because relationship is aggregation, so do not have.
				}
				target.setEdges(edges);
			}else if(attributeType.equals("creationDate")){
				target.setCreateDate((Date)object);
			}else if(attributeType.equals("terminationDate")){
				target.setTerminationDate((Date)object);
			}else if(attributeType.equals("function")){
				//target.setFunction(function);
			}else if(attributeType.equals("usage")){
				target.setUsage((String)object);
			}else if(attributeType.equals("classType")){
				//TODO : 
			}else if(attributeType.equals("codeType")){
				//TODO : 
			}
			
			else {
				System.out.println("update error in cellSpaceType : there is no such attribute name");
			}
		} else {
			System.out.println("there is no name with Id :" + Id + " in document Id : " + docId);
		}
		Container.getInstance().setFeature(docId, Id, "SpaceLayer", target);
		return target;
	}
	/**
	 * Search SpaceLayer feature and delete it
	 * @param id ID of target
	 */
	public static void deleteSpaceLayer(String docId, String Id,Boolean deleteDuality) {
		if (Container.getInstance().hasFeature(docId, Id)) {
			IndoorGMLMap doc = Container.getInstance().getDocument(docId);
			SpaceLayer target = (SpaceLayer) Container.getInstance().getFeature(docId,
					Id);
			// String duality = target.getd;
			doc.getFeatureContainer("SpaceLayer").remove(Id);
			doc.getFeatureContainer("ID").remove(Id);
			List<String>nodes = target.getNodes();
			List<String>edges  = target.getEdges();
			
			for(int i = 0 ; i < nodes.size();i++){
				edu.pnu.stem.feature.Nodes singleNodes = (edu.pnu.stem.feature.Nodes)doc.getFeature(nodes.get(i));
				List<String>stateMembers = singleNodes.getStateMember();
				for(int j = 0 ; j < stateMembers.size();j++){
					StateDAO.deleteState(docId, stateMembers.get(i), false);
					//doc.getFeatureContainer("State").remove(stateMembers.get(i));
				}
				//Nodes.deleteNodes(docId, nodes.get(i));
				
			}
			
			
			for(int i = 0 ; i < edges.size();i++){
				edu.pnu.stem.feature.Edges singleEdges = (edu.pnu.stem.feature.Edges)doc.getFeature(nodes.get(i));
				List<String> transitionMember = singleEdges.getTransitionMembers();
				for(int j = 0 ; j < transitionMember.size();j++){
				
					//doc.getFeatureContainer("Transition").remove(stateMembers.get(i));
					TransitionDAO.deleteTransition(docId, transitionMember.get(i),deleteDuality);
				}
				//doc.getFeatureContainer("Edges").remove(nodes.get(i));
				
			}
			
		}
	}

}
