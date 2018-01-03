package edu.pnu.stem.feature;
/**
 * @author jungh
 *	Implements IndoorFeaturesType of IndoorGML 1.0.3
 */
public class IndoorFeatures extends AbstractFeature{

	/**
	 * save PriamlSpaceFeatures value
	 */
	String primalSpaceFeatures;
	/**
	 * save MultiLayeredGraph value
	 */
	String multiLayeredGraph;
	/**
	 * @return the primalSpaceFeatures
	 */
	public String getPrimalSpaceFeatures() {
		return new String(primalSpaceFeatures);
	}
	/**
	 * @param primalSpaceFeatures the primalSpaceFeatures to set
	 */
	public void setPrimalSpaceFeatures(String primalSpaceFeatures) {
		this.primalSpaceFeatures = primalSpaceFeatures;
	}
	/**
	 * @return the multiLayeredGraph
	 */
	public String getMultiLayeredGraph() {
		return new String(multiLayeredGraph);
	}
	/**
	 * @param multiLayeredGraph the multiLayeredGraph to set
	 */
	public void setMultiLayeredGraph(String multiLayeredGraph) {
		this.multiLayeredGraph = multiLayeredGraph;
	}

}
