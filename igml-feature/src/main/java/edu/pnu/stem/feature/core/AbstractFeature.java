package edu.pnu.stem.feature.core;

import java.io.Serializable;

import edu.pnu.stem.binder.IndoorGMLMap;
import net.opengis.gml.v_3_2_1.BoundingShapeType;

/**
 * @author jungh Implements AbstractFeaturesType of GML 3.2.1
 */
public abstract class AbstractFeature implements Serializable {

	protected IndoorGMLMap indoorGMLMap;

	/**
	 * ID of this feature
	 */
	protected String id;

	/**
	 * Name of this feature
	 */
	protected String name;

	/**
	 * value of envelope which wrap this feature
	 */
	protected String boundedBy;
	// protected BoundingShapeType boundedBy;
	/**
	 * describe this feature
	 */
	protected String description;

	public String getDocId() {
		return this.indoorGMLMap.getDocId();
	}

	public AbstractFeature(IndoorGMLMap map, String id) {
		this.indoorGMLMap = map;
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Envelope getBoundedBy() {
		Envelope found = null;
		if (this.boundedBy != null) {
			found = (Envelope) indoorGMLMap.getFeature(this.boundedBy);
			if (found == null)
				found = (Envelope) indoorGMLMap.getFutureFeature(this.boundedBy);
		}
		return found;
	}

	public void setBoundedBy(Envelope env) {

		Envelope found = null;

		found = (Envelope) indoorGMLMap.getFeature(env.getId());

		if (found == null) {
			indoorGMLMap.setFutureFeature(env.getId(), env);
		}

		this.boundedBy = env.getId();
	}	

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		this.description = description;

	}

}
