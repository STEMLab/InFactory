package edu.pnu.stem.feature;

import org.locationtech.jts.geom.Geometry;

import edu.pnu.stem.binder.IndoorGMLMap;
import edu.pnu.stem.util.GeometryUtil;

/**
 * @author jungh
 * Implements AbstractFeaturesType of GML 3.2.1
 */
public class AbstractFeature {
	
	IndoorGMLMap indoorGMLMap;
	/**
	 * ID of this feature
	 */
	String id;
	/**
	 * Name of this feature
	 */
	String name;
	/**
	 * value of envelope which wrap this feature
	 */
	String boundedBy;
	// Location location;
	/**
	 * describe this feature
	 */
	String description;
	/**
	 * @return the iD
	 */
	
	public AbstractFeature(IndoorGMLMap map){
		this.indoorGMLMap = map;
	}
	
	public AbstractFeature(){
		
	}
	
	public String getId() {
		return id;
	}
	/**
	 * @param iD the iD to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	public Geometry getBoundedBy() {
		Geometry feature = null;
		feature = (Geometry) indoorGMLMap.getFeature(indoorGMLMap.getFeatureContainer("Geometry"), this.geometry);
		return feature;
	}
	
	public void setBoundedBy(Geometry geom) {
		String gId = GeometryUtil.getMetadata(geom, "id");
		Geometry found = (Geometry) indoorGMLMap.getFeature(indoorGMLMap.getFeatureContainer("Geometry"), gId);
		if(found == null) {
			indoorGMLMap.setFeature(gId, "Geometry", geom);
		}
		this.geometry = gId;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;

	}

}
