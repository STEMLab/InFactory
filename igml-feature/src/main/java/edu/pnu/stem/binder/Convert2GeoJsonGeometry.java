package edu.pnu.stem.binder;

import com.fasterxml.jackson.databind.JsonNode;

public class Convert2GeoJsonGeometry {

	public JsonNode convert2GeoJson(JsonNode geometry){
		JsonNode result = null;
		String geometryType = geometry.get("type").asText().trim();
		if(geometryType.equals("Solid")){
			result = convert2Solid3D(geometry);
		}
		else if(geometryType.equals("Surface")){
			if(geometry.get("propertie").get("extrude").asText().trim().equals("true")){
				result = convert2Surface3D(geometry);
			}
			else if(geometry.get("propertie").get("extrude").asText().trim().equals("false")){
				result = convert2Surface2D(geometry);
			}
			else{
				System.out.println("GeoJson : there is no extrude information");
			}
		}
		else if(geometryType.equals("Curve")){
			result = convert2Curve2D(geometry);
		}
		else if(geometryType.equals("Point")){
			result = convert2Point2D(geometry);
		}
		else{
			System.out.println("GeoJson : Not defined Geometry");
		}
		
		return result;
	}
	public JsonNode convert2Solid3D(JsonNode geometry){
		JsonNode result = null;
		return result;
	}
	public JsonNode convert2Surface3D(JsonNode geometry){
		JsonNode result = null;
		return result;
	}
	public JsonNode convert2Surface2D(JsonNode geometry){
		JsonNode result = null;
		return result;
	}
	public JsonNode convert2Curve2D(JsonNode geometry){
		JsonNode result = null;
		return result;
	}
	public JsonNode convert2Point2D(JsonNode geometry){
		JsonNode result = null;
		return result;
	}
	
}
