

import java.util.List;

import Binder.Container;
import Binder.IndoorGMLMap;

public class Transition {

	
	/**
	 * @param docId
	 * @param parentId
	 * @param Id
	 * @param name
	 * @param description
	 * @param duality
	 * @param geometry
	 * @param externalReference
	 * @param connects
	 * @return
	 */
	public static FeatureClassReference.Transition createTransition(String docId, String parentId,
			String Id, String name, String description, String duality, String geometry,
			String externalReference, String[]connects) {
		FeatureClassReference.Transition newFeature = null;
		if (Container.getInstance().hasDoc(docId)) {
			newFeature = new FeatureClassReference.Transition();
			newFeature.setDuality(duality);
			newFeature.setParentID(parentId);
			if (name != null) {
				newFeature.setName(name);
			}
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
			if (externalReference != null) {
				newFeature.setExternalReference(externalReference);
			}
			if (geometry != null) {
				//newFeature.setGeometry(g);
			}
			if(connects.length == 2){
				newFeature.setConnects(connects);
			}
			else{
				System.out.println("createTransition : there is no enough number of connections for this transition");
			}
			Container.getInstance().setFeature(docId, Id, "CellSpaceBoundary", newFeature);

		}
		return newFeature;
	}

	/**
	 * Search Transition feature in document
	 * @param ID ID of target
	 * @return searched Transition feature instance
	 */
	public FeatureClassReference.Transition readTransition(String docId, String Id) {
		FeatureClassReference.Transition target = (FeatureClassReference.Transition) Container.getInstance().getFeature(docId, Id);
		return target;
	}

	/**
	 * Search Transition feature and edit it as the parameters
	 * @param ID ID of target
	 * @param gc Geometry of this Transition. Represented as CurveType of GML-3.2.1
	 * @param sl list of States which are connected with this Transition. Always size need to be 2.
	 * @param csBoundary Feature instance of CellSpaceBoundary which has duality relationship with this Transition
	 * @param weight weight can be used for applications in order to deal with the impedance representing absolute barriers in transportation problems 
	 * @return edited Transition feature instance 
	 */
	public FeatureClassReference.Transition updateTransition(String docId, String Id, String attributeType,
			String attributeId, Object o) {
		FeatureClassReference.Transition target = null;
		if (Container.getInstance().hasFeature(docId, Id)) {
			target = (FeatureClassReference.Transition) Container.getInstance().getFeature(docId,
					Id);
			if (attributeType.equals("geometry") ) {
				// TODO: need to implement geometry class at IndoorGMLAPI
			}  else if (attributeType == "duality") {
				if(Container.getInstance().hasFeature(docId, attributeId)){
					target.setDuality(attributeId);
					int count = (Integer)Container.getInstance().getDocument(docId).getFeatureContainer("Reference").get(attributeId);
					Container.getInstance().setFeature(docId, attributeId, "Reference", (count++));
					
				}
			} else if(attributeType.equals("name")){
				target.setName((String)o);
			} else if(attributeType.equals("description")){
				//TODO : add description at FeatureClassReference.transition
			}			
			else if (attributeType.equals("externalReference") ) {
				target.setExternalReference(attributeId);
				Container.getInstance().setFeature(docId, attributeId, "ExternaReference", o);
			}else if(attributeType.equals("connects")){
				List<String>connects = (List<String>) o;
				Boolean isConnectsExist = true;
				for(int i = 0 ; i < connects.size();i++){
					if(!Container.getInstance().hasFeature(docId, connects.get(i))){
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
			System.out.println("there is no name with Id :" + Id + " in document Id : " + docId);
		}
		return target;
	}

	/**
	 * Search Transition feature and delete it
	 * @param ID ID of target
	 */
	public static void deleteTransition(String docId, String Id, Boolean deleteDuality) {
		if (Container.getInstance().hasFeature(docId, Id)) {
			IndoorGMLMap doc = Container.getInstance().getDocument(docId);
			FeatureClassReference.Transition target = (FeatureClassReference.Transition) Container.getInstance().getFeature(docId,
					Id);
			doc.getFeatureContainer("ExternalReference").remove(target.getExternalReference());			
			doc.getFeatureContainer("Transition").remove(Id);
			doc.getFeatureContainer("ID").remove(target.getExternalReference());
			doc.getFeatureContainer("ID").remove(Id);
			if(deleteDuality == true){
				CellSpaceBoundary.deleteCellSpaceBoundary(docId, target.getDuality(), false);
			}
			
		}
	}

}
