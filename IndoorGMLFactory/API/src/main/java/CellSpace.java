import java.util.List;

import Binder.IndoorGMLMap;
import Binder.docData;

/**
 * @author jungh
 *
 */
public class CellSpace {

	/**
	 * @param docID
	 * @param parentID
	 * @param ID
	 * @param duality
	 * @param partialboundedBy
	 * @param cellSpaceGeometry
	 * @param externalReference
	 * @return
	 */
	public static FeatureClassReference.CellSpace createCellSpace(String docID, String parentID, String ID,
			String duality, List<String> partialboundedBy, String cellSpaceGeometry, String externalReference) {
		FeatureClassReference.CellSpace newFeature = null;
		if (docData.docs.hasDoc(docID)) {
			newFeature.setID(ID);
			newFeature.setParentID(parentID);
			if (duality != null) {
				newFeature.setDuality(duality);
				if (docData.docs.getDocument(docID).getFeatureContainer("Reference").containsKey(duality)) {
					int count = (Integer) docData.docs.getDocument(docID).getFeatureContainer("Reference").get(duality);
					count++;
					docData.docs.setFeature(docID, ID, "Reference", count);
				}
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

	/**
	 * @param docId
	 * @param Id
	 * @return
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
				String tempDuality = target.getDuality();
				target.setDuality(attributeId);				
				if (docData.docs.getDocument(docId).getFeatureContainer("Reference").containsKey(attributeId)) {
					int count = (Integer) docData.docs.getDocument(docId).getFeatureContainer("Reference").get(attributeId);
					count++;
					docData.docs.setFeature(docId, attributeId, "Reference", count);
				}				
				if (docData.docs.getDocument(docId).getFeatureContainer("Reference").containsKey(tempDuality)) {
					int count = (Integer) docData.docs.getDocument(docId).getFeatureContainer("Reference").get(tempDuality);
					if(count > 0)
						count--;
					docData.docs.setFeature(docId, tempDuality, "Reference", count);
				}
				docData.docs.setFeature(docId, attributeId, "State", o);
			} else if (attributeType.equals("externalReference")) {
				target.setExternalReference(attributeId);
				docData.docs.setFeature(docId, attributeId, "ExternaReference", o);
			} else {
				System.out.println("update error in cellSpaceType : there is no such attribute name");
				return null;
			}
			docData.docs.setFeature(docId, Id, "CellSpace", o);
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

	public static void deleteCellSpace(String docId, String Id, Boolean deleteDuality) {
		if (docData.docs.hasFeature(docId, Id)) {
			IndoorGMLMap doc = docData.docs.getDocument(docId);
			FeatureClassReference.CellSpace target = (FeatureClassReference.CellSpace) docData.docs.getFeature(docId,
					Id);
			// String duality = target.getd;
			List<String> partialboundedBy = target.getPartialboundedBy();
			if (deleteDuality) {
				if (docData.docs.hasFeature(docId, target.getDuality())) {
					State.deleteState(docId, target.getDuality(), false);
				}
			}

			// ExdeleteExternalReference()

			for (int i = 0; i < partialboundedBy.size(); i++) {
				int count = (Integer) doc.getFeatureContainer("Reference").get(partialboundedBy.get(i));
				if (count == 1) {
					CellSpaceBoundary.deleteCellSpaceBoundary(docId, partialboundedBy.get(i), deleteDuality);
				} else {
					doc.setFeature(partialboundedBy.get(i), "Reference", (count - 1));
				}
			}
			if(target.hasDuality()){
				int count = (Integer) doc.getFeatureContainer("Reference").get(target.getDuality());
				if(count > 0){
					count--;
					doc.setFeature(target.getDuality(), "Reference", count);
				}
			}

			doc.getFeatureContainer("CellSpace").remove(Id);
			doc.getFeatureContainer("ID").remove(Id);
			doc.getFeatureContainer("ExternalReference").remove(target.getExternalReference());
			doc.getFeatureContainer("ID").remove(target.getExternalReference());

		}

	};

}
