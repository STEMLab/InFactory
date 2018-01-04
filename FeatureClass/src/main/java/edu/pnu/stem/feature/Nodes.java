package edu.pnu.stem.feature;

import java.util.ArrayList;
import java.util.List;

public class Nodes extends AbstractFeature {
	/**
	 * State list which this feature contains
	 */
	List<String> stateMember;

	String parentId;

	public void setParent(MultiLayeredGraph parent) {
		MultiLayeredGraph found = null;
		found = (MultiLayeredGraph)IndoorGMLMap.getFeature(IndoorGMLMap.getFeatureContainer("MultiLayeredGraph"), parent.getId());
		if( found == null ){
			IndoorGMLMap.setFeature(parent.getId(), "MultiLayeredGraph", parent );
		}
		this.parentId = parent.getId();
	}

	public MultiLayeredGraph getParent() {
		MultiLayeredGraph feature = null;
		feature = (MultiLayeredGraph) IndoorGMLMap.getFeature(IndoorGMLMap.getFeatureContainer("MultiLayeredGraph"),
				this.parentId);
		return feature;
	}

	public void setStateMember(List<State> stateMember) {
		for (int i = 0; i < stateMember.size(); i++) {
			State found = null;
			found = (State) IndoorGMLMap.getFeature(IndoorGMLMap.getFeatureContainer("State"),
					stateMember.get(i).getId());
			if (found == null) {
				IndoorGMLMap.setFeature(stateMember.get(i).getId(), "State", stateMember.get(i));
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
				State found = (State) IndoorGMLMap.getFeature(IndoorGMLMap.getFeatureContainer("State"),
						this.stateMember.get(i));
				stateMember.add(found);
			}
		}
		return stateMember;
	}

}
