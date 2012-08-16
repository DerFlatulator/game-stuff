package com.lucasazzola.game.math;

/**
 * Original (java.lang.Math) class is final. This is added Maths functionality
 * 
 * @author Lucas Azzola
 * @since 16/8/2012
 */
public final class GameMath {

	/**
	 * Gets the inverse square root of a number
	 * 
	 * @return the inverse square root
	 */
	public static final float invSqrt(float x) {
		float xhalf = 0.5f * x;
		int i = Float.floatToIntBits(x);
		i = 0x5f3759df - (i >> 1);
		x = Float.intBitsToFloat(i);
		x = x * (1.5f - xhalf * x * x);
		return x;
	}

	/**
	 * Gets the inverse square root of a number
	 * 
	 * @return the inverse square root
	 */
	public static final double invSqrt(double x) {
		// Note this uses doubles and could be proven slower than other
		// implementations
		double xhalf = 0.5f * x;
		long i = Double.doubleToLongBits(x);
		i = 0x5fe6eb50c7b537a9L - (i >> 1);
		x = Double.longBitsToDouble(i);
		x = x * (1.5f - xhalf * x * x);
		return x;
	}

}
