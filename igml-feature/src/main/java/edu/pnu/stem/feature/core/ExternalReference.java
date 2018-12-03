package edu.pnu.stem.feature.core;
/**
 * @author jungh
 *	Implements ExternalReferenceType of IndoorGML 1.0.3
 */
public class ExternalReference {

	public String informationSystem;
	/**
	 * instance of External Reference
	 */
	public ExternalObjectReference externalObject;

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
