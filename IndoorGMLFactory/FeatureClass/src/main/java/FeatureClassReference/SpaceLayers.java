package FeatureClassReference;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jungh
 *	Implements SpaceLayersType of IndoorGML 1.0.3
 */
public class SpaceLayers {
	/**
	 * ID of feature
	 */
	public String ID;
	
	/**
	 * name of feature
	 */
	String name;
	
	/**
	 * List of ID in String Type of SpaceLayers in spaceLayerMember for reference
	 */
	public List<String> spaceLayerMemeber;
	public String parentID;
	
	public void setParentID(String id){this.parentID = id;}
	public String getParentID(){return this.parentID;}
	
	public Object getParentObject(){
		Object feature = null;
		feature = IndoorGMLMap.getFeature(IndoorGMLMap.getFeatureContainer("MultiLayeredGraph"), this.parentID);
		return feature;
	}
	public void setSpaceLayerMember(List<String>spaceLayerMember){
		this.spaceLayerMemeber = spaceLayerMember;
	}
	public List<String> getSpaceLayerMember(){ return this.spaceLayerMemeber;}
	public List<Object> getSpaceLayerMemberInstance(){
		List<Object>feature = new ArrayList<Object>();
		for(int i = 0 ; i < this.spaceLayerMemeber.size(); i++){
			feature.add(IndoorGMLMap.getFeature(IndoorGMLMap.getFeatureContainer("MultiLayeredGraph"), this.spaceLayerMemeber.get(i)));
		}
		return feature;
	}
}
