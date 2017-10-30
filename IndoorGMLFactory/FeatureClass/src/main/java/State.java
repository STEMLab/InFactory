import java.util.List;

import net.opengis.gml.v_3_2_1.PointPropertyType;
import net.opengis.indoorgml.core.v_1_0.CellSpacePropertyType;
import net.opengis.indoorgml.core.v_1_0.TransitionPropertyType;

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
	public CellSpacePropertyType duality;
	/**
	 * value of Transition feature which has this feature as boundary
	 */
	public List<TransitionPropertyType> connects;
	/**
	 * geometry of this feature
	 */
	public PointPropertyType geometry;

}
