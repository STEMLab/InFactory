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

	public MultiLayeredGraph(IndoorGMLMap doc, String id){
		super(doc, id);
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
				SpaceLayers found = (SpaceLayers)indoorGMLMap.getFeature(this.spaceLayers.get(i));
				if(found == null) {
					found = (SpaceLayers)indoorGMLMap.getFutureFeature(this.spaceLayers.get(i));
				}
				spaceLayers.add(found);			
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
				indoorGMLMap.setFutureFeature(spaceLayers.get(i).getId(), spaceLayers.get(i));
			}
			if(!this.spaceLayers.contains(spaceLayers.get(i).getId())){
				this.spaceLayers.add(spaceLayers.get(i).getId());
			}
			
		}
	}
	
	public void addSpaceLayers(SpaceLayers sls) {
		if(this.spaceLayers == null)
			this.spaceLayers = new ArrayList<String>();
		if(!this.spaceLayers.contains(sls.getId())){
			SpaceLayers found = null;
			found = (SpaceLayers)indoorGMLMap.getFeature(sls.getId());
			if(found == null)
				indoorGMLMap.setFutureFeature(sls.getId(), sls);
			this.spaceLayers.add(sls.getId());
			//indoorGMLMap.setFeature(sls.getId(), "SpaceLayers", sls);
		}
	}
	
	/**
	 * @return the interEdges
	 */
	public List<InterEdges> getInterEdges() {
		List<InterEdges>interEdges = new ArrayList<InterEdges>();
		if(this.interEdges != null){
			for(int i = 0 ; i < this.interEdges.size() ; i++){
				InterEdges found = (InterEdges)indoorGMLMap.getFeature(this.interEdges.get(i));
				if(found == null)
					found = (InterEdges)indoorGMLMap.getFutureFeature(this.interEdges.get(i));
				interEdges.add(found);
			}
		}		
		return interEdges;
	}

	/**
	 * @param interEdges
	 *            the interEdges to set
	 */
	public void setInterEdges(List<InterEdges> interEdges) {	
		this.spaceLayers.clear();
		for(int i = 0 ; i < interEdges.size() ; i++ ){
			InterEdges found = null;
			found = (InterEdges)indoorGMLMap.getFeature(interEdges.get(i).getId());
			if(found == null){
				indoorGMLMap.setFutureFeature(interEdges.get(i).getId(), interEdges.get(i));
			}
			if(!this.interEdges.contains(interEdges.get(i).getId())){
				this.interEdges.add(interEdges.get(i).getId());
			}			
		}
	}
	
	public void addInterEdges(InterEdges ie) {
		InterEdges found = null;
		found = (InterEdges)indoorGMLMap.getFeature(ie.getId());
		if(found == null){
			indoorGMLMap.setFutureFeature(ie.getId(), ie);
		}
		if(!this.interEdges.contains(ie.getId())){
			this.interEdges.add(ie.getId());
			//indoorGMLMap.setFeature(ie.getId(), "InterEdges", ie);
		}
	}
	
	public IndoorFeatures getParent() {
		IndoorFeatures parent = null;
		parent = (IndoorFeatures) indoorGMLMap.getFeature(this.parentId);
		if(parent == null)
			parent = (IndoorFeatures)indoorGMLMap.getFutureFeature(this.parentId);
		return parent;
	}

	public void setParent(IndoorFeatures parent) {
		IndoorFeatures found = null;
		found = (IndoorFeatures)indoorGMLMap.getFeature(parent.getId());
		if(found == null){
			indoorGMLMap.setFutureFeature(parent.getId(), parent);			
		}
		this.parentId = parent.getId();
	}
	
	public void resetInterEdges(){
		this.interEdges = null;
	}
	
	public void resetSpaceLayers(){
		this.spaceLayers = null;
	}

	public void deleteSpaceLayers(SpaceLayers target) {
		if(this.spaceLayers.contains(target.getId())) {
			this.spaceLayers.remove(target.getId());
		}
		
	}

	public void resetParent() {
		this.parentId = null;
		
	}

	public void deleteInterEdges(InterEdges target) {
		if(this.interEdges != null)
			if(this.interEdges.contains(target.getId()))
				this.interEdges.remove(target.getId());
			
	}
}
