package edu.pnu.stem.feature;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jungh Implements InterEdgesType of IndoorGML 1.0.3
 */
public class InterEdges extends AbstractFeature {

	/**
	 * hold list of InterLayerConnections
	 */
	List<String> interLayerConnectionMember;

	String parentID;

	public void setParetID(String pi) {
		this.parentID = pi;
	}

	public String getParentID() {
		return new String(this.parentID);
	}

		/**
	 * @return the interLayerConnectionMember
	 */
	public List<String> getInterLayerConnectionMember() {
		return new ArrayList<String>(interLayerConnectionMember);
	}

	/**
	 * @param interLayerConnectionMember
	 *            the interLayerConnectionMember to set
	 */
	public void setInterLayerConnectionMember(List<String> interLayerConnectionMember) {
		this.interLayerConnectionMember = interLayerConnectionMember;
	}

	/**
	 * @param parentID
	 *            the parentID to set
	 */
	public void setParentID(String parentID) {
		this.parentID = parentID;
	}
}
