package edu.pnu.stem.dao;
import java.util.UUID;

import com.vividsolutions.jts.io.ParseException;

import edu.pnu.stem.binder.IndoorGMLMap;
import edu.pnu.stem.feature.CellSpace;
import edu.pnu.stem.feature.PrimalSpaceFeatures;
import edu.pnu.stem.feature.State;
import edu.pnu.stem.geometry.jts.Solid;
import edu.pnu.stem.geometry.jts.WKTReader3D;

/**
 * @author jungh
 *
 */
public class CellSpaceDAO {

	/*
	public static CellSpace createCellSpace(IndoorGMLMap map, String parentId, String ID,
		String duality, List<String> partialboundedBy, String cellSpaceGeometry, String externalReference) {
		CellSpace newFeature = null;
		newFeature = new CellSpace(map);
		newFeature.setId(ID);
		PrimalSpaceFeatures parent = new PrimalSpaceFeatures(map);
		parent.setId(parentId);
		newFeature.setParent(parent);
		if (duality != null) {
			State tempDuality = new State(map);
			tempDuality.setId(duality);
			newFeature.setDuality(tempDuality);
			if (map.getFeatureContainer("Reference").containsKey(duality)) {
				int count = (Integer) map.getFeatureContainer("Reference").get(duality);
				count++;
				map.setFeature(ID, "Reference", count);
			}
		}

		if (cellSpaceGeometry != null) {
			// newFeature.set
		}
		if (partialboundedBy != null) {
			List<CellSpaceBoundary>tempartialboundedBy = new ArrayList<CellSpaceBoundary>();
			for(int i = 0 ; i < partialboundedBy.size(); i++){
				CellSpaceBoundary temp = new CellSpaceBoundary(map);
				temp.setId(partialboundedBy.get(i));
				tempartialboundedBy.add(temp);
			}
			newFeature.setPartialboundedBy(tempartialboundedBy);
		}
		if (externalReference != null) {
			//newFeature.setExternalReference(externalReference);
		}
		map.setFeature(ID, "CellSpace", newFeature);
		return newFeature;
	}
	*/
	
