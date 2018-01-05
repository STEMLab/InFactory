package edu.pnu.stem.feature;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jungh Implements EdgesType of IndoorGML 1.0.3
 */
public class Edges extends AbstractFeature{
	/**
	 * contains list of Transitions as list
	 */
	List<String> transitionMember;

	public String parentId;

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

	public void setTransitionMembers(List<Transition> transitionMember) {
		for(int i = 0 ; i < transitionMember.size(); i++){
			Transition found = null;
			found = (Transition) IndoorGMLMap.getFeature(IndoorGMLMap.getFeatureContainer("Transition"), transitionMember.get(i).getId());
			if(found == null){
				IndoorGMLMap.setFeature(transitionMember.get(i).getId(), "Transition", transitionMember.get(i));
			}
			if(!this.transitionMember.contains(transitionMember.get(i).getId())){
				this.transitionMember.add(transitionMember.get(i).getId());
			}
		}
	}

	public List<Transition> getTransitionMember() {
		List<Transition> transitionMember = new ArrayList<Transition>();
		if (this.transitionMember.size() != 0) {
			for (int i = 0; i < this.transitionMember.size(); i++) {
				Transition found = (Transition) IndoorGMLMap.getFeature(IndoorGMLMap.getFeatureContainer("State"),
						this.transitionMember.get(i));
				transitionMember.add(found);
			}
		}
		return transitionMember;
	}



}
