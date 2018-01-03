package edu.pnu.stem.api.dao;
import edu.pnu.stem.binder.Container;
import edu.pnu.stem.binder.IndoorGMLMap;


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

	public static edu.pnu.stem.feature.CellSpaceBoundary createCellSpaceBoundary(String docId, String parentID,
			String ID, String name, String description, String duality, String cellSpaceBoundaryGeometry,
			String externalReference) {
		edu.pnu.stem.feature.CellSpaceBoundary newFeature = null;
		if (Container.getInstance().hasDoc(docId)) {
			newFeature = new edu.pnu.stem.feature.CellSpaceBoundary();
			newFeature.setDuality(duality);
			newFeature.setParentID(parentID);
			if (name != null) {
				newFeature.setName(name);
			}
			if (duality != null) {
				newFeature.setDuality(duality);
				if(Container.getInstance().getDocument(docId).getFeatureContainer("Reference").containsKey(duality)){
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
			Container.getInstance().setFeature(docId, ID, "CellSpaceBoundary", newFeature);
			Container.getInstance().setFeature(docId, ID, "ID", "CellSpaceBoundary");

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
	public static edu.pnu.stem.feature.CellSpaceBoundary readCellSpaceBoundary(String docID, String ID) {
		return (edu.pnu.stem.feature.CellSpaceBoundary) Container.getInstance().getFeature(docID, ID);
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

	public edu.pnu.stem.feature.CellSpaceBoundary updateCellSpaceBoundary(String docId, String Id, String attributeType,
			String attributeId, Object o) {
		edu.pnu.stem.feature.CellSpaceBoundary target = null;
		if (Container.getInstance().hasFeature(docId, Id)) {
			target = (edu.pnu.stem.feature.CellSpaceBoundary) Container.getInstance().getFeature(docId,
					Id);
			if (attributeType.equals("cellSpaceBoundaryGeometry") ) {
				// TODO: need to implement geometry class at IndoorGMLAPI
			}  else if (attributeType == "duality") {
				String tempDuality = target.getDuality();
				target.setDuality(attributeId);				
				if (Container.getInstance().getDocument(docId).getFeatureContainer("Reference").containsKey(attributeId)) {
					int count = (Integer) Container.getInstance().getDocument(docId).getFeatureContainer("Reference").get(attributeId);
					count++;
					Container.getInstance().setFeature(docId, attributeId, "Reference", count);
				}				
				if (Container.getInstance().getDocument(docId).getFeatureContainer("Reference").containsKey(tempDuality)) {
					int count = (Integer) Container.getInstance().getDocument(docId).getFeatureContainer("Reference").get(tempDuality);
					if(count > 0)
						count--;
					Container.getInstance().setFeature(docId, tempDuality, "Reference", count);
				}
				
				target.setDuality(attributeId);
				Container.getInstance().setFeature(docId, attributeId, "Transition", o);
			} else if(attributeType.equals("name")){
				target.setName((String)o);
			} else if(attributeType.equals("description")){
				//TODO : add description at FeatureClassReference.CellSpaceBoundary
			}			
			else if (attributeType.equals("externalReference") ) {
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
	 * search the CellSpaceBoundary feature and delete it
	 * 
	 * @param id
	 *            ID of target
	 */
	public static void deleteCellSpaceBoundary(String docId, String Id, Boolean deleteDuality) {
		if (Container.getInstance().hasFeature(docId, Id)) {
			IndoorGMLMap doc = Container.getInstance().getDocument(docId);
			edu.pnu.stem.feature.CellSpaceBoundary target = (edu.pnu.stem.feature.CellSpaceBoundary) Container.getInstance().getFeature(docId,
					Id);
			// String duality = target.getd;
			if(deleteDuality){
				int count = (Integer) doc.getFeatureContainer("Reference").get(target.getDuality());
				if(count == 1){
					TransitionDAO.deleteTransition(docId, target.getDuality(),false);
					doc.getFeatureContainer("Reference").remove(target.getDuality());
				}
				else{
					doc.setFeature(target.getDuality(), "Reference", (count-1));
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
