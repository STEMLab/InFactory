package edu.pnu.stem.feature.navigation;

import edu.pnu.stem.binder.IndoorGMLMap;
import edu.pnu.stem.feature.core.CellSpaceBoundary;
import edu.pnu.stem.feature.core.PrimalSpaceFeatures;

public class AnchorBoundary extends TransferBoundary{
	private String parentId;
	public AnchorBoundary(IndoorGMLMap doc, String id) {
		
		super(doc, id);
		// TODO Auto-generated constructor stub
		System.out.println("Navi:AnchorB");
	}
	public void setParent(AnchorBoundary parent) {
		AnchorBoundary found = null;
		found = (AnchorBoundary)indoorGMLMap.getFeature(parent.getId());
		if(found == null){
			indoorGMLMap.setFutureFeature(parent.getId(), parent);
		}
		this.parentId = parent.getId();
	}


	public AnchorBoundary getAnchorBoundaryParent() {
		AnchorBoundary feature = null;
		feature = (AnchorBoundary) indoorGMLMap.getFeature(this.parentId);
		if(feature == null) {
			feature = (AnchorBoundary) indoorGMLMap.getFutureFeature(this.parentId);
		}
		return feature;
	}
	
	public void copyCellBoundary(CellSpaceBoundary cb) {
		this.setCellSpace(cb.getCellSpace());
	}
}
