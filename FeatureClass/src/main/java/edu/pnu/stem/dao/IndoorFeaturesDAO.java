package edu.pnu.stem.dao;
import java.util.UUID;

import edu.pnu.stem.binder.IndoorGMLMap;
import edu.pnu.stem.feature.IndoorFeatures;
import edu.pnu.stem.feature.MultiLayeredGraph;
import edu.pnu.stem.feature.PrimalSpaceFeatures;

public class IndoorFeaturesDAO {

	/**
	 * @param docID
	 * @param parentID
	 * @param ID
	 * @param primalSpaceFeatures
	 * @param multiLayeredGraph
	 * @return
	 */
	public static IndoorFeatures createIndoorFeatures(IndoorGMLMap map, String id,
			String primalSpaceFeatures, String multiLayeredGraph) {
		IndoorFeatures newFeature = new IndoorFeatures(map);
		newFeature.setId(id);
		//newFeature.setParentID(parentID);
		if (primalSpaceFeatures!= null) {
			PrimalSpaceFeatures newPrimalSpaceFeatures = new PrimalSpaceFeatures(map);
			newPrimalSpaceFeatures.setId(primalSpaceFeatures);
			newFeature.setPrimalSpaceFeatures(newPrimalSpaceFeatures);
		}
		if (multiLayeredGraph != null) {
			MultiLayeredGraph newMultiLayeredGraph = new MultiLayeredGraph(map);
			newMultiLayeredGraph.setId(multiLayeredGraph);
			newFeature.setMultiLayeredGraph(newMultiLayeredGraph);
		}
		map.setFeature(id, "IndoorFeatures", newFeature);
		return newFeature;
	}
	
	/**
	 * @param docId
	 * @param id
	 * @return
	 */
	public static IndoorFeatures createIndoorFeatures(IndoorGMLMap map, String id) {
		IndoorFeatures newFeature = new IndoorFeatures(map);
			
		if(id == null) {
			id = UUID.randomUUID().toString();
		}
		newFeature.setId(id);
		map.setFeature(id, "IndoorFeatures", newFeature);
		return newFeature;
	}
	
	/**
	 * Search IndoorFeatures feature instance in document
	 * @param ID ID of target
	 * @return searched feature
	 */
	public IndoorFeatures readIndoorFeatures(String docId, String id) {
		/*
		IndoorFeatures target = null;
		target = (IndoorFeatures)Container.getDocument(docId).getFeature(id);
		return target;
		*/
		return null;
	};

	public IndoorFeatures updateIndoorFeatures(String docId, String Id, String attributeType,
			String object ) {
		/*
		IndoorFeatures target = null;
		if (Container.getInstance().hasFeature(docId, Id)) {
			IndoorGMLMap map = Container.getInstance().getDocument(docId);
			target = (IndoorFeatures) map.getFeature(Id);
			if (attributeType.equals("primalSpaceFeatures")) {
				PrimalSpaceFeatures newPrimalSpaceFeatures = new PrimalSpaceFeatures(map);
				newPrimalSpaceFeatures.setId(object);
				target.setPrimalSpaceFeatures(newPrimalSpaceFeatures);
				//TODO : add cellSpace to cellSpace container and ID container				
			} else if (attributeType.equals("multiLayeredGraph")) {
				MultiLayeredGraph newMultiLayeredGraph = new MultiLayeredGraph(map);
				newMultiLayeredGraph.setId(object);
				target.setMultiLayeredGraph(newMultiLayeredGraph);
			}  else {
				System.out.println("update error in cellSpaceType : there is no such attribute name");
			}
		} else {
			System.out.println("there is no name with Id :" + Id + " in document Id : " + docId);
		}
		return target;
		*/
		return null;
	}
	
	/**
	 * Search IndoorFeatures feature instance and delete it
	 * @param id ID of target
	 */
	public void deleteIndoorFeatures(String docId, String Id, boolean deleteChild) {
		/*
		if (Container.getInstance().hasFeature(docId, Id)) {
			IndoorGMLMap doc = Container.getInstance().getDocument(docId);
			IndoorFeatures target = (IndoorFeatures) doc.getFeature(Id);
			// String duality = target.getd;
			doc.getFeatureContainer("IndoorFeatures").remove(Id);
			doc.getFeatureContainer("ID").remove(Id);
			if(deleteChild){
				PrimalSpaceFeaturesDAO.deletePrimalSpaceFeatures(docId, target.getPrimalSpaceFeatures().getId());
				MultiLayeredGraphDAO.deleteMultiLayeredGraph(docId, Id, true, true);
			}
		}
		*/
	};

}
