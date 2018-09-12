package edu.pnu.stem.geojson;


import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.io.WKTReader;
import edu.pnu.stem.geometry.jts.WKTReader3D;


public class jts2geojson {

	
	public static void main(String[] args) throws Exception {
		/*WKTReader wkt = new WKTReader();
		Geometry polygon = wkt.read("POINT (30 10)");
		GeoJSONWriter writer = new GeoJSONWriter();
		GeoJSON json = writer.write(polygon);
		String jsonstring = json.toString();
		System.out.println(jsonstring);
		GeoJSONReader reader = new GeoJSONReader();
		Geometry geometry = reader.read(json);
		Point point =(Point)geometry;
		System.out.println(point);*/
			
		
		WKTReader3D wkt = new WKTReader3D();
		Geometry solid = wkt.read("SOLID((((40 40, 20 45, 45 30, 40 40)), " + 
				"((20 35, 10 30, 10 10, 30 5, 45 20, 20 35), " + 
				"(30 20, 20 15, 20 25, 30 20))), (((35 10, 45 45, 15 40, 10 20, 35 10), " + 
				"(20 30, 35 35, 30 20, 20 30)))) ");
		GeoJSON3DWriter writer = new GeoJSON3DWriter();
		GeoJSON json = writer.write(solid);
		String jsonstring = json.toString();
		GeoJSON3DReader reader = new GeoJSON3DReader();
		Geometry geometry = reader.read("{\"type\":\"Solid\",\"coordinates\":[[[[[40.0,40.0],[20.0,45.0],[45.0,30.0],[40.0,40.0]]],[[[20.0,35.0],[10.0,30.0],[10.0,10.0],[30.0,5.0],[45.0,20.0],[20.0,35.0]],[[30.0,20.0],[20.0,15.0],[20.0,25.0],[30.0,20.0]]]],[[[[35.0,10.0],[45.0,45.0],[15.0,40.0],[10.0,20.0],[35.0,10.0]],[[20.0,30.0],[35.0,35.0],[30.0,20.0],[20.0,30.0]]]]]}");
		GeoJSON3DWriter writer2 = new GeoJSON3DWriter();
		json = writer2.write(geometry);
		jsonstring = json.toString();
		System.out.println(jsonstring);
		
		
	}
}
