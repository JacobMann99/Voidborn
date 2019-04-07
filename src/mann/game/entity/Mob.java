package mann.game.entity;

import mann.game.entity.tool.Hitbox;
import mann.game.graphics.Graphic;
import mann.game.world.Zone;

public abstract class Mob extends Entity {

	protected Zone zone;
	public Graphic graphic;
	
	public int hitWidth, hitHeight, hitboxXOffset, hitboxYOffset;
	
	public Mob(int x, int y, int width, int height, String filepath, Hitbox hitbox, Zone zone) {
		super(x, y, width, height);
		this.hitbox = new Hitbox(this, width, height, 0, 0);
		graphic = new Graphic(filepath);
		this.zone = zone;
	}

	public Mob(int x, int y, int width, int height, int hitWidth, int hitHeight, int hitboxXOffset,
			int hitboxYOffset, String filepath, Zone zone) {
		super(x, y, width, height);
		this.hitWidth = hitWidth;
		this.hitHeight = hitHeight;
		this.hitboxXOffset = hitboxXOffset;
		this.hitboxYOffset = hitboxYOffset;
		this.hitbox = new Hitbox(this, hitWidth, hitHeight, hitboxXOffset, hitboxYOffset);
		graphic = new Graphic(filepath);
		this.zone = zone;
	}
	
	public boolean[] move(int xDelta, int yDelta) {
		if (Math.abs(xDelta) + Math.abs(yDelta) == 0) return null;
		int xTick = 0;
		int yTick = 0;
		boolean[] successes = new boolean[Math.abs(xDelta) + Math.abs(yDelta)];
		if (xDelta < 0) xTick = -1;
		if (xDelta > 0) xTick = 1;
		if (yDelta < 0) yTick = -1;
		if (yDelta > 0) yTick = 1;
		int i;
		for (i = 0; i < Math.abs(xDelta); i++) {
			successes[i] = moveX(xTick);
		}
		for (; i < Math.abs(xDelta) + Math.abs(yDelta); i++) {
			successes[i] = moveY(yTick);
		}
		return successes;
	}

	public boolean moveX(int xDelta) {
		if (xDelta != 0) {
			if (xDelta < 0) {
				for (Entity e : zone.getEntities()) {
					if (this.hitbox.isCollidingLeft(e.hitbox)) {
						return false;
					}
				}
				this.x--;
			}
			if (xDelta > 0) {
				for (Entity e : zone.getEntities()) {
					if (this.hitbox.isCollidingRight(e.hitbox)) {
						return false;
					}
				}
				this.x++;
			}
		}
		hitbox.update(hitWidth, hitHeight, hitboxXOffset, hitboxYOffset);
		return true;
	}

	public boolean moveY(int yDelta) {
		if (yDelta != 0) {
			if (yDelta < 0) {
				for (Entity e : zone.getEntities()) {
					if (this.hitbox.isCollidingTop(e.hitbox)) {
						return false;
					}
				}
				this.y--;
			}
			if (yDelta > 0) {
				for (Entity e : zone.getEntities()) {
					if (this.hitbox.isCollidingBottom(e.hitbox)) {
						return false;
					}
				}
				this.y++;
			}
		}
		hitbox.update(hitWidth, hitHeight, hitboxXOffset, hitboxYOffset);
		return true;
	}

}
