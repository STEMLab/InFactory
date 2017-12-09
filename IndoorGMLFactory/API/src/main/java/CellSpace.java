import java.util.List;

import Binder.IndoorGMLMap;
import Binder.docData;
import FeatureClassReference.CellSpaceGeometry;
import FeatureClassReference.ExternalReference;

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
	public FeatureClassReference.CellSpace createCellSpace(String docID, String ID, String parentID) {

		FeatureClassReference.CellSpace newFeature = new FeatureClassReference.CellSpace();
		newFeature.setID(ID);
		newFeature.setParentID(parentID);
		docData.setFeature(docID, ID, "CellSpace", newFeature);

		return newFeature;
	}

	public FeatureClassReference.CellSpace createCellSpace(String docID, String ID, String parentID,
			List<String> cellSpaceBoundary) {
		FeatureClassReference.CellSpace newFeature = createCellSpace(docID, ID, parentID);
		newFeature.setPartialboundedBy(cellSpaceBoundary);
		return newFeature;
	};

	public FeatureClassReference.CellSpace createCellSpace(String ID, String parentID, List<String> cellSpaceBoundary,
			String duality) {
		FeatureClassReference.CellSpace newFeature = createCellSpace(ID, parentID, cellSpaceBoundary);
		newFeature.setDuality(duality);
		return newFeature;
	};

	public FeatureClassReference.CellSpace createCellSpace(String ID, String parentID, List<String> cellSpaceBoundary,
			String duality, CellSpaceGeometry csGeometry) {
		FeatureClassReference.CellSpace newFeature = createCellSpace(ID, parentID, cellSpaceBoundary, duality,
				csGeometry);
		newFeature.setCellSpaceGeometry(csGeometry);
		return newFeature;
	};

	public FeatureClassReference.CellSpace createCellSpace(String ID, String parentID, CellSpaceGeometry csGeometry,
			List<String> cellSpaceBoundary, String duality, ExternalReference er) {
		FeatureClassReference.CellSpace newFeature = createCellSpace(ID, parentID, cellSpaceBoundary, duality,
				csGeometry);
		newFeature.setExternalReference(er);
		return newFeature;
	};

	/**
	 * search and get CellSpace feature in document
	 * 
	 * @param ID
	 *            ID of target
	 * @return edited feature
	 */
	public FeatureClassReference.CellSpace readCellSpace(String docId, String Id) {
		FeatureClassReference.CellSpace target = (FeatureClassReference.CellSpace)docData.docs.getFeature(docId, Id);
		return target;
	};


	/**
	 * @param docId : Id of the document that this feature is contained
	 * @param Id : Id of this feature
	 * @param attributeType : the attribute name of this feature which will be updated
	 * @param attributeId : Id of will-be-updated attribute feature
	 * @param o : Data of updated attribute
	 * @return : updated feature instance
	 */
	public FeatureClassReference.CellSpace updateCellSpace(String docId, String Id, String attributeType,
			String attributeId, Object o) {
		FeatureClassReference.CellSpace target = null;
		if (docData.docs.hasFeature(docId, Id)) {
			target = (FeatureClassReference.CellSpace) docData.docs.getFeature(docId,
					Id);
			if (attributeType == "cellSpaceGeometry") {
				// TODO: need to implement geometry class at IndoorGMLAPI
			} else if (attributeType == "partialboundedBy") {
				// 한번에 하나의 cellSpaceBoundary가 들어온다고 가정
				List<String> partialboundedBy = target.getPartialboundedBy();
				partialboundedBy.add(attributeId);
				target.setPartialboundedBy(partialboundedBy);
				docData.docs.setFeature(docId, attributeId, "CelSpaceBoundary", o);
			} else if (attributeType == "duality") {
				target.setDuality(attributeId);
				docData.docs.setFeature(docId, attributeId, "State", o);
			} else if (attributeType == "externalReference") {
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

	public void deleteCellSpace(String docId, String Id) {
		if (docData.docs.hasFeature(docId, Id)) {
			IndoorGMLMap doc = docData.docs.getDocument(docId);
			FeatureClassReference.CellSpace target = (FeatureClassReference.CellSpace) docData.docs.getFeature(docId,
					Id);
			// String duality = target.getd;
			String duality = target.getDuality();
			List<String> partialboundedBy = target.getPartialboundedBy();
			State.deleteState(target.getDuality());

			// ExdeleteExternalReference()

			for (int i = 0; i < partialboundedBy.size(); i++) {
				CellSpaceBoundary.deleteCellSpaceBoundary(partialboundedBy.get(i));
			}
			doc.getFeatureContainer("ExternalReference").remove(target.getExternalReference());
			doc.getFeatureContainer("CellSpace").remove(Id);
			doc.getFeatureContainer("ID").remove(Id);
		}

	};

}
