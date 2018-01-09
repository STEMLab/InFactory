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
	private String primalSpaceFeatures;
	/**
	 * save MultiLayeredGraph value
	 */
	private String multiLayeredGraph;
	
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
		found = (PrimalSpaceFeatures)indoorGMLMap.getFeature(indoorGMLMap.getFeatureContainer("PrimalSpaceFeatures"), this.primalSpaceFeatures);
		return found;
	}
	/**
	 * @param primalSpaceFeatures the primalSpaceFeatures to set
	 */
	public void setPrimalSpaceFeatures(PrimalSpaceFeatures primalSpaceFeatures) {
		PrimalSpaceFeatures found = null;
		found = (PrimalSpaceFeatures)indoorGMLMap.getFeature(indoorGMLMap.getFeatureContainer("PrimalSpaceFeatures"), primalSpaceFeatures.getId());
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
		found = (MultiLayeredGraph)indoorGMLMap.getFeature(indoorGMLMap.getFeatureContainer("MultiLayeredGraph"), this.multiLayeredGraph);
		return found;
	}
	/**
	 * @param multiLayeredGraph the multiLayeredGraph to set
	 */
	public void setMultiLayeredGraph(MultiLayeredGraph multiLayeredGraph) {
		MultiLayeredGraph found = null;
		found = (MultiLayeredGraph)indoorGMLMap.getFeature(indoorGMLMap.getFeatureContainer("MultiLayeredGraph"), multiLayeredGraph.getId());
		if(found == null){
			indoorGMLMap.setFeature(multiLayeredGraph.getId(), "MultiLayeredGraph", multiLayeredGraph);
		}
		this.multiLayeredGraph = multiLayeredGraph.getId();
	}
	
	public MultiLayeredGraph getMultiLayeredGraph1(){
		MultiLayeredGraph found = null;
		found = (MultiLayeredGraph)indoorGMLMap.getFeature(indoorGMLMap.getFeatureContainer("MultiLayeredGraph"),this.multiLayeredGraph);
		return found;
	}
}
