package edu.pnu.stem.feature;

import java.util.ArrayList;
import java.util.List;

import edu.pnu.stem.binder.IndoorGMLMap;

/**
 * @author jungh Implements SpaceLayersType of IndoorGML 1.0.3
 */
public class SpaceLayers extends AbstractFeature {
	
	/**
	 * List of ID in String Type of SpaceLayers in spaceLayerMember for
	 * reference
	 */
	private List<String> spaceLayerMember;
	private String parentId;

	private IndoorGMLMap indoorGMLMap;
	
	public SpaceLayers(IndoorGMLMap doc){
		indoorGMLMap = doc;
	}
	
	public void setParent(MultiLayeredGraph parent) {
		MultiLayeredGraph found = null;
		found = (MultiLayeredGraph)indoorGMLMap.getFeature(indoorGMLMap.getFeatureContainer("MultiLayeredGraph"), parent.getId());
		if(found == null){
			indoorGMLMap.setFeature(parent.getId(), "MultiLayeredGraph", parent);
		}
		this.parentId = parent.getId(); 
	}

	public MultiLayeredGraph getParent() {
		MultiLayeredGraph found = null;
		found = (MultiLayeredGraph)indoorGMLMap.getFeature(indoorGMLMap.getFeatureContainer("MultiLayeredGraph"), this.parentId);
		return found;
	}

	public void setSpaceLayerMember(List<SpaceLayer> spaceLayerMember) {
		for(int i = 0 ; i < spaceLayerMember.size(); i++){
			SpaceLayer found = null;
			if(found == null){
				indoorGMLMap.setFeature(spaceLayerMember.get(i).getId(), "SpaceLayer", spaceLayerMember.get(i));
			}
			if(this.spaceLayerMember == null){
				this.spaceLayerMember = new ArrayList<String>();
			}
			if(!this.spaceLayerMember.contains(spaceLayerMember.get(i).getId())){
				this.spaceLayerMember.add(spaceLayerMember.get(i).getId());
			}
		}
	}

	public List<SpaceLayer> getSpaceLayerMember() {
		List<SpaceLayer> spaceLayerMember = new ArrayList<SpaceLayer>();
		for(int i = 0 ; i < this.spaceLayerMember.size() ; i++){
			SpaceLayer found = (SpaceLayer)indoorGMLMap.getFeature(indoorGMLMap.getFeatureContainer("SpaceLayer"), this.spaceLayerMember.get(i));
			spaceLayerMember.add(found);
		}
		return spaceLayerMember;
	}

}
