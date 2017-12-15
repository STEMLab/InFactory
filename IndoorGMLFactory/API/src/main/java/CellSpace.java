import java.util.List;

import Binder.IndoorGMLMap;
import Binder.docData;

/**
 * @author jungh
 *
 */
public class CellSpace {
	/**
	 * create CellSpace feature instance
	 * 
	 * @param ID
	 *            ID of CellSpace
	 * @param parentID
	 *            ID of parent which will hold this feature
	 * @param csGeometry
	 *            Geometry of CellSpace
	 * @param csBoundary
	 *            CellSpaceBoundary
	 * @param s
	 *            State which has duality with this feature
	 * @param er
	 *            ExternalReference of this feature
	 * @return created CellSpace
	 */
	public static FeatureClassReference.CellSpace createCellSpace(String docID, String parentID, String ID) {

		FeatureClassReference.CellSpace newFeature = new FeatureClassReference.CellSpace();
		if (docData.docs.hasDoc(docID)) {
			newFeature.setID(ID);
			newFeature.setParentID(parentID);
			docData.setFeature(docID, ID, "CellSpace", newFeature);
		}
		return newFeature;
	}

	public static FeatureClassReference.CellSpace createCellSpace(String docID, String parentID, String ID,
			String duality, List<String> partialboundedBy, String cellSpaceGeometry, String externalReference) {
		FeatureClassReference.CellSpace newFeature = null;
		if (docData.docs.hasDoc(docID)) {
			newFeature.setID(ID);
			newFeature.setParentID(parentID);
			if (duality != null) {
				newFeature.setDuality(duality);
			}
			if (cellSpaceGeometry != null) {
				// newFeature.set
			}
			if (partialboundedBy != null) {
				newFeature.setPartialboundedBy(partialboundedBy);
			}
			if (externalReference != null) {
				newFeature.setExternalReference(externalReference);
			}
			docData.docs.setFeature(docID, ID, "CellSpace", newFeature);
		}
		return newFeature;
	}

	public static FeatureClassReference.CellSpace createCellSpace(String docID, String parentID, String ID,
			List<String> cellSpaceBoundary) {
		FeatureClassReference.CellSpace newFeature = null;
		if (docData.docs.hasDoc(docID)) {
			newFeature = createCellSpace(docID, parentID, ID);
			// need to set cellspaceboundary
			// List<String>csbIdList = new ArrayList<String>();
			/*
			 * for(int i = 0 ; i < cellSpaceBoundary.size(); i++){
			 * csbIdList.add(cellSpaceBoundary.get(i).getID()); }
			 */
			newFeature.setPartialboundedBy(cellSpaceBoundary);
			docData.setFeature(docID, ID, "CellSpace", newFeature);
		} else {
			System.out.println("Error in createCellSpace : there is no such document");
			return null;
		}
		return newFeature;
	};

	public static FeatureClassReference.CellSpace createCellSpace(String docId, String ID, String parentID,
			List<String> cellSpaceBoundary, String duality) {
		FeatureClassReference.CellSpace newFeature = createCellSpace(docId, parentID, ID, cellSpaceBoundary);
		newFeature.setDuality(duality);
		docData.docs.setFeature(docId, ID, "CellSpace", newFeature);
		return newFeature;
	};

	public FeatureClassReference.CellSpace createCellSpace(String docId, String ID, String parentID,
			List<String> cellSpaceBoundary, String duality, String externalReference) {
		FeatureClassReference.CellSpace newFeature = createCellSpace(docId, ID, parentID, cellSpaceBoundary, duality);
		newFeature.setExternalReference(externalReference);
		docData.docs.setFeature(docId, ID, "CellSpace", newFeature);
		return newFeature;
	};
	/*
	 * 
	 * public FeatureClassReference.CellSpace createCellSpace(String ID, String
	 * parentID, List<String> cellSpaceBoundary, String duality,
	 * CellSpaceGeometry csGeometry) { FeatureClassReference.CellSpace
	 * newFeature = createCellSpace(ID, parentID, cellSpaceBoundary, duality,
	 * csGeometry); newFeature.setCellSpaceGeometry(csGeometry); return
	 * newFeature; };
	 */

	/**
	 * search and get CellSpace feature in document
	 * 
	 * @param ID
	 *            ID of target
	 * @return edited feature
	 */
	public FeatureClassReference.CellSpace readCellSpace(String docId, String Id) {
		FeatureClassReference.CellSpace target = (FeatureClassReference.CellSpace) docData.docs.getFeature(docId, Id);
		return target;
	};

	/**
	 * @param docId
	 *            : Id of the document that this feature is contained
	 * @param Id
	 *            : Id of this feature
	 * @param attributeType
	 *            : the attribute name of this feature which will be updated
	 * @param attributeId
	 *            : Id of will-be-updated attribute feature
	 * @param o
	 *            : Data of updated attribute
	 * @return : updated feature instance
	 */
	public FeatureClassReference.CellSpace updateCellSpace(String docId, String Id, String attributeType,
			String attributeId, Object o) {
		FeatureClassReference.CellSpace target = null;
		if (docData.docs.hasFeature(docId, Id)) {
			target = (FeatureClassReference.CellSpace) docData.docs.getFeature(docId, Id);
			if (attributeType.equals("cellSpaceGeometry")) {
				// TODO: need to implement geometry class at IndoorGMLAPI
			} else if (attributeType.equals("partialboundedBy")) {
				// 한번에 하나의 cellSpaceBoundary가 들어온다고 가정
				List<String> partialboundedBy = target.getPartialboundedBy();
				partialboundedBy.add(attributeId);
				target.setPartialboundedBy(partialboundedBy);
				docData.docs.setFeature(docId, attributeId, "CellSpaceBoundary", o);
			} else if (attributeType.equals("duality")) {
				target.setDuality(attributeId);
				docData.docs.setFeature(docId, attributeId, "State", o);
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
	 * search CellSpace feature and delete the data
	 * 
	 * @param ID
	 *            ID of target
	 */

	public void deleteCellSpace(String docId, String Id, Boolean deleteDuality) {
		if (docData.docs.hasFeature(docId, Id)) {
			IndoorGMLMap doc = docData.docs.getDocument(docId);
			FeatureClassReference.CellSpace target = (FeatureClassReference.CellSpace) docData.docs.getFeature(docId,
					Id);
			// String duality = target.getd;
			
			List<String> partialboundedBy = target.getPartialboundedBy();
			if(deleteDuality){
				State.deleteState(target.getDuality());
			}
			
			// ExdeleteExternalReference()

			for (int i = 0; i < partialboundedBy.size(); i++) {
				int count = (Integer) doc.getFeatureContainer("Reference").get(partialboundedBy.get(i));
				if ( count == 1) {
					CellSpaceBoundary.deleteCellSpaceBoundary(docId, partialboundedBy.get(i), deleteDuality);
				}
				else{
					doc.setFeature(partialboundedBy.get(i), "Reference", (count-1));
				}
			}

			doc.getFeatureContainer("ExternalReference").remove(target.getExternalReference());
			doc.getFeatureContainer("CellSpace").remove(Id);
			doc.getFeatureContainer("ID").remove(target.getExternalReference());
			doc.getFeatureContainer("ID").remove(Id);
		}

	};

}
