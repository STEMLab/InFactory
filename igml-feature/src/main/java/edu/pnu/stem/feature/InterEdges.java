package edu.pnu.stem.feature;

import java.util.ArrayList;
import java.util.List;

import edu.pnu.stem.binder.IndoorGMLMap;

/**
 * @author jungh Implements InterEdgesType of IndoorGML 1.0.3
 */
public class InterEdges extends AbstractFeature {

	/**
	 * hold list of InterLayerConnections
	 */
	private List<String> interLayerConnectionMember;

	private String parentId;

	public InterEdges(IndoorGMLMap doc, String id){
		super(doc, id);
		interLayerConnectionMember = new ArrayList<String>();
	}
	
	public void setParent(MultiLayeredGraph parent) {
		MultiLayeredGraph found = null;
		found = (MultiLayeredGraph)indoorGMLMap.getFeature(parent.getId());
		if(found == null){
			indoorGMLMap.setFutureFeature(parent.getId(), parent);
		}
		this.parentId = parent.getId(); 
	}

	public MultiLayeredGraph getParent() {
		MultiLayeredGraph found = null;
		found = (MultiLayeredGraph)indoorGMLMap.getFeature(this.parentId);
		return found;
	}

		/**
	 * @return the interLayerConnectionMember
	 */
	public List<InterLayerConnection> getInterLayerConnectionMember() {
		List<InterLayerConnection> interLayerConnectionMember = new ArrayList<InterLayerConnection>();
		for(int i = 0 ; i < this.interLayerConnectionMember.size() ; i++){
			InterLayerConnection found = (InterLayerConnection)indoorGMLMap.getFeature(this.interLayerConnectionMember.get(i));
			interLayerConnectionMember.add(found);
		}
		return interLayerConnectionMember;
	}

	/**
	 * @param interLayerConnectionMember
	 *            the interLayerConnectionMember to set
	 */
	public void setInterLayerConnectionMember(List<InterLayerConnection> interLayerConnectionMember) {
		this.interLayerConnectionMember = new ArrayList<String>();
		for(int i = 0 ; i < interLayerConnectionMember.size(); i++){
			InterLayerConnection found = null;
			if(found == null){
				indoorGMLMap.setFutureFeature(interLayerConnectionMember.get(i).getId(), interLayerConnectionMember.get(i));
			}
			if(!this.interLayerConnectionMember.contains(interLayerConnectionMember.get(i).getId())){
				this.interLayerConnectionMember.add(interLayerConnectionMember.get(i).getId());
			}
		}
	}
	
	public void addInterLayerConnectionMember(InterLayerConnection interLayeredConn) {
		InterLayerConnection found = null;
		if(found == null){
			indoorGMLMap.setFutureFeature(interLayeredConn.getId(), interLayeredConn);
		}		
		if(!this.interLayerConnectionMember.contains(interLayeredConn.getId())){
			this.interLayerConnectionMember.add(interLayeredConn.getId());
			indoorGMLMap.setFeature(interLayeredConn.getId(), "InterLayerConnection", interLayeredConn);
		}
	}
	
	public void clearInterLayerConnectionMember(){
		this.interLayerConnectionMember.clear();
	}

	public void resetParent() {
		this.parentId = null;
	}

}
