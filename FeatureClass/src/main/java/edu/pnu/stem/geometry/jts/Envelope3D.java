/**
 * 
 */
package edu.pnu.stem.geometry.jts;

import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.Envelope;

/**
 * @author hyung
 *
 */
public class Envelope3D extends Envelope {

	private double minz;

	private double maxz;

	/**
	 * Test the point q to see whether it intersects the Envelope defined by p1-p2
	 * 
	 * @param p1
	 *            one extremal point of the envelope
	 * @param p2
	 *            another extremal point of the envelope
	 * @param q
	 *            the point to test for intersection
	 * @return <code>true</code> if q intersects the envelope p1-p2
	 */
	public static boolean intersects(Coordinate p1, Coordinate p2, Coordinate q) {
		// OptimizeIt shows that Math#min and Math#max here are a bottleneck.
		// Replace with direct comparisons. [Jon Aquino]
		if (((q.x >= (p1.x < p2.x ? p1.x : p2.x)) && (q.x <= (p1.x > p2.x ? p1.x : p2.x)))
				&& ((q.y >= (p1.y < p2.y ? p1.y : p2.y)) && (q.y <= (p1.y > p2.y ? p1.y : p2.y)))
				&& ((q.z >= (p1.z < p2.z ? p1.z : p2.z)) && (q.z <= (p1.z > p2.z ? p1.z : p2.z)))) {
			return true;
		}
		return false;
	}

	/**
	 * Tests whether the envelope defined by p1-p2 and the envelope defined by q1-q2
	 * intersect.
	 * 
	 * @param p1
	 *            one extremal point of the envelope P
	 * @param p2
	 *            another extremal point of the envelope P
	 * @param q1
	 *            one extremal point of the envelope Q
	 * @param q2
	 *            another extremal point of the envelope Q
	 * @return <code>true</code> if Q intersects P
	 */
	public static boolean intersects(Coordinate p1, Coordinate p2, Coordinate q1, Coordinate q2) {
		if (Envelope.intersects(p1, p2, q1, q2)) {
			double minq = Math.min(q1.z, q2.z);
			double maxq = Math.max(q1.z, q2.z);
			double minp = Math.min(p1.z, p2.z);
			double maxp = Math.max(p1.z, p2.z);

			if (minp > maxq)
				return false;
			if (maxp < minq)
				return false;

			return true;
		}
		return false;
	}

	/**
	 * Creates a null <code>Envelope</code>.
	 */
	public Envelope3D() {
		init();
	}

	/**
	 * Creates an <code>Envelope</code> for a region defined by maximum and minimum
	 * values.
	 *
	 * @param x1
	 *            the first x-value
	 * @param x2
	 *            the second x-value
	 * @param y1
	 *            the first y-value
	 * @param y2
	 *            the second y-value
	 */
	public Envelope3D(double x1, double x2, double y1, double y2, double z1, double z2) {
		init(x1, x2, y1, y2, z1, z2);
	}

	/**
	 * Creates an <code>Envelope</code> for a region defined by two Coordinates.
	 *
	 * @param p1
	 *            the first Coordinate
	 * @param p2
	 *            the second Coordinate
	 */
	public Envelope3D(Coordinate p1, Coordinate p2) {
		init(p1.x, p2.x, p1.y, p2.y, p1.z, p2.z);
	}

	/**
	 * Creates an <code>Envelope</code> for a region defined by a single Coordinate.
	 *
	 * @param p
	 *            the Coordinate
	 */
	public Envelope3D(Coordinate p) {
		init(p.x, p.x, p.y, p.y);
	}

	/**
	 * Create an <code>Envelope</code> from an existing Envelope.
	 *
	 * @param env
	 *            the Envelope to initialize from
	 */
	public Envelope3D(Envelope env) {
		init(env);
	}

	/**
	 * Initialize to a null <code>Envelope</code>.
	 */
	public void init() {
		setToNull();
	}

	/**
	 * Initialize an <code>Envelope</code> for a region defined by maximum and
	 * minimum values.
	 *
	 * @param x1
	 *            the first x-value
	 * @param x2
	 *            the second x-value
	 * @param y1
	 *            the first y-value
	 * @param y2
	 *            the second y-value
	 */
	public void init(double x1, double x2, double y1, double y2, double z1, double z2) {
		super.init(x1, x2, y1, y2);
		if (z1 < z2) {
			minz = z1;
			maxz = z2;
		} else {
			minz = z2;
			maxz = z1;
		}
	}

