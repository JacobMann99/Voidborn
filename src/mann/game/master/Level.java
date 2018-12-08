package mann.game.master;

import mann.game.graphics.GraphicsEngine;

/**
 * Controls game logic; represented by the main class's tick() method. All processes besides graphics
 * respond to this class.
 * @author Jacob Mann
 */
public class Level {

	GraphicsEngine graphics;
	InputHandler input;
	
	public Level(GraphicsEngine g, InputHandler input) {
		this.graphics = g;
		this.input = input;
	}
	
	public void tick() {
		
	}
	
}
