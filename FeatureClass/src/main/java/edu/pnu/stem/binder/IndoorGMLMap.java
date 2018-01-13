package edu.pnu.stem.binder;

import java.io.IOException;
import java.util.Enumeration;
import java.util.concurrent.ConcurrentHashMap;

import javax.xml.bind.JAXBException;

import edu.pnu.stem.feature.IndoorFeatures;
import net.opengis.indoorgml.core.v_1_0.IndoorFeaturesType;

public class IndoorGMLMap {
	private ConcurrentHashMap<String, ConcurrentHashMap<String, Object>> container;
	private String docId;
	
	public IndoorGMLMap() {
		this.container = new ConcurrentHashMap<String, ConcurrentHashMap<String, Object>>();
		setFeatureClassContainer();
	}

	private void setFeatureClassContainer() {
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
		
		container.put("ID", idHashMap);
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
		container.put("Envelope", new ConcurrentHashMap<String,Object>());
	}

	public boolean hasID(String id) {
		boolean flag = false;
		ConcurrentHashMap<String, Object> idContainer = getFeatureContainer("ID");
		if (idContainer.containsKey(id)) {
			flag = true;
		}
		return flag;
	}
	
	public void setID(String id, String featureName) {
		if(!hasID(id)){
			getFeatureContainer("ID").put(id, featureName);
		}
	}
	
	public void removeID(String id){
		getFeatureContainer("ID").remove(id);
	}
	
	public String getFeatureNameFromID(String id) {
		ConcurrentHashMap<String, Object> idContainer = getFeatureContainer("id");
		String featureName = (String) idContainer.get(id);
		return featureName;
	}

	public String getFeatureNameFromClassType(Object value) {
		String featureName = null;

		return featureName;
	}

	public ConcurrentHashMap<String, Object> getFeatureContainer(String featureName) {
		ConcurrentHashMap<String, Object> newFeatureContainer = null;

		if (container.containsKey(featureName)) {
			newFeatureContainer = container.get(featureName);
		}

		return newFeatureContainer;
	}

	/*
	public static Object getFeature(String id) {
		return Container.getInstance().getFeature(docId, id);
	}
	*/
	
	public Object getFeature(String id){
		Object newFeature = null;
		newFeature = container.get(id);
		return newFeature;
	}

	
	public void setFeature(String id,String featureName, Object featureValue){
		if(!hasID(id)){
			setID(id,featureName);
			container.get(featureName).put(id, featureValue);
		}
		else{
			System.out.println("Already Exist Id");
			container.get(featureName).put(id, featureValue);
		}		
	}
	
	public void deleteFeature(String id, String featureName){
		if(hasID(id)){
			getFeatureContainer(featureName).remove(id);
			removeID(id);
		}
	}
	
	public void setReference(String id){
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

	public void setDocId(String id) {
		this.docId = id;		
	}
	public String getDocId(){
		return new String(this.docId);
	}
	
	public void Marshall(String path) {
		
		Enumeration<Object> fe = container.get("IndoorFeatures").elements();
		IndoorFeatures features = null;
		if(fe.hasMoreElements()) {
			features = (IndoorFeatures) fe.nextElement();
			
			IndoorFeaturesType resultDoc;
			try {
				resultDoc = edu.pnu.stem.binder.Convert2JaxbClass.change2JaxbClass(this, features);
				Mashaller.marshalIndoorFeatures(this.docId, resultDoc);
			} catch (JAXBException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			//TODO
			//Exception
		}
	}

}
