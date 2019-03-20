package mann.game.entity;

import mann.game.entity.tool.Hitbox;
import mann.game.graphics.Graphic;

public abstract class Entity {

	protected int x, y;
	protected int width, height;
	protected Hitbox hitbox;//This field should be here, we just don't want to add it to the constructor.
	
	public Entity(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public abstract Graphic getGraphics();
	
	public abstract void render();
	
}
