package edu.pnu.stem.feature.core;



import org.locationtech.jts.geom.Geometry;

import edu.pnu.stem.binder.IndoorGMLMap;
import edu.pnu.stem.feature.navigation.GeneralSpace;
import edu.pnu.stem.util.GeometryUtil;

/**
 * @author jungh Implements CellSpaceBoundaryType of IndoorGML 1.0.3
 */
public class CellSpaceBoundary extends AbstractFeature{
	
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
	
	private String cellSpaceForPartialBoundedBy;

	public CellSpaceBoundary(IndoorGMLMap doc, String id){
		super(doc, id);
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
		feature = (Geometry) indoorGMLMap.getFeature4Geometry(this.geometry);
		return feature;
	}
	
	public void setGeometry(Geometry geom) {
		String gId = GeometryUtil.getMetadata(geom, "id");
		Geometry found = (Geometry) indoorGMLMap.getFeature4Geometry(gId);
		if(found == null) {
			indoorGMLMap.setFeature4Geometry(gId, geom);
		}
		this.geometry = gId;
	}
	
	public void setParent(PrimalSpaceFeatures parent) {
		PrimalSpaceFeatures found = null;
		found = (PrimalSpaceFeatures)indoorGMLMap.getFeature(parent.getId());
		if(found == null){
			indoorGMLMap.setFutureFeature(parent.getId(), parent);
		}
		this.parentId = parent.getId();
	}


	public PrimalSpaceFeatures getParent() {
		PrimalSpaceFeatures feature = null;
		feature = (PrimalSpaceFeatures) indoorGMLMap.getFeature(this.parentId);
		if(feature == null) {
			feature = (PrimalSpaceFeatures) indoorGMLMap.getFutureFeature(this.parentId);
		}
		return feature;
	}

	public Transition getDuality() {
		Transition found = null;
		if (hasDuality()) {
			found = (Transition) indoorGMLMap.getFeature(this.duality);
			if(found == null) {
				found = (Transition)indoorGMLMap.getFutureFeature(this.duality);
			}
		}
		return found;
	}

	public void setDuality(Transition duality) {
		Transition found = null;
		found = (Transition)indoorGMLMap.getFeature(duality.getId());
		if(found == null){
			indoorGMLMap.setFutureFeature(duality.getId(), duality);
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

	public void resetDuality() {
		this.duality = null;
		
	}

	public void resetParent() {
		this.parentId = null;
		
	}
	
	public void resetCellSpace() {
		this.cellSpaceForPartialBoundedBy = null;
	}
	
	public void setCellSpace(CellSpace c) {
		this.cellSpaceForPartialBoundedBy = c.getId();
	}
	public void setCellSpace(GeneralSpace c) {
		this.cellSpaceForPartialBoundedBy = c.getId();
	}
	
	public CellSpace getCellSpace() {
		CellSpace found = null;
		found = (CellSpace)indoorGMLMap.getFeature(this.cellSpaceForPartialBoundedBy);
		return found;
	}
}

