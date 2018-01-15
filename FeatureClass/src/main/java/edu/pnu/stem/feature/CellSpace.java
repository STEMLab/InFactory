package edu.pnu.stem.feature;

import java.util.ArrayList;
import java.util.List;

import com.vividsolutions.jts.geom.Geometry;

import edu.pnu.stem.binder.IndoorGMLMap;
import edu.pnu.stem.util.GeometryUtil;

/**
 * @author jungh Implements CellSpaceType of IndoorGML 1.0.3
 */
public class CellSpace extends AbstractFeature {
	
	/**
	 * value of geometry of feature
	 */
	private String geometry;

	/**
	 * boundary of the CellSpace
	 */
	private List<String> partialboundedBy;
	/**
	 * value of State which has duality relationship with the CellSpace
	 */
	private String duality;
	/**
	 * If External Reference of the feature is exist, then set this.
	 */
	private ExternalReference externalReference;

	/**
	 * ID of parent feature instance.
	 */
	private String parentId;

	public CellSpace(IndoorGMLMap doc){
		super(doc);
		partialboundedBy = new ArrayList<String>();
	}
	

	public PrimalSpaceFeatures getParent() {
		PrimalSpaceFeatures feature = null;
		feature = (PrimalSpaceFeatures) indoorGMLMap.getFeature(this.parentId);
		return feature;
	}

	public Geometry getGeometry() {
		Geometry feature = null;
		feature = (Geometry) indoorGMLMap.getFeature(this.geometry);
		return feature;
	}
	
	public void setGeometry(Geometry geom) {
		String gId = GeometryUtil.getMetadata(geom, "id");
		Geometry found = (Geometry) indoorGMLMap.getFeature(gId);
		if(found == null) {
			indoorGMLMap.setFeature(gId, "Geometry", geom);
		}
		this.geometry = gId;
	}

	public boolean hasDuality() {
		if (this.duality == null) {
			return false;
		} else {
			return true;
		}
	}

	public State getDuality() {
		State feature = null;
		if (hasDuality()) {
			feature = (State) indoorGMLMap.getFeature(this.duality);
		}
		return feature;
	}
	
	public void setDuality(State s) {
		State found = (State) indoorGMLMap.getFeature(s.getId());
		if(found == null) {
			indoorGMLMap.setFeature(s.getId(), "State", s);
		}
		this.duality = s.getId();
	}

	public List<CellSpaceBoundary> getPartialboundedBy() {
		List<CellSpaceBoundary> cboundaries = new ArrayList<CellSpaceBoundary>();
		if(this.partialboundedBy.size() != 0){
			for (String s : this.partialboundedBy) {
				cboundaries.add((CellSpaceBoundary) indoorGMLMap
						.getFeature(s));
			}
		}
		
		return cboundaries;
	}

	public void setPartialboundedBy(List<CellSpaceBoundary> csbList) {
		for(CellSpaceBoundary cb : csbList){
			CellSpaceBoundary found = null;
			found = (CellSpaceBoundary)indoorGMLMap.getFeature(cb.getId());
			if(found == null){
				indoorGMLMap.setFeature(cb.getId(), "CellSpaceBoundary", cb);
			}
			if(!this.partialboundedBy.contains(cb.getId())){
				this.partialboundedBy.add(cb.getId());
			}
		}
		
	}

	public ExternalReference getExternalReference() {
		return this.getExternalReference();
	}

	
	 
	public void setExternalReference(ExternalReference e) {
		this.externalReference = e;
	}
	
	

	public void setParent(PrimalSpaceFeatures parent) {
		PrimalSpaceFeatures found = null;
		found = (PrimalSpaceFeatures)indoorGMLMap.getFeature(parent.getId());
		if(found == null){
			indoorGMLMap.setFeature(parent.getId(), "PrimalSpaceFeatures", parent);
		}
		this.parentId = parent.getId();
		
	}

	
}
