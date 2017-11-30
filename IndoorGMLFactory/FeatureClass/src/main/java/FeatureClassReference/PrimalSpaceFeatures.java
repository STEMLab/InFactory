package FeatureClassReference;
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

	public String parentID;
	
	public void setParentID(String id){this.parentID = id;}
	public String getParentID(){return this.parentID;}
}
