package edu.pnu.stem.feature;

import com.vividsolutions.jts.geom.Geometry;

import edu.pnu.stem.binder.IndoorGMLMap;
import edu.pnu.stem.util.GeometryUtil;

/**
 * @author jungh Implements CellSpaceBoundaryType of IndoorGML 1.0.3
 */
public class CellSpaceBoundary extends AbstractFeature {
	
	
	private String geometry;
	/**
	 * value of Transition which has duality relationship with this
	 * CellSpaceBoundary
	 */
	private String duality;

	/**
	 * If External Reference of the feature is exist, then set this.
	 */
	private ExternalReference externalReference;

	/**
	 * ID of parent feature instance
	 */
	private String parentId;
	private String cellSpaceBoundaryGeometry;

	/**
	 * @return the docId
	 */
	private IndoorGMLMap indoorGMLMap;
	
	
	public CellSpaceBoundary(IndoorGMLMap doc){
		indoorGMLMap = doc;
	}
	
	public boolean hasDuality() {
		if (this.duality == null) {
			return false;
		} else {
			return true;
		}
	}
	public Geometry getGeometry() {
		Geometry feature = null;
		feature = (Geometry) indoorGMLMap.getFeature(this.geometry);
		return feature;
	}
	
	public void setGeometry(Geometry geom) {
		String gId = GeometryUtil.getMetadata(geom, "id");
		Geometry found = (Geometry) indoorGMLMap.getFeature(gId);
		if(found == null) {
			indoorGMLMap.setFeature(gId, "Geometry", geom);
		}
		this.geometry = gId;
	}
	
	public void setParent(PrimalSpaceFeatures parent) {
		PrimalSpaceFeatures found = null;
		found = (PrimalSpaceFeatures)indoorGMLMap.getFeature(parent.getId());
		if(found == null){
			indoorGMLMap.setFeature(parentId, "PrimalSpaceFeatures", parent);
		}
		this.parentId = parent.getId();
	}


	public PrimalSpaceFeatures getParent() {
		PrimalSpaceFeatures feature = null;
		feature = (PrimalSpaceFeatures) indoorGMLMap.getFeature(this.parentId);
		return feature;
	}

	public Transition getDuality() {
		Transition found = null;
		if (hasDuality()) {
			found = (Transition) indoorGMLMap.getFeature(this.duality);
		}
		return found;
	}

	public void setDuality(Transition duality) {
		Transition found = null;
		found = (Transition)indoorGMLMap.getFeature(duality.getId());
		if(found == null){
			indoorGMLMap.setFeature(duality.getId(), "Transition", duality);
		}
		this.duality = duality.getId();
	}

	public ExternalReference getExternalReference() {
		return this.externalReference;
	}

	public void setExternalReference(ExternalReference e) {
		this.externalReference = e;
	}

	/**
	 * @return the cellSpaceBoundaryGeometry
	 */
	public String getCellSpaceBoundaryGeometry() {
		return new String(cellSpaceBoundaryGeometry);
	}

	/**
	 * @param cellSpaceBoundaryGeometry
	 *            the cellSpaceBoundaryGeometry to set
	 */
	public void setCellSpaceBoundaryGeometry(String cellSpaceBoundaryGeometry) {
		this.cellSpaceBoundaryGeometry = cellSpaceBoundaryGeometry;
	}

}
