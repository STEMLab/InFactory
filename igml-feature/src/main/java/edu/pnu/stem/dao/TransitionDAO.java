package edu.pnu.stem.dao;


import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.geom.LineString;
import org.locationtech.jts.io.ParseException;
import org.locationtech.jts.io.WKTReader;

import com.fasterxml.jackson.databind.JsonNode;

import edu.pnu.stem.binder.IndoorGMLMap;
import edu.pnu.stem.feature.core.CellSpaceBoundary;
import edu.pnu.stem.feature.core.Edges;
import edu.pnu.stem.feature.core.State;
import edu.pnu.stem.feature.core.Transition;

public class TransitionDAO {

	public static Transition createTransition(IndoorGMLMap map, String parentId,
			String id, String name, String description, Geometry geometry, String duality, String[] connects, double weight) {
		if(id == null) {
			id = UUID.randomUUID().toString();
		}
		Transition newFeature = new Transition(map, id);
		
		if (map.hasFutureID(id)) {
			newFeature = (Transition) map.getFutureFeature(id);
			// map.removeFutureID(id);
		} else {
			map.setFutureFeature(id, newFeature);
		}
		
		map.setFeature(id, "Transition", newFeature);
		
		Edges parent = (Edges) map.getFeature(parentId);
		
		if(parent == null){
			if(map.hasFutureID(parentId)){
				parent = (Edges)map.getFutureFeature(parentId);
			}
			else{
				parent = new Edges(map,parentId);
			}
		}
		
		List<Transition>tm = parent.getTransitionMember();
		if(tm == null)
			tm = new ArrayList<Transition>();
		
		tm.add(newFeature);
		parent.setTransitionMembers(tm);
		newFeature.setParent(parent);
		
		/*
		if (duality != null) {
			CellSpaceBoundary tempDuality = new CellSpaceBoundary(map);
			tempDuality.setId(duality);
			newFeature.setDuality(tempDuality);
			if(map.getFeatureContainer("Reference").containsKey(duality)){
				int count = (Integer)map.getFeatureContainer("Reference").get(duality);
				count++;
				map.setFeature(duality, "Reference", count);
			}
			else{
				map.setFeature(duality, "Reference", 1);
			}
			map.setFeature(Id, "Reference", 1);
		}
		if (externalReference != null) {
			//newFeature.setExternalReference(externalReference);
		}
		*/
		
		if(name != null) {
			newFeature.setName(name);
		}
		
		if(description != null) {
			newFeature.setDescription(description);
		}
		
		if(weight != 0) {
			newFeature.setWeight(weight);
		}
		
		if (geometry != null) {
			newFeature.setGeometry(geometry);
		}
		
		if (duality != null) {
			CellSpaceBoundary dualityFeature = (CellSpaceBoundary) map.getFeature(duality);
			if (dualityFeature == null) {
				dualityFeature = new CellSpaceBoundary(map, duality);
				dualityFeature.setDuality(newFeature);
				map.setFutureFeature(duality, dualityFeature);
			} else {
				dualityFeature.setDuality(newFeature);
			}
			newFeature.setDuality(dualityFeature);
		}
		
		if(connects!= null && connects.length == 2) {
			State[] tempConnects = new State[2];
			tempConnects[0] = (State) map.getFeature(connects[0]);
			tempConnects[1] = (State) map.getFeature(connects[1]);
			
			if(tempConnects[0] == null) {
				if(map.hasFutureID(connects[0])) {
					tempConnects[0] = (State)map.getFutureFeature(connects[0]); 
				}
				else {
					map.setFutureFeature(connects[0], new State(map,connects[0]));
					tempConnects[0] = new State(map, connects[0]);
				}
			}
			if(tempConnects[1] == null) {
				if(map.hasFutureID(connects[1])) {
					tempConnects[1] = (State)map.getFutureFeature(connects[1]); 
				}
				else {
					map.setFutureFeature(connects[1], new State(map,connects[1]));
					tempConnects[1] = new State(map, connects[1]);
				}
			}
			
			newFeature.setConnects(tempConnects);
		}
		
		else{
			System.out.println("createTransition : there is no enough number of connections for this transition");
		}
		map.setFeature(id, "Transition", newFeature);
		map.removeFutureID(id);
		return newFeature;
	}
	public static Transition createTransition(IndoorGMLMap map, String parentId,
			String id, JsonNode geometry, String duality, String[] connects) {
		if(id == null) {
			id = UUID.randomUUID().toString();
		}
		Transition newFeature = new Transition(map, id);
		
		if (map.hasFutureID(id)) {
			newFeature = (Transition) map.getFutureFeature(id);
			// map.removeFutureID(id);
		} else {
			map.setFutureFeature(id, newFeature);
		}
		
		map.setFeature(id, "Transition", newFeature);
		
		Edges parent = (Edges) map.getFeature(parentId);
		
		
		if(parent == null){
			if(map.hasFutureID(parentId)){
				parent = (Edges)map.getFutureFeature(parentId);
			}
			else{
				parent = new Edges(map,parentId);
			}			
		}
		List<Transition>tm = parent.getTransitionMember();
		if(tm == null)
			tm = new ArrayList<Transition>();
		
		tm.add(newFeature);
		parent.setTransitionMembers(tm);
		
		newFeature.setParent(parent);
		/*
		if (duality != null) {
			CellSpaceBoundary tempDuality = new CellSpaceBoundary(map);
			tempDuality.setId(duality);
			newFeature.setDuality(tempDuality);
			if(map.getFeatureContainer("Reference").containsKey(duality)){
				int count = (Integer)map.getFeatureContainer("Reference").get(duality);
				count++;
				map.setFeature(duality, "Reference", count);
			}
			else{
				map.setFeature(duality, "Reference", 1);
			}
			map.setFeature(Id, "Reference", 1);
		}
		if (externalReference != null) {
			//newFeature.setExternalReference(externalReference);
		}
		*/
		
		if (geometry != null) {
			WKTReader wkt = new WKTReader();
			LineString l = null;
			String geometryId = null;
			if(geometry.has("coordinates")){
				try{
					l = (LineString) wkt.read(geometry.get("coordinates").asText().trim());
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else{
				try {
					l = (LineString) wkt.read(geometry.asText().trim());
					
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(geometry.has("properties")){
				if(geometry.get("properties").has("id")){
					geometryId = geometry.get("properties").get("id").asText().trim();
				}
			}
			if(geometryId == null){
				geometryId = UUID.randomUUID().toString();
			}
			map.setFeature4Geometry(geometryId, l);
			newFeature.setGeometry(l);
		}
		
		
		if (duality != null) {
			CellSpaceBoundary dualityFeature = (CellSpaceBoundary) map.getFeature(duality);
			if (dualityFeature == null) {
				dualityFeature = new CellSpaceBoundary(map, duality);
				dualityFeature.setDuality(newFeature);
				map.setFutureFeature(duality, dualityFeature);
			} else {
				dualityFeature.setDuality(newFeature);
			}
			newFeature.setDuality(dualityFeature);
		}
		
		if(connects!= null && connects.length == 2) {
			State[] tempConnects = new State[2];
			tempConnects[0] = (State) map.getFeature(connects[0]);
			tempConnects[1] = (State) map.getFeature(connects[1]);
			newFeature.setConnects(tempConnects);
		}
		
		else{
			System.out.println("createTransition : there is no enough number of connections for this transition");
		}
		map.removeFutureID(id);
		return newFeature;
	}
	
	public static Transition updateTransition(IndoorGMLMap map, String parentId,
			String id, String name, String description, Geometry geometry, String duality, String[] connects) {
		
		Transition result = new Transition(map,id);
		Transition target = (Transition)map.getFeature(id);

		if(target == null) {
			//TODO : throw error
		}
		
		Edges parent = target.getParent();
		if(!parent.getId().equals(parentId)) {
			parent.deleteTransitionMember(target);
			Edges newParent = (Edges)map.getFeature(parentId);
			if(newParent == null) {
				newParent = new Edges(map, parentId);
			}
			result.setParent(newParent);
		}
		result.setParent(parent);
		
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
			CellSpaceBoundary d = (CellSpaceBoundary) target.getDuality();
			if(d != null)
				d.resetDuality();
		}
		else{
			if(target.getDuality() != null) {
				if(!target.getDuality().getId().equals(duality)) {
					CellSpaceBoundary oldDuality = target.getDuality();
					oldDuality.resetDuality();				
				}
			}
			
			CellSpaceBoundary newDuality = new CellSpaceBoundary(map,duality);
			result.setDuality(newDuality);
			
		}
		
		if(connects != null) {
			List<State>cnts = new ArrayList<State>();
			
			for(String s : connects) {
				State temp = new State(map,s);
				cnts.add(temp);
			}
			State[] newConnects = new State[2];
			result.setConnects(cnts.toArray(newConnects));
		}
		
		map.removeFeature(id);
		map.setFeature(id, "Transition", result);
		return result;
	}
	public static Transition readTransition(IndoorGMLMap map, String id) {
		Transition target = null;
		try {
			target = (Transition)map.getFeature(id);
		}
		catch(NullPointerException e){
			e.printStackTrace();
		}
		return target;
	}
	
	public static void deleteTransition(IndoorGMLMap map, String id) {
		Transition target = (Transition)map.getFeature(id);
		
		Edges parent = target.getParent();
		
		parent.deleteTransitionMember(target);
		
		if(target.hasDuality()) {
			CellSpaceBoundary duality = target.getDuality();
			duality.resetDuality();
		}
		
		for(State s : target.getConnects()) {
			s.deleteConnects(target);
		}

		map.removeFeature(id);
	}
}
