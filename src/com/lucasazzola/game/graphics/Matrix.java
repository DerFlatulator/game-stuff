package com.lucasazzola.game.graphics;

import java.util.Arrays;

public abstract class Matrix {

	/**
	 * Public Matrix
	 * 
	 * [Column-1][Row-1]
	 */
	public float[][] m;

	// public abstract Matrix increment(Matrix matrix);

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
		return Arrays.deepEquals(m, ((Matrix) obj).m);
	}

	@Override
	public String toString() {
		return "Matrix [" + Arrays.toString(m) + "]";
	}
}
