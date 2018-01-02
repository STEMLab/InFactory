package edu.pnu.stem.feature;

/**
 * @author jungh
 *	Implements CellSpaceBoundaryGeometryType of IndoorGML 1.0.3
 */
public class CellSpaceBoundaryGeometry {
	/**
	 * ID of this feature
	 */
	public String ID;
	/**
	 * Name of this feature
	 */
	public String name;
	/**
	 * save geometry of feature 
	 */	
	public String geometry2D;
	public String geometry3D;
	/**
	 * ID of parent feature instance.
	 */	
	public String parentID;
	
	public String getID(){ return this.ID; }
	public void setID(String id){ this.ID = id;} 
	
	public String getParentID(){return this.parentID;}
	public void setParentID(String id){this.parentID = id;}
	
	public Object getGeometry2D() {
		Object feature = null;
		feature = IndoorGMLMap.getFeature(IndoorGMLMap.getFeatureContainer("Curve"), this.geometry2D);
		return feature;
	}

	public Object getGeometry3D() {
		Object feature = null;
		feature = IndoorGMLMap.getFeature(IndoorGMLMap.getFeatureContainer("Surface"), this.geometry3D);
		return feature;
	}
}
	
