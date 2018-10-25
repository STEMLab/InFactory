package edu.pnu.stem.feature.core;

import java.util.ArrayList;
import java.util.List;

import edu.pnu.stem.binder.IndoorGMLMap;

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
	
	public PrimalSpaceFeatures(IndoorGMLMap doc, String id){
		super(doc, id);
		cellSpaceMember = new ArrayList<String>();
		cellSpaceBoundaryMember = new ArrayList<String>();
	}
	
	public void setParent(IndoorFeatures parent) {
		IndoorFeatures found = null;
		found = (IndoorFeatures) indoorGMLMap.getFeature(parent.getId());
		if (found == null) {
			indoorGMLMap.setFutureFeature(parent.getId(), parent);
		}
		this.parentId = parent.getId();
	}

	public IndoorFeatures getParent() {
		IndoorFeatures parent = null;
		parent = (IndoorFeatures) indoorGMLMap.getFeature(this.parentId);
		if(parent == null)
			parent = (IndoorFeatures)indoorGMLMap.getFutureFeature(this.parentId);
		return parent;
	}

	/**
	 * @return the cellSpaceMember
	 */
	public List<CellSpace> getCellSpaceMember() {
		List<CellSpace>cellSpaceMember = new ArrayList<CellSpace>();
		if(this.cellSpaceMember.size() != 0){
			for (int i = 0; i < this.cellSpaceMember.size(); i++) {
				CellSpace found = null;
				found = (CellSpace)indoorGMLMap.getFeature(this.cellSpaceMember.get(i));
				if(found == null)
					found = (CellSpace)indoorGMLMap.getFutureFeature(this.cellSpaceMember.get(i));
				cellSpaceMember.add(found);
			}
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
			found = (CellSpace)indoorGMLMap.getFeature(cellSpaceMember.get(i).getId());
			if(found == null){
				if(!indoorGMLMap.hasFutureID(cellSpaceMember.get(i).getId())){
					indoorGMLMap.setFutureFeature(cellSpaceMember.get(i).getId(), cellSpaceMember.get(i));
				}
			}
			if(!this.cellSpaceMember.contains(cellSpaceMember.get(i).getId())){
				this.cellSpaceMember.add(cellSpaceMember.get(i).getId());
			}
		}
	}
	
	public void addCellSpaceMember(CellSpace c) {
		if(this.cellSpaceMember == null)
			this.cellSpaceMember = new ArrayList<String>();
		
		if( !this.cellSpaceMember.contains(c.getId()) ){
			CellSpace found = null;
			found = (CellSpace)indoorGMLMap.getFeature(c.getId());
			if(found == null)
				indoorGMLMap.setFutureFeature(c.getId(), c);
			
			this.cellSpaceMember.add(c.getId());
			
		}
	}
	
	/**
	 * @return the cellSpaceBoundaryMember
	 */
	public List<CellSpaceBoundary> getCellSpaceBoundaryMember() {
		List<CellSpaceBoundary>cellSpaceBoundaryMember = new ArrayList<CellSpaceBoundary>();
		if(this.cellSpaceBoundaryMember.size() != 0){
			for(int i = 0 ; i < this.cellSpaceBoundaryMember.size() ; i++){
				CellSpaceBoundary found = (CellSpaceBoundary)indoorGMLMap.getFeature(this.cellSpaceBoundaryMember.get(i));
				if(found == null)
					found = (CellSpaceBoundary)indoorGMLMap.getFutureFeature(this.cellSpaceBoundaryMember.get(i));
				cellSpaceBoundaryMember.add(found);
			}
		}
		return cellSpaceBoundaryMember;
	}

	/**
	 * @param cellSpaceBoundaryMember
	 *            the cellSpaceBoundaryMember to set
	 */
	public void setCellSpaceBoundaryMember(List<CellSpaceBoundary> cellSpaceBoundaryMember) {
		this.cellSpaceBoundaryMember.clear();
		for (int i = 0; i < cellSpaceBoundaryMember.size(); i++) {
			CellSpaceBoundary found = null;
			found = (CellSpaceBoundary)indoorGMLMap.getFeature(cellSpaceBoundaryMember.get(i).getId());
			if(found == null){
				indoorGMLMap.setFutureFeature(cellSpaceBoundaryMember.get(i).getId(), cellSpaceBoundaryMember.get(i));
			}
			if(!this.cellSpaceBoundaryMember.contains(cellSpaceBoundaryMember.get(i).getId())){
				this.cellSpaceBoundaryMember.add(cellSpaceBoundaryMember.get(i).getId());
			}
		}
	}
	
	public void addCellSpaceBoundaryMember(CellSpaceBoundary c) {
		if(this.cellSpaceBoundaryMember == null)
			this.cellSpaceBoundaryMember = new ArrayList<String>();
		if( !this.cellSpaceBoundaryMember.contains(c.getId()) ){
			CellSpaceBoundary found = null;
			found = (CellSpaceBoundary)indoorGMLMap.getFeature(c.getId());
			if(found == null) {
				indoorGMLMap.setFutureFeature(c.getId(), c);
			}
			this.cellSpaceBoundaryMember.add(c.getId());
		}
	}
	
	public void deleteCellSpaceMember(String id) {
		if(cellSpaceMember.contains(id)) {
			cellSpaceMember.remove(id);
		}
	}

	public void deleteCellSpaceBoundaryMember(String id) {
		if(cellSpaceBoundaryMember.contains(id))
			cellSpaceBoundaryMember.remove(id);
		
	}
	
	public void resetParent() {
		this.parentId = null;
	}
}
