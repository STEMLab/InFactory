package edu.pnu.stem.binder;

import java.util.UUID;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.geom.Polygon;
import com.vividsolutions.jts.io.ParseException;

import edu.pnu.stem.feature.CellSpace;
import edu.pnu.stem.geometry.jts.Solid;
import edu.pnu.stem.geometry.jts.WKTReader3D;
import edu.pnu.stem.geometry.jts.WKTWriter3D;
import edu.pnu.stem.util.GeometryUtil;

public class Convert2Json {
	public static ObjectNode convert2CellSpaceJSON(IndoorGMLMap map, CellSpace target) {
		ObjectNode result = JsonNodeFactory.instance.objectNode();
		WKTWriter3D writer = new WKTWriter3D();
		ObjectNode properties = null;
		result.put("type","CellSpace");
		Geometry targetGeometry = target.getGeometry();
		
		if(targetGeometry != null) {
			ObjectNode geometryData = JsonNodeFactory.instance.objectNode();
			ObjectNode geometryProperties = JsonNodeFactory.instance.objectNode();
			
			
			geometryProperties.put("id", GeometryUtil.getMetadata(targetGeometry, "id"));
			geometryProperties.put("type","wkt");
			
			if(targetGeometry instanceof Solid) {			
				geometryData.put("type", "Solid");
				
			}
			else if(targetGeometry instanceof Polygon) {
				geometryData.put("type", "Polygon");
			}
			else {
				//error
			}
			String wktGeometry = writer.write(targetGeometry);
			geometryData.put("coordinate",wktGeometry);
			geometryData.set("properties", geometryProperties);
			result.set("geometry", geometryData);
			//geometryData.put(fieldName, targetGeometry);
		}
		
		result.put("parentId",target.getParent().getId());
		result.put("id",target.getId());
		result.put("docId", map.getDocId());
		
		if(target.getDuality() != null) {
			properties = JsonNodeFactory.instance.objectNode();
			properties.put("duality", target.getDuality().getId());
			
		}
		
		if(target.getName() != null) {
			if(properties == null) {
				properties = JsonNodeFactory.instance.objectNode();
			}
			properties.put("name", target.getName());
		}
		
		if(target.getDescription() != null) {
			if(properties == null) {
				properties = JsonNodeFactory.instance.objectNode();
			}
			properties.put("description", target.getDescription());
		}
		
		if(properties != null) {
			result.set("properties", properties);
		}
		
		return result;
	} 
	public static Geometry json2Geometry(JsonNode geometry) {
		Geometry result = null;
			/*
			 * String geometryType = geometry.get("properties").get("type").asText().trim();				
				JsonNode solid = Convert2GeoJsonGeometry.convert2GeoJson(geometry, geometryType);
				GeoJSON3DReader reader = new GeoJSON3DReader();
				Solid resultSolid = (Solid)reader.read(solid.toString());
				map.setFeature4Geometry(geometry.get("properties").get("id").asText().trim(), resultSolid);
				newFeature.setGeometry(resultSolid);
			 * */
			WKTReader3D wkt = new WKTReader3D();
			Geometry wktG = null;
			if(geometry.has("coordinates")){			
				try {					
					wktG = wkt.read(geometry.get("coordinates").asText().trim());
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else{
				//WKT directly
				try{
					wktG = wkt.read(geometry.asText().trim());
				}catch (ParseException e) {
					e.printStackTrace();
				}
			}
			String geometryId = null;
			if(geometry.has("properties")){
				if(geometry.get("properties").has("id")){
					geometryId = geometry.get("properties").get("id").asText().trim();
				}
			}
			if(geometryId == null){
				geometryId = UUID.randomUUID().toString();
			}
			if(wktG != null){
				if(wktG instanceof Solid){
					result = (Solid)wktG;
				}
				else if(wktG instanceof Polygon){
					result = (Polygon)wktG;
					
				}
				else{
					//TODO : Exception
				}
			}
						
		
		
		return result;
	}
}
