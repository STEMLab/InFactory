package edu.pnu.stem.feature;

import java.util.ArrayList;
import java.util.List;

import edu.pnu.stem.binder.Container;

/**
 * @author jungh Implements SpaceLayersType of IndoorGML 1.0.3
 */
public class SpaceLayers extends AbstractFeature {
	
	private String docId;
	/**
	 * List of ID in String Type of SpaceLayers in spaceLayerMember for
	 * reference
	 */
	private List<String> spaceLayerMemeber;
	private String parentId;

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
