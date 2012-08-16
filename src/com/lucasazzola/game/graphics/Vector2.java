package com.lucasazzola.game.graphics;

import com.lucasazzola.game.math.Angle;

/**
 * 2 Dimensional Vector class
 * 
 * @author Lucas Azzola
 * @since 16/8/2012
 */
public class Vector2 {

	/**
	 * Public members
	 */
	public float x, y;

	/**
	 * Default constructor, sets x and y to 0
	 */
	public Vector2() {
		this(0, 0);
	}

	/**
	 * Constructor with arguments
	 * 
	 * @param x
	 *            The x-coordinate
	 * @param y
	 *            The y-coordinate
	 */
	public Vector2(float x, float y) {
		this.x = x;
		this.y = y;
	}

	/**
	 * Constructor from another Vector2
	 * 
	 * @param vector
	 *            Another 2D Vector
	 */
	public Vector2(Vector2 vector) {
		this.x = vector.x;
		this.y = vector.y;
	}

	/**
	 * The dot product of two vectors
	 * 
	 * @param v1
	 *            The first vector
	 * @param v2
	 *            The second vector
	 * @return the dot product of the two vectors
	 */
	public static float dot(Vector2 v1, Vector2 v2) {
		return (float) v1.x * v2.x + v1.y * v2.y;
	}

	/**
	 * Gets the magnitude of a vector
	 * 
	 * @return the magnitude of the vector
	 */
	public float magnitude() {
		return (float) Math.sqrt(x * x + y * y);
	}

	/**
	 * Gets the squared magnitude of the vector
	 * 
	 * @return the magnitude squared
	 */
	public float magnitudeSqr() {
		return x * x + y * y;
	}

	/**
	 * Gets the negated vector
	 * 
	 * @return the negated vector
	 */
	public Vector2 negate() {
		return new Vector2(-x, -y);
	}

	/**
	 * Returns the scaled vector
	 * 
	 * @param scalar
	 *            the scalar to scale by
	 * @return a new, scaled Vector2
	 */
	public Vector2 scale(float scalar) {
		return new Vector2(x * scalar, y * scalar);
	}
	
	/**
	 * @see #scale(float)
	 */
	public Vector2 multiply(float scalar) {
		return this.scale(scalar);
	}

	/**
	 * Returns the vector divided by the scalar
	 * 
	 * @param scalar
	 *            the scalar to divide by
	 * @return a new Vector2 which is this/scalar
	 */
	public Vector2 divide(float scalar) {
		return new Vector2(x / scalar, y / scalar);
	}

	/**
	 * Adds two vectors
	 * 
	 * @param v1
	 *            the other vector
	 * @return a new Vector which is the sum of this and v1
	 */
	public Vector2 plus(Vector2 v1) {
		return new Vector2(x + v1.x, y + v1.y);
	}

	/**
	 * Subtracts one vector from another
	 * 
	 * @param v1
	 *            vector to subtract from this
	 * @return a new Vector which is this - v1
	 */
	public Vector2 minus(Vector2 v1) {
		return new Vector2(x - v1.x, y - v1.y);
	}

	/**
	 * Gets the distance to another Vector (as a point)
	 * 
	 * @param vectorTo
	 *            the vector to measure to
	 * @return the distance to the vector
	 */
	public float distanceTo(Vector2 vectorTo) {
		return (float) this.minus(vectorTo).magnitude();
	}

	/**
	 * Gets the unit (normalised) vector from this vector
	 * 
	 * @return a new, normalised unit Vector2
	 */
	public Vector2 unitVector() {
		float m = magnitude();
		return new Vector2(x / m, y / m);
	}

	/**
	 * Gets the angle of the vector, measured from positive y
	 * 
	 * @return the angle, in degrees, of the vector
	 */
	public Angle angle() {
		float angle = (float) Math.acos(dot(this, new Vector2(0, 1))
				/ this.magnitude());
		return new Angle(angle);
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
		Vector2 other = (Vector2) obj;
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
