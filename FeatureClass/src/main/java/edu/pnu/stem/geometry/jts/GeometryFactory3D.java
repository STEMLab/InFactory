/**
 * 
 */
package edu.pnu.stem.geometry.jts;

import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.MultiPolygon;
import com.vividsolutions.jts.geom.Polygon;

/**
 * @author Hyung-Gyu Ryoo (hyunggyu.ryoo@gmail.com)
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
	   * @param shell
	   *            the outer boundary of the new <code>Polygon</code>, or
	   *            <code>null</code> or an empty <code>LinearRing</code> if
	   *            the empty geometry is to be created.
	   * @throws IllegalArgumentException if the boundary ring is invalid
	   */
	  public Solid createSolid(Polygon[] shell) {
	    return createSolid(createMultiPolygon(shell));
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