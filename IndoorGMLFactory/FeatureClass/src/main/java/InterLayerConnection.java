

/**
 * @author jungh
 *	Implements InteraLayerConnectionType of IndoorGML 1.0.3
 */
public class InterLayerConnection {
	/**
	 * ID of this feature
	 */
	String ID;
	/**
	 * Name of this feature
	 */
	String name;
	/**
	 * save the topology type value
	 */
	typeOfTopoExpressionCode typeOfTopoExpression;
	/**
	 * describe characteristic of this instance
	 */
	String comment;
	/**
	 * save list of States which are related with each others as this InterLayerConnection
	 */
	State[] interConnects;
	/**
	 * save list of SpaceLayers which are related with each others as this InterLayerConnection
	 */
	SpaceLayer[] connectedLayers;

}
