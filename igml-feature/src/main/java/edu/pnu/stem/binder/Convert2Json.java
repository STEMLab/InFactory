package edu.pnu.stem.binder;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.geom.LineString;
import com.vividsolutions.jts.geom.Point;
import com.vividsolutions.jts.geom.Polygon;
import com.vividsolutions.jts.io.ParseException;

import edu.pnu.stem.feature.CellSpace;
import edu.pnu.stem.feature.CellSpaceBoundary;
import edu.pnu.stem.feature.Edges;
import edu.pnu.stem.feature.InterEdges;
import edu.pnu.stem.feature.InterLayerConnection;
import edu.pnu.stem.feature.MultiLayeredGraph;
import edu.pnu.stem.feature.Nodes;
import edu.pnu.stem.feature.PrimalSpaceFeatures;
import edu.pnu.stem.feature.SpaceLayer;
import edu.pnu.stem.feature.SpaceLayers;
import edu.pnu.stem.feature.State;
import edu.pnu.stem.feature.Transition;
import edu.pnu.stem.geometry.jts.Solid;
import edu.pnu.stem.geometry.jts.WKTReader3D;
import edu.pnu.stem.geometry.jts.WKTWriter3D;
import edu.pnu.stem.util.GeometryUtil;

public class Convert2Json {

