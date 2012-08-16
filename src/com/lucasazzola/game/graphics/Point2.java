package com.lucasazzola.game.graphics;

/**
 * Two dimensional Point class
 * 
 * @author Lucas Azzola
 * @since 16/8/2012
 */
public class Point2 {

	/**
	 * Point members
	 */
	public float x, y;

	/**
	 * Constructs a point with default (0) value
	 */
	public Point2() {
		x = y = 0;
	}

	/**
	 * Constructs a point with set coordinates
	 * 
	 * @param x
	 *            the x coordinate
	 * @param y
	 *            the y coordinate
	 */
	public Point2(float x, float y) {
		this.x = x;
		this.y = y;
	}

	/**
	 * Constructs a point given another point
	 * 
	 * @param point
	 *            The point to duplicate
	 */
	public Point2(Point2 point) {
		this(point.x, point.y);
	}

	/**
	 * Checks whether the point is within a rectangle
	 * 
	 * @param rectangle
	 *            the rectangle
	 * @return true if it intersects
	 */
	public boolean intersectsRectangle(Rectangle rectangle) {
		return rectangle.intersects(this);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Float.floatToIntBits(x);
		result = prime * result + Float.floatToIntBits(y);
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
		Point2 other = (Point2) obj;
		if (Float.floatToIntBits(x) != Float.floatToIntBits(other.x))
			return false;
		if (Float.floatToIntBits(y) != Float.floatToIntBits(other.y))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return String.format("[%.3f, %.3f]", x, y);
	}
}
