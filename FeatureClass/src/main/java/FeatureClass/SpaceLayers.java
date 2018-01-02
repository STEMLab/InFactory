package FeatureClass;

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
	public List<SpaceLayer> spaceLayerMemeber;
}
