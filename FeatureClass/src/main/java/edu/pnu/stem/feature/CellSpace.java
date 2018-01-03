package edu.pnu.stem.feature;

import java.util.ArrayList;
import java.util.List;

import org.locationtech.jts.geom.Polygon;

/**
 * @author jungh Implements CellSpaceType of IndoorGML 1.0.3
 */
public class CellSpace extends AbstractFeature {

	/**
	 * value of geometry of feature
	 */
	private String geometry2D;

	private String geometry3D;

	/**
	 * temporal attribute for IndoorGML 1.0.1. for compatibility, Write the geometry
	 * type as String. Later this will be discarded or changed
	 */
	private String geometryType;
	/**
	 * temporal attribute for IndoorGML 1.0.1.
	 */
	private String cellSpaceGeometryObject;
	/**
	 * boundary of the CellSpace
	 */
	private List<String> partialboundedBy;
	/**
	 * value of State which has duality relationship with the CellSpace
	 */
	private String duality;
	/**
	 * If External Reference of the feature is exist, then set this.
	 */
	private String externalReference;

	/**
	 * ID of parent feature instance.
	 */
	private String parentId;

	public void setParent(PrimalSpaceFeatures parent) {
		State found = (State) IndoorGMLMap.getFeature(IndoorGMLMap.getFeatureContainer("PrimalSpaceFeatures"), parent.getId());
		if(found == null) {
			IndoorGMLMap.setFeature(parent.getId(), "PrimalSpaceFeatures", parent);
		}
		this.parentId = parent.getId();
	}

	public PrimalSpaceFeatures getParent() {
		PrimalSpaceFeatures feature = null;
		feature = (PrimalSpaceFeatures) IndoorGMLMap.getFeature(IndoorGMLMap.getFeatureContainer("PrimalSpaceFeatures"), this.parentId);
		return feature;
	}

	public Polygon getGeometry2D() {
		Polygon feature = null;
		feature = (Polygon) IndoorGMLMap.getFeature(IndoorGMLMap.getFeatureContainer("Surface"), this.geometry2D);
		return feature;
	}

	public Solid getGeometry3D() {
		Solid feature = null;
		feature = (Solid) IndoorGMLMap.getFeature(IndoorGMLMap.getFeatureContainer("Solid"), this.geometry3D);
		return feature;
	}
	

	/**
	 * @param geometry2d
	 *            the geometry2D to set
	 */
	//TODO
	/*
	public void setGeometry2D(Polygon geometry2d) {
		geometry2D = geometry2d;
	}
	*/

	/**
	 * @param geometry3d
	 *            the geometry3D to set
	 */
	//TODO
	/*
	public void setGeometry3D(String geometry3d) {
		geometry3D = geometry3d;
	}
	*/

	public boolean hasDuality() {
		if (this.duality == null) {
			return false;
		} else {
			return true;
		}
	}

	public State getDuality() {
		State feature = null;
		if (hasDuality()) {
			feature = (State) IndoorGMLMap.getFeature(IndoorGMLMap.getFeatureContainer("State"), this.duality);
		}
		return feature;
	}
	
	public void setDuality(State s) {
		State found = (State) IndoorGMLMap.getFeature(IndoorGMLMap.getFeatureContainer("State"), s.getId());
		if(found == null) {
			IndoorGMLMap.setFeature(s.getId(), "State", s);
		}
		this.duality = s.getId();
	}

	public List<CellSpaceBoundary> getPartialboundedBy() {
		List<CellSpaceBoundary> cboundaries = new ArrayList<CellSpaceBoundary>();
		for (String s : this.partialboundedBy) {
			cboundaries.add((CellSpaceBoundary) IndoorGMLMap
					.getFeature(IndoorGMLMap.getFeatureContainer("CellSpaceBoundary"), s));
		}
		return cboundaries;
	}

	//TODO
	/*public void setPartialboundedBy(List<String> pbB) {
		this.partialboundedBy = pbB;
	}
	*/

	public ExternalReference getExternalReference() {
		return (ExternalReference) IndoorGMLMap.getFeature(IndoorGMLMap.getFeatureContainer("ExternalReference"), this.externalReference);
	}

	//TODO
	/* 
	public void setExternalReference(String e) {
		this.externalReference = e;
	}
	*/
	
	/**
	 * @return the geometryType
	 */
	public String getGeometryType() {
		return geometryType;
	}

	/**
	 * @param geometryType
	 *            the geometryType to set
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
	 * @param cellSpaceGeometryObject
	 *            the cellSpaceGeometryObject to set
	 */
	public void setCellSpaceGeometryObject(String cellSpaceGeometryObject) {
		this.cellSpaceGeometryObject = cellSpaceGeometryObject;
	}
}