	/**
	 * Initialize an <code>Envelope</code> to a region defined by two Coordinates.
	 *
	 * @param p1
	 *            the first Coordinate
	 * @param p2
	 *            the second Coordinate
	 */
	public void init(Coordinate p1, Coordinate p2) {
		init(p1.x, p2.x, p1.y, p2.y, p1.z, p2.z);
	}

	/**
	 * Initialize an <code>Envelope</code> to a region defined by a single
	 * Coordinate.
	 *
	 * @param p
	 *            the coordinate
	 */
	public void init(Coordinate p) {
		init(p.x, p.x, p.y, p.y, p.z, p.z);
	}

	/**
	 * Initialize an <code>Envelope</code> from an existing Envelope.
	 *
	 * @param env
	 *            the Envelope to initialize from
	 */
	public void init(Envelope3D env) {
		super.init(env);
		this.minz = env.minz;
		this.maxz = env.maxz;
	}

	/**
	 * Makes this <code>Envelope</code> a "null" envelope, that is, the envelope of
	 * the empty geometry.
	 */
	public void setToNull() {
		super.setToNull();
		minz = 0;
		maxz = -1;
	}

	/**
	 * Returns <code>true</code> if this <code>Envelope</code> is a "null" envelope.
	 *
	 * @return <code>true</code> if this <code>Envelope</code> is uninitialized or
	 *         is the envelope of the empty geometry.
	 */
	public boolean isNull() {
		return maxz < minz;
	}

	public double getDepth() {
		if (isNull()) {
			return 0;
		}
		return maxz - minz;
	}

	/**
	 * Returns the <code>Envelope</code>s minimum z-value. min z &gt; max z
	 * indicates that this is a null <code>Envelope</code>.
	 *
	 * @return the minimum y-coordinate
	 */
	public double getMinZ() {
		return minz;
	}

	/**
	 * Returns the <code>Envelope</code>s maximum z-value. min z &gt; max z
	 * indicates that this is a null <code>Envelope</code>.
	 *
	 * @return the maximum y-coordinate
	 */
	public double getMaxZ() {
		return maxz;
	}

	/**
	 * Gets the area of this envelope.
	 * 
	 * @return the area of the envelope
	 * @return 0.0 if the envelope is null
	 */
	@Override
	public double getArea() {
		return getWidth() * getHeight() * 6;
	}

	/**
	 * Gets the area of this envelope.
	 * 
	 * @return the area of the envelope
	 * @return 0.0 if the envelope is null
	 */
	public double getVolume() {
		return getWidth() * getHeight() * getDepth();
	}

	/**
	 * Gets the minimum extent of this envelope across both dimensions.
	 * 
	 * @return the minimum extent of this envelope
	 */
	public double minExtent() {
		if (isNull())
			return 0.0;
		double min = super.minExtent();
		double z = getDepth();
		if (z < min)
			return z;
		return min;
	}

	/**
	 * Gets the maximum extent of this envelope across both dimensions.
	 * 
	 * @return the maximum extent of this envelope
	 */
	public double maxExtent() {
		if (isNull())
			return 0.0;
		double max = super.maxExtent();
		double z = getDepth();
		if (z > max)
			return z;
		return max;
	}

	/**
	 * Enlarges this <code>Envelope</code> so that it contains the given
	 * {@link Coordinate}. Has no effect if the point is already on or within the
	 * envelope.
	 *
	 * @param p
	 *            the Coordinate to expand to include
	 */
	public void expandToInclude(Coordinate p) {
		expandToInclude(p.x, p.y, p.z);
	}

	/**
	 * Expands this envelope by a given distance in all directions. Both positive
	 * and negative distances are supported.
	 *
	 * @param distance
	 *            the distance to expand the envelope
	 */
	public void expandBy(double distance) {
		expandBy(distance, distance, distance);
	}

