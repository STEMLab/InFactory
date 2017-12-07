package FeatureClassReference;
/**
 * @author jungh
 *	Implements IndoorFeaturesType of IndoorGML 1.0.3
 */
public class IndoorFeatures {
	/**
	 * ID of this feature
	 */
	public String ID;
	/**
	 * Name of this feature
	 */
	public String name;
	/**
	 * save PriamlSpaceFeatures value
	 */
	public String primalSpaceFeatures;
	/**
	 * save MultiLayeredGraph value
	 */
	public String multiLayeredGraph;
	/**
	 * @return the iD
	 */
	public String getID() {
		return ID;
	}
	/**
	 * @param iD the iD to set
	 */
	public void setID(String iD) {
		ID = iD;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the primalSpaceFeatures
	 */
	public String getPrimalSpaceFeatures() {
		return primalSpaceFeatures;
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
		return multiLayeredGraph;
	}
	/**
	 * @param multiLayeredGraph the multiLayeredGraph to set
	 */
	public void setMultiLayeredGraph(String multiLayeredGraph) {
		this.multiLayeredGraph = multiLayeredGraph;
	}

}
