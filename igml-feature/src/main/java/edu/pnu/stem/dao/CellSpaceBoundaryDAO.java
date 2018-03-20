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
import edu.pnu.stem.feature.CellSpaceBoundary;
import edu.pnu.stem.feature.PrimalSpaceFeatures;
import edu.pnu.stem.feature.Transition;
import edu.pnu.stem.geometry.jts.WKTReader3D;

/**
 * @author jungh
 * 
 */
public class CellSpaceBoundaryDAO {

	/*
	 * public static FeatureClassReference.CellSpaceBoundary
	 * createCellSpaceBoundary(String docId, String ID, String parentID) {
	 * FeatureClassReference.CellSpaceBoundary newFeature = null; if
	 * (Container.getInstance().hasDoc(docId)) { newFeature = new
	 * FeatureClassReference.CellSpaceBoundary(); newFeature.setID(ID);
	 * newFeature.setParentID(ID); Container.getInstance().setFeature(docId, ID,
	 * "CellSpaceBoundary", newFeature);
	 * 
	 * } return newFeature; }
	 * 
	 */

	/*
	 * public static CellSpaceBoundary createCellSpaceBoundary(IndoorGMLMap map,
	 * String parentId, String ID, String name, String description, String
	 * duality, String cellSpaceBoundaryGeometry, ExternalReference
	 * externalReference) { if(id == null) { id = UUID.randomUUID().toString();
	 * }
	 * 
	 * CellSpaceBoundary newFeature = new CellSpaceBoundary(map, id);
	 * PrimalSpaceFeatures parent = new PrimalSpaceFeatures(map);
	 * parent.setId(parentId); newFeature.setParent(parent); if (name != null) {
	 * newFeature.setName(name); } if (duality != null) { Transition
	 * dualityTransition = new Transition(map);
	 * dualityTransition.setId(duality);
	 * newFeature.setDuality(dualityTransition);
	 * if(map.getFeatureContainer("Reference").containsKey(duality)){ int count
	 * = (int) map.getFeatureContainer("Reference").get(duality); count++;
	 * map.setFeature(ID, "Reference", count); }
	 * 
	 * } if (externalReference != null) {
	 * newFeature.setExternalReference(externalReference); } if
	 * (cellSpaceBoundaryGeometry != null) {
	 * newFeature.setCellSpaceBoundaryGeometry(cellSpaceBoundaryGeometry); }
	 * map.setFeature(ID, "CellSpaceBoundary", newFeature); map.setFeature(ID,
	 * "ID", "CellSpaceBoundary"); return newFeature; }
	 */

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

