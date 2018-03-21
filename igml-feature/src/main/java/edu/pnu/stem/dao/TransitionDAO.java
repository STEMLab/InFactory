package edu.pnu.stem.dao;


import java.util.UUID;

import com.fasterxml.jackson.databind.JsonNode;
import com.vividsolutions.jts.geom.LineString;
import com.vividsolutions.jts.io.ParseException;
import com.vividsolutions.jts.io.WKTReader;

import edu.pnu.stem.binder.IndoorGMLMap;
import edu.pnu.stem.feature.CellSpaceBoundary;
import edu.pnu.stem.feature.Edges;
import edu.pnu.stem.feature.State;
import edu.pnu.stem.feature.Transition;

public class TransitionDAO {
	
	/*
	public static Transition createTransition(IndoorGMLMap map, String parentId,
			String Id, String name, String description, String duality, String geometry,
			String externalReference, String[]connects) {
		Transition newFeature = null;
		newFeature = new Transition(map);
		Edges parent = new Edges(map);
		parent.setId(parentId);
		newFeature.setParent(parent);
		if (name != null) {
			newFeature.setName(name);
		}
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
		if (geometry != null) {
			//newFeature.setGeometry(g);
		}
		if(connects.length == 2){
			State[] tempConnects = new State[2];
			tempConnects[0] = new State(map);
			tempConnects[1] = new State(map);
			tempConnects[0].setId(connects[0]);
			tempConnects[1].setId(connects[1]);
			newFeature.setConnects(tempConnects);
		}
		else{
			System.out.println("createTransition : there is no enough number of connections for this transition");
		}
		map.setFeature(Id, "Transition", newFeature);
		return newFeature;
	}
	*/
	
	public static Transition createTransition(IndoorGMLMap map, String parentId,
			String id, String geometry, String duality, String[] connects) {
		if(id == null) {
			id = UUID.randomUUID().toString();
		}
		Transition newFeature = new Transition(map, id);
		
		Edges parent = (Edges) map.getFeature(parentId);
		parent.addTransitionMember(newFeature);
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
			try {
				LineString l = (LineString) wkt.read(geometry);
				map.setFeature4Geometry(UUID.randomUUID().toString(), l);
				newFeature.setGeometry(l);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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
		map.setFeature(id, "Transition", newFeature);
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
		parent.addTransitionMember(newFeature);
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
	/**
	 * Search Transition feature in document
	 * @param ID ID of target
	 * @return searched Transition feature instance
	 */
/*	public Transition readTransition(String docId, String Id) {
		Transition target = null;
		target = (Transition) Container.getInstance().getFeature(docId, Id);
		return target;
	}*/

	/**
	 * Search Transition feature and edit it as the parameters
	 * @param ID ID of target
	 * @param gc Geometry of this Transition. Represented as CurveType of GML-3.2.1
	 * @param sl list of States which are connected with this Transition. Always size need to be 2.
	 * @param csBoundary Feature instance of CellSpaceBoundary which has duality relationship with this Transition
	 * @param weight weight can be used for applications in order to deal with the impedance representing absolute barriers in transportation problems 
	 * @return edited Transition feature instance 
	 */
/*	public Transition updateTransition(String docId, String id, String attributeType,
			String attributeId, Object o) {
		Transition target = null;
		IndoorGMLMap map = Container.getInstance().getDocument(docId);
		if (map.hasID(id)) {
			target = (Transition) map.getFeature(id);
			if (attributeType.equals("geometry") ) {
				// TODO: need to implement geometry class at IndoorGMLAPI
			}  else if (attributeType == "duality") {
				if(map.hasID(attributeId)){
					CellSpaceBoundary tempDuality = new CellSpaceBoundary(map);
					tempDuality.setId(attributeId);
					target.setDuality(tempDuality);
					int count = (Integer)map.getFeatureContainer("Reference").get(attributeId);
					map.setFeature(attributeId, "Reference", (count++));
					
				}
			} else if(attributeType.equals("name")){
				target.setName((String)o);
			} else if(attributeType.equals("description")){
				//TODO : add description at FeatureClassReference.transition
			}			
			else if (attributeType.equals("externalReference") ) {
				//target.setExternalReference(attributeId);
				map.setFeature(attributeId, "ExternaReference", o);
			}else if(attributeType.equals("connects")){
				List<String>connects = (List<String>) o;
				Boolean isConnectsExist = true;
				for(int i = 0 ; i < connects.size();i++){
					if(!map.hasID(connects.get(i))){
						isConnectsExist = false;
					}
				}
				if(isConnectsExist){
					//TODO : validation
					//target.setConnects(connects);
				}
				
			}else if(attributeType.equals("weight")){
				target.setWeight((Double)o);
			}
			else {
				System.out.println("update error in cellSpaceType : there is no such attribute name");
			}
		} else {
			System.out.println("there is no name with Id :" + id + " in document Id : " + docId);
		}
		return target;
	}*/

/*	public static void deleteTransition(String docId, String id, Boolean deleteDuality) {
		if (Container.getInstance().hasFeature(docId, id)) {
			IndoorGMLMap doc = Container.getInstance().getDocument(docId);
			Transition target = (Transition) doc.getFeature(id);
			doc.getFeatureContainer("ExternalReference").remove(target.getExternalReference());			
			doc.getFeatureContainer("Transition").remove(id);
			doc.getFeatureContainer("ID").remove(target.getExternalReference());
			doc.getFeatureContainer("ID").remove(id);
			if(deleteDuality == true){
				CellSpaceBoundaryDAO.deleteCellSpaceBoundary(docId, target.getDuality().getId(), false);
			}
			
		}
	}*/

}
