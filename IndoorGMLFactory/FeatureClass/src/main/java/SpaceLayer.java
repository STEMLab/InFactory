import java.util.Date;

public class SpaceLayer {
	/**
	 * ID of this feature
	 */
	public String ID;
	/**
	 * Name of this feature
	 */
	public String name;
	/**
	 * description of usage of the feature
	 */
	public String usage;
	/**
	 * functionality of the feature
	 */
	public String function;
	/**
	 * time stamp when the SpaceLayer is created
	 */
	public Date createDate;
	/**
	 * time stamp when the SpaceLayer is expired
	 */
	public Date terminationDate;
	/**
	 * Nodes which the SpaceLayer contains
	 */
	public Nodes nodes;
	/**
	 * Edges which the SpaceLayer contains
	 */
	public Edges edges;
	/**
	 * represent Class type of the SpaceLayer
	 */
	public SpaceLayerClassType classType;
}
