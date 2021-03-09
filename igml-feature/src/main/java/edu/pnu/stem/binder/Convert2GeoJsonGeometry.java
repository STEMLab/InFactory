package edu.pnu.stem.binder;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class Convert2GeoJsonGeometry {

	public static JsonNode convert2GeoJson(JsonNode geometry, String featureType){
		JsonNode result = null;
		String geometryType = geometry.get("type").asText().trim();
		ObjectMapper mapper = new ObjectMapper();
		ObjectNode jsonNode = mapper .createObjectNode();

		if(geometryType.equals("Solid")||(geometryType.equals("Surface") && geometry.get("properties").get("extrude").asText().trim().equals("true"))){
			result = convert2Solid3D(geometry);
			jsonNode.put("type", "Solid");
			jsonNode.set("coordinates", result);
		}
		else if(geometryType.equals("Surface")){
			if(geometry.get("properties").get("extrude").asText().trim().equals("true")){
				result = convert2Surface3D(geometry);
			}
			else if(geometry.get("properties").get("extrude").asText().trim().equals("false")){
				result = convert2Surface2D(geometry);
			}
			else{
				System.out.println("GeoJson : there is no extrude information");
			}
		}
		//else if(geometryType.equals("Curve")){
		else if(geometryType.equals("LineString")){
			if(featureType.equals("CellSpaceBoundary")){
				if(geometry.get("properties").get("extrude").asText().trim().equals("true")){
					result = convert2ExtrudedCurve3D(geometry);
					jsonNode.put("type", "Polygon");
					jsonNode.set("coordinates", result);
				}
				else if(geometry.get("properties").get("extrude").asText().trim().equals("false")){
					result = convert2Curve2D(geometry);
				}
			}
			else if(featureType.equals("Transition")){
				result = convert2Curve2D(geometry);
			}

		}
		else if(geometryType.equals("Point")){
			result = convert2Point2D(geometry);
		}
		else{
			System.out.println("GeoJson : Not defined Geometry");
		}




		return jsonNode;
	}
	public static List<List> makeDoubleCoordinates(JsonNode coordinates){
		List<List>coordinatesToArray = new ArrayList<List>();

		for(int i = 0 ; i < coordinates.size() ; i++){
			List<Double> coordinate = new ArrayList<Double>();
			coordinate.add(coordinates.get(i).get(0).asDouble());
			coordinate.add(coordinates.get(i).get(1).asDouble());
			if(coordinates.get(i).get(2) != null){
				coordinate.add(coordinates.get(i).get(2).asDouble());
			}
			coordinatesToArray.add(coordinate);
		}

		return coordinatesToArray;
	};
	public static JsonNode convert2Solid3D(JsonNode geometry){
		JsonNode result = null;
		JsonNode coordinates = geometry.get("coordinates");
		ObjectMapper mapper = new ObjectMapper();
		List<List> coordInDouble = makeDoubleCoordinates(coordinates);
		List<List> solid = makeSolid(coordInDouble, geometry.get("properties").get("height").asDouble());
		result = mapper.valueToTree(solid);
		return result;
	}
	public static JsonNode convert2Surface3D(JsonNode geometry){
		JsonNode result = null;
		return result;
	}
	public static JsonNode convert2Surface2D(JsonNode geometry){
		JsonNode result = null;
		return result;
	}
	public static JsonNode convert2Curve2D(JsonNode geometry){
		JsonNode result = null;
		return result;
	}
	public static JsonNode convert2Point2D(JsonNode geometry){
		JsonNode result = null;
		return result;
	}
	public static JsonNode convert2ExtrudedCurve3D(JsonNode geometry){
		JsonNode result = null;
		JsonNode coordinates = geometry.get("coordinates");
		Double height = geometry.get("properties").get("height").asDouble();
		ObjectMapper mapper = new ObjectMapper();
		List<List> coordInDouble = makeDoubleCoordinates(coordinates);
		List<List> container = new ArrayList<List>();
		List<List> polygon = new ArrayList<List>();
		polygon.add(makeExtrudedCurve3D(coordInDouble, height));
		//container.add(polygon);
		result = mapper.valueToTree(polygon);
		return result;

	}
	public static List<List> makeExtrudedCurve3D(List<List>coordinates, Double height){


		List<List> polygon = new ArrayList<List>();
		List<Double> extrudedPoint = new ArrayList<Double>();

		polygon.add(new ArrayList<Double>(coordinates.get(0)));
		polygon.add(new ArrayList<Double>(coordinates.get(1)));

		extrudedPoint = new ArrayList<Double>(coordinates.get(1));
		Double ground = extrudedPoint.get(2);
		extrudedPoint.remove(2);
		extrudedPoint.add(ground + height);
		polygon.add(new ArrayList<Double>(extrudedPoint));

		extrudedPoint = new ArrayList<Double>(coordinates.get(0));
		ground = extrudedPoint.get(2);
		extrudedPoint.remove(2);
		extrudedPoint.add(ground + height);
		polygon.add(new ArrayList<Double>(extrudedPoint));

		polygon.add(new ArrayList<Double>(coordinates.get(0)));
		return polygon;
	}
	public static List<List> makeSolid(List<List> coordinates, Double height){

		List<List> result = new ArrayList<List>();
		List<List> exterior = new ArrayList<List>();
		List<List> interior = new ArrayList<List>();

		List<List> upperSurface = new ArrayList<List>();
		List<List> lowerSurface = new ArrayList<List>();
		List<List> wholeSurface = new ArrayList<List>();

		for(int i = coordinates.size()-1 ; i > -1 ; i--){

			List<Double>tempList = new ArrayList<Double>(coordinates.get(i));
			lowerSurface.add(tempList);
		}
		wholeSurface.add(lowerSurface);
		exterior.add(new ArrayList<List>(wholeSurface));
		//make 3d surfaces of the side
		for(int i = 0 ; i < coordinates.size()-1; i++){
			wholeSurface = new ArrayList<List>();
			List<List> surface = new ArrayList<List>();
			List<Double> extrudedPoint = new ArrayList<Double>();
			Double ground = 0.0;
			surface.add(coordinates.get(i));
			surface.add(coordinates.get(i+1));

			extrudedPoint = new ArrayList<Double>(coordinates.get(i+1));
			ground = extrudedPoint.get(2);
			ground += height;
			extrudedPoint.remove(2);
			extrudedPoint.add(ground);

			surface.add(extrudedPoint);

			extrudedPoint = new ArrayList<Double>(coordinates.get(i));
			ground = extrudedPoint.get(2);
			ground += height;
			extrudedPoint.remove(2);
			extrudedPoint.add(height);

			surface.add(extrudedPoint);
			surface.add(new ArrayList<Double>(coordinates.get(i)));
			wholeSurface.add(surface);
			exterior.add(new ArrayList<List>(wholeSurface));
		}

		//make 3d surface of the lid

		for(int i = 0 ; i < coordinates.size(); i++){
			List<Double>extrudedPoint = new ArrayList<Double>(coordinates.get(i));
			Double ground = 0.0;

			ground = extrudedPoint.get(2);
			ground += height;
			extrudedPoint.remove(2);
			extrudedPoint.add(2, ground);
			upperSurface.add(extrudedPoint);
		}
		wholeSurface = new ArrayList<List>();
		wholeSurface.add(upperSurface);
		exterior.add(wholeSurface);


		result.add(exterior);
		result.add(interior);

		return result;
	}
	public static List<List> makeSurface3D(List<List> coordinates, Double height){
		//List<List> result = new ArrayList<List>();

		for(List coord : coordinates){
			Double ground = .0;

			ground = (Double) coord.get(2);
			ground += height;
			coord.remove(2);
			coord.add(ground);

		}

		//result.add(coordinates);

		return coordinates;

	}

	public static List<List> makeExtrudedCurve(List<List> coordinates, Double height){
		List<List>result = new ArrayList<List>();
		//TODO : need to support linesting which has several points
		List<Double> upperRight = new ArrayList<Double>();
		List<Double> upperLeft = new ArrayList<Double>();

		upperRight.add((Double)coordinates.get(1).get(0));
		upperRight.add((Double)coordinates.get(1).get(1));
		upperRight.add((Double)coordinates.get(1).get(2)+height);

		upperLeft.add((Double)coordinates.get(0).get(0));
		upperLeft.add((Double)coordinates.get(0).get(1));
		upperLeft.add((Double)coordinates.get(0).get(2)+height);

		coordinates.add(upperRight);
		coordinates.add(upperLeft);

		//result.add(coordinates);
		return coordinates;
	}


}
