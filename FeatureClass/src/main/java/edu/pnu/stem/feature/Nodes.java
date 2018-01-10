package edu.pnu.stem.feature;

import java.util.ArrayList;
import java.util.List;

import edu.pnu.stem.binder.IndoorGMLMap;

public class Nodes extends AbstractFeature {
	
	/**
	 * State list which this feature contains
	 */
	private List<String> stateMember;

	private String parentId;
	
	private IndoorGMLMap indoorGMLMap;
	
	public Nodes(IndoorGMLMap doc){
		indoorGMLMap = doc;
		stateMember = new ArrayList<String>();
	}
	
	public void setParent(SpaceLayer parent) {
		SpaceLayer found = null;
		found = (SpaceLayer)indoorGMLMap.getFeature(indoorGMLMap.getFeatureContainer("SpaceLayer"), parent.getId());
		if( found == null ){
			indoorGMLMap.setFeature(parent.getId(), "SpaceLayer", parent );
		}
		this.parentId = parent.getId();
	}
	
	public SpaceLayer getParent() {
		SpaceLayer feature = null;
		feature = (SpaceLayer) indoorGMLMap.getFeature(indoorGMLMap.getFeatureContainer("SpaceLayer"),
				this.parentId);
		return feature;
	}

	public void setStateMember(List<State> stateMember) {
		for (int i = 0; i < stateMember.size(); i++) {
			State found = null;
			found = (State) indoorGMLMap.getFeature(indoorGMLMap.getFeatureContainer("State"),
					stateMember.get(i).getId());
			if (found == null) {
				indoorGMLMap.setFeature(stateMember.get(i).getId(), "State", stateMember.get(i));
			}
			if (!this.stateMember.contains(stateMember.get(i).getId())) {
				this.stateMember.add(stateMember.get(i).getId());
			}
		}

	}

	public List<State> getStateMember() {
		List<State> stateMember = new ArrayList<State>();
		if (this.stateMember.size() != 0) {
			for (int i = 0; i < this.stateMember.size(); i++) {
				State found = (State) indoorGMLMap.getFeature(indoorGMLMap.getFeatureContainer("State"),
						this.stateMember.get(i));
				stateMember.add(found);
			}
		}
		return stateMember;
	}
	
	public void clearStateMember(){
		this.stateMember.clear();
	}

}