	public static CellSpaceBoundary createCellSpaceBoundary(IndoorGMLMap map, String parentId, String id,
			JsonNode geometry, String duality) {
		if (id == null) {
			id = UUID.randomUUID().toString();
		}

		CellSpaceBoundary newFeature = null;

		if (map.hasFutureID(id)) {
			newFeature = (CellSpaceBoundary) map.getFutureFeature(id);
			// map.removeFutureID(id);
		} else {
			newFeature = new CellSpaceBoundary(map, id);
		}

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

		if (geometry != null) {
			if (geometry.has("coordinates")) {
				/*
				 * String geometryType =
				 * geometry.get("properties").get("type").asText().trim();
				 * JsonNode surface =
				 * Convert2GeoJsonGeometry.convert2GeoJson(geometry,
				 * "CellSpaceBoundary"); GeoJSON3DReader reader = new
				 * GeoJSON3DReader(); Polygon resultSolid =
				 * (Polygon)reader.read(surface.toString());
				 * map.setFeature4Geometry(geometry.get("properties").get("id").
				 * asText().trim(), resultSolid);
				 * newFeature.setGeometry(resultSolid);
				 * 
				 */
				WKTReader3D wkt = new WKTReader3D();
				try {
					Polygon p = (Polygon) wkt.read(geometry.get("coordinates").asText().trim());
					map.setFeature4Geometry(UUID.randomUUID().toString(), p);
					newFeature.setGeometry(p);
				} catch (ParseException e) {
					e.printStackTrace();
				}

			} else {
				WKTReader3D wkt = new WKTReader3D();
				try {
					Geometry wktG = wkt.read(geometry.asText().trim());
					if (wktG instanceof Polygon) {
						Polygon p = (Polygon) wktG;
						map.setFeature4Geometry(UUID.randomUUID().toString(), p);
						newFeature.setGeometry(p);
					}
					//
					else {
						WKTReader wkt2D = new WKTReader();
						LineString p = (LineString) wkt2D.read(geometry.asText().trim());
						map.setFeature4Geometry(UUID.randomUUID().toString(), p);
						newFeature.setGeometry(p);
					}

				} catch (ParseException e) {
					e.printStackTrace();
				}

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

		map.setFeature(id, "CellSpaceBoundary", newFeature);
		return newFeature;
	}

	/**
	 * Create CellSpaceBoundary feature instance
	 * 
	 * @param ID
	 *            ID of CellSpaceBoundary
	 * @param parentID
	 * @param duality
	 *            transition which has duality relationship with this
	 *            CellSpaceBonudary
	 * @param csbGeometry
	 *            geometry of CellSpaceBoundary
	 * @param er
	 *            ExternalReference of this feature
	 * @return created CellSpaceBoundary
	 */

	/**
	 * search CellSpaceBoundary feature instance in document
	 * 
	 * @param ID
	 *            ID of target
	 * @return searched feature
	 */
	/*
	 * public static CellSpaceBoundary readCellSpaceBoundary(IndoorGMLMap map,
	 * String ID) { return (CellSpaceBoundary) map.getFeature(ID); };
	 */

	/**
	 * search the CellSpaceBoundaryfeature and edit it as parameters
	 * 
	 * @param id
	 *            ID of target
	 * @param duality
	 * @param csbGeometry
	 *            Geometry of CellSpaceBoundary
	 * @param er
	 *            ExternalReference of this feature
	 * @return edited feature
	 */

	/*
	 * public CellSpaceBoundary updateCellSpaceBoundary(IndoorGMLMap map, String
	 * id, String attributeType, String attributeId, Object o) {
	 * CellSpaceBoundary target = null; target = (CellSpaceBoundary)
	 * map.getFeature(id); if (attributeType.equals("cellSpaceBoundaryGeometry")
	 * ) { // TODO: need to implement geometry class at IndoorGMLAPI } else if
	 * (attributeType == "duality") { Transition tempDuality =
	 * target.getDuality(); target.setDuality((Transition)o); if
	 * (map.getFeatureContainer("Reference").containsKey(attributeId)) { int
	 * count = (Integer) map.getFeatureContainer("Reference").get(attributeId);
	 * count++; map.setFeature(attributeId, "Reference", count); } if
	 * (map.getFeatureContainer("Reference").containsKey(tempDuality.getId())) {
	 * int count = (Integer)
	 * map.getFeatureContainer("Reference").get(tempDuality); if(count > 0)
	 * count--; map.setFeature(tempDuality.getId(), "Reference", count); }
	 * target.setDuality((Transition)o); map.setFeature(attributeId,
	 * "Transition", o); } else if(attributeType.equals("name")){
	 * target.setName((String)o); } else
	 * if(attributeType.equals("description")){ //TODO : add description at
	 * FeatureClassReference.CellSpaceBoundary } else if
	 * (attributeType.equals("externalReference") ) { //TODO
	 * target.setExternalReference(attributeId);
	 * Container.getInstance().setFeature(docId, attributeId,
	 * "ExternaReference", o); } else { System.out.
	 * println("update error in cellSpaceType : there is no such attribute name"
	 * ); } return target; }
	 */

	/**
	 * search the CellSpaceBoundary feature and delete it
	 * 
	 * @param id
	 *            ID of target
	 */
	/*
	 * public static void deleteCellSpaceBoundary(IndoorGMLMap map, String Id,
	 * Boolean deleteDuality) { CellSpaceBoundary target = (CellSpaceBoundary)
	 * map.getFeature(Id); // String duality = target.getd; if(deleteDuality){
	 * int count = (int)
	 * map.getFeatureContainer("Reference").get(target.getDuality()); if(count
	 * == 1){ TransitionDAO.deleteTransition(map,
	 * target.getDuality().getId(),false);
	 * map.getFeatureContainer("Reference").remove(target.getDuality()); } else{
	 * map.setFeature(target.getDuality().getId(), "Reference", (count-1)); }
	 * 
	 * }
	 * 
	 * // ExdeleteExternalReference()
	 * 
	 * map.getFeatureContainer("ExternalReference").remove(target.
	 * getExternalReference());
	 * map.getFeatureContainer("CellSpaceBoundary").remove(Id);
	 * map.getFeatureContainer("ID").remove(target.getExternalReference()); };
	 */
}
