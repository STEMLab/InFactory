package edu.pnu.stem.feature;

/**
 * @author jungh Implements CellSpaceBoundaryType of IndoorGML 1.0.3
 */
public class CellSpaceBoundary extends AbstractFeature {

	/**
	 * value of Transition which has duality relationship with this
	 * CellSpaceBoundary
	 */
	public String duality;

	/**
	 * If External Reference of the feature is exist, then set this.
	 */
	public String externalReference;

	/**
	 * ID of parent feature instance
	 */
	public String parentID;
	public String cellSpaceBoundaryGeometry;

	public void setParentID(String id) {
		this.parentID = id;
	}

	public String getParentID() {
		return new String(this.parentID);
	}

	public Object getParentInstance() {
		Object feature = null;
		feature = IndoorGMLMap.getFeature(IndoorGMLMap.getFeatureContainer("PrimalSpaceFeatures"), this.parentID);
		return feature;
	}

	public String getDuality() {
		return new String(this.duality);
	}

	public Object getDualityInstance() {
		return IndoorGMLMap.getFeature(IndoorGMLMap.getFeatureContainer("Transition"), this.duality);
	}

	public void setDuality(String d) {
		this.duality = d;
	}

	public String getExternalReference() {
		return new String(this.externalReference);
	}

	public void setExternalReference(String e) {
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
