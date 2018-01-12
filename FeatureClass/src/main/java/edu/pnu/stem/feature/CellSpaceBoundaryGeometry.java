package edu.pnu.stem.feature;

import java.awt.Container;

import edu.pnu.stem.binder.IndoorGMLMap;

/**
 * @author jungh
 *	Implements CellSpaceBoundaryGeometryType of IndoorGML 1.0.3
 */
public class CellSpaceBoundaryGeometry extends AbstractFeature {
	
	private IndoorGMLMap indoorGMLMap;
	
	private String docId;
	private String geometry2D;
	private String geometry3D;
	/**
	 * ID of parent feature instance.
	 */	
	private String parentID;
	
	public CellSpaceBoundaryGeometry(IndoorGMLMap doc){
		indoorGMLMap = doc;
	}
	
	public String getParentID(){return this.parentID;}
	public void setParentID(String id){this.parentID = id;}
	
	public Object getGeometry2D(IndoorGMLMap map) {
		Object feature = null;
		feature = indoorGMLMap.getFeature(this.geometry2D);
		return feature;
	}

	public Object getGeometry3D() {
		Object feature = null;
		feature = indoorGMLMap.getFeature(this.geometry3D);
		return feature;
	}
}
	
