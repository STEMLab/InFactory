package FeatureClass;
import net.opengis.gml.v_3_2_1.AbstractGeometryType;

/**
 * @author jungh
 *	Implements CellSpaceGeometryType of IndoorGML 1.0.3
 */
public class CellSpaceGeometry {
	/**
	 * ID of this feature
	 */
	public String ID;
	/**
	 * Name of this feature
	 */
	public String name;
	/**
	 * save geometry of feature 
	 */
	public AbstractGeometryType geometry;
	/**
	 * save geometry type of feature. 
	 * value can be set as "2D" or "3D"
	 */
	public String geometryType;
}
