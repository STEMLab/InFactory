import java.util.Date;

public class SpaceLayer {
	/**
	 * ID of this feature
	 */
	String ID;
	/**
	 * Name of this feature
	 */
	String name;
	/**
	 * description of usage of the feature
	 */
	String usage;
	/**
	 * functionality of the feature
	 */
	String function;
	/**
	 * time stamp when the SpaceLayer is created
	 */
	Date createDate;
	/**
	 * time stamp when the SpaceLayer is expired
	 */
	Date terminationDate;
	/**
	 * Nodes which the SpaceLayer contains
	 */
	Nodes nodes;
	/**
	 * Edges which the SpaceLayer contains
	 */
	Edges edges;
	/**
	 * represent Class type of the SpaceLayer
	 */
	SpaceLayerClassType classType;
}
