import java.util.List;

import net.opengis.indoorgml.core.v_1_0.InterLayerConnectionType;

/**
 * @author jungh
 *	Implements InterEdgesType of IndoorGML 1.0.3
 */
public class InterEdges {
	/**
	 * ID of this feature
	 */
	public String ID;
	/**
	 * Name of this feature
	 */
	public String name;
	/**
	 * hold list of InterLayerConnections 
	 */
	public List<InterLayerConnectionType> interLayerConnectionMember; 

}
