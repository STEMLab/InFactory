import net.opengis.gml.v_3_2_1.AbstractGeometryType;

/**
 * @author jungh
 *	Implements CellSpaceBoundaryGeometryType of IndoorGML 1.0.3
 */
public class CellSpaceBoundaryGeometry {
	/**
	 * ID of this feature
	 */
	String ID;
	/**
	 * Name of this feature
	 */
	String name;
	/**
	 * save geometry of feature 
	 */
	AbstractGeometryType geometry;
	/**
	 * save geometry type of feature. 
	 * value can be set as "2D" or "3D"
	 */
	String geometryType;
}
