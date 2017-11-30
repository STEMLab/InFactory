package FeatureClassReference;
import java.util.List;

public class Nodes {
	/**
	 * ID of this feature
	 */
	public String ID;
	/**
	 * Name of this feature
	 */
	public String name;
	
	/**
	 * State list which this feature contains 
	 */
	public List<String> stateMember;
	
	public String parentID;
	
	public void setParentID(String id){this.parentID = id;}
	public String getParentID(){return this.parentID;}
	
	public void setStateMember(List<String> sm){ this.stateMember = sm;}
	public List<String> getStateMember(){return this.stateMember;}
	
	

}
