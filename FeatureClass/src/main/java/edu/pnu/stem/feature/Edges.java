package edu.pnu.stem.feature;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jungh Implements EdgesType of IndoorGML 1.0.3
 */
public class Edges {
	/**
	 * ID of this feature
	 */
	public String ID;
	/**
	 * Name of this feature
	 */
	public String name;
	/**
	 * contains list of Transitions as list
	 */
	public List<String> transitionMember;

	public String parentID;

	public void setParentID(String id) {
		this.parentID = id;
	}

	public String getParentID() {
		return this.parentID;
	}

	public List<String> getTransitionMembers() {
		return new ArrayList<String>(transitionMember);
	}

	public void setId(String id) {
		this.ID = id;
	}

	public void setTransitionMembers(List<String> members) {
		this.transitionMember = members;
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
	 * @return the transitionMember
	 */
	public List<String> getTransitionMember() {
		return transitionMember;
	}

	/**
	 * @param transitionMember the transitionMember to set
	 */
	public void setTransitionMember(List<String> transitionMember) {
		this.transitionMember = transitionMember;
	}

	/**
	 * @return the iD
	 */
	public String getId() {
		return ID;
	}

}
