package edu.pnu.stem.feature.core;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.locationtech.jts.geom.Geometry;

import edu.pnu.stem.binder.IndoorGMLMap;
import edu.pnu.stem.util.GeometryUtil;

public class Envelope  extends AbstractFeature {
	
	/**
	 * geometry of this feature
	 */
	private String srsName;
	private BigInteger srsDimension;
	
	private String upperCorner;
	private String lowerCorner;
	
	
	public Envelope(IndoorGMLMap doc, String id){
		super(doc, id);
		
	}
	public void setUpperCorner(Geometry geom) {
		String gId = GeometryUtil.getMetadata(geom, "id");
		Geometry found = (Geometry) indoorGMLMap.getFeature4Geometry(gId);
		if(found == null) {
			indoorGMLMap.setFeature4Geometry(gId, geom);
					}
		this.upperCorner = gId;
	}
	
	public Geometry getUpperCorner() {
		Geometry feature = null;
		if(this.upperCorner != null) {
			feature = (Geometry) indoorGMLMap.getFeature4Geometry(this.upperCorner);
		}
		return feature;
	}
	
	public void setLowerCorner(Geometry geom) {
		String gId = GeometryUtil.getMetadata(geom, "id");
		Geometry found = (Geometry) indoorGMLMap.getFeature4Geometry(gId);
		if(found == null) {
			indoorGMLMap.setFeature4Geometry(gId, geom);
			
		}
		this.lowerCorner = gId;
	}
	
	public Geometry getLowerCorner() {
		Geometry feature = null;
		if(this.lowerCorner != null) {
			feature = (Geometry) indoorGMLMap.getFeature4Geometry(this.lowerCorner);
		}
		return feature;
	}	
	
	public void setSrsName(String srsName) {
		this.srsName = srsName;
		
	}
	public String getSrsName() {
		return this.srsName;
	}
	public void setSrsDimension(BigInteger srsDimension) {
		this.srsDimension = srsDimension;
		
	}
	public BigInteger getSrsDimension() {
		return this.srsDimension;
	}

	public String parentId;

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

	
	public void resetParent() {
		this.parentId = null;
		
	}
}
