package FeatureClassReference;

/**
 * @author jungh
 *	Implements SpaceLayerClassTypeType of IndoorGML 1.0.3
 */
public class SpaceLayerClassType {
	/**
	 * ID of this feature
	 */
	public String ID;
	/**
	 * Name of this feature
	 */
	public String name;
	/**
	 * @author jungh
	 *	type of SpaceLayerClassTypeType
	 */
	public enum Type{
		 TOPOGRAPHIC,SENSOR,LOGICAL,TAGS, UNKNOWN;
		}
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

}
