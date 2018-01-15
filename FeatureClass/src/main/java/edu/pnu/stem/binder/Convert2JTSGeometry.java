package edu.pnu.stem.binder;

import java.util.ArrayList;
import java.util.List;

import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.LineString;
import com.vividsolutions.jts.geom.LinearRing;
import com.vividsolutions.jts.geom.MultiPolygon;
import com.vividsolutions.jts.geom.Point;
import com.vividsolutions.jts.geom.Polygon;

import edu.pnu.stem.geometry.jts.Solid;
import net.opengis.gml.v_3_2_1.AbstractRingType;
import net.opengis.gml.v_3_2_1.AbstractSurfaceType;
import net.opengis.gml.v_3_2_1.CompositeSurfaceType;
import net.opengis.gml.v_3_2_1.DirectPositionListType;
import net.opengis.gml.v_3_2_1.DirectPositionType;
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
	public Solid Convert2Solid(SolidType feature){
		Solid newFeature = null;
		ShellType exterior = feature.getExterior().getShell();
		MultiPolygon shell = convert2MultiPolygon(exterior);
		newFeature = new Solid(shell, null, geometryFactory);
		return newFeature;
	}
	
	public MultiPolygon convert2MultiPolygon(ShellType feature){
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
				Polygon[]temp = null;
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
	
	public Polygon convert2Polygon(PolygonType feature){
		AbstractRingType ring = feature.getExterior().getAbstractRing().getValue();
		Polygon newFeature = null;
		if(ring instanceof LinearRingType){
			newFeature = geometryFactory.createPolygon(convert2LinearRing((LinearRingType)ring));
		}
		else if(ring instanceof RingType){
			//TODO : support RingType later
		}
		return newFeature;
	}

	public LinearRing convert2LinearRing(LinearRingType feature){
		DirectPositionListType directpositionList = feature.getPosList();
		List<Coordinate>temp = convert2CoordinateList(directpositionList);
		Coordinate[] newCoordinate = null;
		temp.toArray(newCoordinate);
		LinearRing newFeature = geometryFactory.createLinearRing(newCoordinate);
		return newFeature;
	}

	public LineString convert2LineString(LineStringType feature){
		List<Coordinate>coordinateList = convert2CoordinateList(feature.getPosList());
		return geometryFactory.createLineString((Coordinate[]) coordinateList.toArray());
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
	
	public List<Coordinate> convert2CoordinateList(DirectPositionListType feature){
		List<Double>pointList = feature.getValue();
		List<Coordinate>coordinateList = new ArrayList<Coordinate>();
		if(feature.getSrsDimension().intValue() == 2){
			for(int i = 0 ; i <pointList.size(); i++){
				Coordinate temp = new Coordinate(pointList.get(i), pointList.get(i+1));
				coordinateList.add(temp);
			}
		}
		else if(feature.getSrsDimension().intValue() == 3){
			for(int i = 0 ; i <pointList.size(); i++){
				Coordinate temp = new Coordinate(pointList.get(i), pointList.get(i+1), pointList.get(i+2));
				coordinateList.add(temp);
			}
		}
		else{
			//TODO : dimension error
		}
		return coordinateList;
	}
	
}
