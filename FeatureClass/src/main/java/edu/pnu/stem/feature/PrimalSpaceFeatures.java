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
	private List<String> cellSpaceMember;

	/**
	 * List of CellSpaceBoundary which this feature contains
	 */
	private List<String> cellSpaceBoundaryMember;

	private String parentId;
	
	private IndoorGMLMap indoorGMLMap;
	
	public PrimalSpaceFeatures(IndoorGMLMap doc){
		indoorGMLMap = doc;
	}
	
	public void setParent(IndoorFeatures parent) {
		IndoorFeatures found = null;
		found = (IndoorFeatures) indoorGMLMap.getFeature(indoorGMLMap.getFeatureContainer("IndoorFeatures"),
				parent.getId());
		if (found == null) {
			indoorGMLMap.setFeature(parent.getId(), "IndoorFeatures", parent);
		}
		this.parentId = parent.getId();
	}

	public IndoorFeatures getParent() {
		IndoorFeatures parent = null;
		parent = (IndoorFeatures) indoorGMLMap.getFeature(indoorGMLMap.getFeatureContainer("IndoorFeatures"),
				this.parentId);
		return parent;
	}

	/**
	 * @return the cellSpaceMember
	 */
	public List<CellSpace> getCellSpaceMember() {
		List<CellSpace>cellSpaceMember = new ArrayList<CellSpace>();
		for (int i = 0; i < this.cellSpaceMember.size(); i++) {
			CellSpace found = null;
			found = (CellSpace)indoorGMLMap.getFeature(indoorGMLMap.getFeatureContainer("IndoorFeatures"), this.cellSpaceMember.get(i));
			cellSpaceMember.add(found);
		}
		return cellSpaceMember;
	}

	/**
	 * @param cellSpaceMember
	 *            the cellSpaceMember to set
	 */
	public void setCellSpaceMember(List<CellSpace> cellSpaceMember) {
		for (int i = 0; i < cellSpaceMember.size(); i++) {
			CellSpace found = null;
			found = (CellSpace)indoorGMLMap.getFeature(indoorGMLMap.getFeatureContainer("IndoorFeatures"), cellSpaceMember.get(i).getId());
			if(found == null){
				indoorGMLMap.setFeature(cellSpaceMember.get(i).getId(), "IndoorFeatures" , cellSpaceMember.get(i));
			}
			if(this.cellSpaceMember == null){
				this.cellSpaceMember = new ArrayList<String>();
			}
			if(!this.cellSpaceMember.contains(cellSpaceMember.get(i).getId())){
				this.cellSpaceMember.add(cellSpaceMember.get(i).getId());
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
				cellSpaceBoundaryMember.add((CellSpaceBoundary)indoorGMLMap.getFeature(indoorGMLMap.getFeatureContainer("CellSpaceBoundary"), this.cellSpaceMember.get(i)));
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
			found = (CellSpaceBoundary)indoorGMLMap.getFeature(indoorGMLMap.getFeatureContainer("IndoorFeatures"), cellSpaceBoundaryMember.get(i).getId());
			if(found == null){
				indoorGMLMap.setFeature(cellSpaceBoundaryMember.get(i).getId(), "CellSpaceBoundary" , cellSpaceBoundaryMember.get(i));
			}
			if(this.cellSpaceBoundaryMember == null){
				this.cellSpaceBoundaryMember = new ArrayList<String>();
			}
			if(!this.cellSpaceBoundaryMember.contains(cellSpaceBoundaryMember.get(i).getId())){
				this.cellSpaceBoundaryMember.add(cellSpaceBoundaryMember.get(i).getId());
			}
		}
	}
}
