package edu.pnu.stem.binder;

import java.util.concurrent.ConcurrentHashMap;

public class Container {
	private static Container docs = new Container();
	public static ConcurrentHashMap<String, IndoorGMLMap> docContainer = new ConcurrentHashMap<String, IndoorGMLMap>();

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


	public void setDocument(String docID) {
		IndoorGMLMap map = new IndoorGMLMap();
		docContainer.put(docID, map);
	}


	public static boolean hasDoc(String ID) {
		if (docContainer.containsKey(ID))
			return true;
		else
			return false;
	}

	public static boolean hasFeature(String docId, String Id) {
		if (hasDoc(docId)) {
			IndoorGMLMap doc = docContainer.get(docId);
			if (doc.hasID(Id)) {
				return true;
			}
		}

		return false;
	}

	public static Object getFeature(String docId, String Id) {
		Object o = null;
		if (hasDoc(docId)) {
			IndoorGMLMap doc = docContainer.get(docId);
			if (doc.hasID(Id)) {
				o = doc.getFeature(Id);
			}

		}
		return o;
	}

	public IndoorGMLMap getDocument(String docID) {
		if (hasDoc(docID)) {
			return docContainer.get(docID);
		} else
			return null;
	}

	public static void setFeature(String docId, String id, String featureName, Object o) {
		IndoorGMLMap doc = docContainer.get(docId);
		doc.setFeature(id, featureName, o);
	}
}