	public static ObjectNode convert2JSON(IndoorGMLMap map,Edges target) {
		ObjectNode result = JsonNodeFactory.instance.objectNode();
		WKTWriter3D writer = new WKTWriter3D();
		ObjectNode properties = null;
		result.put("type","Edges");

		result.put("parentId",target.getParent().getId());
		result.put("id",target.getId());
		result.put("docId", map.getDocId());

		
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
		
		if(target.getTransitionMember() != null) {
			if(properties == null) {
				properties = JsonNodeFactory.instance.objectNode();
			}
			List<String>csbl = new ArrayList<String>();
			ArrayNode array = JsonNodeFactory.instance.arrayNode();
			for(Transition b : target.getTransitionMember())
				array.add(b.getId());
			properties.set("transitionMember", array);
		}
		
		if(properties != null) {
			result.set("properties", properties);
		}
		
		return result;
	}
	public static ObjectNode convert2JSON(IndoorGMLMap map, SpaceLayer target) {
		ObjectNode result = JsonNodeFactory.instance.objectNode();
		WKTWriter3D writer = new WKTWriter3D();
		ObjectNode properties = null;
		result.put("type","SpaceLayer");

		result.put("parentId",target.getParent().getId());
		result.put("id",target.getId());
		result.put("docId", map.getDocId());

		
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
		
		if(target.getNodes() != null) {
			if(properties == null) {
				properties = JsonNodeFactory.instance.objectNode();
			}
			List<String>csbl = new ArrayList<String>();
			ArrayNode array = JsonNodeFactory.instance.arrayNode();
			for(Nodes b : target.getNodes())
				array.add(b.getId());
			properties.set("nodes", array);
		}
		
		if(target.getEdges() != null) {
			if(properties == null) {
				properties = JsonNodeFactory.instance.objectNode();
			}
			List<String>csbl = new ArrayList<String>();
			ArrayNode array = JsonNodeFactory.instance.arrayNode();
			for(Edges b : target.getEdges())
				array.add(b.getId());
			properties.set("edges", array);
		}
		
		if(properties != null) {
			result.set("properties", properties);
		}
		
		return result;
	}
	public static ObjectNode convert2JSON(IndoorGMLMap map, SpaceLayers target) {
		ObjectNode result = JsonNodeFactory.instance.objectNode();
		WKTWriter3D writer = new WKTWriter3D();
		ObjectNode properties = null;
		result.put("type","SpaceLayers");

		result.put("parentId",target.getParent().getId());
		result.put("id",target.getId());
		result.put("docId", map.getDocId());

		
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
		
		if(target.getSpaceLayerMember() != null) {
			if(properties == null) {
				properties = JsonNodeFactory.instance.objectNode();
			}
			List<String>csbl = new ArrayList<String>();
			ArrayNode array = JsonNodeFactory.instance.arrayNode();
			for(SpaceLayer b : target.getSpaceLayerMember())
				array.add(b.getId());
			properties.set("spaceLayerMember", array);
		}
		
		if(properties != null) {
			result.set("properties", properties);
		}
		
		return result;
	}
	public static ObjectNode convert2JSON(IndoorGMLMap map, InterEdges target) {
		ObjectNode result = JsonNodeFactory.instance.objectNode();
		WKTWriter3D writer = new WKTWriter3D();
		ObjectNode properties = null;
		result.put("type","InterEdges");

		result.put("parentId",target.getParent().getId());
		result.put("id",target.getId());
		result.put("docId", map.getDocId());

		
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
		
		if(target.getInterLayerConnectionMember() != null) {
			if(properties == null) {
				properties = JsonNodeFactory.instance.objectNode();
			}
			List<String>csbl = new ArrayList<String>();
			ArrayNode array = JsonNodeFactory.instance.arrayNode();
			for(InterLayerConnection b : target.getInterLayerConnectionMember())
				array.add(b.getId());
			properties.set("interLayerConnectionMember", array);
		}
		
		if(properties != null) {
			result.set("properties", properties);
		}
		
		return result;
	}
	public static ObjectNode convert2JSON(IndoorGMLMap map, InterLayerConnection target) {
		ObjectNode result = JsonNodeFactory.instance.objectNode();
		WKTWriter3D writer = new WKTWriter3D();
		ObjectNode properties = null;
		result.put("type","InterLayerConnection");

		result.put("parentId",target.getParent().getId());
		result.put("id",target.getId());
		result.put("docId", map.getDocId());

		
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
		
		if(target.getInterConnects() != null) {
			if(properties == null) {
				properties = JsonNodeFactory.instance.objectNode();
			}
			List<String>csbl = new ArrayList<String>();
			ArrayNode array = JsonNodeFactory.instance.arrayNode();
			for(State b : target.getInterConnects())
				array.add(b.getId());
			properties.set("interConnects", array);
		}
		
		if(target.getConnectedLayers() != null) {
			if(properties == null) {
				properties = JsonNodeFactory.instance.objectNode();
			}
			List<String>csbl = new ArrayList<String>();
			ArrayNode array = JsonNodeFactory.instance.arrayNode();
			for(SpaceLayer b : target.getConnectedLayers())
				array.add(b.getId());
			properties.set("connectedLayers", array);
		}
		
		if(properties != null) {
			result.set("properties", properties);
		}
		
		return result;
	}
	public static ObjectNode convert2JSON(IndoorGMLMap map, MultiLayeredGraph target) {
		ObjectNode result = JsonNodeFactory.instance.objectNode();
		WKTWriter3D writer = new WKTWriter3D();
		ObjectNode properties = null;
		result.put("type","SpaceLayer");

		result.put("parentId",target.getParent().getId());
		result.put("id",target.getId());
		result.put("docId", map.getDocId());

		
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
		
		if(target.getSpaceLayers() != null) {
			if(properties == null) {
				properties = JsonNodeFactory.instance.objectNode();
			}
			List<String>csbl = new ArrayList<String>();
			ArrayNode array = JsonNodeFactory.instance.arrayNode();
			for(SpaceLayers b : target.getSpaceLayers())
				array.add(b.getId());
			properties.set("spaceLayers", array);
		}
		
		if(target.getInterEdges() != null) {
			if(properties == null) {
				properties = JsonNodeFactory.instance.objectNode();
			}
			List<String>csbl = new ArrayList<String>();
			ArrayNode array = JsonNodeFactory.instance.arrayNode();
			for(InterEdges b : target.getInterEdges())
				array.add(b.getId());
			properties.set("interEdges", array);
		}
		
		if(properties != null) {
			result.set("properties", properties);
		}
		
		return result;
	}
	public static ObjectNode convert2JSON(IndoorGMLMap map, PrimalSpaceFeatures target) {
		ObjectNode result = JsonNodeFactory.instance.objectNode();
		WKTWriter3D writer = new WKTWriter3D();
		ObjectNode properties = null;
		result.put("type","PrimalSpaceFeatures");

		result.put("parentId",target.getParent().getId());
		result.put("id",target.getId());
		result.put("docId", map.getDocId());

		
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
		
		if(target.getCellSpaceMember() != null) {
			if(properties == null) {
				properties = JsonNodeFactory.instance.objectNode();
			}
			List<String>csbl = new ArrayList<String>();
			ArrayNode array = JsonNodeFactory.instance.arrayNode();
			for(CellSpace b : target.getCellSpaceMember())
				array.add(b.getId());
			properties.set("cellSpaceMember", array);
		}
		
		if(target.getCellSpaceBoundaryMember() != null) {
			if(properties == null) {
				properties = JsonNodeFactory.instance.objectNode();
			}
			List<String>csbl = new ArrayList<String>();
			ArrayNode array = JsonNodeFactory.instance.arrayNode();
			for(CellSpaceBoundary b : target.getCellSpaceBoundaryMember())
				array.add(b.getId());
			properties.set("cellSpaceBoundaryMember", array);
		}
		
		if(properties != null) {
			result.set("properties", properties);
		}
		
		return result;
	}
	public static ObjectNode convert2JSON(IndoorGMLMap map, Nodes target) {
		ObjectNode result = JsonNodeFactory.instance.objectNode();
		WKTWriter3D writer = new WKTWriter3D();
		ObjectNode properties = null;
		result.put("type","Nodes");

		result.put("parentId",target.getParent().getId());
		result.put("id",target.getId());
		result.put("docId", map.getDocId());

		
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
		
		if(target.getStateMember() != null) {
			if(properties == null) {
				properties = JsonNodeFactory.instance.objectNode();
			}
			List<String>csbl = new ArrayList<String>();
			ArrayNode array = JsonNodeFactory.instance.arrayNode();
			for(State b : target.getStateMember())
				array.add(b.getId());
			properties.set("stateMember", array);
		}
		
		if(properties != null) {
			result.set("properties", properties);
		}
		
		return result;
	}

	
	public static ObjectNode convert2JSON(IndoorGMLMap map, State target) {
		ObjectNode result = JsonNodeFactory.instance.objectNode();
		WKTWriter3D writer = new WKTWriter3D();
		ObjectNode properties = null;
		result.put("type","State");
		Geometry targetGeometry = target.getGeometry();
		
		if(targetGeometry != null) {
			ObjectNode geometryData = convert2GeometryJSON(targetGeometry);
			result.set("geometry", geometryData);
			//geometryData.put(fieldName, targetGeometry);
		}
		
		result.put("parentId",target.getParent().getId());
		result.put("id",target.getId());
		result.put("docId", map.getDocId());
		
		if(target.getDuality() != null) {
			if(properties == null)
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
		
		if(target.getConnects() != null) {
			if(properties == null) {
				properties = JsonNodeFactory.instance.objectNode();
			}
			List<String>csbl = new ArrayList<String>();
			ArrayNode array = JsonNodeFactory.instance.arrayNode();
			for(Transition b : target.getConnects())
				array.add(b.getId());
			properties.set("connects", array);
		}
		
		if(properties != null) {
			result.set("properties", properties);
		}
		
		return result;
	}
	public static ObjectNode convert2CellSpaceJSON(IndoorGMLMap map, CellSpace target) {
		ObjectNode result = JsonNodeFactory.instance.objectNode();
		WKTWriter3D writer = new WKTWriter3D();
		ObjectNode properties = null;
		result.put("type","CellSpace");
		Geometry targetGeometry = target.getGeometry();
		
		if(targetGeometry != null) {
			ObjectNode geometryData = convert2GeometryJSON(targetGeometry);
			result.set("geometry", geometryData);
			//geometryData.put(fieldName, targetGeometry);
		}
		
		result.put("parentId",target.getParent().getId());
		result.put("id",target.getId());
		result.put("docId", map.getDocId());
		
		if(target.getDuality() != null) {
			if(properties == null)
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
		
		if(target.getPartialboundedBy() != null) {
			if(properties == null) {
				properties = JsonNodeFactory.instance.objectNode();
			}
			List<String>csbl = new ArrayList<String>();
			ArrayNode array = JsonNodeFactory.instance.arrayNode();
			for(CellSpaceBoundary b : target.getPartialboundedBy())
				array.add(b.getId());
			properties.set("partialboundedBy", array);
		
		}
		
		if(properties != null) {
			result.set("properties", properties);
		}
		
		return result;
	} 

	public static ObjectNode convert2GeometryJSON(Geometry targetGeometry) {
		ObjectNode geometryData = JsonNodeFactory.instance.objectNode();
		ObjectNode geometryProperties = JsonNodeFactory.instance.objectNode();
		WKTWriter3D writer = new WKTWriter3D();
		
		geometryProperties.put("id", GeometryUtil.getMetadata(targetGeometry, "id"));
		geometryProperties.put("type","wkt");
		
		if(targetGeometry instanceof Solid) {
			geometryData.put("type", "Solid");
		}
		
		else if(targetGeometry instanceof Polygon) {			
			geometryData.put("type", "Surface");
			
		}
		else if(targetGeometry instanceof LineString) {
			geometryData.put("type", "Curve");
		}
		else if(targetGeometry instanceof Point) {
			geometryData.put("type", "Point");
		}
		else {
			//error
		}
		String wktGeometry = writer.write(targetGeometry);
		geometryData.put("coordinate",wktGeometry);
		geometryData.set("properties", geometryProperties);
		
		return geometryData;
	}
	

	
	public static ObjectNode convert2CellSpaceBoundaryJSON(IndoorGMLMap map, CellSpaceBoundary target) {
		ObjectNode result = JsonNodeFactory.instance.objectNode();
		WKTWriter3D writer = new WKTWriter3D();
		ObjectNode properties = null;
		result.put("type","CellSpaceBoundary");
		Geometry targetGeometry = target.getGeometry();
		
		if(targetGeometry != null) {
			ObjectNode geometryData = convert2GeometryJSON(targetGeometry);
			result.set("geometry", geometryData);
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
				else if(wktG instanceof LineString) {
					result = (LineString)wktG;
				}
				else if(wktG instanceof Point) {
					result = (Point)wktG;
				}
				else{
					//TODO : Exception
				}
			}
						
		
		
		return result;
	}
}
