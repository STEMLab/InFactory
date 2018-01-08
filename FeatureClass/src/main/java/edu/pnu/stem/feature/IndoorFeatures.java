package edu.pnu.stem.feature;

import edu.pnu.stem.binder.Container;

/**
 * @author jungh
 *	Implements IndoorFeaturesType of IndoorGML 1.0.3
 */
public class IndoorFeatures extends AbstractFeature{

	private String docId;
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
	 * @return the primalSpaceFeatures
	 */
	public String getPrimalSpaceFeatures() {
		return new String(primalSpaceFeatures);
	}
	/**
	 * @param primalSpaceFeatures the primalSpaceFeatures to set
	 */
	public void setPrimalSpaceFeatures(PrimalSpacefeatures primalSpaceFeatures) {
		PrimalSpaceFeatures found = null;
		
		
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
