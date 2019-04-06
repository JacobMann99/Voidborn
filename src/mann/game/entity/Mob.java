package mann.game.entity;

import mann.game.entity.tool.Hitbox;
import mann.game.graphics.Graphic;

public abstract class Mob extends Entity {

	public Graphic graphic;

	public Mob(int x, int y, int width, int height, String filepath, Hitbox hitbox) {
		super(x, y, width, height);
		this.hitbox = new Hitbox();
		this.hitbox.init(this, 0, 0, width, height);
		graphic = new Graphic(filepath);
	}

	public Mob(int x, int y, int width, int height, int hitWidth, int hitHeight, int hitboxXOffset,
			int hitboxYOffset, String filepath) {
		super(x, y, width, height);
		this.hitbox = new Hitbox();
		this.hitbox.init(this, hitboxXOffset, hitboxYOffset, hitWidth, hitHeight);
		graphic = new Graphic(filepath);
	}

	public boolean moveX(int xDelta) {
		if (xDelta != 0) {
			boolean dir = true;
			if (xDelta > 0)
				dir = false;
			for (int i = 0; i < Math.abs(xDelta); i++) {
				if (hitbox.isCollidingX(dir))
					return false;
				this.x += xDelta / Math.abs(xDelta);
			}
		}
		return true;
	}

	public boolean moveY(int yDelta) {
		if (yDelta != 0) {
			boolean dir = true;
			if (yDelta > 0)
				dir = false;
			for (int i = 0; i < Math.abs(yDelta); i++) {
				if (hitbox.isCollidingX(dir))
					return false;
				this.y += yDelta / Math.abs(yDelta);
			}
		}
		return true;
	}

}
