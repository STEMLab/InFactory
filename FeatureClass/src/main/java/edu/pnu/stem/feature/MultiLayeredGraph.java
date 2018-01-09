package edu.pnu.stem.feature;

import java.util.ArrayList;
import java.util.List;

import edu.pnu.stem.binder.IndoorGMLMap;

/**
 * @author jungh Implements MultiLayeredGraphType of IndoorGML 1.0.3
 */
public class MultiLayeredGraph extends AbstractFeature {
	
	/**
	 * list of the SpaceLayers which are related with in this MultiLayeredGraph
	 */
	private List<String> spaceLayers;
	/**
	 * InterEdges which is between SpaceLayeres
	 */
	private List<String> interEdges;

	private String parentId;

	private IndoorGMLMap indoorGMLMap;
	
	public MultiLayeredGraph(IndoorGMLMap doc){
		indoorGMLMap = doc;
		spaceLayers = new ArrayList<String>();
		interEdges = new ArrayList<String>();
	}
	
	/**
	 * @return the spaceLayers
	 */
	public List<SpaceLayers> getSpaceLayers() {
		List<SpaceLayers>spaceLayers = new ArrayList<SpaceLayers>();
		if(this.spaceLayers.size() != 0){
			spaceLayers = new ArrayList<SpaceLayers>();
			for(int i = 0 ; i < this.spaceLayers.size();i++){
				spaceLayers.add((SpaceLayers)indoorGMLMap.getFeature(indoorGMLMap.getFeatureContainer("SpaceLayers"), this.spaceLayers.get(i)));			
			}
		}
		
		return spaceLayers;
	}
	/**
	 * @param spaceLayers
	 *            the spaceLayers to set
	 */
	public void setSpaceLayers(List<SpaceLayers> spaceLayers) {
		for(int i = 0 ; i < spaceLayers.size(); i++){
			SpaceLayers found = null;
			found = (SpaceLayers)indoorGMLMap.getFeature(indoorGMLMap.getFeatureContainer("SpaceLayers"), spaceLayers.get(i).getId());
			if(found == null){
				indoorGMLMap.setFeature(spaceLayers.get(i).getId(), "SpaceLayers", spaceLayers.get(i));
			}
			if(!this.spaceLayers.contains(spaceLayers.get(i).getId())){
				this.spaceLayers.add(spaceLayers.get(i).getId());
			}
			
		}
	}

	/**
	 * @return the interEdges
	 */
	public List<InterEdges> getInterEdges() {
		List<InterEdges>interEdges = new ArrayList<InterEdges>();
		if(this.interEdges != null){
			for(int i = 0 ; i < this.interEdges.size() ; i++){
				interEdges.add((InterEdges)indoorGMLMap.getFeature(indoorGMLMap.getFeatureContainer("InterEdges"), this.interEdges.get(i)));
			}
		}		
		return interEdges;
	}

	/**
	 * @param interEdges
	 *            the interEdges to set
	 */
	public void setInterEdges(List<InterEdges> interEdges) {				
		for(int i = 0 ; i < interEdges.size() ; i++ ){
			InterEdges found = null;
			found = (InterEdges)indoorGMLMap.getFeature(indoorGMLMap.getFeatureContainer("InterEdges"), interEdges.get(i).getId());
			if(found == null){
				indoorGMLMap.setFeature(interEdges.get(i).getId(), "InterEdges",interEdges.get(i));
			}
			if(!this.interEdges.contains(interEdges.get(i).getId())){
				this.interEdges.add(interEdges.get(i).getId());
			}			
		}
	}
	/**
	 * @return
	 */
	public IndoorFeatures getParent() {
		IndoorFeatures parent = null;
		parent = (IndoorFeatures)indoorGMLMap.getFeature(indoorGMLMap.getFeatureContainer("IndoorFeatures"), this.parentId);
		return parent;
	}

	/**
	 * @param parentID
	 *            the parentID to set
	 */
	public void setParent(IndoorFeatures parent) {
		IndoorFeatures found = null;
		found = (IndoorFeatures)indoorGMLMap.getFeature(indoorGMLMap.getFeatureContainer("IndoorFeatures"), parent.getId());
		if(found == null){
			indoorGMLMap.setFeature(parent.getId(), "IndoorFeatures", parent);			
		}
		this.parentId = parent.getId();
	}
}
