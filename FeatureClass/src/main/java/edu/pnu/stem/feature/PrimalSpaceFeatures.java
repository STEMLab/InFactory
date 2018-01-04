package edu.pnu.stem.feature;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jungh Implements PrimalSpaceFeaturesType of IndoorGML 1.0.3
 */
public class PrimalSpaceFeatures extends AbstractFeature {
	/**
	 * List of CellSpaces which this feature contains
	 */
	List<String> cellSpaceMember;

	/**
	 * List of CellSpaceBoundary which this feature contains
	 */
	List<String> cellSpaceBoundaryMember;

	String parentId;

	public void setParent(IndoorFeatures parent) {
		IndoorFeatures found = null;
		found = (IndoorFeatures) IndoorGMLMap.getFeature(IndoorGMLMap.getFeatureContainer("IndoorFeatures"),
				parent.getId());
		if (found == null) {
			IndoorGMLMap.setFeature(parent.getId(), "IndoorFeatures", parent);
		}
		this.parentId = parent.getId();
	}

	public IndoorFeatures getParent() {
		IndoorFeatures parent = null;
		parent = (IndoorFeatures) IndoorGMLMap.getFeature(IndoorGMLMap.getFeatureContainer("IndoorFeatures"),
				this.parentId);
		return parent;
	}

	/**
	 * @return the cellSpaceMember
	 */
	public List<String> getCellSpaceMember() {
		return cellSpaceMember;
	}

	/**
	 * @param cellSpaceMember
	 *            the cellSpaceMember to set
	 */
	public void setCellSpaceMember(List<CellSpace> cellSpaceMember) {
		for (int i = 0; i < cellSpaceMember.size(); i++) {
			CellSpace found = null;
			found = (CellSpace)IndoorGMLMap.getFeature(IndoorGMLMap.getFeatureContainer("IndoorFeatures"), cellSpaceMember.get(i).getId());
			if(found == null){
				IndoorGMLMap.setFeature(cellSpaceMember.get(i).getId(), "IndoorFeatures" , cellSpaceMember.get(i));
			}
		}
	}

	/**
	 * @return the cellSpaceBoundaryMember
	 */
	public List<CellSpaceBoundary> getCellSpaceBoundaryMember() {
		List<CellSpaceBoundary>cellSpaceBoundaryMember = null;
		if(this.cellSpaceMember != null){
			cellSpaceBoundaryMember = new ArrayList<CellSpaceBoundary>();
			for(int i = 0 ; i < cellSpaceBoundaryMember.size() ; i++){
				cellSpaceBoundaryMember.add((CellSpaceBoundary)IndoorGMLMap.getFeature(IndoorGMLMap.getFeatureContainer("CellSpaceBoundary"), this.cellSpaceMember.get(i)));
			}
		}
		return cellSpaceBoundaryMember;
	}

	/**
	 * @param cellSpaceBoundaryMember
	 *            the cellSpaceBoundaryMember to set
	 */
	public void setCellSpaceBoundaryMember(List<CellSpaceBoundary> cellSpaceBoundaryMember) {
		for (int i = 0; i < cellSpaceBoundaryMember.size(); i++) {
			CellSpaceBoundary found = null;
			found = (CellSpaceBoundary)IndoorGMLMap.getFeature(IndoorGMLMap.getFeatureContainer("IndoorFeatures"), cellSpaceBoundaryMember.get(i).getId());
			if(found == null){
				IndoorGMLMap.setFeature(cellSpaceBoundaryMember.get(i).getId(), "CellSpaceBoundary" , cellSpaceBoundaryMember.get(i));
			}
		}
	}
}
