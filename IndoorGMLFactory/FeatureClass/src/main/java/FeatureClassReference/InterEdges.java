package FeatureClassReference;
import java.util.List;

/**
 * @author jungh
 *	Implements InterEdgesType of IndoorGML 1.0.3
 */
public class InterEdges {
	/**
	 * ID of this feature
	 */
	public String ID;
	/**
	 * Name of this feature
	 */
	public String name;
	/**
	 * hold list of InterLayerConnections 
	 */
	public List<String> interLayerConnectionMember; 
	
	public String parentID;
	
	public void setParetID(String pi){this.parentID = pi;}
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
	 * @return the interLayerConnectionMember
	 */
	public List<String> getInterLayerConnectionMember() {
		return interLayerConnectionMember;
	}
	/**
	 * @param interLayerConnectionMember the interLayerConnectionMember to set
	 */
	public void setInterLayerConnectionMember(List<String> interLayerConnectionMember) {
		this.interLayerConnectionMember = interLayerConnectionMember;
	}
	/**
	 * @param parentID the parentID to set
	 */
	public void setParentID(String parentID) {
		this.parentID = parentID;
	}
}

