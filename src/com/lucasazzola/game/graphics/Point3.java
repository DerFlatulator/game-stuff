package com.lucasazzola.game.graphics;

/**
 * Three dimensional Point class
 * 
 * @author Lucas Azzola
 * @since 16/8/2012
 */
public class Point3 {

	/**
	 * Point members
	 */
	public float x, y, z;

	/**
	 * Constructs a point with default (0) value
	 */
	public Point3() {
		x = y = z = 0;
	}

	/**
	 * Constructs a point with set coordinates
	 * 
	 * @param x
	 *            the x coordinate
	 * @param y
	 *            the y coordinate
	 * @param z
	 * 			  the z coordinate
	 */
	public Point3(float x, float y, float z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	/**
	 * Constructs a point given another point
	 * 
	 * @param point
	 *            The point to duplicate
	 */
	public Point3(Point3 point) {
		this(point.x, point.y, point.y);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Float.floatToIntBits(x);
		result = prime * result + Float.floatToIntBits(y);
		result = prime * result + Float.floatToIntBits(z);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Point3 other = (Point3) obj;
		if (Float.floatToIntBits(x) != Float.floatToIntBits(other.x))
			return false;
		if (Float.floatToIntBits(y) != Float.floatToIntBits(other.y))
			return false;
		if (Float.floatToIntBits(z) != Float.floatToIntBits(other.z))
			return false;
		return true;
	}

	@Override
	public String toString() {	
		return String.format("[%.3f, %.3f, %.3f]", x, y, z);
	}
}
