package mann.game.entity;

import mann.game.entity.tool.Hitbox;
import mann.game.graphics.Graphic;
import mann.game.world.Zone;

public abstract class Mob extends Entity {

	protected Zone zone;
	public Graphic graphic;

	public Mob(int x, int y, int width, int height, String filepath, Hitbox hitbox, Zone zone) {
		super(x, y, width, height);
		this.hitbox = new Hitbox(this, width, height, 0, 0);
		graphic = new Graphic(filepath);
		this.zone = zone;
	}

	public Mob(int x, int y, int width, int height, int hitWidth, int hitHeight, int hitboxXOffset,
			int hitboxYOffset, String filepath, Zone zone) {
		super(x, y, width, height);
		this.hitbox = new Hitbox(this, hitWidth, hitHeight, hitboxXOffset, hitboxYOffset);
		graphic = new Graphic(filepath);
		this.zone = zone;
	}

	public boolean moveX(int xDelta) {
		if (xDelta != 0) {
			boolean isColliding = false;
			if (xDelta < 0) {
				for (Entity e : zone.getEntities()) {
					if (this.hitbox.isCollidingLeft(e.hitbox)) {
						isColliding = true;
					}
				}
				if (!isColliding) x--;
			}
			if (xDelta > 0) {
				for (Entity e : zone.getEntities()) {
					if (this.hitbox.isCollidingRight(e.hitbox)) {
						isColliding = true;
					}
				}
				if (!isColliding) x++;
			}
		}
		return true;
	}

	public boolean moveY(int yDelta) {
		if (yDelta != 0) {
			boolean isColliding = false;
			if (yDelta < 0) {
				for (Entity e : zone.getEntities()) {
					if (this.hitbox.isCollidingTop(e.hitbox)) {
						isColliding = true;
					}
				}
				if (!isColliding) y--;
			}
			if (yDelta > 0) {
				for (Entity e : zone.getEntities()) {
					if (this.hitbox.isCollidingBottom(e.hitbox)) {
						isColliding = true;
					}
				}
				if (!isColliding) y++;
			}
		}
		return true;
	}

}
