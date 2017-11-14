package FeatureClass;
/**
 * @author jungh
 *	Implements CellSpaceBoundaryType of IndoorGML 1.0.3
 */
public class CellSpaceBoundary {
	/**
	 * ID of this feature
	 */
	public String ID;
	/**
	 * Name of this feature
	 */
	public String name;
	/**
	 * value of Transition which has duality relationship with this CellSpaceBoundary
	 */
	public String duality;
	/**
	 * value of CellSpaceBoundaryGeometry of the feature
	 */
	public Object cellSpaceBoundaryGeometry;
	/**
	 * If External Reference of the feature is exist, then set this.
	 */
	public ExternalReference externalReference;

}
