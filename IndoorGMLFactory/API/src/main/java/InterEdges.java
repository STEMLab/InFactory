import java.util.List;

import Binder.docData;

public class InterEdges {
	public static FeatureClassReference.InterEdges createInterEdges(String docId, String parentId, String Id, List<String>interLayerConnectionMember){
		FeatureClassReference.InterEdges newFeature = null;
		if (docData.docs.hasDoc(docId)) {
			newFeature.setID(Id);
			newFeature.setParentID(parentId);
			if(interLayerConnectionMember != null){
				newFeature.setInterLayerConnectionMember(interLayerConnectionMember);
			}
			else{
				System.out.println("Error at createInterEdges : there is no InterLayerConnectionMember");
			}
			
			docData.docs.setFeature(docId, Id, "InterEdges", newFeature);
		}
		
		return newFeature;
	}
	public static FeatureClass.InterEdges readInterEdges(String docId, String Id){
		FeatureClass.InterEdges target = null;
		return target;
	}
	public static FeatureClassReference.InterEdges updateInterEdges(String docId, String Id, String attributeType, String updateType, Object o){
		FeatureClassReference.InterEdges target = null;
		if (docData.docs.hasFeature(docId, Id)) {
			target = (FeatureClassReference.InterEdges)docData.docs.getFeature(docId, Id);
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
			docData.setFeature(docId, Id, "InterEdges", target);
		}
		return target;
	}
	public static void deleteInterEdges(String docId, String Id){}
}
