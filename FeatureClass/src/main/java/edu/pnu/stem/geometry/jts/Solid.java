/**
 * 
 */
package edu.pnu.stem.geometry.jts;

import java.util.Arrays;

import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.CoordinateFilter;
import org.locationtech.jts.geom.CoordinateSequenceComparator;
import org.locationtech.jts.geom.CoordinateSequenceFilter;
import org.locationtech.jts.geom.Envelope;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.geom.GeometryComponentFilter;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.GeometryFilter;
import org.locationtech.jts.geom.MultiPolygon;
import org.locationtech.jts.geom.Polygon;

/**
 * @author Hyung-Gyu Ryoo (hyunggyu.ryoo@gmail.com)
 *
 */
public class Solid extends Geometry {

	private MultiPolygon shell;
	private MultiPolygon[] holes;
	
	public Solid(MultiPolygon shell, MultiPolygon[] holes, GeometryFactory factory) {
		super(factory);
	    if (shell == null) {
		      shell = getFactory().createMultiPolygon();
		    }
		    if (holes == null) {
		      holes = new MultiPolygon[]{};
		    }
		    if (hasNullElements(holes)) {
		      throw new IllegalArgumentException("holes must not contain null elements");
		    }
		    if (shell.isEmpty() && hasNonEmptyElements(holes)) {
		      throw new IllegalArgumentException("shell is empty but holes are not");
		    }
		    this.shell = shell;
		    this.holes = holes;
	}

	@Override
	public void apply(CoordinateFilter filter) {
		shell.apply(filter);
	    for (int i = 0; i < holes.length; i++) {
	      holes[i].apply(filter);
	    }
	}

	@Override
	public void apply(CoordinateSequenceFilter filter) {
		if (!filter.isDone()) {
			for (int i = 0; i < holes.length; i++) {
				holes[i].apply(filter);
				if (filter.isDone())
					break;
			}
		}
		if (filter.isGeometryChanged())
			geometryChanged();
	}

	@Override
	public void apply(GeometryFilter filter) {
		filter.filter(this);
	}

	@Override
	public void apply(GeometryComponentFilter filter) {
		filter.filter(this);
		shell.apply(filter);
		for (int i = 0; i < holes.length; i++) {
			holes[i].apply(filter);
		}
	}

	/**
	 * TODO
	 */
	@Override
	protected int compareToSameClass(Object o) {
		throw new UnsupportedOperationException();
	}

	/**
	 * TODO
	 */
	@Override
	protected int compareToSameClass(Object arg0, CoordinateSequenceComparator arg1) {
		throw new UnsupportedOperationException();
	}

	/**
	 * TODO
	 */
	@Override
	protected Envelope computeEnvelopeInternal() {
		return shell.getEnvelopeInternal();
	}

	@Override
	public Solid copy() {
	    MultiPolygon shellCopy = shell.copy();
	    MultiPolygon[] holeCopies = new MultiPolygon[this.holes.length];
	    for (int i = 0; i < holes.length; i++) {
	    	holeCopies[i] = holes[i].copy();
	    }
	    return new Solid(shellCopy, holeCopies, factory);
	}

	@Override
	public boolean equalsExact(Geometry other, double tolerance) {
		if (!isEquivalentClass(other)) {
			return false;
		}
		Solid otherPolygon = (Solid) other;
		Geometry thisShell = shell;
		Geometry otherPolygonShell = otherPolygon.shell;
		if (!thisShell.equalsExact(otherPolygonShell, tolerance)) {
			return false;
		}
		if (holes.length != otherPolygon.holes.length) {
			return false;
		}
		for (int i = 0; i < holes.length; i++) {
			if (!((Geometry) holes[i]).equalsExact(otherPolygon.holes[i], tolerance)) {
				return false;
			}
		}
		return true;
	}

	@Override
	public Geometry getBoundary() {
		if (isEmpty()) {
			return getFactory().createMultiLineString();
		}
		MultiPolygon[] rings = new MultiPolygon[holes.length + 1];
		rings[0] = shell;
		for (int i = 0; i < holes.length; i++) {
			rings[i + 1] = holes[i];
		}
		// create LineString or MultiLineString as appropriate
		if (rings.length <= 1) {
			int numGeom = rings[0].getNumGeometries();
			Polygon[] poly = new Polygon[numGeom];
			for(int i = 0; i < numGeom; i++) {
				poly[i] = (Polygon) rings[0].getGeometryN(i);
			}
			return getFactory().createMultiPolygon(poly);
		}
		return getFactory().createGeometryCollection(rings);
	}

	@Override
	public int getBoundaryDimension() {
		return 2;
	}
	
	@Override
	public Coordinate getCoordinate() {
		return shell.getCoordinate();
	}

	@Override
	public Coordinate[] getCoordinates() {
		throw new UnsupportedOperationException();
	}

	@Override
	public int getDimension() {
		return 3;
	}

	@Override
	public String getGeometryType() {
		return "Solid";
	}

	@Override
	public int getNumPoints() {
		int numPoints = shell.getNumPoints();
	    for (int i = 0; i < holes.length; i++) {
	      numPoints += holes[i].getNumPoints();
	    }
	    return numPoints;
	}

	@Override
	protected int getSortIndex() {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean isEmpty() {
		return shell.isEmpty();
	}

	@Override
	public void normalize() {
		normalize(shell, true);
	    for (int i = 0; i < holes.length; i++) {
	      normalize(holes[i], false);
	    }
	    Arrays.sort(holes);
	}
	
	private void normalize(MultiPolygon ring, boolean clockwise) {
		if (ring.isEmpty()) {
			return;
		}
		ring.normalize();
	}
	
	@Override
	public Geometry reverse() {
	    Solid s = copy();
	    s.shell = (MultiPolygon) shell.copy().reverse();
	    s.holes = new MultiPolygon[holes.length];
	    for (int i = 0; i < holes.length; i++) {
	      s.holes[i] = (MultiPolygon) holes[i].copy().reverse();
	    }
	    return s;// return the clone
	}

}
