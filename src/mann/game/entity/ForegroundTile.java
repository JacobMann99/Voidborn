package mann.game.entity;

import java.awt.Color;

import mann.game.entity.tool.Hitbox;
import mann.game.graphics.Graphic;

/**
 * @author Christopher Zagurski
 *
 */
public class ForegroundTile extends Entity {
	private Graphic img;
	private Color color;

	public ForegroundTile(int x, int y, Color color) {
		super(x, y);
		width = 36;
		height = 36;
		this.color = color;
		this.hitbox = new Hitbox();
		hitbox.init(this, 0, 0, width, height);
		img = new Graphic(x, y, width, height, color);
	}
	
	public Graphic getGraphics() {
		return img;
	}
	
	public void tick() {
		//x++;
	}
	
	public void render() {
		img = new Graphic(x, y, width, height, color);
		img.render();
	}
	
}
