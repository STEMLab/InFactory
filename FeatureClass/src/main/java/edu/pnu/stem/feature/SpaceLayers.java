package edu.pnu.stem.feature;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jungh Implements SpaceLayersType of IndoorGML 1.0.3
 */
public class SpaceLayers extends AbstractFeature {
	/**
	 * List of ID in String Type of SpaceLayers in spaceLayerMember for
	 * reference
	 */
	List<String> spaceLayerMemeber;
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

	public void setSpaceLayerMember(List<SpaceLayer> spaceLayerMember) {
		for(int i = 0 ; i < spaceLayerMember.size(); i++){
			SpaceLayer found = null;
			if(found == null){
				IndoorGMLMap.setFeature(spaceLayerMember.get(i).getId(), "SpaceLayer", spaceLayerMember.get(i));
			}
			if(!this.spaceLayerMemeber.contains(spaceLayerMember.get(i).getId())){
				this.spaceLayerMemeber.add(spaceLayerMember.get(i).getId());
			}
		}
	}

	public List<SpaceLayer> getSpaceLayerMember() {
		List<SpaceLayer> spaceLayerMember = new ArrayList<SpaceLayer>();
		for(int i = 0 ; i < this.spaceLayerMemeber.size() ; i++){
			SpaceLayer found = (SpaceLayer)IndoorGMLMap.getFeature(IndoorGMLMap.getFeatureContainer("SpaceLayer"), this.spaceLayerMemeber.get(i));
			spaceLayerMember.add(found);
		}
		return spaceLayerMember;
	}

}
