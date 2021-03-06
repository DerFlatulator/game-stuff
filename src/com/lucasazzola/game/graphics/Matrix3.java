package com.lucasazzola.game.graphics;

import java.util.Arrays;

import com.lucasazzola.game.exception.MatrixIndexOutOfBoundsException;

/**
 * Three dimensional Matrix3 class
 * 
 * @author Lucas Azzola
 * @since 16/8/2012
 */
public class Matrix3 extends Matrix {

	/**
	 * Constructs a 3x3 Matrix3 of values 0
	 */
	public Matrix3() {
		this.m = new float[3][3];
		setElementsToValue(m, 0);
	}

	/**
	 * Constructs a 3x3 Matrix3 of values value
	 * 
	 * @param value the value to assign to all cells
	 */
	public Matrix3(float value) {
		this.m = new float[3][3];
		setElementsToValue(m, value);
	}

	/**
	 * Constructs a Matrix3 with specified values
	 * 
	 * @param m11 Matrix3 position m11
	 * @param m12 Matrix3 position m12
	 * @param m13 Matrix3 position m13
	 * @param m21 Matrix3 position m21
	 * @param m22 Matrix3 position m22
	 * @param m23 Matrix3 position m23
	 * @param m31 Matrix3 position m31
	 * @param m32 Matrix3 position m32
	 * @param m33 Matrix3 position m33
	 */
	public Matrix3(float m11, float m12, float m13, float m21, float m22,
			float m23, float m31, float m32, float m33) {
		this.m = new float[3][3];

		m[0][0] = m11;
		m[0][1] = m12;
		m[0][2] = m13;

		m[1][0] = m21;
		m[1][1] = m22;
		m[1][2] = m23;

		m[2][0] = m31;
		m[2][1] = m32;
		m[2][2] = m33;
	}

	/**
	 * Constructs a Matrix3 given a Matrix3 array
	 * 
	 * @param m the Matrix3 array
	 * @throws Matrix3IndexOutOfBoundsException when the array is not 3x3
	 */
	public Matrix3(float[][] m) throws MatrixIndexOutOfBoundsException {
		if (m.length != 3 || m[0].length != 3)
			throw new MatrixIndexOutOfBoundsException();
		this.m = m.clone();
	}

	/**
	 * Constructs a scaling Matrix3 from a Vector3
	 * 
	 * @param vector the vector3
	 */
	public Matrix3(Vector3 vector) {
		this.m = fromVector(vector);
	}

	/**
	 * Constructs a Matrix3 from 3 (column) Vector3s
	 * 
	 * @param v1 the first column vector
	 * @param v2 the second column vector
	 * @param v3 the third column vector
	 */
	public Matrix3(Vector3 v1, Vector3 v2, Vector3 v3) {
		this.m = fromVectorsCols(v1, v2, v3);
	}

	/**
	 * Constructs a Matrix3 given another Matrix3
	 * 
	 * @param Matrix3
	 */
	public Matrix3(Matrix3 Matrix3) {
		this.m = Matrix3.m.clone();
	}

