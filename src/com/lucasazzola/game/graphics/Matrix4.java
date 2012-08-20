package com.lucasazzola.game.graphics;

import java.util.Arrays;

import com.lucasazzola.game.exception.MatrixIndexOutOfBoundsException;

/*
 * TODO Rewrite commented methods for Matrix4, from the Matrix3 class
 * TODO Write a Vector4 class to help this class
 */

/**
 * Three dimensional Matrix4 class
 * 
 * @author Lucas Azzola
 * @since 16/8/2012
 */
public class Matrix4 {

	/**
	 * Public Matrix
	 * 
	 * [Column-1][Row-1]
	 */
	public float[][] m;

	/**
	 * Constructs a 4x4 Matrix of values 0
	 */
	public Matrix4() {
		this.m = new float[4][4];
		setElementsToValue(m, 0);
	}

	/**
	 * Constructs a 3x3 Matrix4 of values value
	 * 
	 * @param value the value to assign to all cells
	 */
	public Matrix4(float value) {
		this.m = new float[4][4];
		setElementsToValue(m, value);
	}

	/**
	 * Constructs a 4x4 matrix with specified values
	 * 
	 * @param m11 matrix position M1_1
	 * @param m12 matrix position M1_2
	 * @param m13 matrix position M1_3
	 * @param m14 matrix position M1_4
	 * @param m21 matrix position M2_1
	 * @param m22 matrix position M2_2
	 * @param m23 matrix position M2_3
	 * @param m24 matrix position M2_4
	 * @param m31 matrix position M3_1
	 * @param m32 matrix position M3_2
	 * @param m33 matrix position M3_3
	 * @param m34 matrix position M3_4
	 * @param m41 matrix position M4_1
	 * @param m42 matrix position M4_2
	 * @param m43 matrix position M4_3
	 * @param m44 matrix position M4_4
	 */
	public Matrix4(float m11, float m12, float m13, float m14, float m21,
			float m22, float m23, float m24, float m31, float m32, float m33,
			float m34, float m41, float m42, float m43, float m44) {
		this.m = new float[4][4];

		m[0][0] = m11;
		m[0][1] = m12;
		m[0][2] = m13;
		m[0][3] = m14;

		m[1][0] = m21;
		m[1][1] = m22;
		m[1][2] = m23;
		m[1][3] = m24;

		m[2][0] = m31;
		m[2][1] = m32;
		m[2][2] = m33;
		m[2][3] = m34;

		m[3][0] = m43;
		m[3][1] = m43;
		m[3][2] = m43;
		m[3][3] = m44;
	}

	public Matrix4(Vector4 col1, Vector4 col2, Vector4 col3, Vector4 col4) {
		this(col1.x, col1.y, col1.z, col1.w, col2.x, col2.y, col2.z, col2.w,
				col3.x, col3.y, col3.z, col3.w, col4.x, col4.y, col4.z, col4.w);
	}

	/**
	 * Constructs a Matrix4 given a Matrix4 array
	 * 
	 * @param m the Matrix4 array
	 * @throws MatrixIndexOutOfBoundsException when the array is not 4x4
	 */
	public Matrix4(float[][] m) throws MatrixIndexOutOfBoundsException {
		if (m.length != 4 || m[0].length != 4)
			throw new MatrixIndexOutOfBoundsException();
		this.m = m.clone();
	}

	// /**
	// * Constructs a Matrix4 from 3 (column) Vector3s
	// *
	// * @param v1 the first column vector
	// * @param v2 the second column vector
	// * @param v3 the third column vector
	// */
	// public Matrix4(Vector3 v1, Vector3 v2, Vector3 v3) {
	// this.m = fromVectorsCols(v1, v2, v3);
	// }

	/**
	 * Constructs a Matrix4 given another Matrix
	 * 
	 * @param matrix
	 */
	public Matrix4(Matrix4 matrix) {
		this.m = matrix.m.clone();
	}

