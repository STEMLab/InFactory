import java.util.List;

/**
 * @author jungh
 *	Implements InterEdgesType of IndoorGML 1.0.3
 */
public class InterEdges {
	/**
	 * ID of this feature
	 */
	String ID;
	/**
	 * Name of this feature
	 */
	String name;
	/**
	 * hold list of InterLayerConnections 
	 */
	List<InterLayerConnection> interLayerConnectionMember; 

}
