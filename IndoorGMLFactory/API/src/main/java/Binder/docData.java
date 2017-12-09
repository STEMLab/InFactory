package Binder;

public class docData {
	public static Container docs = new Container();
	
	public static void setFeature(String docId, String id, String featureName, Object o){
		docs.setFeature(docId, id, featureName, o);
	}
	
	
}