	/**
	 * Expands this envelope by a given distance in all directions. Both positive
	 * and negative distances are supported.
	 *
	 * @param deltaX
	 *            the distance to expand the envelope along the the X axis
	 * @param deltaY
	 *            the distance to expand the envelope along the the Y axis
	 */
	public void expandBy(double deltaX, double deltaY, double deltaZ) {
		if (isNull())
			return;

		super.expandBy(deltaX, deltaY);
		minz -= deltaZ;
		maxz += deltaZ;

		// check for envelope disappearing
		if (minz > maxz)
			setToNull();
	}

	/**
	 * Enlarges this <code>Envelope</code> so that it contains the given point. Has
	 * no effect if the point is already on or within the envelope.
	 *
	 * @param x
	 *            the value to lower the minimum x to or to raise the maximum x to
	 * @param y
	 *            the value to lower the minimum y to or to raise the maximum y to
	 */
	public void expandToInclude(double x, double y, double z) {
		super.expandToInclude(x, y);
		if (isNull()) {
			minz = z;
			maxz = z;
		} else {
			if (z < minz) {
				minz = z;
			}
			if (z > maxz) {
				maxz = z;
			}
		}
	}

	/**
	 * Enlarges this <code>Envelope</code> so that it contains the
	 * <code>other</code> Envelope. Has no effect if <code>other</code> is wholly on
	 * or within the envelope.
	 *
	 * @param other
	 *            the <code>Envelope</code> to expand to include
	 */
	public void expandToInclude(Envelope3D other) {
		if (other.isNull()) {
			return;
		}
		super.expandToInclude(other);
		if (isNull()) {
			minz = other.getMinZ();
			maxz = other.getMaxZ();
		} else {
			if (other.minz < minz) {
				minz = other.minz;
			}
			if (other.maxz > maxz) {
				maxz = other.maxz;
			}
		}
	}

	/**
	 * Translates this envelope by given amounts in the X and Y direction.
	 *
	 * @param transX
	 *            the amount to translate along the X axis
	 * @param transY
	 *            the amount to translate along the Y axis
	 */
	public void translate(double transX, double transY, double transZ) {
		if (isNull()) {
			return;
		}
		init(getMinX() + transX, getMaxX() + transX, getMinY() + transY, getMaxY() + transY, getMinZ() + transZ,
				getMaxZ() + transZ);
	}

	/**
	 * Computes the coordinate of the centre of this envelope (as long as it is
	 * non-null
	 *
	 * @return the centre coordinate of this envelope <code>null</code> if the
	 *         envelope is null
	 */
	public Coordinate centre() {
		if (isNull())
			return null;
		return new Coordinate((getMinX() + getMaxX()) / 2.0, (getMinY() + getMaxY()) / 2.0,
				(getMinZ() + getMaxZ()) / 2.0);
	}

	/**
	 * Computes the intersection of two {@link Envelope}s.
	 *
	 * @param env
	 *            the envelope to intersect with
	 * @return a new Envelope representing the intersection of the envelopes (this
	 *         will be the null envelope if either argument is null, or they do not
	 *         intersect
	 */
	public Envelope intersection(Envelope3D env) {
		if (isNull() || env.isNull() || !intersects(env))
			return new Envelope();

		double intMinX = getMinX() > env.getMinX() ? getMinX() : env.getMinX();
		double intMinY = getMinY() > env.getMinY() ? getMinY() : env.getMinY();
		double intMaxX = getMaxX() < env.getMaxX() ? getMaxX() : env.getMaxX();
		double intMaxY = getMaxY() < env.getMaxY() ? getMaxY() : env.getMaxY();
		double intMinZ = getMinZ() > env.getMinZ() ? getMinZ() : env.getMinZ();
		double intMaxZ = getMaxZ() < env.getMaxZ() ? getMaxZ() : env.getMaxZ();
		return new Envelope3D(intMinX, intMaxX, intMinY, intMaxY, intMinZ, intMaxZ);
	}

