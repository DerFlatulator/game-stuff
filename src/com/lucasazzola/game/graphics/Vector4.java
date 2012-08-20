package com.lucasazzola.game.graphics;

import com.lucasazzola.game.math.Angle;

/**
 * 4 Dimensional Vector class
 * 
 * @author Lucas Azzola
 * @since 19/8/2012
 */
public class Vector4 {

	/**
	 * Public members
	 */
	public float x, y, z, w;

	/**
	 * Default constructor, sets x, y and z to 0
	 */
	public Vector4() {
		this(0, 0, 0, 0);
	}

	/**
	 * Constructor with arguments
	 * 
	 * @param x The x-coordinate
	 * @param y The y-coordinate
	 * @param z The z-coordinate
	 */
	public Vector4(float x, float y, float z, float w) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.w = w;
	}

	/**
	 * Constructor from another Vector4
	 * 
	 * @param vector Another 3D Vector
	 */
	public Vector4(Vector4 vector) {
		this.x = vector.x;
		this.y = vector.y;
		this.z = vector.z;
		this.w = vector.w;
	}

	/**
	 * The dot product of two vectors
	 * 
	 * @param v1 The first vector
	 * @param v2 The second vector
	 * @return the dot product of the two vectors
	 */
	public static float dot(Vector4 v1, Vector4 v2) {
		return (float) v1.x * v2.x + v1.y * v2.y + v1.z * v2.z + v1.w * v2.w;
	}

	/**
	 * The cross product of two vectors FIXME
	 * 
	 * @param v1 The first vector
	 * @param v2 The second vector
	 * @return the cross product of the two vectors
	 */
	public static Vector4 cross(Vector4 v1, Vector4 v2) {
		float x, y, z;
		x = v1.y * v2.z - v1.z * v2.y;
		y = v1.x * v2.z - v1.z * v2.x;
		z = v1.x * v2.y - v1.y * v2.x;
		return new Vector4(x, y, z, (float) Math.sqrt(v1.w * v1.w));
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
	public Vector4 negate() {
		return new Vector4(-x, -y, -z, w);
	}

	/**
	 * Returns the scaled vector
	 * 
	 * @param scalar the scalar to scale by
	 * @return a new, scaled Vector4
	 */
	public Vector4 scale(float scalar) {
		return new Vector4(x * scalar, y * scalar, z * scalar, w * scalar);
	}

	/**
	 * Increments this vector
	 * 
	 * @param vector the vector to increment by
	 * @return this
	 */
	public Vector4 increment(Vector4 vector) {
		x += vector.x;
		y += vector.y;
		z += vector.z;
		w += vector.w;
		return this;
	}

	/**
	 * @see #scale(float)
	 */
	public Vector4 multiply(float scalar) {
		return this.scale(scalar);
	}

	/**
	 * Multiply a Vector4 by a 3x3 Matrix
	 * 
	 * @param matrix the Matrix
	 * @return the resulting Vector4
	 */
	public Vector4 multiply(Matrix matrix) {
		Vector4 out = new Vector4();
		out.x = matrix.m[0][0] * x + matrix.m[0][1] * y + matrix.m[0][2] * z;
		out.y = matrix.m[1][0] * x + matrix.m[1][1] * y + matrix.m[1][2] * z;
		out.z = matrix.m[2][0] * x + matrix.m[2][1] * y + matrix.m[2][2] * z;
		return out;
	}

	/**
	 * Returns the vector divided by the scalar
	 * 
	 * @param scalar the scalar to divide by
	 * @return a new Vector4 which is this/scalar
	 */
	public Vector4 divide(float scalar) {
		return new Vector4(x / scalar, y / scalar, z / scalar, w / scalar);
	}

	/**
	 * Adds two vectors
	 * 
	 * @param v1 the other vector
	 * @return a new Vector which is the sum of this and v1
	 */
	public Vector4 plus(Vector4 v1) {
		return new Vector4(x + v1.x, y + v1.y, z + v1.z, w + v1.w);
	}

	/**
	 * Subtracts one vector from another
	 * 
	 * @param v1 vector to subtract from this
	 * @return a new Vector which is this - v1
	 */
	public Vector4 minus(Vector4 v1) {
		return new Vector4(x - v1.x, y - v1.y, z - v1.z, w - v1.w);
	}

	/**
	 * Gets the distance to another Vector (as a point)
	 * 
	 * @param vectorTo the vector to measure to
	 * @return the distance to the vector
	 */
	public float distanceTo(Vector4 vectorTo) {
		return (float) this.minus(vectorTo).magnitude();
	}

	/**
	 * Gets the unit (normalised) vector from this vector
	 * 
	 * @return a new, normalised unit Vector4
	 */
	public Vector4 unitVector() {
		float m = magnitude();
		return new Vector4(x / m, y / m, z / m, w / m);
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
		result = prime * result + Float.floatToIntBits(w);
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
		Vector4 other = (Vector4) obj;
		if (Float.floatToIntBits(x) != Float.floatToIntBits(other.x))
			return false;
		if (Float.floatToIntBits(y) != Float.floatToIntBits(other.y))
			return false;
		if (Float.floatToIntBits(z) != Float.floatToIntBits(other.z))
			return false;
		if (Float.floatToIntBits(w) != Float.floatToIntBits(other.w))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return String.format("[%.3f, %.3f, %.3f, %.3f]", x, y, z, w);
	}
}
