package FeatureClass;
import net.opengis.gml.v_3_2_1.CurveType;

/**
 * @author jungh
 *	Implements TransitionType of IndoorGML 1.0.3 
 */
public class Transition {
	/**
	 * ID of this feature
	 */
	public String ID;
	/**
	 * Name of this feature
	 */
	public String name;
	/**
	 * geometry of transition
	 */
	public CurveType geometry;
	/**
	 * value of CellSpaceBoundary feature which has duality relationship with this feature
	 */
	public String duality;
	/**
	 * value of weight which usally is used for transfering cost in road network, etc.
	 */
	public double weight;
	
	/**
	 * Array of connected States. minimum and maximum of the number of element needs to be 2
	 */
	public String[] connects = new String[2];
	
	public String getID(){ return this.ID; }
	public void setID(String id){ this.ID = id;} 
	
	public Object getCellSpaceBoundaryGeometry(){return this.cellSpaceBoundaryGeometry;}
	public void setCellSpaceGeometry(CellSpaceGeometry csg){ this.cellSpaceBoundaryGeometry = csg; }
	
	public String getDuality(){return this.duality;}
	public void setDuality(String d){this.duality = d;}

	public String getName(){return this.name;}
	public void setName(String name){this.name = name;}

}
