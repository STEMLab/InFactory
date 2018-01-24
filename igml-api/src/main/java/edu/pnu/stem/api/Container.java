package edu.pnu.stem.api;

import java.util.concurrent.ConcurrentHashMap;
import org.springframework.stereotype.Service;
import edu.pnu.stem.binder.IndoorGMLMap;

@Service
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

	public static IndoorGMLMap getDocument(String docID) {
		if (hasDoc(docID)) {
			return docContainer.get(docID);
		} else {
			return null;
		}
	}

	public static IndoorGMLMap createDocument(String docID) {
		IndoorGMLMap map = new IndoorGMLMap();
		
		map.setDocId(docID);
		if(!docContainer.containsKey(docID)) {
			docContainer.put(docID, map);
		} else {
			//TODO : Exception
		}
		
		return map;
	}
	
	public static void removeDocument(String docID) {
		if(docContainer.containsKey(docID)) {
			docContainer.remove(docID);
		}
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

	public static Object getFeature(String docId, String id) {		
		Object newFeature = null;
		if (hasDoc(docId)) {
			IndoorGMLMap doc = docContainer.get(docId);
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

	public static void setFeature(String docId, String id, String featureName, Object featureValue) {
		IndoorGMLMap doc = docContainer.get(docId);
		if (!doc.hasID(id)) {
			doc.setFeature(id, featureName, featureValue);
		} else {
			//TODO : Exception
		}
	}
}
