package edu.pnu.stem.reference;
import java.util.List;

/**
 * @author jungh
 * Implements MultiLayeredGraphType of IndoorGML 1.0.3
 */
public class MultiLayeredGraph {
	/**
	 * ID of this feature
	 */
	public String ID;
	/**
	 * Name of this feature
	 */
	public String name;
	/**
	 * list of the SpaceLayers which are related with in this MultiLayeredGraph
	 */
	public List<String> spaceLayers;
	/**
	 * InterEdges which is between SpaceLayeres
	 */
	public List<String> interEdges;
	
	public String parentID;

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
	 * @return the spaceLayers
	 */
	public List<String> getSpaceLayers() {
		return spaceLayers;
	}

	/**
	 * @param spaceLayers the spaceLayers to set
	 */
	public void setSpaceLayers(List<String> spaceLayers) {
		this.spaceLayers = spaceLayers;
	}

	/**
	 * @return the interEdges
	 */
	public List<String> getInterEdges() {
		return interEdges;
	}

	/**
	 * @param interEdges the interEdges to set
	 */
	public void setInterEdges(List<String> interEdges) {
		this.interEdges = interEdges;
	}

	/**
	 * @return the parentID
	 */
	public String getParentID() {
		return parentID;
	}

	/**
	 * @param parentID the parentID to set
	 */
	public void setParentID(String parentID) {
		this.parentID = parentID;
	}
}
