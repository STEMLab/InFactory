package edu.pnu.stem.binder;

import com.vividsolutions.jts.geom.LineString;
import com.vividsolutions.jts.geom.MultiPolygon;
import com.vividsolutions.jts.geom.Point;
import com.vividsolutions.jts.geom.Polygon;

import edu.pnu.stem.geometry.jts.Solid;
import net.opengis.gml.v_3_2_1.LineStringType;
import net.opengis.gml.v_3_2_1.ObjectFactory;
import net.opengis.gml.v_3_2_1.PointType;
import net.opengis.gml.v_3_2_1.SolidType;
import net.opengis.gml.v_3_2_1.SurfaceType;

public class Convert2JaxbGeometry {
	ObjectFactory gmlFactory;
	public SolidType Convert2SolidType(Solid feature){
		MultiPolygon shell = feature.getShell();
		return null;
	}
	
	public SurfaceType Convert2SurfaceType(Polygon feature){
		return null;
	}
	public LineStringType Convert2LineStringType(LineString feature){
		return null;
	}
	public PointType Convert2PointType(Point Feature){
		return null;
	}
}