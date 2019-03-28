package mann.game.entity;

import mann.game.entity.tool.Hitbox;

public abstract class Mob extends Entity {

	public Mob(int x, int y, int width, int height) {
		super(x, y, width, height);
		hitbox = new Hitbox();
		hitbox.init(this, 0, 0, width, height);
	}
	
	public Mob(int x, int y, int width, int height, int hitboxXOffset, int hitboxYOffset) {
		super(x, y, width, height);
		hitbox = new Hitbox();
		hitbox.init(this, hitboxXOffset, hitboxYOffset, width, height);
	}
	
	public boolean moveX(int xDelta) {
		if (xDelta != 0) {
			boolean dir = true;
			if (xDelta > 0) dir = false;
			for (int i = 0; i < xDelta; i++) {
				if (hitbox.isCollidingX(dir)) return false;
				this.x += xDelta / Math.abs(xDelta);
			}
		}
		return true;
	}
	
	public boolean moveY(int yDelta) {
		if (yDelta != 0) {
			boolean dir = true;
			if (yDelta > 0) dir = false;
			for (int i = 0; i < yDelta; i++) {
				if (hitbox.isCollidingX(dir)) return false;
				this.y += yDelta / Math.abs(yDelta);
			}
		}
		return true;
	}

}
