package com.lucasazzola.game.graphics;

import com.lucasazzola.game.math.Angle;

public class Quaternion {

	public float x, y, z, w;

	public Quaternion() {
		this(1, 0, 0, 0);
	}

	public Quaternion(float w, float x, float y, float z) {
		this.w = w;
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public Quaternion(Vector4 vector) {
		this(vector.w, vector.x, vector.y, vector.z);
	}

	public void createFromAxisAngle(float x, float y, float z, Angle angle) {
		float rads = angle.getRadians();
		float result = (float) Math.sin(rads / 2.0f);

		this.w = (float) Math.cos(rads / 2.0f);
		this.x = (float) x * result;
		this.y = (float) y * result;
		this.z = (float) z * result;
	}

	public Matrix4 createMatrix() {
		float xx = x * x, yy = y * y, zz = z * z;
		Vector4 col1, col2, col3, col4;
		col1 = new Vector4(1 - 2.0f * (yy + zz), 2.0f * (x * y - w * z),
				2.0f * (x * z + w * y), 0);
		col2 = new Vector4(2.0f * (x * y + w * z), 1 - 2.0f * (xx + zz),
				2.0f * (y * z - w * x), 0);
		col3 = new Vector4(2.0f * (x * z - w * y), 2.0f * (y * z + w * x),
				1.0f - 2.0f * (xx + yy), 0);
		col4 = new Vector4(0, 0, 0, 1);
		return new Matrix4(col1, col2, col3, col4);
	}

	Quaternion multiply(final Quaternion q) {
		Vector4 v = new Vector4();

		v.w = w * q.w - x * q.x - y * q.y - z * q.z;
		v.x = w * q.x + x * q.w + y * q.z - z * q.y;
		v.y = w * q.y + y * q.w + z * q.x - x * q.z;
		v.z = w * q.z + z * q.w + x * q.y - y * q.x;

		return new Quaternion(v);
	}
}
