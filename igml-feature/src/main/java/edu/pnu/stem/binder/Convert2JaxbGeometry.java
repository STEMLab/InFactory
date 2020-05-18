package edu.pnu.stem.binder;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBElement;

import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.LineString;
import org.locationtech.jts.geom.LinearRing;
import org.locationtech.jts.geom.MultiPolygon;
import org.locationtech.jts.geom.Point;
import org.locationtech.jts.geom.Polygon;

import com.vividsolutions.jts.geom.Envelope;

import edu.pnu.stem.geometry.jts.Envelope3D;
import edu.pnu.stem.geometry.jts.Solid;
import edu.pnu.stem.util.GeometryUtil;
import net.opengis.gml.v_3_2_1.AbstractRingPropertyType;
import net.opengis.gml.v_3_2_1.DirectPositionListType;
import net.opengis.gml.v_3_2_1.DirectPositionType;
import net.opengis.gml.v_3_2_1.EnvelopeType;
import net.opengis.gml.v_3_2_1.LineStringType;
import net.opengis.gml.v_3_2_1.LinearRingType;
import net.opengis.gml.v_3_2_1.PointType;
import net.opengis.gml.v_3_2_1.PolygonType;
import net.opengis.gml.v_3_2_1.ShellPropertyType;
import net.opengis.gml.v_3_2_1.ShellType;
import net.opengis.gml.v_3_2_1.SolidType;
import net.opengis.gml.v_3_2_1.SurfacePropertyType;

public class Convert2JaxbGeometry {
	private final static net.opengis.gml.v_3_2_1.ObjectFactory gmlFactory = new net.opengis.gml.v_3_2_1.ObjectFactory();
	
		public static SolidType Convert2SolidType(Solid feature){
		MultiPolygon shell = feature.getShell();
		MultiPolygon[] holes = feature.getHoles();
		SolidType newFeature = gmlFactory.createSolidType();
		
		ShellType exteriorShellType = Convert2ShellType(shell);
		
		ShellPropertyType shellProp = gmlFactory.createShellPropertyType();
		shellProp.setShell(exteriorShellType);
		
		newFeature.setExterior(shellProp);
		
		if(holes!=null) {
			List<ShellPropertyType> holesPropList = new ArrayList<ShellPropertyType>();
			int index = 0;
			for(MultiPolygon mp : holes) {
				
				ShellType interiorShellType = Convert2ShellType(mp);
				ShellPropertyType inshellProp = gmlFactory.createShellPropertyType();
				inshellProp.setShell(interiorShellType);
				holesPropList.add(inshellProp);
			}
			newFeature.setInterior(holesPropList);
		}
		
		newFeature.setId(GeometryUtil.getMetadata(feature, "id"));
		
		return newFeature;
	}
	
	public static ShellType Convert2ShellType(MultiPolygon feature){
		List<SurfacePropertyType> surfaceProps = new ArrayList<SurfacePropertyType>();
		ShellType newFeature = gmlFactory.createShellType();
		for(int i = 0 ; i < feature.getNumGeometries() ; i++){
			Polygon p = (Polygon) feature.getGeometryN(i);
			PolygonType s = Convert2SurfaceType(p);
			SurfacePropertyType sProp = gmlFactory.createSurfacePropertyType();
			sProp.setAbstractSurface(gmlFactory.createPolygon(s));
			surfaceProps.add(sProp);
		}

		newFeature.setSurfaceMember(surfaceProps);
		return newFeature;
	}
	
	public static PolygonType Convert2SurfaceType(Polygon feature){
		PolygonType newFeature = gmlFactory.createPolygonType();
		
		LinearRingType extRing = Convert2LinearRingType((LinearRing)feature.getExteriorRing());
		AbstractRingPropertyType extProp = gmlFactory.createAbstractRingPropertyType();
		extProp.setAbstractRing(gmlFactory.createLinearRing(extRing));
		newFeature.setExterior(extProp);
		
		int numofIntRing = feature.getNumInteriorRing();
		if(numofIntRing!= 0) {
			List<AbstractRingPropertyType> intProp = new ArrayList<AbstractRingPropertyType>();
			for(int i = 0 ; i < numofIntRing; i++) {
				LinearRingType tempIntRing = Convert2LinearRingType((LinearRing)feature.getInteriorRingN(i));
				AbstractRingPropertyType singleintProp = gmlFactory.createAbstractRingPropertyType();
				singleintProp.setAbstractRing(gmlFactory.createLinearRing(tempIntRing));
				intProp.add(singleintProp);
			}
			newFeature.setInterior(intProp);
		}
		
		
		if(feature.getNumInteriorRing() > 0) {
			//TODO
		}
		newFeature.setId(GeometryUtil.getMetadata(feature, "id"));
		return newFeature;
	}
	
	public static LinearRingType Convert2LinearRingType(LinearRing feature){
		LinearRingType newFeature = gmlFactory.createLinearRingType();
		
		List<JAXBElement<?>> dpList = new ArrayList<JAXBElement<?>>();
		for(int i = 0 ; i < feature.getCoordinates().length; i++){
			Coordinate c = feature.getCoordinates()[i];
			JAXBElement<DirectPositionType> dpt = gmlFactory.createPos(Convert2CoordinateType(c, feature.getDimension()));
			dpList.add(dpt);
		}
		
		newFeature.setPosOrPointPropertyOrPointRep(dpList);
		return newFeature;
	}
	
	public static LineStringType Convert2LineStringType(LineString feature){
		LineStringType newFeature = gmlFactory.createLineStringType();
		
		List<JAXBElement<?>> dpList = new ArrayList<JAXBElement<?>>();
		for(int i = 0 ; i < feature.getCoordinates().length; i++){
			Coordinate c = feature.getCoordinates()[i];
			JAXBElement<DirectPositionType> dpt = gmlFactory.createPos(Convert2CoordinateType(c, feature.getDimension()));
			dpList.add(dpt);
		}
		
		newFeature.setPosOrPointPropertyOrPointRep(dpList);
		newFeature.setId(GeometryUtil.getMetadata(feature, "id"));
		return newFeature;
	}
	
	public static PointType Convert2PointType(Point feature){
		PointType newFeature = gmlFactory.createPointType();
		newFeature.setPos(Convert2CoordinateType(feature.getCoordinateSequence().getCoordinate(0), feature.getDimension()));
		newFeature.setId(GeometryUtil.getMetadata(feature, "id"));
		return newFeature;
	}
	
	public DirectPositionListType Convert2DirectPositionType(Coordinate[] feature){
		DirectPositionListType newFeature = gmlFactory.createDirectPositionListType();
		return newFeature;
	}
	public static DirectPositionType Convert2CoordinateType(Coordinate feature, int dimension){
		DirectPositionType newFeature = gmlFactory.createDirectPositionType();
		int count = 0;
		for (char ch: feature.toString().toCharArray()) {
	        if (ch == ',')  {
	        	count++;
	        } 
	    }		
		 if(count == 1){
			List<Double> points = new ArrayList<Double>();
			points.add(feature.x);
			points.add(feature.y);
			newFeature.setValue(points);
		}
		else if(count == 2){
			List<Double>points = new ArrayList<Double>();
			points.add(feature.x);
			points.add(feature.y);
			points.add(feature.z);
			newFeature.setValue(points);
		}
		count++;
		BigInteger d = BigInteger.valueOf((long)count);
		newFeature.setSrsDimension(d);
		return newFeature;
	}
	
	
}
