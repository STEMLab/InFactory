package edu.pnu.stem.api;
import java.util.List;

import edu.pnu.stem.binder.Container;
import edu.pnu.stem.binder.IndoorGMLMap;

public class InterEdges {
	public static edu.pnu.stem.feature.InterEdges createInterEdges(String docId, String parentId, String Id, List<String>interLayerConnectionMember){
		edu.pnu.stem.feature.InterEdges newFeature = null;
		if (Container.getInstance().hasDoc(docId)) {
			newFeature.setID(Id);
			
			newFeature.setParentID(parentId);
			if(interLayerConnectionMember != null){
				newFeature.setInterLayerConnectionMember(interLayerConnectionMember);
			}
			else{
				System.out.println("Error at createInterEdges : there is no InterLayerConnectionMember");
			}
			Container.getInstance().setFeature(docId, Id, "ID", "InterEdges");
			Container.getInstance().setFeature(docId, Id, "InterEdges", newFeature);
		}
		
		return newFeature;
	}
	public static edu.pnu.stem.feature.InterEdges readInterEdges(String docId, String Id){
		edu.pnu.stem.feature.InterEdges target = null;
		return target;
	}
	public static edu.pnu.stem.feature.InterEdges updateInterEdges(String docId, String Id, String attributeType, String updateType, Object o){
		edu.pnu.stem.feature.InterEdges target = null;
		if (Container.getInstance().hasFeature(docId, Id)) {
			target = (edu.pnu.stem.feature.InterEdges)Container.getInstance().getFeature(docId, Id);
			if(attributeType.equals("interLayerConnectionMember")){
				List<String>interLayerConnectionMember = target.getInterLayerConnectionMember();
				if(updateType != null){
					List<String>object = (List<String>)o;	
					if(updateType.equals("add")){
						interLayerConnectionMember.addAll((List<String>)object);
					}
					else if(updateType.equals("remove")){
						for(int i = 0 ; i < object.size();i++){
							if(interLayerConnectionMember.contains(object.get(i))){
								interLayerConnectionMember.remove(object.get(i));
								InterLayerConnection.deleteInterLayerConnection(docId, Id);
							}
							
						}
					}
				}
				if(interLayerConnectionMember.size() != 0){
					target.setInterLayerConnectionMember(interLayerConnectionMember);
				}
				else
					System.out.println("Error at updateInterEdges : empty stateMember cannot be submited");
				
			}
			Container.getInstance().setFeature(docId, Id, "InterEdges", target);
		}
		return target;
	}
	public static void deleteInterEdges(String docId, String Id){
		if (Container.getInstance().hasFeature(docId, Id)) {
			IndoorGMLMap doc = Container.getInstance().getDocument(docId);
			edu.pnu.stem.feature.InterEdges target = (edu.pnu.stem.feature.InterEdges) Container.getInstance().getFeature(docId,
					Id);
			// String duality = target.getd;
			doc.getFeatureContainer("InterEdges").remove(Id);
			doc.getFeatureContainer("ID").remove(Id);
			for(int i = 0 ; i < target.getInterLayerConnectionMember().size();i++){
				InterLayerConnection.deleteInterLayerConnection(docId, target.getInterLayerConnectionMember().get(i));
			}
			
		}
	}
}
