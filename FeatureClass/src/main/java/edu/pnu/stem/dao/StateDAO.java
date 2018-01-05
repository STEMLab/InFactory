package edu.pnu.stem.dao;


import java.util.List;

import edu.pnu.stem.binder.Container;
import edu.pnu.stem.binder.IndoorGMLMap;
import edu.pnu.stem.feature.State;
import net.opengis.gml.v_3_2_1.PointType;

public class StateDAO {
	
	/**
	 * Create State feature instance
	 * @param ID ID of State feature instance 
	 * @param parentID ID of parent which will hold this feature
	 * @param d feature instance of CellSpace which has duality relationship with this state
	 * @param t feature instance of Transition which is connected with this feature
	 * @param geo Geometry instance of Point which represent this state
	 * @return created State feature instance
	 */
	public State createState(String ID, String parentID, CellSpaceDAO d, TransitionDAO t, PointType geo) {
		return null;
	}

	/**
	 * Search State feature in document
	 * @param Id ID of target 
	 * @return searched State feature instance
	 */
	
	public static State createState(String docId, String parentId, String Id,
			String duality, List<String> connects, String geometry, String externalReference) {
		State newFeature = null;
		if (Container.getInstance().hasDoc(docId)) {
			newFeature.setID(Id);
			newFeature.setParentID(parentId);
			if (duality != null) {
				newFeature.setDuality(duality);
				if(Container.getInstance().getDocument(docId).getFeatureContainer("Reference").containsKey(duality)){
					int count = (Integer)Container.getInstance().getDocument(docId).getFeatureContainer("Reference").get(duality);
					count++;
					Container.getInstance().setFeature(docId, duality, "Reference", count);
				}
				else{
					Container.getInstance().setFeature(docId, duality, "Reference", 1);
				}
				Container.getInstance().setFeature(docId, Id, "Reference", 1);
			}
			if (geometry != null) {
				// newFeature.set
			}
			if (connects != null) {
			
				newFeature.setConnects(connects);
				
			}
			if (externalReference != null) {
				newFeature.setExternalReference(externalReference);
			}
			Container.getInstance().setFeature(docId, Id, "CellSpace", newFeature);
		}
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
	public State updateState(String ID, CellSpaceDAO d, TransitionDAO t, PointType geo) {
		return null;
	}
	public State updateState(String docId, String Id, String attributeType,
			String attributeId, Object o) {
		State target = null;
		if (Container.getInstance().hasFeature(docId, Id)) {
			target = (State) Container.getInstance().getFeature(docId, Id);
			if (attributeType.equals("geometry")) {
				// TODO: need to implement geometry class at IndoorGMLAPI
			} else if (attributeType.equals("connects")) {
				// 한번에 하나의 cellSpaceBoundary가 들어온다고 가정
				List<String> connects = target.getConnects();
				connects.add(attributeId);
				target.setConnects(connects);
				Container.getInstance().setFeature(docId, attributeId, "Transition", o);
			} else if (attributeType.equals("duality")) {
				target.setDuality(attributeId);
				Container.getInstance().setFeature(docId, attributeId, "CellSpace", o);
			} else if (attributeType.equals("externalReference")) {
				target.setExternalReference(attributeId);
				Container.getInstance().setFeature(docId, attributeId, "ExternaReference", o);
			} else {
				System.out.println("update error in cellSpaceType : there is no such attribute name");
			}
		} else {
			System.out.println("there is no name with Id :" + Id + " in document Id : " + docId);
		}
		return target;
	}
	
	/**
	 * Search State feature and delete it
	 * @param ID ID of target 
	 */
	public static void deleteState(String docId, String Id, Boolean deleteDuality) {
		if (Container.getInstance().hasFeature(docId, Id)) {
			IndoorGMLMap doc = Container.getInstance().getDocument(docId);
			State target = (State) Container.getInstance().getFeature(docId,
					Id);
			// String duality = target.getd;
			doc.getFeatureContainer("State").remove(Id);
			doc.getFeatureContainer("ID").remove(Id);
			
			List<String> connects = target.getConnects();
			if(deleteDuality){
				//State.deleteState(target.getDuality());
				if(Container.getInstance().hasFeature(docId, target.getDuality())){
					CellSpaceDAO.deleteCellSpace(docId,target.getDuality(),false);
				}
				
			}
			
			for(int i = 0 ; i < connects.size();i++){
				int count = (Integer) doc.getFeatureContainer("Reference").get(connects.get(i));
				if(count == 1){
					TransitionDAO.deleteTransition(docId, connects.get(i),deleteDuality);
					doc.getFeatureContainer("Reference").remove(connects.get(i));
				}
				else{
					doc.setFeature(connects.get(i), "Reference", (count-1));
				}
				
			}
			
			// ExdeleteExternalReference()

			for (int i = 0; i < connects.size(); i++) {
				int count = (Integer) doc.getFeatureContainer("Reference").get(connects.get(i));
				if ( count == 1) {
					CellSpaceBoundaryDAO.deleteCellSpaceBoundary(docId, connects.get(i), deleteDuality);
				}
				else{
					doc.setFeature(connects.get(i), "Reference", (count-1));
				}
			}

			doc.getFeatureContainer("ExternalReference").remove(target.getExternalReference());
			doc.getFeatureContainer("ID").remove(target.getExternalReference());
			
		}

	};

}
