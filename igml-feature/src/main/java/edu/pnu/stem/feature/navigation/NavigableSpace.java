package edu.pnu.stem.feature.navigation;

import edu.pnu.stem.binder.IndoorGMLMap;
import edu.pnu.stem.feature.core.CellSpace;
import edu.pnu.stem.feature.core.PrimalSpaceFeatures;

public class NavigableSpace extends CellSpace {
	private String parentId;
	private String classType;
	private String functionType;
	private String usageType;


	public NavigableSpace(IndoorGMLMap doc, String id) {
		super(doc, id);
		// TODO Auto-generated constructor stub
	}

	public void setParent(CellSpace parent) {
		CellSpace found = null;
		found = (CellSpace) indoorGMLMap.getFeature(parent.getId());
		if (found == null) {
			indoorGMLMap.setFutureFeature(parent.getId(), parent);
		}
		this.parentId = parent.getId();
	}

	public CellSpace getCellSpaceFeature() {
		CellSpace feature = null;
		feature = (CellSpace) indoorGMLMap.getFeature(this.parentId);
		if (feature == null) {
			feature = (CellSpace) indoorGMLMap.getFutureFeature(this.parentId);
		}
		return feature;
	}
	public void setClassType(String classType) {
		this.classType = classType;

	}
	public String getClassType() {
		return classType;
	}

	public void setFunctionType(String functionType) {
		this.functionType = functionType;

	}
	public String getFunctionType() {
		return functionType;
	}

	public void setUsageType(String usageType) {
		this.usageType=usageType;

	}
	public String getUsageType() {
		return usageType;
	}

}
