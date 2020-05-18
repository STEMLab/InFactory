/**
 * 
 */
package edu.pnu.stem.geometry.jts;

import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.MultiPolygon;

/**
 * @author Hyung-Gyu Ryoo (hyunggyu.ryoo@gmail.com, Pusan National University)
 *
 */
public class GeometryFactory3D extends GeometryFactory {

	  /**
	   * Constructs a <code>Polygon</code> with the given exterior boundary and
	   * interior boundaries.
	   *
	   * @param shell
	   *            the outer boundary of the new <code>Polygon</code>, or
	   *            <code>null</code> or an empty <code>LinearRing</code> if
	   *            the empty geometry is to be created.
	   * @param holes
	   *            the inner boundaries of the new <code>Polygon</code>, or
	   *            <code>null</code> or empty <code>LinearRing</code> s if
	   *            the empty geometry is to be created.
	   * @throws IllegalArgumentException if a ring is invalid
	   */
	  public Solid createSolid(MultiPolygon shell, MultiPolygon[] holes) {
	    return new Solid(shell, holes, this);
	  }

	  /**
	   * Constructs a <code>Polygon</code> with the given exterior boundary.
	   *
	   * @param shells
	   *            the outer boundary of the new <code>Polygon</code>, or
	   *            <code>null</code> or an empty <code>LinearRing</code> if
	   *            the empty geometry is to be created.
	   * @throws IllegalArgumentException if the boundary ring is invalid
	   */
	  public Solid createSolid(MultiPolygon[] shells) {
		if(shells == null || shells.length == 0) {
			return createSolid();
		} else if(shells.length == 1) {
			return createSolid(shells[0]);
		} else {
			MultiPolygon[] holes = new MultiPolygon[shells.length - 1];
			for(int i = 1; i < shells.length; i++) {
				holes[i - 1] = shells[i];
			}
			return createSolid(shells[0], holes);
		}
	  }

	  /**
	   * Constructs a <code>Polygon</code> with the given exterior boundary.
	   *
	   * @param shell
	   *            the outer boundary of the new <code>Polygon</code>, or
	   *            <code>null</code> or an empty <code>LinearRing</code> if
	   *            the empty geometry is to be created.
	   * @throws IllegalArgumentException if the boundary ring is invalid
	   */
	  public Solid createSolid(MultiPolygon shell) {
	    return createSolid(shell, null);
	  }
	  
	  public Solid createSolid() {
	    return createSolid(null, null);
	  }	
}