package FeatureClass;
/**
 * @author jungh
 *	Implements InteraLayerConnectionType of IndoorGML 1.0.3
 */
public class InterLayerConnection {
	/**
	 * ID of this feature
	 */
	public String ID;
	/**
	 * Name of this feature
	 */
	public String name;
	/**
	 * save the topology type value
	 */
	public typeOfTopoExpressionCode typeOfTopoExpression;
	/**
	 * describe characteristic of this instance
	 */
	public String comment;
	/**
	 * save list of ID of States which are related with each others as this InterLayerConnection
	 */
	public State[] interConnects;
	/**
	 * save list of ID of SpaceLayers which are related with each others as this InterLayerConnection
	 */
	public SpaceLayer[] connectedLayers;
	
	public Boolean checkInterConnectsNumber(){
		//Boolean flag = false;
		if(this.interConnects.length != 2 || this.connectedLayers.length != 2){
			return false;			
		}
		return true; 
					
	}

}
