package edu.pnu.stem.feature;

import java.util.ArrayList;
import java.util.List;

import edu.pnu.stem.binder.IndoorGMLMap;

/**
 * @author jungh Implements EdgesType of IndoorGML 1.0.3
 */
public class Edges extends AbstractFeature{
	
	/**
	 * contains list of Transitions as list
	 */
	private List<String> transitionMember;

	private String parentId;
	
	public Edges(IndoorGMLMap doc, String id){
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
		return feature;
	}

	public void setTransitionMembers(List<Transition> transitionMember) {
		if(transitionMember != null && transitionMember.size()!= 0)
			this.transitionMember = new ArrayList<String>();
		for(int i = 0 ; i < transitionMember.size(); i++){
			Transition found = null;
			found = (Transition) indoorGMLMap.getFeature(transitionMember.get(i).getId());
			if(found == null){
				indoorGMLMap.setFutureFeature(transitionMember.get(i).getId(), transitionMember.get(i));
			}
			if(this.transitionMember == null){
				this.transitionMember = new ArrayList<String>();
			}
			if(!this.transitionMember.contains(transitionMember.get(i).getId())){
				this.transitionMember.add(transitionMember.get(i).getId());
			}
		}
	}

	public List<Transition> getTransitionMember() {
		List<Transition> transitionMember = null;
		if(this.transitionMember != null && this.transitionMember.size() != 0)
			transitionMember = new ArrayList<Transition>();
		if (this.transitionMember.size() != 0) {
			for (int i = 0; i < this.transitionMember.size(); i++) {
				Transition found = (Transition) indoorGMLMap.getFeature(this.transitionMember.get(i));
				if(found == null)
					found = (Transition)indoorGMLMap.getFutureFeature(this.transitionMember.get(i));
				transitionMember.add(found);
			}
		}
		return transitionMember;
	}
	
	public void cleanTransitionMember(){
		this.transitionMember.clear();
	}

	public void addTransitionMember(Transition t) {
		if(!this.transitionMember.contains(t.getId())){
			this.transitionMember.add(t.getId());
			
			//TODO : check duplicated id
			indoorGMLMap.setFeature(t.getId(), "Transition", t);
		}
	}

	public void deleteTransitionMember(Transition t) {
		if(this.transitionMember.contains(t.getId()))
			this.transitionMember.remove(t.getId());
		
	}

	public void resetParent() {
		this.parentId = null;
		
	}


}
