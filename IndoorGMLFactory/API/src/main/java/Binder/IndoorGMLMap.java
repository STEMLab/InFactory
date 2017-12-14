package Binder;

import java.util.concurrent.ConcurrentHashMap;

public class IndoorGMLMap {
	public static ConcurrentHashMap<String, ConcurrentHashMap<String, Object>> container;

	public IndoorGMLMap() {

		this.container = new ConcurrentHashMap<String, ConcurrentHashMap<String, Object>>();
		setFeatureClassContainer();
	}

	public static void setFeatureClassContainer() {
		ConcurrentHashMap<String, Object> idHashMap = new ConcurrentHashMap<String, Object>();
		ConcurrentHashMap<String, Object> IndoorFeatures = new ConcurrentHashMap<String, Object>();
		ConcurrentHashMap<String, Object> MultiLayeredGraph = new ConcurrentHashMap<String, Object>();
		ConcurrentHashMap<String, Object> PrimalSpaceFeatures = new ConcurrentHashMap<String, Object>();
		ConcurrentHashMap<String, Object> CellSpace = new ConcurrentHashMap<String, Object>();
		ConcurrentHashMap<String, Object> CellSpaceBoundary = new ConcurrentHashMap<String, Object>();
		ConcurrentHashMap<String, Object> SpaceLayers = new ConcurrentHashMap<String, Object>();
		ConcurrentHashMap<String, Object> SpaceLayer = new ConcurrentHashMap<String, Object>();
		ConcurrentHashMap<String, Object> Nodes = new ConcurrentHashMap<String, Object>();
		ConcurrentHashMap<String, Object> Edges = new ConcurrentHashMap<String, Object>();
		ConcurrentHashMap<String, Object> State = new ConcurrentHashMap<String, Object>();
		ConcurrentHashMap<String, Object> Transition = new ConcurrentHashMap<String, Object>();
		ConcurrentHashMap<String, Object> InterLayerConnection = new ConcurrentHashMap<String, Object>();
		ConcurrentHashMap<String, Object> InterEdges = new ConcurrentHashMap<String, Object>();
		ConcurrentHashMap<String, Object> CellSpaceGeometry = new ConcurrentHashMap<String, Object>();
		ConcurrentHashMap<String, Object> CellSpaceBoundaryGeometry = new ConcurrentHashMap<String, Object>();
		ConcurrentHashMap<String, Object> pointGeometry = new ConcurrentHashMap<String, Object>();
		ConcurrentHashMap<String, Object> curveGeometry = new ConcurrentHashMap<String, Object>();
		ConcurrentHashMap<String, Object> surfaceGeometry = new ConcurrentHashMap<String, Object>();
		ConcurrentHashMap<String, Object> solidGeometry = new ConcurrentHashMap<String, Object>();
		ConcurrentHashMap<String, Object> ExternalReference = new ConcurrentHashMap<String, Object>();
		ConcurrentHashMap<String, Object> Reference = new ConcurrentHashMap<String, Object>();
		
		container.put("id", idHashMap);
		container.put("IndoorFeatures", IndoorFeatures);
		container.put("MultiLayeredGraph", MultiLayeredGraph);
		container.put("PrimalSpaceFeatures", PrimalSpaceFeatures);
		container.put("CellSpace", CellSpace);
		container.put("CellSpaceBoundary", CellSpaceBoundary);
		container.put("SpaceLayers", SpaceLayers);
		container.put("SpaceLayer", SpaceLayer);
		container.put("Nodes", Nodes);
		container.put("Edges", Edges);
		container.put("Transition", Transition);
		container.put("InterLayerConnection", InterLayerConnection);
		container.put("InterEdges", InterEdges);
		container.put("CellSpaceGeometry", CellSpaceGeometry);
		container.put("CellSpaceBoundaryGeometry", CellSpaceBoundaryGeometry);
		container.put("Point", pointGeometry);
		container.put("Curve", curveGeometry);
		container.put("Surface", surfaceGeometry);
		container.put("Solid", solidGeometry);
		container.put("State", State);
		container.put("Reference", Reference);
	}

	public static boolean hasID(String id) {
		boolean flag = false;

		ConcurrentHashMap<String, Object> idContainer = getFeatureContainer("id");
		if (idContainer.containsKey(id)) {
			flag = true;
		}
		return flag;
	}

	public static void inputID(String id, String featureName) {

		ConcurrentHashMap<String, Object> idContainer = getFeatureContainer("id");
		idContainer.put(id, featureName);

	}

	public static String getFeatureNameFromID(String id) {
		ConcurrentHashMap<String, Object> idContainer = getFeatureContainer("id");
		String featureName = (String) idContainer.get(id);
		return featureName;
	}

	public static String getFeatureNameFromClassType(Object value) {
		String featureName = null;

		return featureName;
	}

	public static ConcurrentHashMap<String, Object> getFeatureContainer(String featureName) {
		ConcurrentHashMap<String, Object> newFeatureContainer = null;

		if (container.containsKey(featureName)) {
			newFeatureContainer = container.get(featureName);
		}

		return newFeatureContainer;
	}

	public static Object getFeature(String ID) {
		String featureName = getFeatureNameFromID(ID);
		ConcurrentHashMap<String, Object> featureContainer = getFeatureContainer(featureName);
		Object newFeature = null;
		if (featureContainer.containsKey(ID)) {
			newFeature = featureContainer.get(ID);
		}
		return newFeature;
	}

	public static void setFeature(String id, String featureName, Object featureValue) {
		if (!hasID(id)) {
			inputID(id, featureName);
			container.get(featureName).put(id, featureValue);
		} else {
			System.out.println("Newly updated feature Id : " + id);
			container.get(featureName).remove(id);
			container.get(featureName).put(id, featureValue);

		}

	}
	public static void setReference(String id){
		if(hasID(id)){
			ConcurrentHashMap<String, Object> referenceContainer = getFeatureContainer("Reference");
			if(!referenceContainer.containsKey(id)){
				referenceContainer.put(id, 1);
			}
			else{
				Integer count =(Integer) referenceContainer.get(id);
				count = count+1;
				referenceContainer.remove(id);
				referenceContainer.put(id, count);
			}
		}
	}

}
