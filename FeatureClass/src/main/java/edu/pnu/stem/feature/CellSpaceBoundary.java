package edu.pnu.stem.feature;

/**
 * @author jungh
 *	Implements CellSpaceBoundaryType of IndoorGML 1.0.3
 */
public class CellSpaceBoundary {
	/**
	 * ID of this feature
	 */
	public String ID;
	/**
	 * Name of this feature
	 */
	public String name;
	/**
	 * value of Transition which has duality relationship with this CellSpaceBoundary
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
	
	public String getID(){ return this.ID; }
	public void setID(String id){ this.ID = id;} 
	public void setParentID(String id){this.parentID = id;}
	public String getParentID(){return this.parentID;}
	public Object getParentInstance(){
		Object feature = null;
		feature = IndoorGMLMap.getFeature(IndoorGMLMap.getFeatureContainer("PrimalSpaceFeatures"), this.parentID);
		return feature;
	}
	
	

	public String getDuality(){return this.duality;}
	public Object getDualityInstance(){return IndoorGMLMap.getFeature(IndoorGMLMap.getFeatureContainer("Transition"), this.duality);}
	public void setDuality(String d){this.duality = d;}

	public String getName(){return this.name;}
	public void setName(String name){this.name = name;}
	
	public String getExternalReference(){return this.externalReference;}
	public void setExternalReference(String e){this.externalReference = e;}
	/**
	 * @return the cellSpaceBoundaryGeometry
	 */
	public String getCellSpaceBoundaryGeometry() {
		return cellSpaceBoundaryGeometry;
	}
	/**
	 * @param cellSpaceBoundaryGeometry the cellSpaceBoundaryGeometry to set
	 */
	public void setCellSpaceBoundaryGeometry(String cellSpaceBoundaryGeometry) {
		this.cellSpaceBoundaryGeometry = cellSpaceBoundaryGeometry;
	}

}
