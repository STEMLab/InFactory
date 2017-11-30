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
	public String getParentID(String parentID){
		return this.parentID;
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

	public Object getDuality() {
		Object feature = null;
		if (hasDuality()) {

			feature = IndoorGMLMap.getFeature(IndoorGMLMap.getFeatureContainer("State"), this.duality);

		}
		return feature;
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
}
