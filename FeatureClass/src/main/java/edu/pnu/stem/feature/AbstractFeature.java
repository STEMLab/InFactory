package edu.pnu.stem.feature;

import org.locationtech.jts.geom.Envelope;
import edu.pnu.stem.binder.IndoorGMLMap;

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
	
	boolean boundedBy;
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
	public Envelope getBoundedBy() {
		Envelope feature = null;
		if(boundedBy) {
			feature = (Envelope) indoorGMLMap.getFeature(indoorGMLMap.getFeatureContainer("Envelope"), this.id);
		} else {
			feature = new Envelope();
		}
		return feature;
	}
	
	public void setBoundedBy(Envelope env) {
		Envelope found = (Envelope) indoorGMLMap.getFeature(indoorGMLMap.getFeatureContainer("Envelope"), this.id);
		if(found == null) {
			indoorGMLMap.setFeature(this.id, "Envelope", env);
		}
		
		if(!env.isNull()) {
			this.boundedBy = true;
		}
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
