package edu.pnu.stem.binder;

import java.io.IOException;
import java.util.Enumeration;
import java.util.concurrent.ConcurrentHashMap;

import javax.xml.bind.JAXBException;

import com.vividsolutions.jts.geom.Geometry;

import edu.pnu.stem.feature.IndoorFeatures;
import edu.pnu.stem.util.GeometryUtil;
import net.opengis.indoorgml.core.v_1_0.IndoorFeaturesType;

public class IndoorGMLMap {
	private ConcurrentHashMap<String, ConcurrentHashMap<String, Object>> container;
	private String docId;
	
	public IndoorGMLMap() {
		this.container = new ConcurrentHashMap<String, ConcurrentHashMap<String, Object>>();
		setFeatureClassContainer();
	}

	private void setFeatureClassContainer() {
		
		container.put("ID", new ConcurrentHashMap<String,Object>());
		container.put("FutureID", new ConcurrentHashMap<String,Object>());
		container.put("IndoorFeatures", new ConcurrentHashMap<String,Object>());
		container.put("MultiLayeredGraph", new ConcurrentHashMap<String,Object>());
		container.put("PrimalSpaceFeatures", new ConcurrentHashMap<String,Object>());
		container.put("CellSpace", new ConcurrentHashMap<String,Object>());
		container.put("CellSpaceBoundary", new ConcurrentHashMap<String,Object>());
		container.put("SpaceLayers", new ConcurrentHashMap<String,Object>());
		container.put("SpaceLayer", new ConcurrentHashMap<String,Object>());
		container.put("Nodes", new ConcurrentHashMap<String,Object>());
		container.put("Edges", new ConcurrentHashMap<String,Object>());
		container.put("Transition", new ConcurrentHashMap<String,Object>());
		container.put("InterLayerConnection", new ConcurrentHashMap<String,Object>());
		container.put("InterEdges", new ConcurrentHashMap<String,Object>());
		container.put("CellSpaceGeometry", new ConcurrentHashMap<String,Object>());
		container.put("CellSpaceBoundaryGeometry", new ConcurrentHashMap<String,Object>());
		container.put("Point", new ConcurrentHashMap<String,Object>());
		container.put("Curve", new ConcurrentHashMap<String,Object>());
		container.put("Surface", new ConcurrentHashMap<String,Object>());
		container.put("Solid", new ConcurrentHashMap<String,Object>());
		container.put("State", new ConcurrentHashMap<String,Object>());
		container.put("Reference", new ConcurrentHashMap<String,Object>());
		container.put("Envelope", new ConcurrentHashMap<String,Object>());
		container.put("Geometry", new ConcurrentHashMap<String,Object>());
		
	}

	public boolean hasID(String id) {
		boolean flag = false;
		ConcurrentHashMap<String, Object> idContainer = getFeatureContainer("ID");
		if (idContainer.containsKey(id)) {
			flag = true;
		}
		return flag;
	}
	
	public boolean hasFutureID(String id){
		boolean flag = false;
		ConcurrentHashMap<String, Object> idContainer = getFeatureContainer("FutureID");
		if (idContainer.containsKey(id)) {
			flag = true;
		}
		return flag;
	}
	
	public void setFutureFeature(String id, String featureName){
		if(!hasID(id)){
			container.get("FutureFeature").put(id, featureName);
		}
	}
	
	private void setID(String id, String featureName) {
		if(!hasID(id)){
			getFeatureContainer("ID").put(id, featureName);
		}
	}
	
	public void removeFutureID(String id){
		getFeatureContainer("FutureID").remove(id);
	}
	
	private void removeID(String id){
		getFeatureContainer("ID").remove(id);
	}
	
	public String getFeatureNameFromID(String id) {
		ConcurrentHashMap<String, Object> idContainer = getFeatureContainer("id");
		String featureName = (String) idContainer.get(id);
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
		if(hasID(id)){
			String typeName = (String) getFeatureContainer("ID").get(id);
			newFeature = container.get(typeName).get(id);
		} else {
			//TODO
			//Excpetion
		}
		return newFeature;
	}
	
	public Geometry getFeature4Geometry(String id){
		ConcurrentHashMap<String,Object> geomContainer = container.get("Geometry");
		Geometry geom = null;
		if(geomContainer.containsKey(id)){
			geom = (Geometry)geomContainer.get(id);
		}
		else{
			//TODO
			//Excpetion
		}
		return geom;
	}
	public void setFeature4Geometry(String id, Geometry geom){
		GeometryUtil.setMetadata(geom, "id", id);
		ConcurrentHashMap<String,Object> geomContainer = container.get("Geometry");
		if(!geomContainer.containsKey(id)){
			geomContainer.put(id, geom);
		}
		else{
			//TODO
			//Excpetion
		}
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
				Mashaller.marshalIndoorFeatures(path, resultDoc);
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
