package edu.pnu.stem.dao;


import java.util.UUID;

import edu.pnu.stem.binder.IndoorGMLMap;
import edu.pnu.stem.feature.IndoorFeatures;
import edu.pnu.stem.feature.MultiLayeredGraph;



public class MultiLayeredGraphDAO {

	/*
	public static MultiLayeredGraph createMultiLayeredGraph(IndoorGMLMap map, String parentId, String id, List<String>spaceLayers, List<String>interEdges){
		MultiLayeredGraph newFeature = new MultiLayeredGraph(map);
		newFeature.setId(id);
		
		IndoorFeatures parent = new IndoorFeatures(map);
		parent.setId(parentId);
		newFeature.setParent(parent);
		if (spaceLayers!= null) {
			List<SpaceLayers>tempSpaceLayers = new ArrayList<SpaceLayers>();
			for(int i = 0 ; i < spaceLayers.size() ; i++){
				SpaceLayers temp = new SpaceLayers(map);
				temp.setId(spaceLayers.get(i));
				tempSpaceLayers.add(temp);
			}
			newFeature.setSpaceLayers(tempSpaceLayers);
		}
		else if(spaceLayers == null){
			System.out.println("Error at createMultiLayeredGraph : there is no enough SpaceLayersType instance");
		}
		if (interEdges != null) {
			List<InterEdges>tempInterEdges = new ArrayList<InterEdges>();
			for(int i = 0 ; i < interEdges.size(); i++){
				InterEdges temp = new InterEdges(map);
				temp.setId(interEdges.get(i));
				tempInterEdges.add(temp);
			}
			newFeature.setInterEdges(tempInterEdges);
		}
		map.setFeature(id, "MultiLayeredGraph", newFeature);
		return newFeature;
	}
	*/

	public static MultiLayeredGraph createMultiLayeredGraph(IndoorGMLMap map, String parentId, String id) {
		if(id == null) {
			id = UUID.randomUUID().toString();
		}
		
		MultiLayeredGraph newFeature = (MultiLayeredGraph) map.getFutureFeature(id);
		if(newFeature == null){
			newFeature = new MultiLayeredGraph(map, id);
		}
		map.setFutureFeature(id, newFeature);
		map.setFeature(id, "MultiLayeredGraph", newFeature);
		
		IndoorFeatures parent = (IndoorFeatures) map.getFeature(parentId);
		if(parent == null){
			if(map.hasFutureID(parentId)){
				parent = (IndoorFeatures)map.getFutureFeature(parentId);
			}
			else{
				parent = new IndoorFeatures(map,parentId);
			}
		}		
		parent.setMultiLayeredGraph(newFeature);
		newFeature.setParent(parent);
		map.removeFutureID(id);

		return newFeature;
	}
	
	/*
	public static MultiLayeredGraph readMultilayeredGraph(String ID) {
		return null;
	}
	*/

	/*
	public static MultiLayeredGraph updateMultiLayeredGraph(String docId, String Id, String attributeType,
			String updateType, List<String>object ) {
		MultiLayeredGraph target = null;
		if (Container.getInstance().hasFeature(docId, Id)) {
			IndoorGMLMap map = Container.getInstance().getDocument(docId);
			target = (MultiLayeredGraph) map.getFeature(Id);
			if (attributeType.equals("spaceLayers")) {
				List<SpaceLayers>spaceLayers = target.getSpaceLayers();
				if(updateType.equals("add")){
					List<SpaceLayers>tempSpaceLayers = new ArrayList<SpaceLayers>();
					for(int i = 0 ; i < object.size(); i++){
						SpaceLayers temp = new SpaceLayers(map);
						temp.setId((String)object.get(i));
						tempSpaceLayers.add(temp);
					}
					target.setSpaceLayers(tempSpaceLayers);
				}
				else if(updateType.equals("delete")){
					for(int i = 0 ; i < object.size();i++){
						if(spaceLayers.contains(object.get(i))){
							spaceLayers.remove(object.get(i));
						}
					}
				target.clearSpaceLayers();
				//TODO : remove cellSpace at cellSpace container and ID container?
				}
				if(spaceLayers.size()!= 0){
					target.setSpaceLayers(spaceLayers);
				}
				else{
					System.out.println("Error at updateMultiLayeredGraph : there is no enough Spacelayers instance");
				}
			} else if (attributeType.equals("InterEdges")) {
				List<InterEdges>interEdges = target.getInterEdges();
				List<InterEdges>tempInterEdges = new ArrayList<InterEdges>();
				for(int i = 0 ; i < object.size() ; i++){
					InterEdges temp = new InterEdges(map);
					temp.setId((String)object.get(i));
				}
				if(updateType.equals("add")){
					target.setInterEdges(tempInterEdges);
				}
				else if(updateType.equals("delete")){
					for(int i = 0 ; i < object.size();i++){
						if(interEdges.contains(object.get(i))){
							interEdges.remove(object.get(i));
						}
					}
				target.clearInterEdges();
				//TODO : remove cellSpace at cellSpace container and ID container?
					//answer : because relationship is aggregation, so do not have.
				}
				target.setInterEdges(interEdges);
			}  else {
				System.out.println("update error in cellSpaceType : there is no such attribute name");
			}
		} else {
			System.out.println("there is no name with Id :" + Id + " in document Id : " + docId);
		}
		return target;
	}
	*/
	
	/*
	public static void deleteMultiLayeredGraph(String docId, String Id, Boolean deleteALL, Boolean deleteDuality) {
		if (Container.getInstance().hasFeature(docId, Id)) {
			IndoorGMLMap doc = Container.getInstance().getDocument(docId);
			MultiLayeredGraph target = (MultiLayeredGraph) Container.getInstance().getFeature(docId,
					Id);
			// String duality = target.getd;
			if(deleteALL){
				doc.deleteFeature(Id, "MultiLayeredGraph");
				NodesDAO.deleteNodes(docId, Id, deleteDuality);
				EdgesDAO.deleteEdges(docId, Id, deleteDuality);
			}	
			else if(target.getInterEdges().size()==0&&target.getSpaceLayers().size()==0){
				for(int i = 0 ; i < target.getInterEdges().size(); i++){
					InterEdgesDAO.deleteInterEdges(docId, target.getInterEdges().get(i).getId());
				}
				
				for(int i = 0 ; i < target.getSpaceLayers().size() ; i++){
					SpaceLayersDAO.deleteSpaceLayers(docId, Id, deleteDuality);
				}
			}
			else{
				System.out.println("Warning at deleteMultilayeredGraph : If you want to delete this MultiLayeredGraph, then please put deleteALL parameter as True");
			}
			doc.getFeatureContainer("ID").remove(Id);
		}
	};
	*/
}
