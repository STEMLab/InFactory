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
	public static FeatureClassReference.InterEdges updateInterEdges(String docId, String Id, String attributeType, String updateType, Object o){}
	public static void deleteInterEdges(String docId, String Id){}
}
