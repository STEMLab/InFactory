package edu.pnu.stem.dao;


import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.geom.Point;
import org.locationtech.jts.io.ParseException;
import org.locationtech.jts.io.WKTReader;

import edu.pnu.stem.binder.IndoorGMLMap;
import edu.pnu.stem.feature.core.CellSpace;
import edu.pnu.stem.feature.core.Nodes;
import edu.pnu.stem.feature.core.State;
import edu.pnu.stem.feature.core.Transition;

public class StateDAO {
	
	public static State readState(IndoorGMLMap map, String id) {
		State target = null;
		try {
			target = (State)map.getFeature(id);
		}
		catch(NullPointerException e){
			e.printStackTrace();
		}
		return target;
	}
	
	public static State createState(IndoorGMLMap map, String parentId, String id, String name, String description, Geometry geometry, String duality, List<String> connects) {
		if(id == null) {
			id = UUID.randomUUID().toString();
		}
		
		State newFeature = new State(map, id);
		if(map.hasFutureID(id)){
			newFeature = (State)map.getFutureFeature(id);
			//map.removeFutureID(id);
		}
		else{
			map.setFutureFeature(id, newFeature);
		}		
		map.setFeature(id, "State", newFeature);
		
		Nodes parent = (Nodes) map.getFeature(parentId);
		if(parent == null){
			if(map.hasFutureID(parentId)){
				parent = (Nodes)map.getFutureFeature(parentId);
			}
			else{
				parent = new Nodes(map,parentId);
			}
		}
		
		List<State> sm = parent.getStateMember();
		if(sm == null)
			sm = new ArrayList<State>();
		sm.add(newFeature);
		parent.setStateMember(sm);
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
		
		if(connects != null){
			List<Transition> realConnected = new ArrayList<Transition>();
			for(String t : connects){
				Transition ct = (Transition)map.getFeature(t);
				if(ct == null){
					ct = new Transition(map, t);
					map.setFutureFeature(t, ct);
				}
				realConnected.add(ct);
			}
			newFeature.setConnects(realConnected);
		}
		
		if(duality != null){
			CellSpace dualityFeature = (CellSpace) map.getFeature(duality);
			
			if(dualityFeature == null){
				dualityFeature = new CellSpace(map, duality);
			}
			
			dualityFeature.setDuality(newFeature);
			newFeature.setDuality(dualityFeature);

		}

		map.removeFutureID(id);
		return newFeature;
	}	
	public static State createState(IndoorGMLMap map, String parentId, String id, String geometry, List<String> connected) {
		if(id == null) {
			id = UUID.randomUUID().toString();
		}
		
		State newFeature = new State(map, id);
		if(map.hasFutureID(id)){
			newFeature = (State)map.getFutureFeature(id);
		}
		
		
		Nodes parent = (Nodes) map.getFeature(parentId);
		if(parent == null){
			if(map.hasFutureID(parentId)){
				parent = (Nodes)map.getFutureFeature(parentId);
			}
			else{
				parent = new Nodes(map,parentId);
			}
		}
		
		List<State>sm = parent.getStateMember();
		if(sm == null)
			sm = new ArrayList<State>();
		
		sm.add(newFeature);
		parent.setStateMember(sm);
		newFeature.setParent(parent);
		
		if (geometry != null) {
			WKTReader wkt = new WKTReader();
			try {
				Point p = (Point) wkt.read(geometry);
				map.setFeature4Geometry(UUID.randomUUID().toString(), p);
				newFeature.setGeometry(p);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(connected != null){
			List<Transition> realConnected = new ArrayList<Transition>();
			for(String t : connected){
				Transition ct = (Transition)map.getFeature(t);
				if(ct == null){
					ct = new Transition(map, t);
				}
				realConnected.add(ct);
			}
			newFeature.setConnects(realConnected);
		}

		map.setFeature(id, "State", newFeature);
		return newFeature;
	}
	

	
	public static void deleteState(IndoorGMLMap map, String id) {
		State target = (State)map.getFeature(id);
		
		if(target == null) {
			if(map.hasFutureID(id))
				target = (State)map.getFutureFeature(id);
		}
		
		Nodes parent = target.getParent();
		
		parent.deleteStateMember(target);
		
		if(target.hasDuality()) {
			CellSpace duality = target.getDuality();
			duality.resetDuality();
		}
		
		List<Transition> connects = target.getConnects();
		
		for(Transition t : connects) {
			t.deleteConnects(target);
		}
		
		map.removeFeature(id);
	}
	
	public static State updateState(IndoorGMLMap map,String parentId, String id, String name, String description, Geometry geometry, String duality, List<String>connects) {
		State result = new State(map, id);
		State target = (State)map.getFeature(id);
		
		if(map.hasFutureID(id)){
			//TODO : throw error because this feature has not yet been created
			
			//target = (State)map.getFutureFeature(id);
			//map.removeFutureID(id);
		}
		Nodes parent = target.getParent();
	
		
		if(!parent.getId().equals(parentId)) {
			Nodes newParent = (Nodes)map.getFeature(parentId);
			if(newParent == null)
				newParent = new Nodes(map, parentId);
			parent.deleteStateMember(target);

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
		
		
		if(connects != null) {
			List<Transition> cnts = new ArrayList<Transition>();
			
			for(String t : connects) {
				Transition temp = new Transition(map,t);
				cnts.add(temp);
			}
			result.setConnects(cnts);
		}
		
		if(duality == null) {
			CellSpace d = target.getDuality();
			if(d != null)
				d.resetDuality();
		}
		else {
			if(target.getDuality() != null) {
				if(!target.getDuality().getId().equals(duality)) {
					CellSpace	oldDuality = new CellSpace(map,duality);
					oldDuality.resetDuality();
				}
			}
			
			CellSpace newDuality = new CellSpace(map,duality);
			result.setDuality(newDuality);
		}
		
		map.removeFeature(id);
		map.setFeature(id, "State", result);
		
		return result;
	}
}
