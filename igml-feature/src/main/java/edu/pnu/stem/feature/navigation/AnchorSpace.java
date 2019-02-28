package edu.pnu.stem.feature.navigation;

import edu.pnu.stem.binder.IndoorGMLMap;

public class AnchorSpace extends TransferSpace {
	private String parentId;

	public AnchorSpace(IndoorGMLMap doc, String id) {
		super(doc, id);
		System.out.println("Navi:Anchor");
		// TODO Auto-generated constructor stub
	}

	public void setParent(TransferSpace parent) {
		TransferSpace found = null;
		found = (TransferSpace) indoorGMLMap.getFeature(parent.getId());
		if (found == null) {
			indoorGMLMap.setFutureFeature(parent.getId(), parent);
		}
		this.parentId = parent.getId();
	}

	public TransferSpace getTransferSpaceFeature() {
		TransferSpace feature = null;
		feature = (TransferSpace) indoorGMLMap.getFeature(this.parentId);
		if (feature == null) {
			feature = (TransferSpace) indoorGMLMap.getFutureFeature(this.parentId);
		}
		return feature;
	}

}