	/**
	 * Sets all elements in m to a single value
	 * 
	 * @param m the Matrix3 to set elements in
	 * @param value the value to set
	 */
	private void setElementsToValue(float[][] m, float value) {
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[0].length; j++) {
				m[i][j] = value;
			}
		}
	}

	/**
	 * Increments this by another Matrix3
	 * 
	 * @param Matrix3 the Matrix3 to increment this by
	 * @return this, for chaining
	 */
	public Matrix3 increment(Matrix3 Matrix3) {
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[0].length; j++) {
				m[i][j] += Matrix3.m[i][j];
			}
		}
		return this;
	}

	/**
	 * Add two matrices
	 * 
	 * @param Matrix3 the first Matrix3 to add
	 * @param Matrix3 the second Matrix3 to add
	 * @return A new Matrix3 which is the sum of the other two
	 */
	public static Matrix3 add(Matrix3 m1, Matrix3 m2) {
		Matrix3 out = new Matrix3();
		for (int i = 0; i < m2.m.length; i++) {
			for (int j = 0; j < m2.m[0].length; j++) {
				out.m[i][j] = m1.m[i][j] + m2.m[i][j];
			}
		}
		return out;
	}

	/**
	 * Add two matrices
	 * 
	 * @param m1 the first Matrix3
	 * @param m2 the Matrix3 to add
	 * @param out the resulting Matrix3, values will be assigned to this
	 * @return the out param, for chainability
	 */
	public static Matrix3 add(Matrix3 m1, Matrix3 m2, Matrix3 out) {
		for (int i = 0; i < m2.m.length; i++) {
			for (int j = 0; j < m2.m[0].length; j++) {
				out.m[i][j] = m1.m[i][j] + m2.m[i][j];
			}
		}
		return out;
	}

	/**
	 * Subtract one Matrix3 from another
	 * 
	 * @param m1 the first Matrix3
	 * @param m2 the Matrix3 to subtract
	 * @return A new Matrix3 which is m1 - m2
	 */
	public static Matrix3 subtract(Matrix3 m1, Matrix3 m2) {
		Matrix3 out = new Matrix3();
		for (int i = 0; i < m2.m.length; i++) {
			for (int j = 0; j < m2.m[0].length; j++) {
				out.m[i][j] = m1.m[i][j] - m2.m[i][j];
			}
		}
		return out;
	}

	/**
	 * Subtract one Matrix3 from another
	 * 
	 * @param m1 the first Matrix3
	 * @param m2 the Matrix3 to subtract
	 * @param out the resulting Matrix3, values will be assigned to this
	 * @return the out param, for chainability
	 */
	public static Matrix3 subtract(Matrix3 m1, Matrix3 m2, Matrix3 out) {
		for (int i = 0; i < m2.m.length; i++) {
			for (int j = 0; j < m2.m[0].length; j++) {
				out.m[i][j] = m1.m[i][j] - m2.m[i][j];
			}
		}
		return out;
	}

	/**
	 * Gets the negated Matrix3
	 * 
	 * @return the negated Matrix3
	 */
	public Matrix3 negate() {
		Matrix3 out = new Matrix3();
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[0].length; j++) {
				out.m[i][j] = -m[i][j];
			}
		}
		return out;
	}

	/**
	 * Negates the Matrix3 passed, and returns itself
	 * 
	 * @param Matrix3 the Matrix3 to negate
	 * @return the the reference to the Matrix3 passed
	 */
	public static Matrix3 negate(Matrix3 Matrix3) {
		for (int i = 0; i < Matrix3.m.length; i++) {
			for (int j = 0; j < Matrix3.m[0].length; j++) {
				Matrix3.m[i][j] = -Matrix3.m[i][j];
			}
		}
		return Matrix3;
	}

	/**
	 * Get a (scaling) Matrix3 array from a Vector
	 * 
	 * @param vector the vector
	 * @return the Matrix3 {{x 0 0} {0 y 0} {0 0 z}}
	 */
	public static float[][] fromVector(Vector3 vector) {
		float[][] m = { { vector.x, 0, 0 }, { 0, vector.y, 0 },
				{ 0, 0, vector.z }, };
		return m;
	}

	/**
	 * Get a Matrix3 array from three vectors, where a vector represents a
	 * single column
	 * 
	 * @param v1 the first column
	 * @param v2 the second column
	 * @param v3 the third column
	 * @return a Matrix3 array
	 */
	public static float[][] fromVectorsCols(Vector3 v1, Vector3 v2, Vector3 v3) {
		float[][] m = { { v1.x, v2.x, v3.x }, { v1.y, v2.y, v3.y },
				{ v1.z, v2.z, v3.z }, };
		return m;
	}

	/**
	 * Get a Matrix3 array from three vectors, where a vector represents a
	 * single row
	 * 
	 * @param v1 the first row
	 * @param v2 the second row
	 * @param v3 the third row
	 * @return a Matrix3 array
	 */
	public static float[][] fromVectorsRows(Vector3 v1, Vector3 v2, Vector3 v3) {
		float[][] m = { { v1.x, v1.y, v1.z }, { v2.x, v2.y, v2.z },
				{ v3.x, v3.y, v3.z }, };
		return m;
	}

	/**
	 * Multiply a Vector3 by a 3x3 Matrix3
	 * 
	 * @param Matrix3 the Matrix3
	 * @return the resulting Vector3
	 */
	public Vector3 multiply(Vector3 vector) {
		Vector3 out = new Vector3();
		out.x = m[0][0] * vector.x + m[0][1] * vector.y + m[0][2] * vector.z;
		out.y = m[1][0] * vector.x + m[1][1] * vector.y + m[1][2] * vector.z;
		out.z = m[2][0] * vector.x + m[2][1] * vector.y + m[2][2] * vector.z;
		return out;
	}

	/**
	 * Multiply a Vector3 by a 3x3 Matrix3
	 * 
	 * @param Matrix3 the input Matrix3
	 * @param vector the input Vector
	 * @param out the resulting Vector will be assigned to this vector
	 * @return out, with the resulting vector values assigned
	 */
	public static Vector3 multiply(Matrix3 Matrix3, Vector3 vector, Vector3 out) {
		// M11*V1 + M12*V2 + M13*V3
		out.x = Matrix3.m[0][0] * vector.x + Matrix3.m[0][1] * vector.y
				+ Matrix3.m[0][2] * vector.z;
		// M21*V1 + M22*V2 + M23*V3
		out.y = Matrix3.m[1][0] * vector.x + Matrix3.m[1][1] * vector.y
				+ Matrix3.m[1][2] * vector.z;
		// M31*V1 + M32*V2 + M33*V3
		out.z = Matrix3.m[2][0] * vector.x + Matrix3.m[2][1] * vector.y
				+ Matrix3.m[2][2] * vector.z;
		return out;
	}

	/**
	 * Sets the X Scale of the Matrix3 (M11)
	 * 
	 * @param xScale the scale to apply
	 */
	public void setXScale(float xScale) {
		m[0][0] = xScale;
	}

	/**
	 * Sets the Y Scale of the Matrix3 (M22)
	 * 
	 * @param yScale the scale to apply
	 */
	public void setYScale(float yScale) {
		m[1][1] = yScale;
	}

	/**
	 * Sets the Z Scale of the Matrix3 (M33)
	 * 
	 * @param zScale the scale to apply
	 */
	public void setZScale(float zScale) {
		m[2][2] = zScale;
	}

	/**
	 * Sets all elements other than M11, M22 and M33 to 0.
	 * 
	 * @param toThis true to manipulate this, false to clone
	 * @return a reference to this, or the new Matrix3
	 */
	public Matrix3 trimToScalarMatrix3(boolean toThis) {
		Matrix3 temp = toThis ? this : new Matrix3(this);
		temp.m[0][1] = 0;
		temp.m[0][2] = 0;
		temp.m[1][0] = 0;
		temp.m[1][2] = 0;
		temp.m[2][0] = 0;
		temp.m[2][1] = 0;
		return temp;
	}

	public boolean isRotationMatrix() {
		if (Math.abs(determinant() - 1) > 0.0001f)
			return false;
		
		return true;
	}

	/**
	 * Compute the determinant of the matrix
	 * 
	 * @return the determinant
	 */
	public float determinant() {
		return m[0][0] * m[1][1] * m[2][2] + m[1][0] * m[2][1] * m[0][2]
				+ m[2][2] * m[0][1] * m[1][2] - m[2][2] * m[1][1] * m[0][2]
				- m[1][0] * m[0][1] * m[2][2] - m[0][0] * m[2][1] * m[1][2];
	}

	@Override
	public int hashCode() {
		return 31 + Arrays.hashCode(m);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;
		Matrix3 other = (Matrix3) obj;
		if (!Arrays.deepEquals(m, other.m))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Matrix3 [" + Arrays.toString(m) + "]";
	}
}