	/**
	 * Check if the region defined by <code>other</code> intersects the region of
	 * this <code>Envelope</code>.
	 *
	 * @param other
	 *            the <code>Envelope</code> which this <code>Envelope</code> is
	 *            being checked for intersecting
	 * @return <code>true</code> if the <code>Envelope</code>s intersect
	 */
	public boolean intersects(Envelope3D other) {
		if (isNull() || other.isNull()) {
			return false;
		}
		return !(other.getMinX() > getMaxX() || other.getMaxX() < getMinX() || other.getMinY() > getMaxY()
				|| other.getMaxY() < getMinY() || other.getMinZ() > getMaxZ() || other.getMaxZ() < getMinZ());
	}

	/**
	 * Check if the extent defined by two extremal points intersects the extent of
	 * this <code>Envelope</code>.
	 *
	 * @param a
	 *            a point
	 * @param b
	 *            another point
	 * @return <code>true</code> if the extents intersect
	 */
	@Override
	public boolean intersects(Coordinate a, Coordinate b) {
		if (isNull()) {
			return false;
		}

		if (super.intersects(a, b)) {
			double envminz = (a.z < b.z) ? a.z : b.z;
			if (envminz > maxz)
				return false;

			double envmaxz = (a.z > b.z) ? a.z : b.z;
			if (envmaxz < minz)
				return false;

			return true;
		}
		return false;
	}

	/**
	 * Check if the point <code>p</code> intersects (lies inside) the region of this
	 * <code>Envelope</code>.
	 *
	 * @param p
	 *            the <code>Coordinate</code> to be tested
	 * @return <code>true</code> if the point intersects this <code>Envelope</code>
	 */
	public boolean intersects(Coordinate p) {
		return intersects(p.x, p.y, p.z);
	}

	/**
	 * Check if the point <code>(x, y)</code> intersects (lies inside) the region of
	 * this <code>Envelope</code>.
	 *
	 * @param x
	 *            the x-ordinate of the point
	 * @param y
	 *            the y-ordinate of the point
	 * @return <code>true</code> if the point overlaps this <code>Envelope</code>
	 */
	public boolean intersects(double x, double y, double z) {
		if (isNull())
			return false;
		return !(x > getMaxX() || x < getMinX() || y > getMaxY() || y < getMinY() || z > maxz || z < minz);
	}

	public boolean contains(Envelope other) {
		return covers(other);
	}

	/**
	 * Tests if the given point lies in or on the envelope.
	 * <p>
	 * Note that this is <b>not</b> the same definition as the SFS
	 * <tt>contains</tt>, which would exclude the envelope boundary.
	 *
	 * @param p
	 *            the point which this <code>Envelope</code> is being checked for
	 *            containing
	 * @return <code>true</code> if the point lies in the interior or on the
	 *         boundary of this <code>Envelope</code>.
	 * 
	 * @see #covers(Coordinate)
	 */
	public boolean contains(Coordinate p) {
		return covers(p);
	}

	/**
	 * Tests if the given point lies in or on the envelope.
	 * <p>
	 * Note that this is <b>not</b> the same definition as the SFS
	 * <tt>contains</tt>, which would exclude the envelope boundary.
	 *
	 * @param x
	 *            the x-coordinate of the point which this <code>Envelope</code> is
	 *            being checked for containing
	 * @param y
	 *            the y-coordinate of the point which this <code>Envelope</code> is
	 *            being checked for containing
	 * @return <code>true</code> if <code>(x, y)</code> lies in the interior or on
	 *         the boundary of this <code>Envelope</code>.
	 * 
	 * @see #covers(double, double)
	 */
	public boolean contains(double x, double y, double z) {
		return covers(x, y, z);
	}

	/**
	 * Tests if the given point lies in or on the envelope.
	 *
	 * @param x
	 *            the x-coordinate of the point which this <code>Envelope</code> is
	 *            being checked for containing
	 * @param y
	 *            the y-coordinate of the point which this <code>Envelope</code> is
	 *            being checked for containing
	 * @return <code>true</code> if <code>(x, y)</code> lies in the interior or on
	 *         the boundary of this <code>Envelope</code>.
	 */
	public boolean covers(double x, double y, double z) {
		if (isNull())
			return false;
		return x >= getMinX() && x <= getMaxX() && y >= getMinY() && y <= getMaxY() && z >= getMinZ() && z <= getMaxZ();
	}

