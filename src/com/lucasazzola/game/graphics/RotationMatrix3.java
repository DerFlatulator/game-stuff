package com.lucasazzola.game.graphics;

import java.util.Arrays;

import com.lucasazzola.game.math.Angle;

/**
 * Matrix3 wrapper class with added constructors for rotation matrices, can be
 * safely up-casted to a Matrix3 to perform other matrix operations
 * 
 * @author Lucas Azzola
 * @since 21/8/12
 */
public class RotationMatrix3 extends Matrix3 {

	/**
	 * Construct a rotation matrix with the default value (0)
	 */
	public RotationMatrix3() {
		super();
	}

	/**
	 * Constructs a 3x3 matrix of values 0
	 */
	public RotationMatrix3(float value) {
		super(value);
	}

	/**
	 * Constructs a Matrix3 given another Matrix3
	 * 
	 * @param Matrix3
	 */
	public RotationMatrix3(Matrix3 matrix) {
		super(matrix);
	}

	/**
	 * Construct a rotation matrix given an angle and an axis
	 * 
	 * @param angle the angle to rotate
	 * @param axis the axis to rotate about
	 */
	public RotationMatrix3(Angle angle, Axis axis) {
		super();
		this.setRotation(angle, axis);
	}

	/**
	 * Construct a rotation matrix given an angle and an arbitrary axis. It is
	 * assumed that the input Vector3 is a unit vector, and no check is made to
	 * increase performance. Passing a non-unit vector may result in an improper
	 * matrix.
	 * 
	 * @param angle the angle to rotate
	 * @param axis the unit vector which represents the arbitrary axis to rotate
	 *            about
	 */
	public RotationMatrix3(Angle angle, Vector3 unitVectorArbitraryAxis) {
		super();
		setRotation(angle, unitVectorArbitraryAxis);
	}

	/**
	 * Construct a rotation matrix given an angle and an axis
	 * 
	 * @param angle the angle to rotate
	 * @param axis the axis to rotate about
	 */
	public void setRotation(Angle angle, Axis axis) {
		Vector3 row1, row2, row3;
		float cosT, sinT;

		cosT = (float) Math.cos(angle.getRadians());
		sinT = (float) Math.sin(angle.getRadians());

		switch (axis) {
			case X:
				row1 = new Vector3(1, 0, 0);
				row2 = new Vector3(0, cosT, -sinT);
				row3 = new Vector3(0, sinT, cosT);

				super.fromVectorsRows(row1, row2, row3);
				break;
			case Y:
				row1 = new Vector3(cosT, 0, sinT);
				row2 = new Vector3(0, 1, 0);
				row3 = new Vector3(-sinT, 0, cosT);

				super.fromVectorsRows(row1, row2, row3);
				break;
			case Z:
				row1 = new Vector3(cosT, -sinT, 0);
				row2 = new Vector3(sinT, cosT, 0);
				row3 = new Vector3(0, 0, 1);

				m = super.fromVectorsRows(row1, row2, row3);
		}
	}

	/**
	 * Sets the rotation matrix given an angle and an arbitrary axis. It is
	 * assumed that the input Vector3 is a unit vector, and no check is made to
	 * increase performance. Passing a non-unit vector may result in an improper
	 * matrix.
	 * 
	 * @param angle the angle to rotate
	 * @param axis the unit vector which represents the arbitrary axis to rotate
	 *            about
	 */
	public void setRotation(Angle angle, Vector3 unitVectorArbitraryAxis) {
		Vector3 row1, row2, row3;
		float cosT, sinT, oneMCosT, x, y, z, xx, yy, zz;

		x = unitVectorArbitraryAxis.x;
		y = unitVectorArbitraryAxis.y;
		z = unitVectorArbitraryAxis.z;
		xx = x * x;
		yy = y * y;
		zz = z * z;

		cosT = (float) Math.cos(angle.getRadians());
		sinT = (float) Math.sin(angle.getRadians());
		oneMCosT = 1.0f - cosT;

		row1 = new Vector3(cosT + xx * oneMCosT, x * y * oneMCosT - z * sinT, x
				* z * oneMCosT + y * sinT);
		row2 = new Vector3(x * y * oneMCosT + z * sinT, cosT + yy * oneMCosT, y
				* z * oneMCosT - x * sinT);
		row3 = new Vector3(x * z * oneMCosT - y * sinT, y * z * oneMCosT + x
				* sinT, cosT + zz * oneMCosT);

		m = super.fromVectorsRows(row1, row2, row3);
	}

	@Override
	public String toString() {
		return "RotationMatrix3 [\n" + Arrays.toString(m[0]) + "\n"
				+ Arrays.toString(m[1]) + "\n" + Arrays.toString(m[2]) + "\n]";
	}
}
