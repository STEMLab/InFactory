
import net.opengis.gml.v_3_2_1.EnvelopeType;

/**
 * @author jungh
 * Implements AbstractFeaturesType of GML 3.2.1
 */
public class AbstractFeatures {
	/**
	 * ID of this feature
	 */
	String ID;
	/**
	 * Name of this feature
	 */
	String name;
	/**
	 * value of envelope which wrap this feature
	 */
	EnvelopeType boundedBy;
	// Location location;
	/**
	 * describe this feature
	 */
	String description;

}
