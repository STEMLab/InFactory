package edu.pnu.stem.binder;

import java.util.concurrent.ConcurrentHashMap;

public class Container {
	private static Container docs = new Container();
	private static ConcurrentHashMap<String, IndoorGMLMap> docContainer = new ConcurrentHashMap<String, IndoorGMLMap>();
	
	/**
	 * @return the container
	 */
	public static Container getInstance() {
		return docs;
	}

	public ConcurrentHashMap<String, IndoorGMLMap> getContainer() {
		return docContainer;
	}

	/**
	 * @param container
	 *            the container to set
	 */


	public static void setDocument(String docID) {
		IndoorGMLMap map = new IndoorGMLMap();
		map.setDocId(docID);
		Container.getInstance().docContainer.put(docID, map);
		
	}
	
	public static void setDocument(String docId, IndoorGMLMap map){
		map.setDocId(docId);
		Container.getInstance().docContainer.put(docId, map);
	}
	
	public static boolean hasDoc(String ID) {
		if (Container.getInstance().docContainer.containsKey(ID))
			return true;
		else
			return false;
	}

	public static boolean hasFeature(String docId, String Id) {
		if (hasDoc(docId)) {
			IndoorGMLMap doc = Container.getInstance().docContainer.get(docId);
			if (doc.hasID(Id)) {
				return true;
			}
		}

		return false;
	}

	public static Object getFeature(String docId, String id) {		
		Object newFeature = null;
		if (hasDoc(docId)) {
			IndoorGMLMap doc = Container.getInstance().docContainer.get(docId);
			if (doc.hasID(id)) {
				String featureName = doc.getFeatureNameFromID(id);
				ConcurrentHashMap<String, Object> featureContainer = doc.getFeatureContainer(featureName);				
				if (featureContainer.containsKey(id)) {
					newFeature = featureContainer.get(id);
				}
			}

		}
		return newFeature;
	}

	public static IndoorGMLMap getDocument(String docID) {
		if (hasDoc(docID)) {
			return Container.getInstance().docContainer.get(docID);
		} else
			return null;
	}

	public static void setFeature(String docId, String id, String featureName, Object featureValue) {
		IndoorGMLMap doc = Container.getInstance().docContainer.get(docId);
		if (!doc.hasID(id)) {
			doc.inputID(id, featureName);
			doc.container.get(featureName).put(id, featureValue);
		} else {
			System.out.println("Newly updated feature Id : " + id);
			doc.container.get(featureName).remove(id);
			doc.container.get(featureName).put(id, featureValue);

		}
		//doc.setFeature(id, featureName, o);
	}
}
