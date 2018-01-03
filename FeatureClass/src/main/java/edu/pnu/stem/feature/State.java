package edu.pnu.stem.feature;

import java.util.ArrayList;
import java.util.List;

import net.opengis.gml.v_3_2_1.PointPropertyType;

/**
 * @author jungh
 *
 */
public class State extends AbstractFeature {
	String duality;
	/**
	 * value of Transition feature which has this feature as boundary
	 */
	List<String> connects = new ArrayList<String>();

	String externalReference;
	/**
	 * geometry of this feature
	 */
	PointPropertyType geometry;

	public void setExternalReference(String e) {
		this.externalReference = e;
	}

	public String getExternalReference() {
		return this.externalReference;
	}

	public String parentID;

	public void setParentID(String id) {
		this.parentID = id;
	}

	public String getParentID() {
		return new String(this.parentID);
	}

	public PointPropertyType getGeometry() {
		return this.geometry;
	}

	public void setGeometry(PointPropertyType g) {
		this.geometry = g;
	}

	public String getDuality() {
		return new String(this.duality);
	}

	public void setDuality(String d) {
		this.duality = d;
	}

	public void setConnects(List<String> connects) {
		for (int i = 0; i < connects.size(); i++) {
			this.connects.add(connects.get(i));
		}
	}

	public List<String> getConnects() {
		return new ArrayList<String>(this.connects);
	}

	public List<Object> getConnectsInstance() {
		List<Object> feature = new ArrayList<Object>();
		for (int i = 0; i < connects.size(); i++) {
			feature.add(IndoorGMLMap.getFeature(IndoorGMLMap.getFeatureContainer("State"), this.connects.get(i)));
		}
		return feature;

	}
}