	public static CellSpace createCellSpace(IndoorGMLMap map, String parentId, String id, String geometry, String duality) {
		if(id == null) {
			id = UUID.randomUUID().toString();
		}
		

		CellSpace newFeature = new CellSpace(map, id);
		if(map.hasFutureID(id)){
			newFeature = (CellSpace)map.getFutureFeature(id);
			map.removeFutureID(id);
		}

		PrimalSpaceFeatures parent = (PrimalSpaceFeatures) map.getFeature(parentId);
		
		if(parent == null){
			if(map.hasFutureID(parentId)){
				parent = (PrimalSpaceFeatures)map.getFutureFeature(parentId);
				map.removeFutureID(parentId);
			}
			else{
				parent = new PrimalSpaceFeatures(map,parentId);
			}			
		}
		
		parent.addCellSpaceMember(newFeature);
		newFeature.setParent(parent);
		
		if (geometry != null) {
			WKTReader3D wkt = new WKTReader3D();
			try {
				Solid s = (Solid) wkt.read(geometry);
				map.setFeature4Geometry(UUID.randomUUID().toString(), s);
				newFeature.setGeometry(s);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if(duality != null){
			State dualityFeature = (State) map.getFeature(duality);
			
			if(dualityFeature == null){
				dualityFeature = new State(map, duality);
			}
			
			dualityFeature.setDuality(newFeature);
			newFeature.setDuality(dualityFeature);

		}

		map.setFeature(id, "CellSpace", newFeature);
		return newFeature;
	}

	/**
	 * @param docId
	 * @param Id
	 * @return
	 */
	/*
	public CellSpace readCellSpace(String docId, String Id) {
		CellSpace target = null;
		target = (CellSpace) Container.getInstance().getFeature(docId, Id);
		return target;
	};
	*/

	/**
	 * @param docId
	 *            : Id of the document that this feature is contained
	 * @param id
	 *            : Id of this feature
	 * @param attributeType
	 *            : the attribute name of this feature which will be updated
	 * @param attributeId
	 *            : Id of will-be-updated attribute feature
	 * @param o
	 *            : Data of updated attribute
	 * @return : updated feature instance
	 */
	/*
	public CellSpace updateCellSpace(String docId, String id, String attributeType,
			String attributeId, Object o) {
		CellSpace target = null;
		if (Container.getInstance().hasFeature(docId, id)) {
			IndoorGMLMap map = Container.getInstance().getDocument(docId);
			target = (CellSpace) Container.getInstance().getFeature(docId, id);
			if (attributeType.equals("cellSpaceGeometry")) {
				// TODO: need to implement geometry class at IndoorGMLAPI
			} else if (attributeType.equals("partialboundedBy")) {
				// 한번에 하나의 cellSpaceBoundary가 들어온다고 가정
				List<CellSpaceBoundary> partialboundedBy = target.getPartialboundedBy();
				List<CellSpaceBoundary> templist = new ArrayList<CellSpaceBoundary>();
				CellSpaceBoundary temp = new CellSpaceBoundary(map);
				temp.setId(attributeId);
				partialboundedBy.add(temp);
				target.setPartialboundedBy(partialboundedBy);
				Container.getInstance().setFeature(docId, attributeId, "CellSpaceBoundary", o);
			} else if (attributeType.equals("duality")) {
				State tempDuality = target.getDuality();
				target.setDuality((State)o);				
				if (Container.getInstance().getDocument(docId).getFeatureContainer("Reference").containsKey(attributeId)) {
					int count = (Integer) Container.getInstance().getDocument(docId).getFeatureContainer("Reference").get(attributeId);
					count++;
					map.setFeature(attributeId, "Reference", count);
				}				
				if (Container.getInstance().getDocument(docId).getFeatureContainer("Reference").containsKey(tempDuality)) {
					int count = (Integer) Container.getInstance().getDocument(docId).getFeatureContainer("Reference").get(tempDuality);
					if(count > 0)
						count--;
					map.setFeature(tempDuality.getId(), "Reference", count);
				}
				Container.getInstance().setFeature(docId, attributeId, "State", o);
			} else if (attributeType.equals("externalReference")) {
				//target.setExternalReference(attributeId);
				Container.getInstance().setFeature(docId, attributeId, "ExternaReference", o);
			} else {
				System.out.println("update error in cellSpaceType : there is no such attribute name");
				return null;
			}
			Container.getInstance().setFeature(docId, id, "CellSpace", o);
		} else {
			System.out.println("there is no name with Id :" + id + " in document Id : " + docId);
		}
		return target;
	}
	*/
	/**
	 * search CellSpace feature and delete the data
	 * 
	 * @param id
	 *            ID of target
	 */
	/*
	public static void deleteCellSpace(String docId, String Id, Boolean deleteDuality) {
		if(Container.getDocument(docId) != null){
			IndoorGMLMap map = Container.getInstance().getDocument(docId);
			if (map.hasID(Id)) {
				CellSpace target = (CellSpace) Container.getInstance().getFeature(docId,
						Id);
				// String duality = target.getd;
				List<CellSpaceBoundary> partialboundedBy = target.getPartialboundedBy();
				
				int count = (Integer)map.getFeatureContainer("Reference").get(target.getId());
				
				
				
				if (deleteDuality) {
					if (map.hasID(target.getDuality().getId())) {
						StateDAO.deleteState(docId, target.getDuality().getId(), false);
					}
				}
				
				// ExdeleteExternalReference()

				for (int i = 0; i < partialboundedBy.size(); i++) {
					int boundaryCount = (Integer) map.getFeatureContainer("Reference").get(partialboundedBy.get(i));
					if (boundaryCount == 1) {
						CellSpaceBoundaryDAO.deleteCellSpaceBoundary(docId, partialboundedBy.get(i).getId(), deleteDuality);
					} else {
						map.setFeature(partialboundedBy.get(i).getId(), "Reference", (boundaryCount - 1));
					}
				}
				if(target.hasDuality()){
					int dualityCount = (Integer) map.getFeatureContainer("Reference").get(target.getDuality());
					if(dualityCount > 0){
						dualityCount--;
						map.setFeature(target.getDuality().getId(), "Reference", count);
					}
				}

				map.getFeatureContainer("CellSpace").remove(Id);
				map.getFeatureContainer("ID").remove(Id);
				map.getFeatureContainer("ExternalReference").remove(target.getExternalReference());
				map.getFeatureContainer("ID").remove(target.getExternalReference());

		}
		
		}

	};
	*/
}
