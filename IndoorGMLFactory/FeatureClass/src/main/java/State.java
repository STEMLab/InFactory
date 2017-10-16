import net.opengis.gml.v_3_2_1.PointType;

/**
 * @author jungh
 *
 */
public class State {
	/**
	 * ID of this feature
	 */
	String ID;
	/**
	 * Name of this feature
	 */
	String name;
	/**
	 * value of CellSpace feature which has duality relationship with this feature
	 */
	CellSpace duality;
	/**
	 * value of Transition feature which has this feature as boundary
	 */
	Transition connects;
	/**
	 * geometry of this feature
	 */
	PointType geometry;

}
