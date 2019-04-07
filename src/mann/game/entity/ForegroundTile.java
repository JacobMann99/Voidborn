package mann.game.entity;

import java.awt.Color;

import mann.game.entity.tool.Hitbox;
import mann.game.graphics.Graphic;

/**
 * @author Christopher Zagurski
 */
public class ForegroundTile extends Tile {

	public ForegroundTile(int x, int y, int color) {
		super(x, y, color);
		this.hitbox = new Hitbox(this, width, height, 0, 0);
	}
	
}
