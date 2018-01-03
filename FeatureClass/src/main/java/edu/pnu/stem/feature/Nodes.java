package edu.pnu.stem.feature;

import java.util.ArrayList;
import java.util.List;

public class Nodes extends AbstractFeature{
	/**
	 * State list which this feature contains
	 */
	public List<String> stateMember;

	public String parentID;

	public void setParentID(String id) {
		this.parentID = id;
	}

	public String getParentID() {
		return new String(this.parentID);
	}

	public void setStateMember(List<String> sm) {
		this.stateMember = sm;
	}

	public List<String> getStateMember() {
		return new ArrayList<String>(this.stateMember);
	}

}
