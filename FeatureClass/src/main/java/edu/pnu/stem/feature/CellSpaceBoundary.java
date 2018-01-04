package edu.pnu.stem.feature;

/**
 * @author jungh Implements CellSpaceBoundaryType of IndoorGML 1.0.3
 */
public class CellSpaceBoundary extends AbstractFeature {

	/**
	 * value of Transition which has duality relationship with this
	 * CellSpaceBoundary
	 */
	String duality;

	/**
	 * If External Reference of the feature is exist, then set this.
	 */
	String externalReference;

	/**
	 * ID of parent feature instance
	 */
	String parentId;
	String cellSpaceBoundaryGeometry;

	public boolean hasDuality() {
		if (this.duality == null) {
			return false;
		} else {
			return true;
		}
	}

	public void setParent(PrimalSpaceFeatures parent) {
		this.parentId = parent.getId();
	}


	public PrimalSpaceFeatures getParent() {
		PrimalSpaceFeatures feature = null;
		feature = (PrimalSpaceFeatures) IndoorGMLMap.getFeature(IndoorGMLMap.getFeatureContainer("PrimalSpaceFeatures"),
				this.parentId);
		return feature;
	}

	public Transition getDuality() {
		Transition found = null;
		if (hasDuality()) {
			found = (Transition) IndoorGMLMap.getFeature(IndoorGMLMap.getFeatureContainer("Transition"), this.duality);
		}
		return found;
	}

	public void setDuality(Transition duality) {
		Transition found = null;
		found = (Transition)IndoorGMLMap.getFeature(IndoorGMLMap.getFeatureContainer("Transition"), duality.getId());
		if(found == null){
			IndoorGMLMap.setFeature(duality.getId(), "Transition", duality);
		}
		this.duality = duality.getId();
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
