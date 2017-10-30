import net.opengis.indoorgml.core.v_1_0.MultiLayeredGraphType;
import net.opengis.indoorgml.core.v_1_0.PrimalSpaceFeaturesType;

/**
 * @author jungh
 *	Implements IndoorFeaturesType of IndoorGML 1.0.3
 */
public class IndoorFeatures {
	/**
	 * ID of this feature
	 */
	public String ID;
	/**
	 * Name of this feature
	 */
	public String name;
	/**
	 * save PriamlSpaceFeatures value
	 */
	public PrimalSpaceFeaturesType primalSpaceFeatures;
	/**
	 * save MultiLayeredGraph value
	 */
	public MultiLayeredGraphType multiLayeredGraph;

}
