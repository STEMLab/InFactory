package edu.pnu.stem.binder;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.xml.bind.JAXBElement;

import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.LineString;
import org.locationtech.jts.geom.LinearRing;
import org.locationtech.jts.geom.MultiPolygon;
import org.locationtech.jts.geom.Point;
import org.locationtech.jts.geom.Polygon;

import com.vividsolutions.jts.geom.Envelope;

import edu.pnu.stem.geometry.jts.Envelope3D;
import edu.pnu.stem.geometry.jts.Solid;
import net.opengis.gml.v_3_2_1.AbstractRingType;
import net.opengis.gml.v_3_2_1.AbstractSurfaceType;
import net.opengis.gml.v_3_2_1.CompositeSurfaceType;
import net.opengis.gml.v_3_2_1.CoordinatesType;
import net.opengis.gml.v_3_2_1.DirectPositionListType;
import net.opengis.gml.v_3_2_1.DirectPositionType;
import net.opengis.gml.v_3_2_1.EnvelopeType;
import net.opengis.gml.v_3_2_1.LineStringType;
import net.opengis.gml.v_3_2_1.LinearRingType;
import net.opengis.gml.v_3_2_1.OrientableSurfaceType;
import net.opengis.gml.v_3_2_1.PointType;
import net.opengis.gml.v_3_2_1.PolygonType;
import net.opengis.gml.v_3_2_1.RingType;
import net.opengis.gml.v_3_2_1.ShellType;
import net.opengis.gml.v_3_2_1.SolidType;
import net.opengis.gml.v_3_2_1.SurfacePropertyType;
import net.opengis.gml.v_3_2_1.SurfaceType;

public class Convert2JTSGeometry {

	private final static GeometryFactory geometryFactory = new GeometryFactory();


	public static Solid Convert2Solid(SolidType feature){
		Solid newFeature = null;
		ShellType exterior = feature.getExterior().getShell();
		MultiPolygon shell = convert2MultiPolygon(exterior);
		newFeature = new Solid(shell, null, geometryFactory);
		if(feature.getId() == null) {
			edu.pnu.stem.util.GeometryUtil.setMetadata(newFeature,"id", UUID.randomUUID().toString());
		}
		else {
			edu.pnu.stem.util.GeometryUtil.setMetadata(newFeature,"id", feature.getId());
		}
		return newFeature;
	}

	public static MultiPolygon convert2MultiPolygon(ShellType feature){
		MultiPolygon newFeature = null;
		AbstractSurfaceType firstGeo = feature.getSurfaceMember().get(0).getAbstractSurface().getValue();
		List<Polygon>multiPolygonList = new ArrayList<Polygon>();
		MultiPolygon shell = null;
		if(firstGeo instanceof CompositeSurfaceType){
			//TODO : support CompositeSurfaceType later
		}
		else if(firstGeo instanceof OrientableSurfaceType){
			SurfacePropertyType surface = ((OrientableSurfaceType) firstGeo).getBaseSurface();
			//surface.getHref()
			//TODO : support OrientableSurfaceType later
		}
		else if(firstGeo instanceof PolygonType){
			List<PolygonType>polygonList = new ArrayList<PolygonType>();
			for(int i = 0 ; i < feature.getSurfaceMember().size() ; i++){
				polygonList.add((PolygonType)feature.getSurfaceMember().get(i).getAbstractSurface().getValue());
			}

			for(int i = 0 ; i < polygonList.size() ; i++){
				multiPolygonList.add(convert2Polygon(polygonList.get(i)));
				Polygon[]temp = new Polygon[multiPolygonList.size()];
				shell = geometryFactory.createMultiPolygon(multiPolygonList.toArray(temp));
			}
		}
		else if(firstGeo instanceof SurfaceType){
			//TODO : support SurfaceType later
		}
		return shell;
	}
	/*
	public Polygon Convert2Surface(SurfaceType feature){


	}
	 * */

	public static Polygon convert2Polygon(PolygonType feature){
		AbstractRingType ring = feature.getExterior().getAbstractRing().getValue();
		Polygon newFeature = null;
		if(ring instanceof LinearRingType){
			newFeature = geometryFactory.createPolygon(convert2LinearRing((LinearRingType)ring));
		}
		else if(ring instanceof RingType){
			//TODO : support RingType later
		}
		if(feature.getId() == null) {
			edu.pnu.stem.util.GeometryUtil.setMetadata(newFeature,"id", UUID.randomUUID().toString());
		}
		else {
			edu.pnu.stem.util.GeometryUtil.setMetadata(newFeature,"id", feature.getId());
		}
		return newFeature;
	}

	public static LinearRing convert2LinearRing(LinearRingType feature){
		DirectPositionListType directpositionList = feature.getPosList();
		List<JAXBElement<?>> postList = feature.getPosOrPointPropertyOrPointRep();
		CoordinatesType coord = feature.getCoordinates();
		List<Coordinate> coordList = new ArrayList<Coordinate>();

		if(directpositionList != null){
			 //coord = convert2Coordinate(directpositionList);
		}
		else{
			if(postList.size() != 0){
				for( JAXBElement<?> point : postList){
					coordList.add(convert2Coordinate((DirectPositionType)point.getValue()));
				}
			}
			else{
				if(coord != null){

				}
				else{
					//TODO
					//nogeometryexception
				}
			}
		}

		Coordinate[] newCoordinate = new Coordinate[coordList.size()];
		coordList.toArray(newCoordinate);

		LinearRing newFeature = null;

		try{
			newFeature = geometryFactory.createLinearRing(newCoordinate);
		}
		catch(Exception e){
			e.printStackTrace();
		}

		return newFeature;
	}

	public static LineString convert2LineString(LineStringType feature){
		List<Coordinate> pointList = new ArrayList<Coordinate>();

		for(int i = 0 ; i < feature.getPosOrPointPropertyOrPointRep().size() ; i++){
			pointList.add(convert2Coordinate((DirectPositionType)feature.getPosOrPointPropertyOrPointRep().get(i).getValue()));
		}
		Coordinate[] coordList = new Coordinate[pointList.size()];
		return geometryFactory.createLineString(pointList.toArray(coordList));
	}

	public static Point convert2Point(PointType feature){
		Point newFeature = null;
		newFeature = geometryFactory.createPoint(convert2Coordinate(feature.getPos()));
		return newFeature;
	}

	public static Coordinate convert2Coordinate(DirectPositionType feature){
		Coordinate newFeature = null;
		List<Double>coordinates = feature.getValue();
		if(coordinates.size() == 2){
			newFeature = new Coordinate(coordinates.get(0), coordinates.get(1));
		}
		else if(coordinates.size() == 3){
			newFeature = new Coordinate(coordinates.get(0), coordinates.get(1), coordinates.get(2));
		}
		return newFeature;
	}

	public static List<Coordinate> convert2CoordinateList(DirectPositionListType feature) {
		List<Double> pointList = feature.getValue();
		List<Coordinate> coordinateList = new ArrayList<Coordinate>();
		if(feature.getSrsDimension().intValue() == 2) {
			for(int i = 0 ; i < pointList.size(); i++) {
				Coordinate temp = new Coordinate(pointList.get(i), pointList.get(i + 1));
				coordinateList.add(temp);
			}
		}
		else if(feature.getSrsDimension().intValue() == 3) {
			for(int i = 0 ; i < pointList.size(); i++) {
				Coordinate temp = new Coordinate(pointList.get(i), pointList.get(i + 1), pointList.get(i + 2));
				coordinateList.add(temp);
			}
		}
		else{
			//TODO : dimension error
		}
		return coordinateList;
	}

}
