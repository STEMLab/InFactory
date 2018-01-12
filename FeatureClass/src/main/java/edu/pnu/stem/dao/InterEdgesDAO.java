package edu.pnu.stem.dao;
import java.util.ArrayList;
import java.util.List;

import edu.pnu.stem.api.Container;
import edu.pnu.stem.binder.IndoorGMLMap;
import edu.pnu.stem.feature.InterEdges;
import edu.pnu.stem.feature.InterLayerConnection;
import edu.pnu.stem.feature.MultiLayeredGraph;

public class InterEdgesDAO {
	public static InterEdges createInterEdges(String docId, String parentId, String Id, List<String>interLayerConnectionMember){
		InterEdges newFeature = null;
		if (Container.getInstance().hasDoc(docId)) {
			IndoorGMLMap map = Container.getInstance().getDocument(docId);
			newFeature.setId(Id);
			MultiLayeredGraph parent = new MultiLayeredGraph(map);
			parent.setId(parentId);
			newFeature.setParent(parent);
			
			if(interLayerConnectionMember != null){
				List<InterLayerConnection>tempList = new ArrayList<InterLayerConnection>();
				for(int i = 0 ; i < interLayerConnectionMember.size() ; i++){
					InterLayerConnection temp = new InterLayerConnection(map);
					temp.setId(interLayerConnectionMember.get(i));
					tempList.add(temp);
				}
				newFeature.setInterLayerConnectionMember(tempList);
			}
			else{
				System.out.println("Error at createInterEdges : there is no InterLayerConnectionMember");
			}
			map.setFeature(Id, "ID", "InterEdges");
			map.setFeature(Id, "InterEdges", newFeature);
		}
		
		return newFeature;
	}
	public static InterEdges readInterEdges(String docId, String Id){
		InterEdges target = null;
		return target;
	}
	public static InterEdges updateInterEdges(String docId, String Id, String attributeType, String updateType, Object o){
		InterEdges target = null;
		if (Container.getInstance().hasFeature(docId, Id)) {
			IndoorGMLMap map = Container.getInstance().getDocument(docId);
			target = (InterEdges)map.getFeature(Id);
			if(attributeType.equals("interLayerConnectionMember")){
				List<InterLayerConnection>interLayerConnectionMember = target.getInterLayerConnectionMember();
				List<InterLayerConnection>newInterLayerConnectionMember = new ArrayList<InterLayerConnection>();
				if(updateType != null){
					List<String>object = (List<String>)o;
					for(int i = 0 ; i < object.size(); i++){
						InterLayerConnection temp = new InterLayerConnection(map);
						temp.setId(object.get(i));
					}
					if(updateType.equals("add")){
						target.setInterLayerConnectionMember(newInterLayerConnectionMember);
					}					
					
					else if(updateType.equals("remove")){
						for(int i = 0 ; i < object.size();i++){
							if(interLayerConnectionMember.contains(object.get(i))){
								interLayerConnectionMember.remove(object.get(i));
								InterLayerConnectionDAO.deleteInterLayerConnection(docId,object.get(i));
							}
						}
						target.clearInterLayerConnectionMember();
					}
					if(interLayerConnectionMember.size() != 0){
						target.setInterLayerConnectionMember(interLayerConnectionMember);
					}
					else
						System.out.println("Error at updateInterEdges : empty stateMember cannot be submited");
				}				
			}
			map.setFeature(Id, "InterEdges", target);
		}
		return target;
	}
	public static void deleteInterEdges(String docId, String Id){
		if (Container.getInstance().hasFeature(docId, Id)) {
			IndoorGMLMap doc = Container.getInstance().getDocument(docId);
			InterEdges target = (InterEdges) Container.getInstance().getFeature(docId,
					Id);
			// String duality = target.getd;
			doc.getFeatureContainer("InterEdges").remove(Id);
			doc.getFeatureContainer("ID").remove(Id);
			for(int i = 0 ; i < target.getInterLayerConnectionMember().size();i++){
				InterLayerConnectionDAO.deleteInterLayerConnection(docId, target.getInterLayerConnectionMember().get(i).getId());
			}
			
		}
	}
}
