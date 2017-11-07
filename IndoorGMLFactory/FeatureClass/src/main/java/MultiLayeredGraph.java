import java.util.List;

/**
 * @author jungh
 * Implements MultiLayeredGraphType of IndoorGML 1.0.3
 */
public class MultiLayeredGraph {
	/**
	 * ID of this feature
	 */
	public String ID;
	/**
	 * Name of this feature
	 */
	public String name;
	/**
	 * list of the SpaceLayers which are related with in this MultiLayeredGraph
	 */
	public List<SpaceLayer> spaceLayers;
	/**
	 * InterEdges which is between SpaceLayeres
	 */
	public List<InterEdges> interEdges;

}
