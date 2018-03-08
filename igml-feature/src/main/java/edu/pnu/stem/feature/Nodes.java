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
	
	public Nodes(IndoorGMLMap doc, String id){
		super(doc, id);
		stateMember = new ArrayList<String>();
	}
	
	public void setParent(SpaceLayer parent) {
		SpaceLayer found = null;
		found = (SpaceLayer)indoorGMLMap.getFeature(parent.getId());
		if( found == null ){
			indoorGMLMap.setFutureFeature(parent.getId(), parent);
		}
		this.parentId = parent.getId();
	}
	
	public SpaceLayer getParent() {
		SpaceLayer feature = null;
		feature = (SpaceLayer) indoorGMLMap.getFeature(this.parentId);
		return feature;
	}

	public void setStateMember(List<State> stateMember) {
		for (State s : stateMember) {
			State found = null;
			found = (State) indoorGMLMap.getFeature(s.getId());
			if (found == null) {
				if(!indoorGMLMap.hasFutureID(s.getId())){
					indoorGMLMap.setFutureFeature(s.getId(),s);
				}
			}
			if (!this.stateMember.contains(s.getId())) {
				this.stateMember.add(s.getId());
			}
		}

	}

	public List<State> getStateMember() {
		List<State> stateMember = new ArrayList<State>();
		if (this.stateMember.size() != 0) {
			for (int i = 0; i < this.stateMember.size(); i++) {
				State found = (State) indoorGMLMap.getFeature(this.stateMember.get(i));
				stateMember.add(found);
			}
		}
		return stateMember;
	}
	
	
	public void addStateMember(State s) {
		if(!this.stateMember.contains(s.getId())){
			this.stateMember.add(s.getId());
			indoorGMLMap.setFeature(s.getId(), "State", s);
		}
	}
	
	public void clearStateMember(){
		this.stateMember.clear();
	}

}
