import net.opengis.gml.v_3_2_1.CurveType;

/**
 * @author jungh
 *	Implements TransitionType of IndoorGML 1.0.3 
 */
public class Transition {
	/**
	 * ID of this feature
	 */
	public String ID;
	/**
	 * Name of this feature
	 */
	public String name;
	/**
	 * geometry of transition
	 */
	public CurveType geometry;
	/**
	 * value of CellSpaceBoundary feature which has duality relationship with this feature
	 */
	public String duality;
	/**
	 * value of weight which usally is used for transfering cost in road network, etc.
	 */
	public double weight;

}
