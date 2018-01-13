package edu.pnu.stem.feature;

import edu.pnu.stem.binder.IndoorGMLMap;

/**
 * @author jungh
 *	Implements IndoorFeaturesType of IndoorGML 1.0.3
 */
public class IndoorFeatures extends AbstractFeature{

	/**
	 * save PriamlSpaceFeatures value
	 */
	private String primalSpaceFeatures = null;
	/**
	 * save MultiLayeredGraph value
	 */
	private String multiLayeredGraph = null;
	
	/**
	 * @return the docId
	 */
	private IndoorGMLMap indoorGMLMap;
	
	
	public IndoorFeatures(IndoorGMLMap doc){
		indoorGMLMap = doc;
	}
	/**
	 * @return the primalSpaceFeatures
	 */
	public PrimalSpaceFeatures getPrimalSpaceFeatures() {
		PrimalSpaceFeatures found = null;
		
		if(this.primalSpaceFeatures != null) {
			found = (PrimalSpaceFeatures) indoorGMLMap.getFeature(this.primalSpaceFeatures);
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
			indoorGMLMap.setFeature(primalSpaceFeatures.getId(), "PrimalSpaceFeatures", primalSpaceFeatures);
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
		}
		
		return found;
	}
	/**
	 * @param multiLayeredGraph the multiLayeredGraph to set
	 */
	public void setMultiLayeredGraph(MultiLayeredGraph multiLayeredGraph) {
		if(multiLayeredGraph != null) {
			this.multiLayeredGraph = multiLayeredGraph.getId();
		}
	}
	
	public MultiLayeredGraph getMultiLayeredGraph1(){
		MultiLayeredGraph found = null;
		found = (MultiLayeredGraph)indoorGMLMap.getFeature(this.multiLayeredGraph);
		return found;
	}
}
