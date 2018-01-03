package edu.pnu.stem.feature;

import org.locationtech.jts.geom.Envelope;

/**
 * @author jungh
 * Implements AbstractFeaturesType of GML 3.2.1
 */
public class AbstractFeature {
	
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
	Envelope boundedBy;
	// Location location;
	/**
	 * describe this feature
	 */
	String description;
	/**
	 * @return the iD
	 */
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
	/**
	 * @return the boundedBy
	 */
	public Envelope getBoundedBy() {
		return boundedBy;
	}
	/**
	 * @param boundedBy the boundedBy to set
	 */
	public void setBoundedBy(Envelope boundedBy) {
		this.boundedBy = boundedBy;
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
