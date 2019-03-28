package mann.game.entity;

import java.awt.Color;

import mann.game.entity.tool.Hitbox;
import mann.game.graphics.Graphic;

/**
 * @author Christopher Zagurski
 *
 */
public class ForegroundTile extends Entity {
	private int color;

	public ForegroundTile(int x, int y, int color) {
		super(x, y, 36, 36);
		width = 36;
		height = 36;
		this.color = color;
		this.hitbox = new Hitbox();
		hitbox.init(this, 0, 0, width, height);
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				pixels[i + j * width] = color;
			}
		}
	}
	
	public void tick() {
		//x++;
	}
	
	public int[] render() {
		return pixels;
	}
	
}
