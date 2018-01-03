package edu.pnu.stem.feature;
import java.util.List;

/**
 * @author jungh
 *	Implements PrimalSpaceFeaturesType of IndoorGML 1.0.3
 */
public class PrimalSpaceFeatures extends AbstractFeature{
	/**
	 * List of CellSpaces which this feature contains
	 */
	List<String>cellSpaceMember;
	
	/**
	 * List of CellSpaceBoundary which this feature contains
	 */
	List<String>cellSpaceBoundaryMember;

	String parentID;
	
	public void setParentID(String id){this.parentID = id;}
	public String getParentID(){return this.parentID;}

	/**
	 * @return the cellSpaceMember
	 */
	public List<String> getCellSpaceMember() {
		return cellSpaceMember;
	}
	/**
	 * @param cellSpaceMember the cellSpaceMember to set
	 */
	public void setCellSpaceMember(List<String> cellSpaceMember) {
		this.cellSpaceMember = cellSpaceMember;
	}
	/**
	 * @return the cellSpaceBoundaryMember
	 */
	public List<String> getCellSpaceBoundaryMember() {
		return cellSpaceBoundaryMember;
	}
	/**
	 * @param cellSpaceBoundaryMember the cellSpaceBoundaryMember to set
	 */
	public void setCellSpaceBoundaryMember(List<String> cellSpaceBoundaryMember) {
		this.cellSpaceBoundaryMember = cellSpaceBoundaryMember;
	}
}
