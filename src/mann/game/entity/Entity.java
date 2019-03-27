package mann.game.entity;

import mann.game.entity.tool.Hitbox;
import mann.game.graphics.Graphic;

public abstract class Entity {

	protected int x, y;
	protected int width, height;
	protected int[] pixels;
	protected Hitbox hitbox;//This field should be here, we just don't want to add it to the constructor.
	
	public Entity(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		pixels = new int[width * height];
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
	
	public abstract void tick();
	
	public abstract int[] render();
	
}
