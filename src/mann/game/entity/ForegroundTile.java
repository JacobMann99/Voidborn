package mann.game.entity;

import mann.game.entity.tool.Hitbox;

//
/**
 * @author Christopher Zagurski
 *
 */
public class ForegroundTile extends Entity{
	private int x, y;
	private int height, width;
	private Hitbox hitbox;//This might not be used, I just put it here just in-case we want to create an object that helps create an object
	public ForegroundTile(int x, int y, Hitbox hitbox) {//I think this is what we want to do.
		super(x, y);
		if(hitbox != null) {
		this.hitbox = hitbox;
		}else {
		this.hitbox = null;
		}
	}
}
