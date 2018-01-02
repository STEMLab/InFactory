package edu.pnu.stem.feature;
import java.util.List;

/**
 * @author jungh
 * Implements CellSpaceType of IndoorGML 1.0.3
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
	public CellSpaceGeometry cellSpaceGeometry;
	
	/**
	 * temporal attribute for IndoorGML 1.0.1.
	 * for compatibility, Write the geometry type as String. Later this will be discarded or changed
	 */
	public String geometryType;
	/**
	 * temporal attribute for IndoorGML 1.0.1. 
	 */
	public Object cellSpaceGeometryObject;
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
	public ExternalReference externalReference;
	
	public String getID(){ return this.ID; }
	public void setID(String id){ this.ID = id;} 
	
	public CellSpaceGeometry getCellSpaceGeometry(){return this.cellSpaceGeometry;}
	public void setCellSpaceGeometry(CellSpaceGeometry csg){ this.cellSpaceGeometry = csg; }
	
	public List<String> getPartialboundedBy(){ return this.partialboundedBy;}
	public void setPartialboundedBy(List<String >pbB){ this.partialboundedBy = pbB; }
	
	public String getDuality(){return this.duality;}
	public void setDuality(String d){this.duality = d;}

	public String getName(){return this.name;}
	public void setName(String name){this.name = name;}
	
	public ExternalReference getExternalReference(){return this.externalReference;}
	public void setExternalReference(ExternalReference e){this.externalReference = e;}
	
	public boolean hasDuality(){
		if(this.duality == null ){
			return false;
		}
		else
			return true;
	}
}
