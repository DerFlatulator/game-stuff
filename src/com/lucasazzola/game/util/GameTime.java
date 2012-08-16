package com.lucasazzola.game.util;

/**
 * GameTime object used to maintain timings within the game loop
 * 
 * @author Lucas Azzola
 * @since 16/8/2012
 */
public class GameTime {

	private long startTime;
	private long elapsed;

	public GameTime() {
	}

	public void reset() {
		startTime = now();
		elapsed = 0;
	}

	public long elapsed() {
		if (elapsed == -1)
			elapsed = now() - startTime;

		return elapsed;
	}

	public static long now() {
		return System.nanoTime();
	}
}
