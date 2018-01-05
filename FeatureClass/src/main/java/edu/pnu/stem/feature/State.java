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

	public String parentId;

	public void setParent(SpaceLayer parent) {
		SpaceLayer found = null;
		found = (SpaceLayer)IndoorGMLMap.getFeature(IndoorGMLMap.getFeatureContainer("SpaceLayer"), parent.getId());
		if(found == null){
			IndoorGMLMap.setFeature(parent.getId(), "SpaceLayer", parent);
		}		
		this.parentId = parent.getId();
	}

	public SpaceLayer getParentID() {
		SpaceLayer found = (SpaceLayer)IndoorGMLMap.getFeature(IndoorGMLMap.getFeatureContainer("SpaceLayer"), this.parentId);
		return found;
	}

	public PointPropertyType getGeometry() {
		return this.geometry;
	}

	public void setGeometry(PointPropertyType g) {
		this.geometry = g;
	}

	public CellSpace getDuality() {
		CellSpace found = null;
		found = (CellSpace)IndoorGMLMap.getFeature(IndoorGMLMap.getFeatureContainer("CellSpace"), this.duality);
		return found;
	}

	public void setDuality(CellSpace duality) {
		CellSpace found = null;
		found = (CellSpace)IndoorGMLMap.getFeature(IndoorGMLMap.getFeatureContainer("CellSpace"), duality.getId());
		if(found == null){
			IndoorGMLMap.setFeature(duality.getId(), "CellSpace", duality);
		}
		this.duality = duality.getId();
	}

	public void setConnects(List<Transition> connects) {
		for (int i = 0; i < connects.size(); i++) {
			Transition found = null;
			found = (Transition)IndoorGMLMap.getFeature(IndoorGMLMap.getFeatureContainer("Transition"), connects.get(i).getId());
			if(found == null){
				
			} 
		}
	}

	public List<Transition> getConnects() {
		List<Transition> connects = new ArrayList<Transition>();
		for(int i = 0 ; i < this.connects.size() ; i++){
			Transition found = (Transition)IndoorGMLMap.getFeature(IndoorGMLMap.getFeatureContainer("Transition"), this.connects.get(i));
			connects.add(found);
		}
		return connects;
	}


}
