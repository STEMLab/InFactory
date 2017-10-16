
/**
 * @author jungh
 *	Implements SpaceLayerClassTypeType of IndoorGML 1.0.3
 */
public class SpaceLayerClassType {
	/**
	 * ID of this feature
	 */
	String ID;
	/**
	 * Name of this feature
	 */
	String name;
	/**
	 * @author jungh
	 *	type of SpaceLayerClassTypeType
	 */
	public enum Type{
		 TOPOGRAPHIC,SENSOR,LOGICAL,TAGS, UNKNOWN;
		}

}
