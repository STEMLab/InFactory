package edu.pnu.stem.feature.navigation;

import edu.pnu.stem.binder.IndoorGMLMap;

public class ConnectionBoundary extends TransferBoundary{
	private String parentId;
	public ConnectionBoundary(IndoorGMLMap doc, String id) {
		super(doc, id);
		// TODO Auto-generated constructor stub
	}

	public void setParent(TransferBoundary parent) {
		TransferBoundary found = null;
		found = (TransferBoundary)indoorGMLMap.getFeature(parent.getId());
		if(found == null){
			indoorGMLMap.setFutureFeature(parent.getId(), parent);
		}
		this.parentId = parent.getId();
	}


	public TransferBoundary getTransferBoundaryFeature() {
		TransferBoundary feature = null;
		feature = (TransferBoundary) indoorGMLMap.getFeature(this.parentId);
		if(feature == null) {
			feature = (TransferBoundary) indoorGMLMap.getFutureFeature(this.parentId);
		}
		return feature;
	}
}
