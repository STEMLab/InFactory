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

	public MultiLayeredGraph(IndoorGMLMap doc){
		super(doc);
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
				spaceLayers.add((SpaceLayers)indoorGMLMap.getFeature(this.spaceLayers.get(i)));			
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
			found = (SpaceLayers)indoorGMLMap.getFeature(spaceLayers.get(i).getId());
			if(found == null){
				indoorGMLMap.setFeature(spaceLayers.get(i).getId(), "SpaceLayers", spaceLayers.get(i));
			}
			if(!this.spaceLayers.contains(spaceLayers.get(i).getId())){
				this.spaceLayers.add(spaceLayers.get(i).getId());
			}
			
		}
	}
	
	public void addSpaceLayers(SpaceLayers sls) {
		if(!this.spaceLayers.contains(sls.getId())){
			this.spaceLayers.add(sls.getId());
			indoorGMLMap.setFeature(sls.getId(), "SpaceLayers", sls);
		}
	}
	
	/**
	 * @return the interEdges
	 */
	public List<InterEdges> getInterEdges() {
		List<InterEdges>interEdges = new ArrayList<InterEdges>();
		if(this.interEdges != null){
			for(int i = 0 ; i < this.interEdges.size() ; i++){
				interEdges.add((InterEdges)indoorGMLMap.getFeature(this.interEdges.get(i)));
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
			found = (InterEdges)indoorGMLMap.getFeature(interEdges.get(i).getId());
			if(found == null){
				indoorGMLMap.setFeature(interEdges.get(i).getId(), "InterEdges",interEdges.get(i));
			}
			if(!this.interEdges.contains(interEdges.get(i).getId())){
				this.interEdges.add(interEdges.get(i).getId());
			}			
		}
	}
	
	public IndoorFeatures getParent() {
		IndoorFeatures parent = null;
		parent = (IndoorFeatures)indoorGMLMap.getFeature(this.parentId);
		return parent;
	}

	public void setParent(IndoorFeatures parent) {
		IndoorFeatures found = null;
		found = (IndoorFeatures)indoorGMLMap.getFeature(parent.getId());
		if(found == null){
			indoorGMLMap.setFeature(parent.getId(), "IndoorFeatures", parent);			
		}
		this.parentId = parent.getId();
	}
	
	public void clearInterEdges(){
		this.interEdges.clear();
	}
	
	public void clearSpaceLayers(){
		this.spaceLayers.clear();
	}
}
