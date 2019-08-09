package edu.pnu.stem.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.io.ParseException;

import edu.pnu.stem.binder.IndoorGMLMap;
import edu.pnu.stem.feature.core.CellSpace;
import edu.pnu.stem.feature.core.CellSpaceBoundary;
import edu.pnu.stem.feature.core.PrimalSpaceFeatures;
import edu.pnu.stem.feature.core.State;
import edu.pnu.stem.feature.navigation.ConnectionSpace;
import edu.pnu.stem.geometry.jts.Solid;
import edu.pnu.stem.geometry.jts.WKTReader3D;

public class ConnectionSpaceDAO {
	public static void deleteConnectionSpace(IndoorGMLMap map, String id) {
		ConnectionSpace target = (ConnectionSpace) map.getFeature(id);
		PrimalSpaceFeatures parent = target.getParent();
		parent.deleteCellSpaceMember(id);

		if (target.hasDuality()) {
			State duality = target.getDuality();
			duality.resetDuality();
		}
		map.removeFeature(id);
	}

	public static ConnectionSpace readConnectionSpace(IndoorGMLMap map, String id) {
		ConnectionSpace target = null;
		try {
			target = (ConnectionSpace) map.getFeature(id);
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
		return target;
	}

	public static ConnectionSpace updateConnectionSpace(IndoorGMLMap map, String parentId, String id, String name,	String description, Geometry geometry, String duality, List<String> partialboundedBy) {
		ConnectionSpace result = new ConnectionSpace(map, id);
		ConnectionSpace target = (ConnectionSpace) map.getFeature(id);

		PrimalSpaceFeatures parent = target.getParent();

		if (!parent.getId().equals(parentId)) {
			parent.deleteCellSpaceMember(id);
			PrimalSpaceFeatures newParent = new PrimalSpaceFeatures(map, parentId);
			result.setParent(newParent);
			result.getParent().addCellSpaceMember(result);
		} else {
			result.setParent(parent);
		}

		if (name != null) {
			result.setName(name);
		}

		if (description != null) {
			result.setDescription(description);
		}

		if (geometry != null) {
			result.setGeometry(geometry);
		}

		if (duality == null) {
			State d = target.getDuality();
			if (d != null)
				d.resetDuality();
		} else {
			if (target.getDuality() != null) {
				if (!target.getDuality().getId().equals(duality)) {
					State oldDuality = target.getDuality();
					oldDuality.resetDuality();
				}
			}

			State newDuality = new State(map, duality);
			result.setDuality(newDuality);

		}

		if (partialboundedBy != null) {
			List<CellSpaceBoundary> pbb = new ArrayList<CellSpaceBoundary>();
			for (String csbi : partialboundedBy) {
				CellSpaceBoundary temp = new CellSpaceBoundary(map, csbi);
				pbb.add(temp);
			}
			result.setPartialboundedBy(pbb);
		}

		map.removeFeature(id);
		map.setFeature(id, "ConnectionSpace", result);

		return result;
	}

	public static ConnectionSpace createConnectionSpace(IndoorGMLMap map, String parentId, String id, String name,	String description, Geometry geometry, String duality, List<String> partialBoundedBy, String classType,	String functionType, String usageType) {
		
		if (id == null) {
			id = UUID.randomUUID().toString();
		}

		ConnectionSpace newFeature = new ConnectionSpace(map, id);

		if (map.hasFutureID(id)) {
			newFeature = (ConnectionSpace) map.getFutureFeature(id);
			// map.removeFutureID(id);
		} else {
			map.setFutureFeature(id, newFeature);
		}
		map.setFeature(id, "ConnectionSpace", newFeature);

		PrimalSpaceFeatures parent = (PrimalSpaceFeatures) map.getFeature(parentId);

		if (parent == null) {
			if (map.hasFutureID(parentId)) {
				parent = (PrimalSpaceFeatures) map.getFutureFeature(parentId);
			} else {
				parent = new PrimalSpaceFeatures(map, parentId);

			}
		}

		if (name != null) {
			newFeature.setName(name);
		}

		if (description != null) {
			newFeature.setDescription(description);
		}
		if (classType != null) {

			newFeature.setClassType(classType);
			System.out.println("classType");
		}
		if (functionType != null) {
			newFeature.setFunctionType(functionType);
			System.out.println("functionType");
		}
		if (usageType != null) {
			newFeature.setUsageType(usageType);
			System.out.println("usageType");
		}

		// parent.addCellSpaceMember(newFeature);
		List<CellSpace> cellSpaceMember = parent.getCellSpaceMember();
		if (cellSpaceMember == null)
			cellSpaceMember = new ArrayList<CellSpace>();

		cellSpaceMember.add(newFeature);
		parent.setCellSpaceMember(cellSpaceMember);
		newFeature.setParent(parent);

		if (geometry != null) {
			newFeature.setGeometry(geometry);
		}

		if (duality != null) {
			State dualityFeature = (State) map.getFeature(duality);

			if (dualityFeature == null) {
				dualityFeature = new State(map, duality);
			}

			dualityFeature.setDuality(newFeature);
			newFeature.setDuality(dualityFeature);

		}

		if (partialBoundedBy != null) {
			List<CellSpaceBoundary> realPartialBoundedBy = new ArrayList<CellSpaceBoundary>();
			for (String b : partialBoundedBy) {
				CellSpaceBoundary pb = (CellSpaceBoundary) map.getFeature(b);
				if (pb == null) {
					pb = new CellSpaceBoundary(map, b);
				}
				realPartialBoundedBy.add(pb);
			}
			newFeature.setPartialboundedBy(realPartialBoundedBy);
		}
		map.removeFutureID(id);

		return newFeature;
	}

	public static ConnectionSpace createConnectionSpace(IndoorGMLMap map, String parentId, String id, String geometry,
			String duality) {

		if (id == null) {
			id = UUID.randomUUID().toString();
		}

		ConnectionSpace newFeature = new ConnectionSpace(map, id);
		if (map.hasFutureID(id)) {
			newFeature = (ConnectionSpace) map.getFutureFeature(id);
			// map.removeFutureID(id);
		} else {
			map.setFutureFeature(id, newFeature);
		}
		map.setFeature(id, "ConnectionSpace", newFeature);

		PrimalSpaceFeatures parent = (PrimalSpaceFeatures) map.getFeature(parentId);

		if (parent == null) {
			if (map.hasFutureID(parentId)) {
				parent = (PrimalSpaceFeatures) map.getFutureFeature(parentId);
			} else {
				parent = new PrimalSpaceFeatures(map, parentId);
			}
		}

		// parent.addCellSpaceMember(newFeature);
		ArrayList<CellSpace> cellSpaceMember = new ArrayList<CellSpace>();
		cellSpaceMember.add(newFeature);
		parent.setCellSpaceMember(cellSpaceMember);
		newFeature.setParent(parent);

		if (geometry != null) {
			WKTReader3D wkt = new WKTReader3D();
			try {

				Solid s = (Solid) wkt.read(geometry);
				map.setFeature4Geometry(UUID.randomUUID().toString(), s);
				newFeature.setGeometry(s);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		if (duality != null) {
			State dualityFeature = (State) map.getFeature(duality);

			if (dualityFeature == null) {
				dualityFeature = new State(map, duality);
			}

			dualityFeature.setDuality(newFeature);
			newFeature.setDuality(dualityFeature);

		}
		map.removeFutureID(id);

		return newFeature;
	}

}
