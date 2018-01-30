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
        org.wololo.geojson.Point json = new org.wololo.geojson.Point(
                convert(point.getCoordinate()));
        return json;
    }

    org.wololo.geojson.MultiPoint convert(MultiPoint multiPoint) {
        return new org.wololo.geojson.MultiPoint(
                convert(multiPoint.getCoordinates()));
    }

    org.wololo.geojson.LineString convert(LineString lineString) {
        return new org.wololo.geojson.LineString(
                convert(lineString.getCoordinates()));
    }

    org.wololo.geojson.MultiLineString convert(MultiLineString multiLineString) {
        int size = multiLineString.getNumGeometries();
        double[][][] lineStrings = new double[size][][];
        for (int i = 0; i < size; i++) {
            lineStrings[i] = convert(multiLineString.getGeometryN(i).getCoordinates());
        }
        return new org.wololo.geojson.MultiLineString(lineStrings);
    }

    org.wololo.geojson.Polygon convert(Polygon polygon) {
        int size = polygon.getNumInteriorRing() + 1;
        double[][][] rings = new double[size][][];
        rings[0] = convert(polygon.getExteriorRing().getCoordinates());
        for (int i = 0; i < size - 1; i++) {
            rings[i + 1] = convert(polygon.getInteriorRingN(i).getCoordinates());
        }
        return new org.wololo.geojson.Polygon(rings);
    }

    org.wololo.geojson.MultiPolygon convert(MultiPolygon multiPolygon) {
        int size = multiPolygon.getNumGeometries();
        double[][][][] polygons = new double[size][][][];
        for (int i = 0; i < size; i++) {
            polygons[i] = convert((Polygon) multiPolygon.getGeometryN(i)).getCoordinates();
        }
        return new org.wololo.geojson.MultiPolygon(polygons);
    }
    
    edu.pnu.stem.geojson.Solid convert(edu.pnu.stem.geometry.jts.Solid solid) {
        int size = solid.getHoles().length;
        double[][][][][] multipolygons = new double[size+1][][][][];
        multipolygons[0] = convert((MultiPolygon) solid.getShell()).getCoordinates();
        for (int i = 1; i <= size; i++) {
        	multipolygons[i] = convert((MultiPolygon) solid.getHoles()[i-1]).getCoordinates();
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

    double[][] convert(Coordinate[] coordinates) {
        double[][] array = new double[coordinates.length][];
        for (int i = 0; i < coordinates.length; i++) {
            array[i] = convert(coordinates[i]);
        }
        return array;
    }
}
