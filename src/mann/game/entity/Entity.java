package mann.game.entity;

import mann.game.entity.tool.Hitbox;

public abstract class Entity {

	private int x, y;
	private int width, height;
	private Hitbox hitbox;//This field should be here, we just don't want to add it to the constructor.
	
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
	
}
