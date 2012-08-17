package com.lucasazzola.game.graphics;

import com.lucasazzola.game.math.Angle;

/**
 * 3 Dimensional Vector class
 * 
 * @author Lucas Azzola
 * @since 16/8/2012
 */
public class Vector3 {

	/**
	 * Public members
	 */
	public float x, y, z;

	/**
	 * Default constructor, sets x, y and z to 0
	 */
	public Vector3() {
		this(0, 0, 0);
	}

	/**
	 * Constructor with arguments
	 * 
	 * @param x
	 *            The x-coordinate
	 * @param y
	 *            The y-coordinate
	 * @param z
	 *            The z-coordinate
	 */
	public Vector3(float x, float y, float z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	/**
	 * Constructor from another Vector3
	 * 
	 * @param vector
	 *            Another 3D Vector
	 */
	public Vector3(Vector3 vector) {
		this.x = vector.x;
		this.y = vector.y;
		this.z = vector.z;
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
	public static float dot(Vector3 v1, Vector3 v2) {
		return (float) v1.x * v2.x + v1.y * v2.y + v1.z * v2.z;
	}

	/**
	 * The cross product of two vectors
	 * 
	 * @param v1
	 *            The first vector
	 * @param v2
	 *            The second vector
	 * @return the cross product of the two vectors
	 */
	public static Vector3 cross(Vector3 v1, Vector3 v2) {
		float x, y, z;
		x = v1.y * v2.z - v1.z * v2.y;
		y = v1.x * v2.z - v1.z * v2.x;
		z = v1.x * v2.y - v1.y * v2.x;
		return new Vector3(x, y, z);
	}

	/**
	 * Gets the magnitude of a vector
	 * 
	 * @return the magnitude of the vector
	 */
	public float magnitude() {
		return (float) Math.sqrt(x * x + y * y + z * z);
	}

	/**
	 * Gets the squared magnitude of the vector
	 * 
	 * @return the magnitude squared
	 */
	public float magnitudeSqr() {
		return x * x + y * y + z * z;
	}

	/**
	 * Gets the negated vector
	 * 
	 * @return the negated vector
	 */
	public Vector3 negate() {
		return new Vector3(-x, -y, -z);
	}

	/**
	 * Returns the scaled vector
	 * 
	 * @param scalar
	 *            the scalar to scale by
	 * @return a new, scaled Vector3
	 */
	public Vector3 scale(float scalar) {
		return new Vector3(x * scalar, y * scalar, z * scalar);
	}

	/**
	 * Increments this vector
	 * 
	 * @param vector
	 *            the vector to increment by
	 * @return this
	 */
	public Vector3 increment(Vector3 vector) {
		x += vector.x;
		y += vector.y;
		z += vector.z;
		return this;
	}

	/**
	 * @see #scale(float)
	 */
	public Vector3 multiply(float scalar) {
		return this.scale(scalar);
	}

	/**
	 * Multiply a Vector3 by a 3x3 Matrix
	 * 
	 * @param matrix
	 *            the Matrix
	 * @return the resulting Vector3
	 */
	public Vector3 multiply(Matrix matrix) {
		Vector3 out = new Vector3();
		out.x = matrix.m[0][0] * x + matrix.m[0][1] * y + matrix.m[0][2] * z;
		out.y = matrix.m[1][0] * x + matrix.m[1][1] * y + matrix.m[1][2] * z;
		out.z = matrix.m[2][0] * x + matrix.m[2][1] * y + matrix.m[2][2] * z;
		return out;
	}

	/**
	 * Returns the vector divided by the scalar
	 * 
	 * @param scalar
	 *            the scalar to divide by
	 * @return a new Vector3 which is this/scalar
	 */
	public Vector3 divide(float scalar) {
		return new Vector3(x / scalar, y / scalar, z / scalar);
	}

	/**
	 * Adds two vectors
	 * 
	 * @param v1
	 *            the other vector
	 * @return a new Vector which is the sum of this and v1
	 */
	public Vector3 plus(Vector3 v1) {
		return new Vector3(x + v1.x, y + v1.y, z + v1.z);
	}

	/**
	 * Subtracts one vector from another
	 * 
	 * @param v1
	 *            vector to subtract from this
	 * @return a new Vector which is this - v1
	 */
	public Vector3 minus(Vector3 v1) {
		return new Vector3(x - v1.x, y - v1.y, z - v1.z);
	}

	/**
	 * Gets the distance to another Vector (as a point)
	 * 
	 * @param vectorTo
	 *            the vector to measure to
	 * @return the distance to the vector
	 */
	public float distanceTo(Vector3 vectorTo) {
		return (float) this.minus(vectorTo).magnitude();
	}

	/**
	 * Gets the unit (normalised) vector from this vector
	 * 
	 * @return a new, normalised unit Vector3
	 */
	public Vector3 unitVector() {
		float m = magnitude();
		return new Vector3(x / m, y / m, z / m);
	}

	/**
	 * Gets the angle of the vector, measured from positive z, clockwise about x
	 * (pitch)
	 * 
	 * @return the angle of the vector
	 */
	public Angle angleX() {
		// opposite = y
		// adjacent = z
		float angle = (float) Math.atan(y / z);
		return new Angle(angle);
	}

	/**
	 * Gets the angle of the vector, measured from positive z, clockwise about y
	 * (yaw)
	 * 
	 * @return the angle of the vector
	 */
	public Angle angleY() {
		// opposite = x
		// adjacent = z
		float angle = (float) Math.atan(x / z);
		return new Angle(angle);
	}

	/**
	 * Gets the angle of the vector, measured from positive y, clockwise about z
	 * (roll)
	 * 
	 * @return the angle of the vector
	 */
	public Angle angleZ() {
		// opposite = y
		// adjacent = x
		float angle = (float) Math.atan(y / x);
		return new Angle(angle);
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
		Vector3 other = (Vector3) obj;
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
