package edu.pnu.stem.feature.core;

import java.io.Serializable;

import com.vividsolutions.jts.geom.Envelope;

import edu.pnu.stem.binder.IndoorGMLMap;

/**
 * @author jungh
 * Implements AbstractFeaturesType of GML 3.2.1
 */
public abstract class AbstractFeature implements Serializable{
	
	protected IndoorGMLMap indoorGMLMap;
	
	/**
	 * ID of this feature
	 */
	protected String id;
	
	/**
	 * Name of this feature
	 */
	protected String name;
	
	/**
	 * value of envelope which wrap this feature
	 */
	protected boolean boundedBy;
	
	/**
	 * describe this feature
	 */
	protected String description;
	
	public String getDocId() {
		return this.indoorGMLMap.getDocId();
	}
	
	public AbstractFeature(IndoorGMLMap map, String id){
		this.indoorGMLMap = map;
		this.id = id;
	}
	
	public String getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Envelope getBoundedBy() {
		Envelope feature = null;
		if(boundedBy) {
			feature = (Envelope) indoorGMLMap.getFeature(this.id);
		} else {
			feature = new Envelope();
		}
		return feature;
	}
	
	/*
	public void setBoundedBy(Envelope env) {
		Envelope found = (Envelope) indoorGMLMap.getFeature(this.id);
		if(found == null) {
			indoorGMLMap.setFeature(this.id, "Envelope", env);
		}
		
		if(!env.isNull()) {
			this.boundedBy = true;
		}
	}
	*/
	
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
