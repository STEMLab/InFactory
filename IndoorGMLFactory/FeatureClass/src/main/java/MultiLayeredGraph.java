import java.util.List;

import net.opengis.indoorgml.core.v_1_0.InterEdgesType;
import net.opengis.indoorgml.core.v_1_0.SpaceLayersType;

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
	public List<SpaceLayersType> spaceLayers;
	/**
	 * InterEdges which is between SpaceLayeres
	 */
	public List<InterEdgesType> interEdges;

}
