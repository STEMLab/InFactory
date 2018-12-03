package edu.pnu.stem.feature.core;


/**
 * @author jungh
 *	Implements ExternalObjectReferenceType of IndoorGML 1.0.3
 */
public class ExternalObjectReference {

	private String name;
	/**
	 * Save uri of External Object Reference
	 */
	private String uri;

	/**
	 * @return the name
	 */
	private String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	private void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the uri
	 */
	public String getUri() {
		return uri;
	}
	/**
	 * @param uri the uri to set
	 */
	public void setUri(String uri) {
		this.uri = uri;
	}

}
