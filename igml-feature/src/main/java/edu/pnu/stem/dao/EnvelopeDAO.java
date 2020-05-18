package edu.pnu.stem.dao;

import java.math.BigInteger;
import java.util.UUID;

import org.locationtech.jts.geom.Geometry;

import edu.pnu.stem.binder.IndoorGMLMap;
import edu.pnu.stem.feature.core.Envelope;
import edu.pnu.stem.feature.core.IndoorFeatures;
import edu.pnu.stem.feature.core.Nodes;
import edu.pnu.stem.feature.core.PrimalSpaceFeatures;

public class EnvelopeDAO {
	public static Envelope readEnvelope(IndoorGMLMap map, String id) {
		Envelope target = null;
		try {
			target = (Envelope) map.getFeature(id);
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
		return target;
	}

	public static Envelope createEnvelope(IndoorGMLMap map, String parentId, String id, Geometry upperCorner,
			Geometry lowerCorner, String srsName, BigInteger srsDimension) {
	
		if (id == null) {
			id = UUID.randomUUID().toString();
		}
	

		Envelope newFeature = new Envelope(map, id);
		if (map.hasFutureID(id)) {
			newFeature = (Envelope)map.getFutureFeature(id);

			
			// map.removeFutureID(id);
		} else {
			map.setFutureFeature(id, newFeature);
			
		}
	

		IndoorFeatures parent = (IndoorFeatures) map.getFeature(parentId);
		if (parent == null) {
			
			if (map.hasFutureID(parentId)) {
				map.getFutureFeature(parentId);
				
				// map.removeFutureID(parentId);
			} else {
				parent = new IndoorFeatures(map, parentId);
				
			}
		}

		if (upperCorner != null) {

			newFeature.setUpperCorner(upperCorner);
	
		}
		if (lowerCorner != null) {

			newFeature.setLowerCorner(lowerCorner);
			
		}

		if (srsName != null) {
			newFeature.setSrsName(srsName);
			
		}

		if (srsDimension != null) {
			newFeature.setSrsDimension(srsDimension);
			
		}

		parent.setBoundedBy(newFeature);		
		newFeature.setParent(parent);
		map.removeFutureID(id);
		map.setFeature(id, "Envelope", newFeature);		
		return newFeature;
		
	}

	public static void deleteEnvelope(IndoorGMLMap map, String id) {
		Envelope target = (Envelope) map.getFeature(id);

		if (target == null) {
			if (map.hasFutureID(id))
				target = (Envelope) map.getFutureFeature(id);
		}
		IndoorFeatures parent = target.getParent();

		map.removeFeature(id);
	}

	public static Envelope updateEnvelope(IndoorGMLMap map, String parentId, String id, Geometry upperCorner,
			Geometry lowerCorner, String srsName, int srsDimension) {
		Envelope result = new Envelope(map, id);
		Envelope target = (Envelope) map.getFeature(id);
		return result;

	}

}
