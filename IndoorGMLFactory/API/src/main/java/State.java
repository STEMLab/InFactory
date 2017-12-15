

import java.util.List;

import Binder.IndoorGMLMap;
import Binder.docData;
import net.opengis.gml.v_3_2_1.PointType;

public class State {
	
	/**
	 * Create State feature instance
	 * @param ID ID of State feature instance 
	 * @param parentID ID of parent which will hold this feature
	 * @param d feature instance of CellSpace which has duality relationship with this state
	 * @param t feature instance of Transition which is connected with this feature
	 * @param geo Geometry instance of Point which represent this state
	 * @return created State feature instance
	 */
	public FeatureClass.State createState(String ID, String parentID, CellSpace d, Transition t, PointType geo) {
		return null;
	}

	/**
	 * Search State feature in document
	 * @param ID ID of target 
	 * @return searched State feature instance
	 */
	
	public static FeatureClassReference.State createState(String docID, String parentID, String ID,
			String duality, List<String> connects, String geometry, String externalReference) {
		FeatureClassReference.State newFeature = null;
		if (docData.docs.hasDoc(docID)) {
			newFeature.setID(ID);
			newFeature.setParentID(parentID);
			if (duality != null) {
				newFeature.setDuality(duality);
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
			docData.docs.setFeature(docID, ID, "CellSpace", newFeature);
		}
		return newFeature;
	}
	
	
	public FeatureClass.State readState(String ID) {
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
	public FeatureClass.State updateState(String ID, CellSpace d, Transition t, PointType geo) {
		return null;
	}
	public FeatureClassReference.State updateState(String docId, String Id, String attributeType,
			String attributeId, Object o) {
		FeatureClassReference.State target = null;
		if (docData.docs.hasFeature(docId, Id)) {
			target = (FeatureClassReference.State) docData.docs.getFeature(docId, Id);
			if (attributeType.equals("geometry")) {
				// TODO: need to implement geometry class at IndoorGMLAPI
			} else if (attributeType.equals("connects")) {
				// 한번에 하나의 cellSpaceBoundary가 들어온다고 가정
				List<String> connects = target.getConnects();
				connects.add(attributeId);
				target.setConnects(connects);
				docData.docs.setFeature(docId, attributeId, "Transition", o);
			} else if (attributeType.equals("duality")) {
				target.setDuality(attributeId);
				docData.docs.setFeature(docId, attributeId, "CellSpace", o);
			} else if (attributeType.equals("externalReference")) {
				target.setExternalReference(attributeId);
				docData.docs.setFeature(docId, attributeId, "ExternaReference", o);
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
		if (docData.docs.hasFeature(docId, Id)) {
			IndoorGMLMap doc = docData.docs.getDocument(docId);
			FeatureClassReference.State target = (FeatureClassReference.State) docData.docs.getFeature(docId,
					Id);
			// String duality = target.getd;
			doc.getFeatureContainer("State").remove(Id);
			doc.getFeatureContainer("ID").remove(Id);
			
			List<String> connects = target.getConnects();
			if(deleteDuality){
				//State.deleteState(target.getDuality());
				if(docData.docs.hasFeature(docId, target.getDuality())){
					CellSpace.deleteCellSpace(docId,target.getDuality(),false);
				}
				
			}
			
			for(int i = 0 ; i < connects.size();i++){
				int count = (Integer) doc.getFeatureContainer("Reference").get(connects.get(i));
				if(count == 1){
					Transition.deleteTransition(docId, connects.get(i));
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
					CellSpaceBoundary.deleteCellSpaceBoundary(docId, connects.get(i), deleteDuality);
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
