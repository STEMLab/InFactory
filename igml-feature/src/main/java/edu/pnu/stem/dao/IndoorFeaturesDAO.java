package edu.pnu.stem.dao;
import java.util.UUID;

import edu.pnu.stem.binder.IndoorGMLMap;
import edu.pnu.stem.feature.core.Envelope;
import edu.pnu.stem.feature.core.IndoorFeatures;
import edu.pnu.stem.feature.core.MultiLayeredGraph;
import edu.pnu.stem.feature.core.PrimalSpaceFeatures;

public class IndoorFeaturesDAO {

	public static IndoorFeatures createIndoorFeatures(IndoorGMLMap map, String id, String name, String description, String envelope,
			String multiLayeredGraph, String primalSpaceFeatures ) {
		IndoorFeatures newFeature = new IndoorFeatures(map, id);
		
		if(map.hasFutureID(id)){
			newFeature = (IndoorFeatures)map.getFutureFeature(id);
			//map.removeFutureID(id);
		}
		else{
			newFeature = new IndoorFeatures(map, id);
		}
		map.setFutureFeature(id, newFeature);
		if(name != null) {
			newFeature.setName(name);
		}
		
		if(description != null) {
			newFeature.setDescription(description);
		}
		if (envelope!= null) {
			Envelope newEnvelope = new Envelope(map, envelope);
			newFeature.setBoundedBy(newEnvelope);
		}		
		//newFeature.setParentID(parentID);
		if (primalSpaceFeatures!= null) {
			PrimalSpaceFeatures newPrimalSpaceFeatures = new PrimalSpaceFeatures(map, primalSpaceFeatures);
			newFeature.setPrimalSpaceFeatures(newPrimalSpaceFeatures);
		}
		if (multiLayeredGraph != null) {
			MultiLayeredGraph newMultiLayeredGraph = new MultiLayeredGraph(map, multiLayeredGraph);
			newFeature.setMultiLayeredGraph(newMultiLayeredGraph);
		}
		map.removeFutureID(id);
		map.setFeature(id, "IndoorFeatures", newFeature);
		return newFeature;
	}
	
	public static IndoorFeatures createIndoorFeatures(IndoorGMLMap map, String id) {
		if(id == null) {
			id = UUID.randomUUID().toString();
		}
		
		IndoorFeatures newFeature = null;
		
		if(map.hasFutureID(id)){
			newFeature = (IndoorFeatures)map.getFutureFeature(id);
			//map.removeFutureID(id);
		}
		else{
			newFeature = new IndoorFeatures(map, id);
		}
		
		map.setFeature(id, "IndoorFeatures", newFeature);
		return newFeature;
	}
	
	public static IndoorFeatures readIndoorFeatures(IndoorGMLMap map, String id) {
		IndoorFeatures target = null;
		try {
			target = (IndoorFeatures)map.getFeature(id);
		}
		catch(NullPointerException e){
			e.printStackTrace();
		}
		return target;
	}

	public static IndoorFeatures updateIndoorFeatures(IndoorGMLMap map, String id, String name, String description, String multilayeredgraph, String primalspacefeatures) {
		IndoorFeatures result = new IndoorFeatures(map, id);
		IndoorFeatures target = (IndoorFeatures)map.getFeature(id);
		
		
		if(name != null) {
			result.setName(name);
		}
	
		
		if(description != null) {
			result.setDescription(description);
		}
		
		if(multilayeredgraph != null) {
			if(target.getMultiLayeredGraph() != null && !target.getMultiLayeredGraph().getId().equals(multilayeredgraph)) {
				result.setMultiLayeredGraph(new MultiLayeredGraph(map,multilayeredgraph));
			}
		}
		else {
			if(target.getMultiLayeredGraph() != null) {
				target.getMultiLayeredGraph().resetParent();
			}
		}
		
		if(primalspacefeatures != null) {
			if(target.getPrimalSpaceFeatures() != null && !target.getPrimalSpaceFeatures().getId().equals(primalspacefeatures)) {
				result.setPrimalSpaceFeatures(new PrimalSpaceFeatures(map,primalspacefeatures));
			}
		}
		else {
			if(target.getPrimalSpaceFeatures() != null) {
				target.getMultiLayeredGraph().resetParent();
			}
		}
		map.removeFeature(id);
		map.setFeature(id, "IndoorFeatures", result);
		return result;
		
	}
	
	public static void deleteIndoorFeatures(IndoorGMLMap map, String id) {
		IndoorFeatures target = (IndoorFeatures) map.getFeature(id);
		
		if(target.getMultiLayeredGraph() != null)
			target.getMultiLayeredGraph().resetParent();
		if(target.getPrimalSpaceFeatures() != null)
			target.getPrimalSpaceFeatures().resetParent();
		
		map.removeFeature(id);
	}

}
