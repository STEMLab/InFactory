package FeatureClassReference;

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

}
