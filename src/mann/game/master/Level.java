package mann.game.master;

import mann.game.graphics.GraphicsEngine;

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
