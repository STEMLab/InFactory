package edu.pnu.stem.feature;

import java.util.ArrayList;
import java.util.List;

import edu.pnu.stem.binder.Container;

public class Nodes extends AbstractFeature {
	
	private String docId;
	/**
	 * State list which this feature contains
	 */
	private List<String> stateMember;

	private String parentId;

	public void setParent(SpaceLayer parent) {
		SpaceLayer found = null;
		found = (SpaceLayer)IndoorGMLMap.getFeature(IndoorGMLMap.getFeatureContainer("SpaceLayer"), parent.getId());
		if( found == null ){
			IndoorGMLMap.setFeature(parent.getId(), "SpaceLayer", parent );
		}
		this.parentId = parent.getId();
	}
	
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
	
	public SpaceLayer getParent() {
		SpaceLayer feature = null;
		feature = (SpaceLayer) IndoorGMLMap.getFeature(IndoorGMLMap.getFeatureContainer("SpaceLayer"),
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
