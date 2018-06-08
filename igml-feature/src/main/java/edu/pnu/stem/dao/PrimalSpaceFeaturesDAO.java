package edu.pnu.stem.dao;


import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import edu.pnu.stem.binder.IndoorGMLMap;
import edu.pnu.stem.feature.CellSpace;
import edu.pnu.stem.feature.CellSpaceBoundary;
import edu.pnu.stem.feature.IndoorFeatures;
import edu.pnu.stem.feature.InterEdges;
import edu.pnu.stem.feature.PrimalSpaceFeatures;
import edu.pnu.stem.feature.SpaceLayers;

/**
 * 
 * @author jungh
 *	This class implements PrimalSpaceFeaturestype of IndoorGML-1.0.3
 */
public class PrimalSpaceFeaturesDAO {
	
	public static PrimalSpaceFeatures createPrimalSpaceFeatures(IndoorGMLMap map, String parentId, String id) {
		if (id == null) {
			id = UUID.randomUUID().toString();
		}
		PrimalSpaceFeatures newFeature = new PrimalSpaceFeatures(map, id);

		if(map.hasFutureID(id)){
			newFeature = (PrimalSpaceFeatures)map.getFutureFeature(id);
			//map.removeFutureID(id);
		}
		
		IndoorFeatures parent = (IndoorFeatures) map.getFeature(parentId);
		
		if(parent == null){
			if(map.hasFutureID(parentId)){
				map.getFutureFeature(parentId);
				//map.removeFutureID(parentId);
			}
			else{
				parent = new IndoorFeatures(map,parentId);
			}
		}
		
		parent.setPrimalSpaceFeatures(newFeature);
		newFeature.setParent(parent);
		
		map.setFeature(id, "PrimalSpaceFeatures", newFeature);
		return newFeature;
	}
	public static PrimalSpaceFeatures readPrimalSpaceFeatures(IndoorGMLMap map, String id) {
		PrimalSpaceFeatures target = null;
		try {
			target = (PrimalSpaceFeatures)map.getFeature(id);
		}
		catch(NullPointerException e){
			e.printStackTrace();
		}
		return target;
	}
	public static PrimalSpaceFeatures updatePrimalSpaceFeatures(IndoorGMLMap map, String parentId, String id, String name, String description, List<String>cellspacemembers, List<String>cellspaceboundarymembers) {
		PrimalSpaceFeatures result = new PrimalSpaceFeatures(map, id);
		PrimalSpaceFeatures target = (PrimalSpaceFeatures)map.getFeature(id);
		
		IndoorFeatures parent = target.getParent();
		if(parent.getId() != parentId) {
			IndoorFeatures newParent = new IndoorFeatures(map, parentId);
			parent.resetMultiLayerdGraph();
			result.setParent(newParent);
		}
		
		
		if(name != null) {
			result.setName(name);
		}
	
		
		if(description != null) {
			result.setDescription(description);
		}
		
		if(cellspacemembers != null) {
			List<CellSpace> oldChild = target.getCellSpaceMember();
			List<CellSpace> newChild = new ArrayList<CellSpace>();
			
			for(String ni : cellspacemembers) {
				newChild.add(new CellSpace(map,ni));
			}
			
			for(CellSpace n : oldChild) {
				if(!newChild.contains(n)) {
					oldChild.remove(n);
				}
			}
			
			for(CellSpace n : newChild) {
				if(!oldChild.contains(n)) {
					oldChild.add(n);
				}
			}
			
			result.setCellSpaceMember(oldChild);
			
		}
		else {
			if(target.getCellSpaceMember().size() != 0) {
				List<CellSpace> oldChild = target.getCellSpaceMember();
				
				for(CellSpace child : oldChild) {
					child.resetParent();
				}
			}
		}
		
		if(cellspaceboundarymembers != null) {
			List<CellSpaceBoundary> oldChild = target.getCellSpaceBoundaryMember();
			List<CellSpaceBoundary> newChild = new ArrayList<CellSpaceBoundary>();
			
			
			for(String ei :	cellspaceboundarymembers) {
				newChild.add(new CellSpaceBoundary(map,ei));
			}
			
			for(CellSpaceBoundary n : oldChild) {
				if(!newChild.contains(n)) {
					oldChild.remove(n);
				}
			}
			
			for(CellSpaceBoundary n : newChild) {
				if(!oldChild.contains(n)) {
					oldChild.add(n);
				}
			}

			
			result.setCellSpaceBoundaryMember(oldChild);
		}
		else {
			if(target.getCellSpaceBoundaryMember().size() != 0) {
				List<CellSpaceBoundary> oldChild = target.getCellSpaceBoundaryMember();
				
				for(CellSpaceBoundary child : oldChild) {
					child.resetParent();
				}
			}
		}
		
		map.getFeatureContainer("PrimalSpaceFeatures").remove(id);
		map.getFeatureContainer("PrimalSpaceFeatures").put(id, result);
		
		return result;
	}
}
