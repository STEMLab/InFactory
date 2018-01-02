package FeatureClassReference;

import java.util.List;

/**
 * @author jungh Implements CellSpaceType of IndoorGML 1.0.3
 */
public class CellSpace {
	/**
	 * ID of this feature
	 */
	public String ID;
	/**
	 * Name of this feature
	 */
	public String name;
	/**
	 * value of geometry of feature
	 */
	public String geometry2D;

	public String geometry3D;

	/**
	 * temporal attribute for IndoorGML 1.0.1. for compatibility, Write the
	 * geometry type as String. Later this will be discarded or changed
	 */
	public String geometryType;
	/**
	 * temporal attribute for IndoorGML 1.0.1.
	 */
	public String cellSpaceGeometryObject;
	/**
	 * boundary of the CellSpace
	 */
	public List<String> partialboundedBy;
	/**
	 * value of State which has duality relationship with the CellSpace
	 */
	public String duality;
	/**
	 * If External Reference of the feature is exist, then set this.
	 */
	public String externalReference;

	
	/**
	 * ID of parent feature instance.
	 */
	public String parentID;
	
	public void setParentID(String parentID){
		this.parentID = parentID;
	}

	public String getID() {
		return this.ID;
	}

	public void setID(String id) {
		this.ID = id;
	}
	
	public Object getParent(){
		Object feature = null;
		feature = IndoorGMLMap.getFeature(IndoorGMLMap.getFeatureContainer("PrimalSpaceFeatures"), this.parentID);
		return feature;
	}
	public Object getGeometry2D() {
		Object feature = null;
		feature = IndoorGMLMap.getFeature(IndoorGMLMap.getFeatureContainer("Surface"), this.geometry2D);
		return feature;
	}

	public Object getGeometry3D() {
		Object feature = null;
		feature = IndoorGMLMap.getFeature(IndoorGMLMap.getFeatureContainer("Solid"), this.geometry3D);
		return feature;
	}

	@SuppressWarnings("null")
	public Object getPartialBoundedBy() {
		List<Object> feature = null;
		for (int i = 0; i < this.partialboundedBy.size(); i++) {
			feature.add(
					IndoorGMLMap.getFeature(IndoorGMLMap.getFeatureContainer("CellSpaceBoundary"), this.geometry2D));
		}
		return feature;
	}

/*
 * 
 * 	public Object getDuality() {
		Object feature = null;
		if (hasDuality()) {

			feature = IndoorGMLMap.getFeature(IndoorGMLMap.getFeatureContainer("State"), this.duality);

		}
		return feature;
	}
 * 
 * */
	
	public String getDuality(){
		return this.duality;
	}
	public List<String> getPartialboundedBy() {
		return this.partialboundedBy;
	}

	public void setPartialboundedBy(List<String> pbB) {
		this.partialboundedBy = pbB;
	}

	// public String getDuality(){return this.duality;}
	public void setDuality(String d) {
		this.duality = d;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getExternalReference() {
		return this.externalReference;
	}

	public void setExternalReference(String e) {
		this.externalReference = e;
	}

	public boolean hasDuality() {
		if (this.duality == null) {
			return false;
		} else
			return true;
	}
	/**
	 * @return the geometryType
	 */
	public String getGeometryType() {
		return geometryType;
	}
	/**
	 * @param geometryType the geometryType to set
	 */
	public void setGeometryType(String geometryType) {
		this.geometryType = geometryType;
	}
	/**
	 * @return the cellSpaceGeometryObject
	 */
	public String getCellSpaceGeometryObject() {
		return cellSpaceGeometryObject;
	}
	/**
	 * @param cellSpaceGeometryObject the cellSpaceGeometryObject to set
	 */
	public void setCellSpaceGeometryObject(String cellSpaceGeometryObject) {
		this.cellSpaceGeometryObject = cellSpaceGeometryObject;
	}
	/**
	 * @return the parentID
	 */
	public String getParentID() {
		return parentID;
	}
	/**
	 * @param geometry2d the geometry2D to set
	 */
	public void setGeometry2D(String geometry2d) {
		geometry2D = geometry2d;
	}
	/**
	 * @param geometry3d the geometry3D to set
	 */
	public void setGeometry3D(String geometry3d) {
		geometry3D = geometry3d;
	}
}
