
/**
 * @author jungh
 * Implements CellSpaceType of IndoorGML 1.0.3
 */
public class CellSpace {
	/**
	 * ID of this feature
	 */
	String ID;
	/**
	 * Name of this feature
	 */
	String name;
	/**
	 * value of geometry of feature
	 */
	CellSpaceGeometry cellSpaceGeometry;
	/**
	 * boundary of the CellSpace
	 */
	CellSpaceBoundary partialboundedBy;
	/**
	 * value of State which has duality relationship with the CellSpace
	 */
	State duality;
	/**
	 * If External Reference of the feature is exist, then set this.
	 */
	ExternalReference externalReference;

}
