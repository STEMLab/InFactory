package edu.pnu.stem.dao;
import java.util.ArrayList;
import java.util.List;

import edu.pnu.stem.api.Container;
import edu.pnu.stem.binder.IndoorGMLMap;
import edu.pnu.stem.feature.MultiLayeredGraph;
import edu.pnu.stem.feature.SpaceLayer;
import edu.pnu.stem.feature.SpaceLayers;

public class SpaceLayersDAO {
	public static SpaceLayers createSpaceLayers(String docId, String parentId, String id,
			List<String> spaceLayerMember) {
		SpaceLayers newFeature = null;
		if (Container.getInstance().hasDoc(docId)) {
			IndoorGMLMap map = Container.getInstance().getDocument(docId);
			newFeature.setId(id);
			MultiLayeredGraph parent = new MultiLayeredGraph(map);
			parent.setId(parentId);
			newFeature.setParent(parent);
			if (spaceLayerMember!= null) {
				List<SpaceLayer>tempSpaceLayerMember = new ArrayList<SpaceLayer>();
				for(int i = 0 ; i < spaceLayerMember.size(); i++){
					SpaceLayer temp = new SpaceLayer(map);
					temp.setId(id);
					tempSpaceLayerMember.add(temp);
				}
				newFeature.setSpaceLayerMember(tempSpaceLayerMember);
				map.setFeature(id, "SpaceLayers", newFeature);
			}
			else if(spaceLayerMember == null){
				System.out.println("Error at createSpaceLayers : there is no enough SpaceLayerType instance");
			}
		}
		return newFeature;
	}
	/**
	 * Search SpaceLayer feature in document
	 * @param ID ID of target
	 * @return searched SpaceLayer feature instance
	 */


	/**
	 * Search SpaceLayer feature and edit it as the Parameters
	 * @param id ID of target
	 * @param usage Comment on usage
	 * @param function explanation about functionality of this SpaceLayer
	 * @param createDate the time when this SpaceLayer is created
	 * @param terminationDate the time when this SpaceLayer is expired
	 * @param n nodes which is contained in this SpaceLayer
	 * @param e	edges which is contained in this SpaceLayer
	 * @param ct SpaceLayerClassType of this SpaceLayer
	 * @return edited SpaceLayer feature instance
	 */
	public static SpaceLayers updatePrimalSpaceFeatures(String docId, String Id, String attributeType,
			String updateType, List<String>objectMember, Object object , Boolean deleteDuality ) {
		SpaceLayers target = null;
		if (Container.getInstance().hasFeature(docId, Id)) {
			target = (SpaceLayers) Container.getInstance().getFeature(docId, Id);
			if (attributeType.equals("spaceLayerMember")) {
				List<SpaceLayer>spaceLayerMember = target.getSpaceLayerMember();
				if(updateType.equals("add")){
					
					//spaceLayerMember.addAll(objectMember);
				}
				//TODO : add cellSpace to cellSpace container and ID container
				else if(updateType.equals("delete")){
					for(int i = 0 ; i < objectMember.size();i++){
						if(spaceLayerMember.contains(objectMember.get(i))){
							spaceLayerMember.remove(objectMember.get(i));
							StateDAO.deleteState(docId, objectMember.get(i), deleteDuality);
						}
					}
				//TODO : remove cellSpace at cellSpace container and ID container?
				}
				if(spaceLayerMember.size() == 0){
					System.out.println("Error at updateSpaceLayer : there should be at least on NodesType instance at SpaceLayer");
				}
				else
					target.setSpaceLayerMember(spaceLayerMember);
			}
			else {
				System.out.println("update error in updateSpaceLayers : there is no such attribute name");
			}
		} else {
			System.out.println("there is no name with Id :" + Id + " in document Id : " + docId);
		}
		Container.getInstance().setFeature(docId, Id, "SpaceLayer", target);
		return target;
	}
	/**
	 * Search SpaceLayer feature and delete it
	 * @param id ID of target
	 */
	public static void deleteSpaceLayers(String docId, String Id,Boolean deleteDuality) {
		if (Container.getInstance().hasFeature(docId, Id)) {
			IndoorGMLMap doc = Container.getInstance().getDocument(docId);
			SpaceLayers target = (SpaceLayers) Container.getInstance().getFeature(docId,
					Id);
			// String duality = target.getd;
			doc.getFeatureContainer("SpaceLayers").remove(Id);
			doc.getFeatureContainer("ID").remove(Id);
			
			List<SpaceLayer>spaceLayerMember = target.getSpaceLayerMember();			
			for(int i = 0 ; i < spaceLayerMember.size();i++){
				SpaceLayerDAO.deleteSpaceLayer(docId, spaceLayerMember.get(i).getId(), deleteDuality);
				
			}
			
			
		}
	}
}
