package edu.pnu.stem.feature;

import java.util.ArrayList;
import java.util.List;

import com.vividsolutions.jts.geom.Geometry;

import edu.pnu.stem.binder.IndoorGMLMap;
import edu.pnu.stem.util.GeometryUtil;

/**
 * @author jungh
 *
 */
public class State extends AbstractFeature {
	
	/**
	 * geometry of this feature
	 */
	private String geometry;
	
	private String duality;
	/**
	 * value of Transition feature which has this feature as boundary
	 */
	private List<String> connects;

	private String externalReference;
	
	public State(IndoorGMLMap doc, String id){
		super(doc, id);
		connects = new ArrayList<String>();
	}
	
	public Geometry getGeometry() {
		Geometry feature = null;
		feature = (Geometry) indoorGMLMap.getFeature4Geometry(this.geometry);
		return feature;
	}
	
	public void setGeometry(Geometry geom) {
		String gId = GeometryUtil.getMetadata(geom, "id");
		Geometry found = (Geometry) indoorGMLMap.getFeature4Geometry(gId);
		if(found == null) {
			indoorGMLMap.setFeature4Geometry(gId, geom);
		}
		this.geometry = gId;
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
		found = (Nodes)indoorGMLMap.getFeature(parent.getId());
		if(found == null){
			indoorGMLMap.setFeature(parent.getId(), "Nodes", parent);
		}		
		this.parentId = parent.getId();
	}

	public Nodes getParentID() {
		Nodes found = (Nodes)indoorGMLMap.getFeature(this.parentId);
		return found;
	}

	public CellSpace getDuality() {
		CellSpace found = null;
		if(this.duality != null) {
			found = (CellSpace)indoorGMLMap.getFeature(this.duality);
		}
		return found;
	}

	public void setDuality(CellSpace duality) {
		CellSpace found = null;
		found = (CellSpace)indoorGMLMap.getFeature(duality.getId());
		if(found == null){
			indoorGMLMap.setFeature(duality.getId(), "CellSpace", duality);
		}
		this.duality = duality.getId();
	}

	public void setConnects(List<Transition> connects) {
		for (int i = 0; i < connects.size(); i++) {
			Transition found = null;
			found = (Transition)indoorGMLMap.getFeature(connects.get(i).getId());
			if(found == null){
				indoorGMLMap.setFeature(connects.get(i).getId(), "Transition", connects.get(i));
			}
			if(!this.connects.contains(connects.get(i).getId())){
				this.connects.add(connects.get(i).getId());
			}
		}
	}
	
	public void addConnects(Transition t) {
		if(!this.connects.contains(t.getId())){
			this.connects.add(t.getId());
			indoorGMLMap.setFeature(t.getId(), "Transition", t);
		}
	}

	public List<Transition> getConnects() {
		List<Transition> connects = null;
		if(this.connects.size() != 0){
			connects = new ArrayList<Transition>();
			for(int i = 0 ; i < this.connects.size() ; i++){
				Transition found = (Transition)indoorGMLMap.getFeature(this.connects.get(i));
				connects.add(found);
			}
		}
		return connects;
	}

	public void clearConnects(){
		this.connects.clear();
	}
}
