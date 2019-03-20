package mann.game.entity;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import mann.game.entity.ForegroundTile.ForegroundTileGraphic;
import mann.game.entity.tool.Hitbox;

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
	
	public abstract ForegroundTileGraphic getGraphics();
	
	public abstract void render();
	
}
