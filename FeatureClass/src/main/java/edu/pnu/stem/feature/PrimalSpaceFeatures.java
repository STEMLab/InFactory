package edu.pnu.stem.feature;
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
	public List<String>cellSpaceMember;
	
	/**
	 * List of CellSpaceBoundary which this feature contains
	 */
	public List<String>cellSpaceBoundaryMember;

	public String parentID;
	
	public void setParentID(String id){this.parentID = id;}
	public String getParentID(){return this.parentID;}
	/**
	 * @return the iD
	 */
	public String getID() {
		return ID;
	}
	/**
	 * @param iD the iD to set
	 */
	public void setID(String iD) {
		ID = iD;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
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
