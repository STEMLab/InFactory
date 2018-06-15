package edu.pnu.stem.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.fasterxml.jackson.databind.JsonNode;
import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.geom.LineString;
import com.vividsolutions.jts.geom.Polygon;
import com.vividsolutions.jts.io.ParseException;
import com.vividsolutions.jts.io.WKTReader;

import edu.pnu.stem.binder.IndoorGMLMap;
import edu.pnu.stem.feature.CellSpace;
import edu.pnu.stem.feature.CellSpaceBoundary;
import edu.pnu.stem.feature.PrimalSpaceFeatures;
import edu.pnu.stem.feature.State;
import edu.pnu.stem.feature.Transition;
import edu.pnu.stem.geometry.jts.WKTReader3D;

/**
 * @author jungh
 * 
 */
public class CellSpaceBoundaryDAO {

	public static CellSpaceBoundary createCellSpaceBoundary(IndoorGMLMap map, String parentId, String id,
			String geometry, String duality) {
		if (id == null) {
			id = UUID.randomUUID().toString();
		}

		CellSpaceBoundary newFeature = new CellSpaceBoundary(map, id);

		if (map.hasFutureID(id)) {
			newFeature = (CellSpaceBoundary) map.getFutureFeature(id);
			// map.removeFutureID(id);
		} else {
			map.setFutureFeature(id, newFeature);
		}
		map.setFeature(id, "CellSpaceBoundary", newFeature);

		PrimalSpaceFeatures parent = (PrimalSpaceFeatures) map.getFeature(parentId);
		if (parent == null) {
			if (map.hasFutureID(parentId)) {
				parent = (PrimalSpaceFeatures) map.getFutureFeature(parentId);
			} else {
				parent = new PrimalSpaceFeatures(map, parentId);
			}
		}

		List<CellSpaceBoundary> cellSpaceBoundaryMember = new ArrayList<CellSpaceBoundary>();
		cellSpaceBoundaryMember.add(newFeature);
		parent.setCellSpaceBoundaryMember(cellSpaceBoundaryMember);
		newFeature.setParent(parent);

		if (geometry != null) {
			WKTReader3D wkt = new WKTReader3D();
			try {
				Polygon p = (Polygon) wkt.read(geometry);
				map.setFeature4Geometry(UUID.randomUUID().toString(), p);
				newFeature.setGeometry(p);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}

		if (duality != null) {
			Transition dualityFeature = (Transition) map.getFeature(duality);
			if (dualityFeature == null) {
				dualityFeature = new Transition(map, duality);
				dualityFeature.setDuality(newFeature);
				map.setFutureFeature(duality, dualityFeature);
			} else {
				dualityFeature.setDuality(newFeature);
			}
			newFeature.setDuality(dualityFeature);
		}

		map.removeFutureID(id);
		return newFeature;
	}
	public static CellSpaceBoundary readCellSpaceBoundary(IndoorGMLMap map, String id) {
		CellSpaceBoundary target = null;
		try {
			target = (CellSpaceBoundary)map.getFeature(id);
		}
		catch(NullPointerException e){
			e.printStackTrace();
		}
		return target;
	}
	public static CellSpaceBoundary createCellSpaceBoundary(IndoorGMLMap map, String parentId, String id,
			String name, String description, Geometry geometry, String duality) {
		if (id == null) {
			id = UUID.randomUUID().toString();
		}

		CellSpaceBoundary newFeature = new CellSpaceBoundary(map, id);;

		if (map.hasFutureID(id)) {
			newFeature = (CellSpaceBoundary) map.getFutureFeature(id);
			// map.removeFutureID(id);
		} else {
			map.setFutureFeature(id, newFeature);
		}

		map.setFeature(id, "CellSpaceBoundary", newFeature);
		PrimalSpaceFeatures parent = (PrimalSpaceFeatures) map.getFeature(parentId);
		if (parent == null) {
			if (map.hasFutureID(parentId)) {
				parent = (PrimalSpaceFeatures) map.getFutureFeature(parentId);
				map.removeFutureID(parentId);
			} else {
				parent = new PrimalSpaceFeatures(map, parentId);
			}
		}

		parent.addCellSpaceBoundaryMember(newFeature);
		newFeature.setParent(parent);
		
		if(name != null) {
			newFeature.setName(name);
		}
		
		if(description != null) {
			newFeature.setDescription(description);
		}
		
		if (geometry != null) {
			newFeature.setGeometry(geometry);
		}

		if (duality != null) {
			Transition dualityFeature = (Transition) map.getFeature(duality);
			if (dualityFeature == null) {
				dualityFeature = new Transition(map, duality);
				dualityFeature.setDuality(newFeature);
				map.setFutureFeature(duality, dualityFeature);
			} else {
				dualityFeature.setDuality(newFeature);
			}
			newFeature.setDuality(dualityFeature);
		}

		
		
		return newFeature;
	}

	public static CellSpaceBoundary updateCellSpaceBoundary(IndoorGMLMap map, String parentId, String id,
			String name, String description, Geometry geometry, String duality) {
		CellSpaceBoundary result = new CellSpaceBoundary(map, id);
		CellSpaceBoundary target = (CellSpaceBoundary)map.getFeature(id);
		
		PrimalSpaceFeatures parent = target.getParent();
		if(parent.getId() != parentId) {
			parent.deleteCellSpaceMember(id);
			PrimalSpaceFeatures oldParent = target.getParent();
			PrimalSpaceFeatures newParent = new PrimalSpaceFeatures(map, parentId);
			oldParent.deleteCellSpaceMember(id);
			result.setParent(newParent);
		}
		
		if(name != null) {
			result.setName(name);
		}
		
		if(description != null) {
			result.setDescription(description);
		}
		
		if(geometry != null) {
			result.setGeometry(geometry);
		}
		
		if(duality == null) {
			Transition d = (Transition) target.getDuality();
			d.resetDuality();
		}
		else{
			if(target.getDuality() != null) {
				if(target.getDuality().getId() != duality) {
					Transition oldDuality = target.getDuality();
					oldDuality.resetDuality();				
				}
			}
			
			Transition newDuality = new Transition(map,duality);
			result.setDuality(newDuality);
			
		}
		
		return result;
		
	}
	public static void deleteCellSpaceBoundary(IndoorGMLMap map, String id) {
		CellSpaceBoundary target = (CellSpaceBoundary)map.getFeature(id);
		PrimalSpaceFeatures parent = target.getParent();
		parent.deleteCellSpaceBoundaryMember(id);
		
		if(target.hasDuality()) {
			Transition duality = target.getDuality();
			duality.resetDuality();
		}
		
		//cellspace 찾아가서 partialboundedby 해제
		 CellSpace cellspaceForPartialBoundedBy = target.getCellSpace();
		 cellspaceForPartialBoundedBy.deletePartialBoundedBy(target);
		
		map.removeFeature(id);
	}
}
