package edu.pnu.stem.geojson;

import org.wololo.geojson.LineString;
import org.wololo.geojson.MultiLineString;
import org.wololo.geojson.MultiPoint;
import org.wololo.geojson.MultiPolygon;
import org.wololo.geojson.Point;
import org.wololo.geojson.Polygon;

import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.geom.LinearRing;

import edu.pnu.stem.geometry.jts.GeometryFactory3D;

public class GeoJSON3DReader {
    final static GeometryFactory3D factory3d = new GeometryFactory3D();

    public Geometry read(String json) {
        GeoJSON geoJSON = GeoJSONFactory.create(json);
        return read(geoJSON);
    }
    
    public Geometry read(GeoJSON geoJSON) {
        if (geoJSON instanceof Solid) {
            return convert((Solid) geoJSON);
        }  else {
            throw new UnsupportedOperationException();
        }
    }

    Geometry convert(Point point) {
    	double[] objectCoordinates = point.getCoordinates();
    	Coordinate coordinate = convert(objectCoordinates);
        return factory3d.createPoint(coordinate);
    }

    Geometry convert(MultiPoint multiPoint) {
    	double[][] objectCoordinates = multiPoint.getCoordinates();
    	Coordinate[] coordinates = convert(objectCoordinates);
        return factory3d.createMultiPoint(coordinates);
    }

    Geometry convert(LineString lineString) {
    	double[][] objectCoordinates = lineString.getCoordinates();
    	Coordinate[] coordinates = convert(objectCoordinates);
        return factory3d.createLineString(coordinates);
    }

    Geometry convert(MultiLineString multiLineString) {
    	double[][] objectCoordinates;
    	Coordinate[] coordinates;
    	double[][][] mlCoordinates = multiLineString.getCoordinates();
        int size = mlCoordinates.length;
        com.vividsolutions.jts.geom.LineString[] lineStrings = new com.vividsolutions.jts.geom.LineString[size];
        for (int i = 0; i < size; i++) {
        	objectCoordinates = mlCoordinates[i];
        	coordinates = convert(objectCoordinates);
            lineStrings[i] = factory3d.createLineString(coordinates);
        }
        return factory3d.createMultiLineString(lineStrings);
    }

    Geometry convert(Polygon polygon) {
    	double[][][] objectCoordinates = polygon.getCoordinates();
        return convertToPolygon(objectCoordinates);
    }

    com.vividsolutions.jts.geom.Polygon convertToPolygon(double[][][] coordinates) {
    	if (coordinates == null) {
    		throw new NullPointerException("Coordinates of Polygon are not initialized");
    	}
    	int size = coordinates.length;
    	Coordinate[] shellCoordinates = convert(coordinates[0]);
    	Coordinate[] holeCoordinates;
        LinearRing shell = factory3d.createLinearRing(shellCoordinates);
        if (size > 1) {
            size = coordinates.length - 1;
            LinearRing[] holes = new LinearRing[size];
            for (int i = 0; i < size; i++) {
            	holeCoordinates = convert(coordinates[i + 1]);
                holes[i] = factory3d.createLinearRing(holeCoordinates);
            }
            return factory3d.createPolygon(shell, holes);
        } else {
            return factory3d.createPolygon(shell);
        }
    }

    Geometry convert(MultiPolygon multiPolygon) {
    	double[][][] polygonCoordinates;
    	double[][][][] mpolygonCoordinates = multiPolygon.getCoordinates();
    	if (mpolygonCoordinates == null) {
    		throw new NullPointerException("Coordinates of MultiPolygon are not initialized");
    	}
        int size = mpolygonCoordinates.length;
        com.vividsolutions.jts.geom.Polygon[] polygons = new com.vividsolutions.jts.geom.Polygon[size];
        for (int i = 0; i < size; i++) {
        	polygonCoordinates = mpolygonCoordinates[i];
            polygons[i] = convertToPolygon(polygonCoordinates);
        }
        return factory3d.createMultiPolygon(polygons);
    }
    
    Geometry convertToMultiPolygon(double[][][][] coordinates) {
    	if (coordinates == null) {
    		throw new NullPointerException("Coordinates of MultiPolygon are not initialized");
    	}
        int size = coordinates.length;
        com.vividsolutions.jts.geom.Polygon[] polygons = new com.vividsolutions.jts.geom.Polygon[size];
        for (int i = 0; i < size; i++) {
            polygons[i] = convertToPolygon(coordinates[i]);
        }
        return factory3d.createMultiPolygon(polygons);
    }
    
    Geometry convert(Solid solid) {
    	double[][][][][] S_coordinates = solid.getCoordinates();
        return convertToSolid(S_coordinates);
    }

    edu.pnu.stem.geometry.jts.Solid convertToSolid(double[][][][][] coordinates) {
    	if (coordinates == null) {
    		throw new NullPointerException("Coordinates of Solid are not initialized");
    	}
    	else if (coordinates[0] == null) {
    		throw new NullPointerException("Coordinates of shell are not initialized");
    	}
    	int size = coordinates.length;
    	com.vividsolutions.jts.geom.MultiPolygon shell = (com.vividsolutions.jts.geom.MultiPolygon) convertToMultiPolygon(coordinates[0]);
        if (coordinates.length > 1) {
            size = coordinates.length - 1;
            com.vividsolutions.jts.geom. MultiPolygon[] holes = new com.vividsolutions.jts.geom.MultiPolygon[size];
            for (int i = 0; i < size; i++) {
                holes[i] = (com.vividsolutions.jts.geom.MultiPolygon) convertToMultiPolygon(coordinates[i + 1]);
            }
            return factory3d.createSolid(shell, holes);
        } else {
            return factory3d.createSolid(shell);
        }
    }

    Coordinate convert(double[] c) {
    	if (c == null) {
    		throw new NullPointerException("Coordinate array of double type is not initialized");
    	}
        if(c.length == 2){
            return new Coordinate(c[0], c[1]);
        }
        else{
            return new Coordinate(c[0], c[1], c[2]);
        }
    }

    Coordinate[] convert(double[][] ca) {
    	if (ca == null) {
    		throw new NullPointerException("Two-dimensional coordinate array of double type is not initialized");
    	}
    	int size = ca.length;
        Coordinate[] coordinates = new Coordinate[size];
        for (int i = 0; i < size; i++) {
            coordinates[i] = convert(ca[i]);
        }
        return coordinates;
    }
}