package edu.pnu.stem.dao;


import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.vividsolutions.jts.geom.Point;
import com.vividsolutions.jts.io.ParseException;
import com.vividsolutions.jts.io.WKTReader;

import edu.pnu.stem.binder.IndoorGMLMap;
import edu.pnu.stem.feature.CellSpace;
import edu.pnu.stem.feature.Nodes;
import edu.pnu.stem.feature.SpaceLayer;
import edu.pnu.stem.feature.SpaceLayers;
import edu.pnu.stem.feature.State;
import edu.pnu.stem.feature.Transition;

public class StateDAO {
	
	public static State createState(IndoorGMLMap map, String parentId, String Id,
			String duality, List<String> connects, String geometry, String externalReference) {
		State newFeature = null;
		newFeature = new State(map);
		newFeature.setId(Id);
		
		Nodes parent = (Nodes) map.getFeature(parentId);
		parent.addStateMember(newFeature);
		newFeature.setParent(parent);
		
		if (duality != null) {
			CellSpace tempDuality = new CellSpace(map);
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
		if (geometry != null) {
			// newFeature.set
		}
		if (connects != null) {
			List<Transition>tempConnects = new ArrayList<Transition>();	
			for(int i = 0 ; i < connects.size() ; i++){
				Transition temp = new Transition(map);
				temp.setId(connects.get(i));
				tempConnects.add(temp);
			}
			newFeature.setConnects(tempConnects);				
		}
		if (externalReference != null) {
			newFeature.setExternalReference(externalReference);
		}
		map.setFeature(Id, "CellSpace", newFeature);
		return newFeature;
	}
	
	public static State createState(IndoorGMLMap map, String parentId, String Id, String geometry) {
		State newFeature = null;
		newFeature = new State(map);
		newFeature.setId(Id);

		Nodes parent = (Nodes) map.getFeature(parentId);
		parent.addStateMember(newFeature);
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

		map.setFeature(Id, "State", newFeature);
		return newFeature;
	}
	
	public State readState(String ID) {
		return null;
	};

	/**
	 * Search State feature and edit it as the parameters
	 * @param ID ID of target 
	 * @param d feature of CellSpace which has duality relationship with this state
	 * @param t feature instance of Transition which is connected with this feature
	 * @param geo Geometry instance of Point which represent this state
	 * @return edited State feature instance
	 */
/*	public State updateState(String ID, CellSpaceDAO d, TransitionDAO t, PointType geo) {
		return null;
	}
	public State updateState(String docId, String Id, String attributeType, String updateType, Object o) {
		State target = null;
		if (Container.getInstance().hasFeature(docId, Id)) {
			IndoorGMLMap map = Container.getInstance().getDocument(docId);
			target = (State) Container.getInstance().getFeature(docId, Id);
			if (attributeType.equals("geometry")) {
				// TODO: need to implement geometry class at IndoorGMLAPI
			} else if (attributeType.equals("connects")) {
				List<String>connects = new ArrayList<String>();
				List<Transition>tempConnects = target.getConnects();
				List<Transition>newConnects = new ArrayList<Transition>();
				if(o instanceof List<?>){
					connects = (List<String>)o;
				}
				else if(o instanceof String){
					connects.add((String)o);
				}
				for(int i = 0 ; i < connects.size() ; i++){
					Transition temp = new Transition(map);
					temp.setId(connects.get(i));
					newConnects.add(temp);
				}
				
				if(updateType.equals("add")){
					for(int i = 0 ; i < newConnects.size(); i++){
						if(!tempConnects.contains(newConnects.get(i))){
							tempConnects.add(newConnects.get(i));
						}
					}
				}
				else if(updateType.equals("remove")){
					for(int i = 0 ; i < newConnects.size(); i++){
						if(tempConnects.contains(newConnects.get(i))){
							tempConnects.remove(newConnects.get(i));
						}
					}
					target.clearConnects();
				}
				target.setConnects(tempConnects);				
			} else if (attributeType.equals("duality")) {
				CellSpace tempDuality = new CellSpace(map);
				tempDuality.setId((String)o);
				target.setDuality(tempDuality);
			} else if (attributeType.equals("externalReference")) {
				//target.setExternalReference(attributeId);
				//map.setFeature(attributeId, "ExternaReference", o);
			} else {
				System.out.println("update error in cellSpaceType : there is no such attribute name");
			}
		} else {
			System.out.println("there is no name with Id :" + Id + " in document Id : " + docId);
		}
		return target;
	}
	*/
	/**
	 * Search State feature and delete it
	 * @param ID ID of target 
	 */
/*	public static void deleteState(String docId, String Id, Boolean deleteDuality) {
		if (Container.getInstance().hasFeature(docId, Id)) {
			IndoorGMLMap doc = Container.getInstance().getDocument(docId);
			State target = (State) Container.getInstance().getFeature(docId,
					Id);
			// String duality = target.getd;
			doc.getFeatureContainer("State").remove(Id);
			doc.getFeatureContainer("ID").remove(Id);
			
			List<Transition> connects = target.getConnects();
			if(deleteDuality){
				//State.deleteState(target.getDuality());
				if(doc.hasID(target.getDuality().getId())){
					CellSpaceDAO.deleteCellSpace(docId,target.getDuality().getId(),false);
				}
				
			}
			
			for(int i = 0 ; i < connects.size();i++){
				int count = (Integer) doc.getFeatureContainer("Reference").get(connects.get(i));
				if(count == 1){
					TransitionDAO.deleteTransition(docId, connects.get(i).getId(),deleteDuality);
					doc.getFeatureContainer("Reference").remove(connects.get(i));
				}
				else{
					doc.setFeature(connects.get(i).getId(), "Reference", (count-1));
				}
				
			}
			
			// ExdeleteExternalReference()

			for (int i = 0; i < connects.size(); i++) {
				int count = (Integer) doc.getFeatureContainer("Reference").get(connects.get(i));
				if ( count == 1) {
					CellSpaceBoundaryDAO.deleteCellSpaceBoundary(docId, connects.get(i).getId(), deleteDuality);
				}
				else{
					doc.setFeature(connects.get(i).getId(), "Reference", (count-1));
				}
			}

			doc.getFeatureContainer("ExternalReference").remove(target.getExternalReference());
			doc.getFeatureContainer("ID").remove(target.getExternalReference());
			
		}

	};
*/
}
