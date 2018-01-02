package FeatureClassReference;
/**
 * @author jungh
 *	Implements ExternalReferenceType of IndoorGML 1.0.3
 */
public class ExternalReference {
	/**
	 * ID of this feature
	 */
	public String ID;
	/**
	 * Name of this feature
	 */
	public String name;
	/**
	 * describe information of this ExternalRefence
	 */
	public String informationSystem;
	/**
	 * instance of External Reference
	 */
	public ExternalObjectReference externalObject;
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
	 * @return the informationSystem
	 */
	public String getInformationSystem() {
		return informationSystem;
	}
	/**
	 * @param informationSystem the informationSystem to set
	 */
	public void setInformationSystem(String informationSystem) {
		this.informationSystem = informationSystem;
	}
	/**
	 * @return the externalObject
	 */
	public ExternalObjectReference getExternalObject() {
		return externalObject;
	}
	/**
	 * @param externalObject the externalObject to set
	 */
	public void setExternalObject(ExternalObjectReference externalObject) {
		this.externalObject = externalObject;
	}

}
