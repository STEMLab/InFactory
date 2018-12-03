package edu.pnu.stem.feature.core;

import edu.pnu.stem.binder.IndoorGMLMap;

/**
 * @author jungh
 *	Implements IndoorFeaturesType of IndoorGML 1.0.3
 */
public class IndoorFeatures extends AbstractFeature {

	/**
	 * save PriamlSpaceFeatures value
	 */
	private String primalSpaceFeatures = null;
	/**
	 * save MultiLayeredGraph value
	 */
	private String multiLayeredGraph = null;

	public IndoorFeatures(IndoorGMLMap doc, String id) {
		super(doc, id);
	}
	/**
	 * @return the primalSpaceFeatures
	 */
	public PrimalSpaceFeatures getPrimalSpaceFeatures() {
		PrimalSpaceFeatures found = null;
		
		if(this.primalSpaceFeatures != null) {
			found = (PrimalSpaceFeatures) indoorGMLMap.getFeature(this.primalSpaceFeatures);
			if(found == null)
				found = (PrimalSpaceFeatures)indoorGMLMap.getFutureFeature(this.primalSpaceFeatures);
		}
		
		return found;
	}
	

	
	/**
	 * @param primalSpaceFeatures the primalSpaceFeatures to set
	 */
	public void setPrimalSpaceFeatures(PrimalSpaceFeatures primalSpaceFeatures) {
		PrimalSpaceFeatures found = null;
		found = (PrimalSpaceFeatures) indoorGMLMap.getFeature(primalSpaceFeatures.getId());
		if( found == null ){
			indoorGMLMap.setFutureFeature(primalSpaceFeatures.getId(), primalSpaceFeatures);
		}		
		this.primalSpaceFeatures = primalSpaceFeatures.getId();
	}
	/**
	 * @return the multiLayeredGraph
	 */
	public MultiLayeredGraph getMultiLayeredGraph() {
		MultiLayeredGraph found = null;
		
		if(this.multiLayeredGraph != null) {
			found = (MultiLayeredGraph) indoorGMLMap.getFeature(this.multiLayeredGraph);
			if(found == null)
				found = (MultiLayeredGraph)indoorGMLMap.getFutureFeature(this.multiLayeredGraph); 
		}
			
		return found;
	}
	/**
	 * @param multiLayeredGraph the multiLayeredGraph to set
	 */
	public void setMultiLayeredGraph(MultiLayeredGraph multiLayeredGraph) {
		MultiLayeredGraph found = null;
		found = (MultiLayeredGraph) indoorGMLMap.getFeature(multiLayeredGraph.getId());
		
		if(found == null){
			if(!indoorGMLMap.hasFutureID(multiLayeredGraph.getId())){
				indoorGMLMap.setFutureFeature(multiLayeredGraph.getId(), multiLayeredGraph);
			}
		}
		if(multiLayeredGraph != null) {
			this.multiLayeredGraph = multiLayeredGraph.getId();
		}
	}
	public void resetMultiLayerdGraph() {
		this.multiLayeredGraph = null;
		
	}
	public void deleteMultiLayeredGraph(MultiLayeredGraph target) {
		if(this.multiLayeredGraph.equals(target.getId()))
			this.multiLayeredGraph = null;
		
	}
	public void deletePrimalSpaceFeatures(PrimalSpaceFeatures target) {
		if(this.primalSpaceFeatures.equals(target.getId()))
			this.primalSpaceFeatures = null;
		
	}
	
}
