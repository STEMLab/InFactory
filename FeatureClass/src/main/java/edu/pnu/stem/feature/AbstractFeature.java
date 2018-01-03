package edu.pnu.stem.feature;

/**
 * @author jungh
 * Implements AbstractFeaturesType of GML 3.2.1
 */
public class AbstractFeature {
	
	/**
	 * ID of this feature
	 */
	String ID;
	/**
	 * Name of this feature
	 */
	String name;
	/**
	 * reference Id of envelope which wrap this feature
	 */
	String boundedBy;
	/**
	 * reference Id of location
	 */
	String location;
	/**
	 * describe this feature
	 */
	String description;
	/**
	 * @return the iD
	 */
	public String getID() {
		return ID;
	}
	/**
	 * @param iD the iD to set
	 */
	public void setID(String iD) {
		ID = iD;
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
	public String getBoundedBy() {
		return new String(boundedBy);
	}
	/**
	 * @param boundedBy the boundedBy to set
	 */
	public void setBoundedBy(String boundedBy) {
		this.boundedBy = boundedBy;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return new String(description);
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * @return the location
	 */
	public String getLocation() {
		return new String(location);
	}
	/**
	 * @param location the location to set
	 */
	public void setLocation(String location) {
		this.location = location;
	}

}
