package edu.pnu.stem.geojson;

import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.geom.LineString;
import com.vividsolutions.jts.geom.MultiLineString;
import com.vividsolutions.jts.geom.MultiPoint;
import com.vividsolutions.jts.geom.MultiPolygon;
import com.vividsolutions.jts.geom.Point;
import com.vividsolutions.jts.geom.Polygon;

public class GeoJSON3DWriter {

    public edu.pnu.stem.geojson.Geometry write(Geometry geometry) {
        Class<? extends Geometry> c = geometry.getClass();
        if (c.equals(edu.pnu.stem.geometry.jts.Solid.class)) {
            return convert((edu.pnu.stem.geometry.jts.Solid) geometry);      
        } else {
            throw new UnsupportedOperationException();
        }
    }
    
    org.wololo.geojson.Point convert(Point point) {
    	Coordinate coordinates = point.getCoordinate();
    	double[] convertedCoordinates = convert(coordinates);
        return new org.wololo.geojson.Point(convertedCoordinates);
    }

    org.wololo.geojson.MultiPoint convert(MultiPoint multiPoint) {
    	Coordinate[] coordinates = multiPoint.getCoordinates();
    	double[][] convertedCoordinates = convert(coordinates);
        return new org.wololo.geojson.MultiPoint(convertedCoordinates);
    }

    org.wololo.geojson.LineString convert(LineString lineString) {
    	Coordinate[] coordinates = lineString.getCoordinates();
    	double[][] convertedCoordinates = convert(coordinates);
        return new org.wololo.geojson.LineString(convertedCoordinates);
    }

    org.wololo.geojson.MultiLineString convert(MultiLineString multiLineString) {
        Geometry tempGeometry;
        Coordinate[] coordinates;
    	int size = multiLineString.getNumGeometries();
        double[][][] lineStrings = new double[size][][];
        for (int i = 0; i < size; i++) {
        	tempGeometry = multiLineString.getGeometryN(i);
        	coordinates = tempGeometry.getCoordinates();
            lineStrings[i] = convert(coordinates);
        }
        return new org.wololo.geojson.MultiLineString(lineStrings);
    }

    org.wololo.geojson.Polygon convert(Polygon polygon) {
        int size = polygon.getNumInteriorRing() + 1;
        double[][][] rings = new double[size][][];
        LineString ring = polygon.getExteriorRing();
        Coordinate[] coordinates = ring.getCoordinates();
        rings[0] = convert(coordinates);
        for (int i = 0; i < size - 1; i++) {
        	ring = polygon.getInteriorRingN(i);
        	coordinates = ring.getCoordinates();
            rings[i + 1] = convert(coordinates);
        }
        return new org.wololo.geojson.Polygon(rings);
    }

    org.wololo.geojson.MultiPolygon convert(MultiPolygon multiPolygon) {
        int size = multiPolygon.getNumGeometries();
        double[][][][] polygons = new double[size][][][];
        Polygon polygon;
        org.wololo.geojson.Polygon geojsonPolygon;
        for (int i = 0; i < size; i++) {
        	polygon = (Polygon)multiPolygon.getGeometryN(i);
        	geojsonPolygon = convert(polygon);
            polygons[i] = geojsonPolygon.getCoordinates();
        }
        return new org.wololo.geojson.MultiPolygon(polygons);
    }
    
    edu.pnu.stem.geojson.Solid convert(edu.pnu.stem.geometry.jts.Solid solid) {   	
        int size = 0;
        if (solid.getHoles()!= null) {
        	size = solid.getHoles().length;
        }
        double[][][][][] multipolygons = new double[size + 1][][][][];
        MultiPolygon mpg = (MultiPolygon) solid.getShell();
        org.wololo.geojson.MultiPolygon multipolygon = convert(mpg);
        multipolygons[0] = multipolygon.getCoordinates();
        for (int i = 1; i <= size; i++) {
        	mpg = (MultiPolygon) solid.getHoles()[i-1];
        	multipolygon = convert(mpg);
        	multipolygons[i] = multipolygon.getCoordinates();
        }
        return new edu.pnu.stem.geojson.Solid(multipolygons);
    }

    double[] convert(Coordinate coordinate) {
        if(Double.isNaN( coordinate.z )) {
            return new double[] { coordinate.x, coordinate.y };
        }
        else {
            return new double[] { coordinate.x, coordinate.y, coordinate.z };
        }
    }

    double[][] convert(Coordinate[] coordinates){
    	if (coordinates == null) {
    		throw new NullPointerException("Coordinate array is not initialized");
    	}
    	int size = coordinates.length;
        double[][] array = new double[size][];
        for (int i = 0; i < size; i++) {
            array[i] = convert(coordinates[i]);
        }
        return array;
    }
}
