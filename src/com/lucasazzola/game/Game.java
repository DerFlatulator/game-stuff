package com.lucasazzola.game;

import com.lucasazzola.game.graphics.render.Graphics;
import com.lucasazzola.game.util.GameTime;

/**
 * Game Interface
 * 
 * @author Lucas Azzola
 * @since 16/8/2012
 */
public abstract class Game {

	public abstract void Load();

	public abstract void Update(GameTime time);

	public abstract void Draw(Graphics g);

	public abstract void Unload();
}