	/**
	 * Sets all elements in m to a single value
	 * 
	 * @param m the Matrix4 to set elements in
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
	 * Increments this by another matrix
	 * 
	 * @param matrix the Matrix4 to increment this by
	 * @return this, for chaining
	 */
	public Matrix4 increment(Matrix4 matrix) {
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[0].length; j++) {
				m[i][j] += matrix.m[i][j];
			}
		}
		return this;
	}

	/**
	 * Add two matrices
	 * 
	 * @param matrix the first Matrix4 to add
	 * @param matrix the second Matrix4 to add
	 * @return A new Matrix4 which is the sum of the other two
	 */
	public static Matrix4 add(final Matrix4 m1, final Matrix4 m2) {
		Matrix4 out = new Matrix4();
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
	 * @param m1 the first Matrix
	 * @param m2 the Matrix4 to add
	 * @param out the resulting Matrix, values will be assigned to this
	 * @return the out param, for chainability
	 */
	public static Matrix4 add(final Matrix4 m1, final Matrix4 m2, Matrix4 out) {
		for (int i = 0; i < m2.m.length; i++) {
			for (int j = 0; j < m2.m[0].length; j++) {
				out.m[i][j] = m1.m[i][j] + m2.m[i][j];
			}
		}
		return out;
	}

	/**
	 * Subtract one Matrix4 from another
	 * 
	 * @param m1 the first Matrix
	 * @param m2 the Matrix4 to subtract
	 * @return A new Matrix4 which is m1 - m2
	 */
	public static Matrix4 subtract(final Matrix4 m1, final Matrix4 m2) {
		Matrix4 out = new Matrix4();
		for (int i = 0; i < m2.m.length; i++) {
			for (int j = 0; j < m2.m[0].length; j++) {
				out.m[i][j] = m1.m[i][j] - m2.m[i][j];
			}
		}
		return out;
	}

	/**
	 * Subtract one Matrix4 from another
	 * 
	 * @param m1 the first Matrix
	 * @param m2 the Matrix4 to subtract
	 * @param out the resulting Matrix, values will be assigned to this
	 * @return the out param, for chainability
	 */
	public static Matrix4 subtract(final Matrix4 m1, final Matrix4 m2,
			Matrix4 out) {
		for (int i = 0; i < m2.m.length; i++) {
			for (int j = 0; j < m2.m[0].length; j++) {
				out.m[i][j] = m1.m[i][j] - m2.m[i][j];
			}
		}
		return out;
	}

	/**
	 * Gets the negated matrix
	 * 
	 * @return the negated matrix
	 */
	public Matrix4 negate() {
		Matrix4 out = new Matrix4();
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[0].length; j++) {
				out.m[i][j] = -m[i][j];
			}
		}
		return out;
	}

	/**
	 * Negates the Matrix4 passed, and returns itself
	 * 
	 * @param matrix the Matrix4 to negate
	 * @return the the reference to the Matrix4 passed
	 */
	public static Matrix4 negate(final Matrix4 matrix) {
		for (int i = 0; i < matrix.m.length; i++) {
			for (int j = 0; j < matrix.m[0].length; j++) {
				matrix.m[i][j] = -matrix.m[i][j];
			}
		}
		return matrix;
	}

	// /**
	// * Get a (scaling) Matrix4 array from a Vector
	// *
	// * @param vector the vector
	// * @return the Matrix4 {{x 0 0} {0 y 0} {0 0 z}}
	// */
	// public static float[][] fromVector(Vector3 vector) {
	// float[][] m = { { vector.x, 0, 0 }, { 0, vector.y, 0 },
	// { 0, 0, vector.z }, };
	// return m;
	// }

	// /**
	// * Get a Matrix4 array from three vectors, where a vector represents a
	// * single column
	// *
	// * @param v1 the first column
	// * @param v2 the second column
	// * @param v3 the third column
	// * @return a Matrix4 array
	// */
	// public static float[][] fromVectorsCols(Vector3 v1, Vector3 v2, Vector3
	// v3) {
	// float[][] m = { { v1.x, v2.x, v3.x }, { v1.y, v2.y, v3.y },
	// { v1.z, v2.z, v3.z }, };
	// return m;
	// }

	// /**
	// * Get a Matrix4 array from three vectors, where a vector represents a
	// * single row
	// *
	// * @param v1 the first row
	// * @param v2 the second row
	// * @param v3 the third row
	// * @return a Matrix4 array
	// */
	// public static float[][] fromVectorsRows(Vector3 v1, Vector3 v2, Vector3
	// v3) {
	// float[][] m = { { v1.x, v1.y, v1.z }, { v2.x, v2.y, v2.z },
	// { v3.x, v3.y, v3.z }, };
	// return m;
	// }

	// /**
	// * Multiply a Vector3 by a 3x3 Matrix
	// *
	// * @param matrix the Matrix
	// * @return the resulting Vector3
	// */
	// public Vector3 multiply(Vector3 vector) {
	// Vector3 out = new Vector3();
	// out.x = m[0][0] * vector.x + m[0][1] * vector.y + m[0][2] * vector.z;
	// out.y = m[1][0] * vector.x + m[1][1] * vector.y + m[1][2] * vector.z;
	// out.z = m[2][0] * vector.x + m[2][1] * vector.y + m[2][2] * vector.z;
	// return out;
	// }

	// /**
	// * Multiply a Vector3 by a 3x3 Matrix
	// *
	// * @param matrix the input Matrix
	// * @param vector the input Vector
	// * @param out the resulting Vector will be assigned to this vector
	// * @return out, with the resulting vector values assigned
	// */
	// public static Vector3 multiply(Matrix4 matrix, Vector3 vector, Vector3
	// out) {
	// // M11*V1 + M12*V2 + M13*V3
	// out.x = matrix.m[0][0] * vector.x + matrix.m[0][1] * vector.y
	// + matrix.m[0][2] * vector.z;
	// // M21*V1 + M22*V2 + M23*V3
	// out.y = matrix.m[1][0] * vector.x + matrix.m[1][1] * vector.y
	// + matrix.m[1][2] * vector.z;
	// // M31*V1 + M32*V2 + M33*V3
	// out.z = matrix.m[2][0] * vector.x + matrix.m[2][1] * vector.y
	// + matrix.m[2][2] * vector.z;
	// return out;
	// }

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
		Matrix4 other = (Matrix4) obj;
		if (!Arrays.deepEquals(m, other.m))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Matrix4 [" + Arrays.toString(m) + "]";
	}
}
