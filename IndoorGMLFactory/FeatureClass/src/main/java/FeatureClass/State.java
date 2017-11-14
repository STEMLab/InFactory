package FeatureClass;
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
	
	/**
	 * geometry of this feature
	 */
	public PointPropertyType geometry;

}
