package edu.pnu.stem.feature;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jungh Implements InterEdgesType of IndoorGML 1.0.3
 */
public class InterEdges extends AbstractFeature {

	/**
	 * hold list of InterLayerConnections
	 */
	List<String> interLayerConnectionMember;

	String parentId;

	public void setParent(MultiLayeredGraph parent) {
		MultiLayeredGraph found = null;
		found = (MultiLayeredGraph)IndoorGMLMap.getFeature(IndoorGMLMap.getFeatureContainer("MultiLayeredGraph"), parent.getId());
		if(found == null){
			IndoorGMLMap.setFeature(parent.getId(), "MultiLayeredGraph", parent);
		}
		this.parentId = parent.getId(); 
	}

	public MultiLayeredGraph getParent() {
		MultiLayeredGraph found = null;
		found = (MultiLayeredGraph)IndoorGMLMap.getFeature(IndoorGMLMap.getFeatureContainer("MultiLayeredGraph"), this.parentId);
		return found;
	}

		/**
	 * @return the interLayerConnectionMember
	 */
	public List<InterLayerConnection> getInterLayerConnectionMember() {
		List<InterLayerConnection> interLayerConnectionMember = new ArrayList<InterLayerConnection>();
		for(int i = 0 ; i < this.interLayerConnectionMember.size() ; i++){
			InterLayerConnection found = (InterLayerConnection)IndoorGMLMap.getFeature(IndoorGMLMap.getFeatureContainer("SpaceLayer"), this.interLayerConnectionMember.get(i));
			interLayerConnectionMember.add(found);
		}
		return interLayerConnectionMember;
	}

	/**
	 * @param interLayerConnectionMember
	 *            the interLayerConnectionMember to set
	 */
	public void setInterLayerConnectionMember(List<InterLayerConnection> interLayerConnectionMember) {
		for(int i = 0 ; i < interLayerConnectionMember.size(); i++){
			InterLayerConnection found = null;
			if(found == null){
				IndoorGMLMap.setFeature(interLayerConnectionMember.get(i).getId(), "InterLayerConnection", interLayerConnectionMember.get(i));
			}
			if(!this.interLayerConnectionMember.contains(interLayerConnectionMember.get(i).getId())){
				this.interLayerConnectionMember.add(interLayerConnectionMember.get(i).getId());
			}
		}
	}

}
