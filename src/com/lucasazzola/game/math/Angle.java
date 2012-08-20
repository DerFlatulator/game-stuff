package com.lucasazzola.game.math;

/**
 * Basic angle conversions
 * 
 * @author Lucas Azzola
 * @since 16/8/2012
 */
public class Angle {

	/**
	 * Private members
	 */
	private float inRadians, inDegrees;
	private boolean degreesIsSet, radiansIsSet;

	/**
	 * Stores an angle, in radians
	 * 
	 * @param radians the angle in radians
	 */
	public Angle(float radians) {
		inRadians = radians;
		degreesIsSet = false;
		radiansIsSet = true;
	}

	/**
	 * Stores an angle, in degrees
	 * 
	 * @param degrees the angle in degrees
	 * @param ignored this parameter is ignored (used to modify the signature)
	 */
	public Angle(float degrees, boolean ignored) {
		inDegrees = degrees;
		degreesIsSet = true;
		radiansIsSet = false;
	}

	/**
	 * Gets the angle in degrees
	 * 
	 * @return the angle in degrees
	 */
	public float getDegrees() {
		if (degreesIsSet)
			return inDegrees;
		inDegrees = radiansToDegrees(inRadians);
		degreesIsSet = true;
		return inDegrees;
	}

	/**
	 * Gets the angle in radians
	 * 
	 * @return the angle in radians
	 */
	public float getRadians() {
		if (radiansIsSet)
			return inRadians;
		inRadians = degreesToRadians(inRadians);
		radiansIsSet = true;
		return inRadians;
	}

	/**
	 * Converts an angle to radians
	 * 
	 * @param degrees the angle in radians
	 * @return the angle in radians
	 */
	public static float degreesToRadians(float degrees) {
		return (float) (degrees * Math.PI) / 180;
	}

	/**
	 * Converts an angle to degrees
	 * 
	 * @param radians the angle in degrees
	 * @return the angle in degrees
	 */
	public static float radiansToDegrees(float radians) {
		return (float) ((radians * 180f) / Math.PI);
	}

	@Override
	public String toString() {
		if (degreesIsSet)
			return inDegrees + "ᵒ";
		return inRadians + "ᶜ";
	}
}
