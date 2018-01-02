package FeatureClass;
import java.util.List;

/**
 * @author jungh
 *	Implements PrimalSpaceFeaturesType of IndoorGML 1.0.3
 */
public class PrimalSpaceFeatures {
	/**
	 * ID of this feature
	 */
	public String ID;
	/**
	 * Name of this feature
	 */
	public String name;
	/**
	 * List of CellSpaces which this feature contains
	 */
	public List<CellSpace>cellSpaceMember;
	
	/**
	 * List of CellSpaceBoundary which this feature contains
	 */
	public List<CellSpaceBoundary>cellSpaceBoundaryMember;

}
