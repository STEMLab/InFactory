package edu.pnu.stem.dao;
import edu.pnu.stem.binder.Container;
import edu.pnu.stem.binder.IndoorGMLMap;
import edu.pnu.stem.feature.CellSpaceBoundary;
import edu.pnu.stem.feature.ExternalReference;
import edu.pnu.stem.feature.PrimalSpaceFeatures;
import edu.pnu.stem.feature.Transition;


/**
 * @author jungh
 * 
 */
public class CellSpaceBoundaryDAO {

	/*
	public static FeatureClassReference.CellSpaceBoundary createCellSpaceBoundary(String docId, String ID,
			String parentID) {
		FeatureClassReference.CellSpaceBoundary newFeature = null;
		if (Container.getInstance().hasDoc(docId)) {
			newFeature = new FeatureClassReference.CellSpaceBoundary();
			newFeature.setID(ID);
			newFeature.setParentID(ID);
			Container.getInstance().setFeature(docId, ID, "CellSpaceBoundary", newFeature);
			
		}
		return newFeature;
	}
	 * 
	 * */

	public static CellSpaceBoundary createCellSpaceBoundary(String docId, String parentId,
			String ID, String name, String description, String duality, String cellSpaceBoundaryGeometry,
			ExternalReference externalReference) {
		CellSpaceBoundary newFeature = null;
		if (Container.getInstance().hasDoc(docId)) {
			IndoorGMLMap map = Container.getInstance().getDocument(docId);
			newFeature = new CellSpaceBoundary(map);		
			PrimalSpaceFeatures parent = new PrimalSpaceFeatures(map);
			parent.setId(parentId);			
			newFeature.setParent(parent);
			if (name != null) {
				newFeature.setName(name);
			}
			if (duality != null) {
				Transition dualityTransition = new Transition(map);
				dualityTransition.setId(duality);
				newFeature.setDuality(dualityTransition);
				if(map.getFeatureContainer("Reference").containsKey(duality)){
					int count = (Integer)Container.getInstance().getDocument(docId).getFeatureContainer("Reference").get(duality);
					count++;
					Container.getInstance().setFeature(docId, ID, "Reference", count);
				}
				
			}
			if (externalReference != null) {
				newFeature.setExternalReference(externalReference);
			}
			if (cellSpaceBoundaryGeometry != null) {
				newFeature.setCellSpaceBoundaryGeometry(cellSpaceBoundaryGeometry);
			}
			map.setFeature(ID, "CellSpaceBoundary", newFeature);
			map.setFeature(ID, "ID", "CellSpaceBoundary");

		}
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
	public static CellSpaceBoundary readCellSpaceBoundary(String docID, String ID) {
		return (CellSpaceBoundary) Container.getInstance().getFeature(docID, ID);
	};

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

	public CellSpaceBoundary updateCellSpaceBoundary(String docId, String id, String attributeType,
			String attributeId, Object o) {
		CellSpaceBoundary target = null;
		if (Container.getInstance().hasFeature(docId, id)) {
			IndoorGMLMap map = Container.getInstance().getDocument(docId);
			target = (CellSpaceBoundary) map.getFeature(id);
			if (attributeType.equals("cellSpaceBoundaryGeometry") ) {
				// TODO: need to implement geometry class at IndoorGMLAPI
			}  else if (attributeType == "duality") {
				Transition tempDuality = target.getDuality();
				target.setDuality((Transition)o);				
				if (map.getFeatureContainer("Reference").containsKey(attributeId)) {
					int count = (Integer) map.getFeatureContainer("Reference").get(attributeId);
					count++;
					map.setFeature(attributeId, "Reference", count);
				}				
				if (map.getFeatureContainer("Reference").containsKey(tempDuality.getId())) {
					int count = (Integer) map.getFeatureContainer("Reference").get(tempDuality);
					if(count > 0)
						count--;
					map.setFeature(tempDuality.getId(), "Reference", count);
				}
				target.setDuality((Transition)o);
				Container.getInstance().setFeature(docId, attributeId, "Transition", o);
			} else if(attributeType.equals("name")){
				target.setName((String)o);
			} else if(attributeType.equals("description")){
				//TODO : add description at FeatureClassReference.CellSpaceBoundary
			}			
			else if (attributeType.equals("externalReference") ) {
				/* TODO
				target.setExternalReference(attributeId);
				Container.getInstance().setFeature(docId, attributeId, "ExternaReference", o);
				*/
			} else {
				System.out.println("update error in cellSpaceType : there is no such attribute name");
			}
		} else {
			System.out.println("there is no name with Id :" + id + " in document Id : " + docId);
		}
		return target;
	}

	/**
	 * search the CellSpaceBoundary feature and delete it
	 * 
	 * @param id
	 *            ID of target
	 */
	public static void deleteCellSpaceBoundary(String docId, String Id, Boolean deleteDuality) {
		if (Container.getInstance().hasFeature(docId, Id)) {
			IndoorGMLMap doc = Container.getInstance().getDocument(docId);
			CellSpaceBoundary target = (CellSpaceBoundary) Container.getInstance().getFeature(docId,
					Id);
			// String duality = target.getd;
			if(deleteDuality){
				int count = (Integer) doc.getFeatureContainer("Reference").get(target.getDuality());
				if(count == 1){
					TransitionDAO.deleteTransition(docId, target.getDuality().getId(),false);
					doc.getFeatureContainer("Reference").remove(target.getDuality());
				}
				else{
					doc.setFeature(target.getDuality().getId(), "Reference", (count-1));
				}
				
			}
			
			// ExdeleteExternalReference()

			doc.getFeatureContainer("ExternalReference").remove(target.getExternalReference());			
			doc.getFeatureContainer("CellSpaceBoundary").remove(Id);
			doc.getFeatureContainer("ID").remove(target.getExternalReference());
			doc.getFeatureContainer("ID").remove(Id);
		}
		
	};

}
