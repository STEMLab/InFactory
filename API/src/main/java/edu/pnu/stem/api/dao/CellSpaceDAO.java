package edu.pnu.stem.api.dao;
import java.util.List;

import edu.pnu.stem.binder.Container;
import edu.pnu.stem.binder.IndoorGMLMap;

/**
 * @author jungh
 *
 */
public class CellSpaceDAO {

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
	public static edu.pnu.stem.feature.CellSpace createCellSpace(String docID, String parentID, String ID,
			String duality, List<String> partialboundedBy, String cellSpaceGeometry, String externalReference) {
		edu.pnu.stem.feature.CellSpace newFeature = null;
		if (Container.getInstance().hasDoc(docID)) {
			newFeature.setID(ID);
			newFeature.setParentID(parentID);
			if (duality != null) {
				newFeature.setDuality(duality);
				if (Container.getInstance().getDocument(docID).getFeatureContainer("Reference").containsKey(duality)) {
					int count = (Integer) Container.getInstance().getDocument(docID).getFeatureContainer("Reference").get(duality);
					count++;
					Container.getInstance().setFeature(docID, ID, "Reference", count);
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
			Container.getInstance().setFeature(docID, ID, "CellSpace", newFeature);
		}
		return newFeature;
	}

	/**
	 * @param docId
	 * @param Id
	 * @return
	 */
	public edu.pnu.stem.feature.CellSpace readCellSpace(String docId, String Id) {
		edu.pnu.stem.feature.CellSpace target = (edu.pnu.stem.feature.CellSpace) Container.getInstance().getFeature(docId, Id);
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
	public edu.pnu.stem.feature.CellSpace updateCellSpace(String docId, String Id, String attributeType,
			String attributeId, Object o) {
		edu.pnu.stem.feature.CellSpace target = null;
		if (Container.getInstance().hasFeature(docId, Id)) {
			target = (edu.pnu.stem.feature.CellSpace) Container.getInstance().getFeature(docId, Id);
			if (attributeType.equals("cellSpaceGeometry")) {
				// TODO: need to implement geometry class at IndoorGMLAPI
			} else if (attributeType.equals("partialboundedBy")) {
				// 한번에 하나의 cellSpaceBoundary가 들어온다고 가정
				List<String> partialboundedBy = target.getPartialboundedBy();
				partialboundedBy.add(attributeId);
				target.setPartialboundedBy(partialboundedBy);
				Container.getInstance().setFeature(docId, attributeId, "CellSpaceBoundary", o);
			} else if (attributeType.equals("duality")) {
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
				Container.getInstance().setFeature(docId, attributeId, "State", o);
			} else if (attributeType.equals("externalReference")) {
				target.setExternalReference(attributeId);
				Container.getInstance().setFeature(docId, attributeId, "ExternaReference", o);
			} else {
				System.out.println("update error in cellSpaceType : there is no such attribute name");
				return null;
			}
			Container.getInstance().setFeature(docId, Id, "CellSpace", o);
		} else {
			System.out.println("there is no name with Id :" + Id + " in document Id : " + docId);
		}
		return target;
	}

	/**
	 * search CellSpace feature and delete the data
	 * 
	 * @param id
	 *            ID of target
	 */

	public static void deleteCellSpace(String docId, String Id, Boolean deleteDuality) {
		if (Container.getInstance().hasFeature(docId, Id)) {
			IndoorGMLMap doc = Container.getInstance().getDocument(docId);
			edu.pnu.stem.feature.CellSpace target = (edu.pnu.stem.feature.CellSpace) Container.getInstance().getFeature(docId,
					Id);
			// String duality = target.getd;
			List<String> partialboundedBy = target.getPartialboundedBy();
			
			int count = (Integer) doc.getFeatureContainer("Reference").get(target.getID());
			
			
			
			if (deleteDuality) {
				if (Container.getInstance().hasFeature(docId, target.getDuality())) {
					StateDAO.deleteState(docId, target.getDuality(), false);
				}
			}
			
			// ExdeleteExternalReference()

			for (int i = 0; i < partialboundedBy.size(); i++) {
				int boundaryCount = (Integer) doc.getFeatureContainer("Reference").get(partialboundedBy.get(i));
				if (boundaryCount == 1) {
					CellSpaceBoundaryDAO.deleteCellSpaceBoundary(docId, partialboundedBy.get(i), deleteDuality);
				} else {
					doc.setFeature(partialboundedBy.get(i), "Reference", (boundaryCount - 1));
				}
			}
			if(target.hasDuality()){
				int dualityCount = (Integer) doc.getFeatureContainer("Reference").get(target.getDuality());
				if(dualityCount > 0){
					dualityCount--;
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
