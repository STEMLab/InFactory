package edu.pnu.stem.feature;

import java.util.ArrayList;
import java.util.List;

import edu.pnu.stem.binder.Container;

/**
 * @author jungh Implements MultiLayeredGraphType of IndoorGML 1.0.3
 */
public class MultiLayeredGraph extends AbstractFeature {
	
	private String docId;
	/**
	 * list of the SpaceLayers which are related with in this MultiLayeredGraph
	 */
	private List<String> spaceLayers;
	/**
	 * InterEdges which is between SpaceLayeres
	 */
	private List<String> interEdges;

	private String parentId;

	/**
	 * @return the docId
	 */
	public String getDocId() {
		return new String(this.docId);
	}

	/**
	 * @param docId the docId to set
	 */
	public void setDocId(String docId) {
		if(Container.hasDoc(docId))
			this.docId = docId;
		else
			System.out.println("There is no document with that document Id.");
	}
	
	/**
	 * @return the spaceLayers
	 */
	public List<SpaceLayer> getSpaceLayers() {
		List<SpaceLayer>spaceLayers = new ArrayList<SpaceLayer>();
		for(int i = 0 ; i < this.spaceLayers.size();i++){
			spaceLayers.add((SpaceLayer)IndoorGMLMap.getFeature(IndoorGMLMap.getFeatureContainer("SpaceLayer"), this.spaceLayers.get(i)));			
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
			found = (SpaceLayers)IndoorGMLMap.getFeature(IndoorGMLMap.getFeatureContainer("SpaceLayers"), spaceLayers.get(i).getId());
			if(found == null){
				IndoorGMLMap.setFeature(spaceLayers.get(i).getId(), "SpaceLayers", spaceLayers.get(i));
			}
			this.spaceLayers.add(spaceLayers.get(i).getId());
		}
	}

	/**
	 * @return the interEdges
	 */
	public List<InterEdges> getInterEdges() {
		List<InterEdges>interEdges = new ArrayList<InterEdges>();
		for(int i = 0 ; i < this.interEdges.size() ; i++){
			interEdges.add((InterEdges)IndoorGMLMap.getFeature(IndoorGMLMap.getFeatureContainer("InterEdges"), this.interEdges.get(i)));
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
			found = (InterEdges)IndoorGMLMap.getFeature(IndoorGMLMap.getFeatureContainer("InterEdges"), interEdges.get(i).getId());
			if(found == null){
				IndoorGMLMap.setFeature(interEdges.get(i).getId(), "InterEdges",interEdges.get(i));
			}
			if(this.interEdges.contains(interEdges.get(i).getId())){
				this.interEdges.add(interEdges.get(i).getId());
			}			
		}
	}
	/**
	 * @return
	 */
	public IndoorFeatures getParent() {
		IndoorFeatures parent = null;
		parent = (IndoorFeatures)IndoorGMLMap.getFeature(IndoorGMLMap.getFeatureContainer("IndoorFeatures"), this.parentId);
		return parent;
	}

	/**
	 * @param parentID
	 *            the parentID to set
	 */
	public void setParent(IndoorFeatures parent) {
		IndoorFeatures found = null;
		found = (IndoorFeatures)IndoorGMLMap.getFeature(IndoorGMLMap.getFeatureContainer("IndoorFeatures"), parent.getId());
		if(found == null){
			IndoorGMLMap.setFeature(parent.getId(), "IndoorFeatures", parent);			
		}
		this.parentId = parent.getId();
	}
}
