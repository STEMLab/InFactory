package edu.pnu.stem.reference;

import net.opengis.gml.v_3_2_1.BoundingShapeType;

/**
 * @author jungh
 * Implements AbstractFeaturesType of GML 3.2.1
 */
public class AbstractFeatures {
	
	/**
	 * ID of this feature
	 */
	public String ID;
	/**
	 * Name of this feature
	 */
	public String name;
	/**
	 * value of envelope which wrap this feature
	 */
	public BoundingShapeType boundedBy;
	// Location location;
	/**
	 * describe this feature
	 */
	public String description;
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
	public BoundingShapeType getBoundedBy() {
		return boundedBy;
	}
	/**
	 * @param boundedBy the boundedBy to set
	 */
	public void setBoundedBy(BoundingShapeType boundedBy) {
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
