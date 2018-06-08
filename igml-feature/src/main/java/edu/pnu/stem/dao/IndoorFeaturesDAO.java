package edu.pnu.stem.dao;
import java.util.UUID;

import edu.pnu.stem.binder.IndoorGMLMap;
import edu.pnu.stem.feature.CellSpace;
import edu.pnu.stem.feature.IndoorFeatures;
import edu.pnu.stem.feature.MultiLayeredGraph;
import edu.pnu.stem.feature.PrimalSpaceFeatures;

public class IndoorFeaturesDAO {

	public static IndoorFeatures createIndoorFeatures(IndoorGMLMap map, String id,
			String primalSpaceFeatures, String multiLayeredGraph) {
		IndoorFeatures newFeature = new IndoorFeatures(map, id);
		
		//newFeature.setParentID(parentID);
		if (primalSpaceFeatures!= null) {
			PrimalSpaceFeatures newPrimalSpaceFeatures = new PrimalSpaceFeatures(map, primalSpaceFeatures);
			newFeature.setPrimalSpaceFeatures(newPrimalSpaceFeatures);
		}
		if (multiLayeredGraph != null) {
			MultiLayeredGraph newMultiLayeredGraph = new MultiLayeredGraph(map, multiLayeredGraph);
			newFeature.setMultiLayeredGraph(newMultiLayeredGraph);
		}
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
			if(target.getMultiLayeredGraph() != null && target.getMultiLayeredGraph().getId() != multilayeredgraph) {
				result.setMultiLayeredGraph(new MultiLayeredGraph(map,multilayeredgraph));
			}
		}
		else {
			if(target.getMultiLayeredGraph() != null) {
				target.getMultiLayeredGraph().resetParent();
			}
		}
		
		if(primalspacefeatures != null) {
			if(target.getPrimalSpaceFeatures() != null && target.getPrimalSpaceFeatures().getId() != primalspacefeatures) {
				result.setPrimalSpaceFeatures(new PrimalSpaceFeatures(map,primalspacefeatures));
			}
		}
		else {
			if(target.getPrimalSpaceFeatures() != null) {
				target.getMultiLayeredGraph().resetParent();
			}
		}
		
		return result;
		
	}

}
