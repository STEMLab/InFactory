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
		if(feature == null) {
			if(indoorGMLMap.hasFutureID(parentId))
				feature = (SpaceLayer) indoorGMLMap.getFutureFeature(parentId);
		}
		return feature;
	}

	public void setStateMember(List<State> stateMember) {
		if(stateMember != null && stateMember.size() != 0)
			this.stateMember = new ArrayList<String>();
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
		List<State>stateMember = null;
		if(this.stateMember != null) {
			stateMember = new ArrayList<State>();
			if (this.stateMember.size() != 0) {
				for (int i = 0; i < this.stateMember.size(); i++) {
					State found = (State) indoorGMLMap.getFeature(this.stateMember.get(i));
					if(found == null)
						found = (State)indoorGMLMap.getFutureFeature(this.stateMember.get(i));
					stateMember.add(found);
				}
			}
		}
		return stateMember;
	}
	
	public void deleteStateMember(State s) {
		if(this.stateMember != null)
			if(this.stateMember.contains(s.getId())) {
				this.stateMember.remove(s.getId());
			}
	}
	
	public void addStateMember(State s) {
		if(!this.stateMember.contains(s.getId())){
			State found = null;
			if(found != null)
				indoorGMLMap.setFutureFeature(s.getId(), s);
			this.stateMember.add(s.getId());
			//indoorGMLMap.setFeature(s.getId(), "State", s);
		}
	}
	
	public void resetStateMember(){
		this.stateMember= null;
	}

	public void resetParent() {
		this.parentId = null;
		
	}

}
