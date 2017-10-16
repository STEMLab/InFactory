

/**
 * @author jungh
 *	Implements CellSpaceBoundaryType of IndoorGML 1.0.3
 */
public class CellSpaceBoundary {
	/**
	 * ID of this feature
	 */
	String ID;
	/**
	 * Name of this feature
	 */
	String name;
	/**
	 * value of Transition which has duality relationship with this CellSpaceBoundary
	 */
	Transition duality;
	/**
	 * value of CellSpaceBoundaryGeometry of the feature
	 */
	CellSpaceBoundaryGeometry cellSpaceBoundaryGeometry;
	/**
	 * If External Reference of the feature is exist, then set this.
	 */
	ExternalReference externalReference;

}
