package FeatureClassReference;
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
	
	public String externalReference;
	/**
	 * geometry of this feature
	 */
	public PointPropertyType geometry;
	
	public void setExternalReference(String e){
		this.externalReference = e;
	}
	public String getExternalReference(){
		return this.externalReference;
	}
	public String parentID;
	
	public String getID(){ return this.ID; }
	public void setID(String id){ this.ID = id;} 
	
	public void setParentID(String id){this.parentID = id;}
	public String getParentID(){return this.parentID;}
	
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
	public List<Object> getConnectsInstance(){
		List<Object>feature = new ArrayList<Object>();
		for(int i = 0 ; i < connects.size(); i++){
			feature.add(IndoorGMLMap.getFeature(IndoorGMLMap.getFeatureContainer("State"), this.connects.get(i)));
		}
		return feature;
		
	}
}
