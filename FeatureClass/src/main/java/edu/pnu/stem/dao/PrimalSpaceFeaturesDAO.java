package edu.pnu.stem.dao;


import java.util.ArrayList;
import java.util.List;

import edu.pnu.stem.binder.Container;
import edu.pnu.stem.binder.IndoorGMLMap;
import edu.pnu.stem.feature.CellSpace;
import edu.pnu.stem.feature.CellSpaceBoundary;
import edu.pnu.stem.feature.IndoorFeatures;
import edu.pnu.stem.feature.PrimalSpaceFeatures;

/**
 * 
 * @author jungh
 *	This class implements PrimalSpaceFeaturestype of IndoorGML-1.0.3
 */
public class PrimalSpaceFeaturesDAO {
	/**
	 * Create PrimalSpaceFeatures feature instance
	 * @param ID ID of PrimalSpaceFeatures
	 * @param parentID parentID ID of parent which will hold this feature
	 * @param csl List of CellSpace 
	 * @param csb List of CellSpaceBoundary
	 * @return created PrimalSpaceFeatures
	 */
	public PrimalSpaceFeatures createPrimalSpaceFeatures(String ID, String parentID, List<CellSpace> csl,
			List<CellSpaceBoundary> csb) {
		return null;
	}
	
	public static PrimalSpaceFeatures createPrimalFeatures(String docId, String parentId, String id,
			List<String>cellSpaceMember, List<String>cellSpaceBoundaryMember) {
		PrimalSpaceFeatures newFeature = null;
		if (Container.getInstance().hasDoc(docId)) {
			IndoorGMLMap map = Container.getInstance().getDocument(docId);
			newFeature = new PrimalSpaceFeatures(map);
			newFeature.setId(id);
			IndoorFeatures parent = new IndoorFeatures(map);
			parent.setId(parentId);
			newFeature.setParent(parent);
			if (cellSpaceMember!= null) {
				List<CellSpace>tempCellSpaceMember = new ArrayList<CellSpace>();
				for(int i = 0 ; i < cellSpaceMember.size(); i++){
					CellSpace temp = new CellSpace(map);
					temp.setId(cellSpaceMember.get(i));
					tempCellSpaceMember.add(temp);
				}
				newFeature.setCellSpaceMember(tempCellSpaceMember);
			}
			if (cellSpaceBoundaryMember != null) {
				List<CellSpaceBoundary>tempCellSpaceBoundaryMember = new ArrayList<CellSpaceBoundary>();
				for(int i = 0 ; i < cellSpaceBoundaryMember.size(); i++){
					CellSpaceBoundary temp = new CellSpaceBoundary(map);
					temp.setId(cellSpaceMember.get(i));
					tempCellSpaceBoundaryMember.add(temp);
				}
				newFeature.setCellSpaceBoundaryMember(tempCellSpaceBoundaryMember);
			}
			Container.getInstance().setFeature(docId, id, "CellSpace", newFeature);
		}
		return newFeature;
	}
	/**
	 * Search PrimalSpaceFeatures feature in document
	 * @param ID ID of target
	 * @return searched PrimalSpaceFeatures
	 */
	public static PrimalSpaceFeatures readPrimalSpaceFeatures(String docId, String id) {
		PrimalSpaceFeatures target = null;
		target = (PrimalSpaceFeatures)Container.getInstance().getDocument(docId).getFeature(id);
		return target;
	}

	/**
	 * Search PrimalSpaceFeatures feature and edit it as the parameters
	 * @param ID ID of target
	 * @param csl List of CellSpace
	 * @param csbl List of CellSpaceBoundary
	 * @return edited feature instance
	 */
	public static PrimalSpaceFeatures updatePrimalSpaceFeatures(String ID, List<CellSpace> csl, List<CellSpaceBoundary> csbl) {
		return null;
	}
	
	public PrimalSpaceFeatures updatePrimalSpaceFeatures(String docId, String Id, String attributeType,
			String updateType, List<String>object ) {
		PrimalSpaceFeatures target = null;
		if (Container.getInstance().hasFeature(docId, Id)) {
			target = (PrimalSpaceFeatures) Container.getInstance().getFeature(docId, Id);
			if (attributeType.equals("cellSpaceMember")) {
				List<CellSpace>cellSpaceMember = target.getCellSpaceMember();
				for(int i = 0 ; i < object.size(); i++){
					
				}
				if(updateType.equals("add")){
					//cellSpaceMember.addAll(object);
				}
				//TODO : add cellSpace to cellSpace container and ID container
				else if(updateType.equals("delete")){
					for(int i = 0 ; i < object.size();i++){
						if(cellSpaceMember.contains(object.get(i))){
							cellSpaceMember.remove(object.get(i));
						}
					}
				//TODO : remove cellSpace at cellSpace container and ID container?
				}
				
			} else if (attributeType.equals("cellSpaceBoundaryMember")) {
				/*
				 *List<String>cellSpaceBoundaryMember = target.getCellSpaceBoundaryMember();
				if(updateType.equals("add")){
					cellSpaceBoundaryMember.addAll(object);
				}
				//TODO : add cellSpace to cellSpace container and ID container
				else if(updateType.equals("delete")){
					for(int i = 0 ; i < object.size();i++){
						if(cellSpaceBoundaryMember.contains(object.get(i))){
							cellSpaceBoundaryMember.remove(object.get(i));
						}
					}
				//TODO : remove cellSpace at cellSpace container and ID container?
					//answer : because relationship is aggregation, so do not have.
				}

				 * 
				 * */
			}  else {
				System.out.println("update error in cellSpaceType : there is no such attribute name");
			}
		} else {
			System.out.println("there is no name with Id :" + Id + " in document Id : " + docId);
		}
		return target;
	}
	/**
	 * Search PrimalSpaceFeatures feature and delete it
	 * @param id ID of target
	 * 
	 */
	public static void deletePrimalSpaceFeatures(String docId, String Id) {
		if (Container.getInstance().hasFeature(docId, Id)) {
			IndoorGMLMap doc = Container.getInstance().getDocument(docId);
			PrimalSpaceFeatures target = (PrimalSpaceFeatures) Container.getInstance().getFeature(docId,
					Id);
			// String duality = target.getd;
			doc.getFeatureContainer("PrimalSpaceFeatures").remove(Id);
			doc.getFeatureContainer("ID").remove(Id);
			
			
		}
	}

}
