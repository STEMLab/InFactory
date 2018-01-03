package edu.pnu.stem.feature;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jungh Implements MultiLayeredGraphType of IndoorGML 1.0.3
 */
public class MultiLayeredGraph extends AbstractFeature {

	/**
	 * list of the SpaceLayers which are related with in this MultiLayeredGraph
	 */
	List<String> spaceLayers;
	/**
	 * InterEdges which is between SpaceLayeres
	 */
	List<String> interEdges;

	String parentID;

	/**
	 * @return the spaceLayers
	 */
	public List<String> getSpaceLayers() {
		return new ArrayList<String>(spaceLayers);
	}

	/**
	 * @param spaceLayers
	 *            the spaceLayers to set
	 */
	public void setSpaceLayers(List<String> spaceLayers) {
		this.spaceLayers = spaceLayers;
	}

	/**
	 * @return the interEdges
	 */
	public List<String> getInterEdges() {
		return new ArrayList<String>(interEdges);
	}

	/**
	 * @param interEdges
	 *            the interEdges to set
	 */
	public void setInterEdges(List<String> interEdges) {
		this.interEdges = interEdges;
	}

	/**
	 * @return the parentID
	 */
	public String getParentID() {
		return new String(parentID);
	}

	/**
	 * @param parentID
	 *            the parentID to set
	 */
	public void setParentID(String parentID) {
		this.parentID = parentID;
	}
}