	/**
	 * Tests if the given point lies in or on the envelope.
	 *
	 * @param p
	 *            the point which this <code>Envelope</code> is being checked for
	 *            containing
	 * @return <code>true</code> if the point lies in the interior or on the
	 *         boundary of this <code>Envelope</code>.
	 */
	public boolean covers(Coordinate p) {
		return covers(p.x, p.y, p.z);
	}

	/**
	 * Tests if the <code>Envelope other</code> lies wholely inside this
	 * <code>Envelope</code> (inclusive of the boundary).
	 *
	 * @param other
	 *            the <code>Envelope</code> to check
	 * @return true if this <code>Envelope</code> covers the <code>other</code>
	 */
	public boolean covers(Envelope3D other) {
		if (isNull() || other.isNull()) {
			return false;
		}
		return other.getMinX() >= getMinX() && other.getMaxX() <= getMaxX() && other.getMinY() >= getMinY()
				&& other.getMaxY() <= getMaxY() && other.getMinZ() >= getMinZ() && other.getMaxZ() <= getMaxZ();
	}

	/**
	 * Computes the distance between this and another <code>Envelope</code>. The
	 * distance between overlapping Envelopes is 0. Otherwise, the distance is the
	 * Euclidean distance between the closest points.
	 */
	public double distance(Envelope3D env) {
		if (intersects(env))
			return 0;

		double dx = 0.0;
		if (getMaxX() < env.getMinX())
			dx = env.getMinX() - getMaxX();
		else if (getMinX() > env.getMaxX())
			dx = getMinX() - env.getMaxX();

		double dy = 0.0;
		if (getMaxY() < env.getMinY())
			dy = env.getMinY() - getMaxY();
		else if (getMinY() > env.getMaxY())
			dy = getMinY() - env.getMaxY();

		double dz = 0.0;
		if (getMaxZ() < env.getMinZ())
			dy = env.getMinZ() - getMaxZ();
		else if (getMinZ() > env.getMaxZ())
			dy = getMinZ() - env.getMaxZ();

		// if either is zero, the envelopes overlap either vertically or horizontally
		if (dx == 0.0)
			return Math.sqrt(dy * dy + dz * dz);
		if (dy == 0.0)
			return Math.sqrt(dx * dx + dz * dz);
		if (dz == 0.0)
			return Math.sqrt(dx * dx + dy * dy);
		return Math.sqrt(dx * dx + dy * dy + dz * dz);
	}

	@Override
	public boolean equals(Object other) {
		if(super.equals(other)) {
			Envelope3D otherEnvelope = (Envelope3D) other;
			return maxz == otherEnvelope.getMaxX() && maxz == otherEnvelope.getMaxY();
		}
		return false;
	}

	@Override
	public String toString() {
		return "Env3D[" + getMinX() + " : " + getMaxX() + ", " + getMinY() + " : " + getMaxY() + ", " + getMinZ() + " : " + getMaxZ() + "]";
	}

	/**
	 * Compares two envelopes using lexicographic ordering. The ordering comparison
	 * is based on the usual numerical comparison between the sequence of ordinates.
	 * Null envelopes are less than all non-null envelopes.
	 * 
	 * @param o
	 *            an Envelope object
	 */
	public int compareTo(Object o) {
		Envelope env = (Envelope) o;
		// compare nulls if present
		if (isNull()) {
			if (env.isNull())
				return 0;
			return -1;
		} else {
			if (env.isNull())
				return 1;
		}
		// compare based on numerical ordering of ordinates
		if (getMinX() < env.getMinX())
			return -1;
		if (getMinX() > env.getMinX())
			return 1;
		if (getMinY() < env.getMinY())
			return -1;
		if (getMinY() > env.getMinY())
			return 1;
		if (getMaxX() < env.getMaxX())
			return -1;
		if (getMaxX() > env.getMaxX())
			return 1;
		if (getMaxY() < env.getMaxY())
			return -1;
		if (getMaxY() > env.getMaxY())
			return 1;
		
		Envelope3D env3d = (Envelope3D) o;
		if (getMinZ() < env3d.getMinZ())
			return -1;
		if (getMinZ() > env3d.getMinZ())
			return 1;
		if (getMaxZ() < env3d.getMaxZ())
			return -1;
		if (getMaxZ() > env3d.getMaxZ())
			return 1;
		
		return 0;

	}
}
