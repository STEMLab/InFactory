package edu.pnu.stem.feature;

import java.util.ArrayList;
import java.util.List;

import edu.pnu.stem.binder.IndoorGMLMap;
import net.opengis.gml.v_3_2_1.PointPropertyType;

/**
 * @author jungh
 *
 */
public class State extends AbstractFeature {
	
	private String duality;
	/**
	 * value of Transition feature which has this feature as boundary
	 */
	private List<String> connects;

	private String externalReference;
	/**
	 * geometry of this feature
	 */
	private PointPropertyType geometry;
	
	private IndoorGMLMap indoorGMLMap;
	
	public State(IndoorGMLMap doc){
		indoorGMLMap = doc;
		connects = new ArrayList<String>();
	}
	
	public void setExternalReference(String e) {
		this.externalReference = e;
	}

	public String getExternalReference() {
		return this.externalReference;
	}

	public String parentId;

	public void setParent(Nodes parent) {
		Nodes found = null;
		found = (Nodes)indoorGMLMap.getFeature(indoorGMLMap.getFeatureContainer("Nodes"), parent.getId());
		if(found == null){
			indoorGMLMap.setFeature(parent.getId(), "Nodes", parent);
		}		
		this.parentId = parent.getId();
	}

	public Nodes getParentID() {
		Nodes found = (Nodes)indoorGMLMap.getFeature(indoorGMLMap.getFeatureContainer("Nodes"), this.parentId);
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
		found = (CellSpace)indoorGMLMap.getFeature(indoorGMLMap.getFeatureContainer("CellSpace"), this.duality);
		return found;
	}

	public void setDuality(CellSpace duality) {
		CellSpace found = null;
		found = (CellSpace)indoorGMLMap.getFeature(indoorGMLMap.getFeatureContainer("CellSpace"), duality.getId());
		if(found == null){
			indoorGMLMap.setFeature(duality.getId(), "CellSpace", duality);
		}
		this.duality = duality.getId();
	}

	public void setConnects(List<Transition> connects) {
		for (int i = 0; i < connects.size(); i++) {
			Transition found = null;
			found = (Transition)indoorGMLMap.getFeature(indoorGMLMap.getFeatureContainer("Transition"), connects.get(i).getId());
			if(found == null){
				indoorGMLMap.setFeature(connects.get(i).getId(), "Transition", connects.get(i));
			}
			if(!this.connects.contains(connects.get(i).getId())){
				this.connects.add(connects.get(i).getId());
			}
		}
	}

	public List<Transition> getConnects() {
		List<Transition> connects = null;
		if(this.connects.size() != 0){
			connects = new ArrayList<Transition>();
			for(int i = 0 ; i < this.connects.size() ; i++){
				Transition found = (Transition)indoorGMLMap.getFeature(indoorGMLMap.getFeatureContainer("Transition"), this.connects.get(i));
				connects.add(found);
			}
		}
		return connects;
	}


}
