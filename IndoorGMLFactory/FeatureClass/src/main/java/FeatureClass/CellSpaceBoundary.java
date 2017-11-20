package FeatureClass;

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
	 * value of CellSpaceBoundaryGeometry of the feature
	 */
	public Object cellSpaceBoundaryGeometry;
	/**
	 * If External Reference of the feature is exist, then set this.
	 */
	public ExternalReference externalReference;
	
	public String getID(){ return this.ID; }
	public void setID(String id){ this.ID = id;} 
	
	public Object getCellSpaceBoundaryGeometry(){return this.cellSpaceBoundaryGeometry;}
	public void setCellSpaceGeometry(CellSpaceGeometry csg){ this.cellSpaceBoundaryGeometry = csg; }
	
	public String getDuality(){return this.duality;}
	public void setDuality(String d){this.duality = d;}

	public String getName(){return this.name;}
	public void setName(String name){this.name = name;}
	
	public ExternalReference getExternalReference(){return this.externalReference;}
	public void setExternalReference(ExternalReference e){this.externalReference = e;}

}
