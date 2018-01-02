package FeatureClass;
import java.util.ArrayList;
import java.util.List;

import net.opengis.gml.v_3_2_1.PointPropertyType;

/**
 * @author jungh
 *
 */
public class State {
	/**
	 * ID of this feature
	 */
	public String ID;
	/**
	 * Name of this feature
	 */
	public String name;
	/**
	 * value of CellSpace feature which has duality relationship with this feature
	 */
	public String duality;
	/**
	 * value of Transition feature which has this feature as boundary
	 */
	public List<String>connects = new ArrayList<String>();
	
	/**
	 * geometry of this feature
	 */
	public PointPropertyType geometry;
	
	public String getID(){ return this.ID; }
	public void setID(String id){ this.ID = id;} 
	
	public PointPropertyType getGeometry(){return this.geometry;}
	public void setGeometry(PointPropertyType g){ this.geometry = g; }
		
	public String getDuality(){return this.duality;}
	public void setDuality(String d){this.duality = d;}

	public String getName(){return this.name;}
	public void setName(String name){this.name = name;}
	
	public void setConnects(List<String> connects){
		for(int i = 0 ; i < connects.size(); i++){
			this.connects.add(connects.get(i));
		}
	}
	public List<String> getConnects(){ return this.connects;}

}
