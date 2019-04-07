package mann.game.entity.tool;

import java.util.ArrayList;

import mann.game.entity.Entity;

/**
 * This object, intended to be paired to a single entity, is designed to allow
 * detection for collision with other entities. It holds methods allowing the
 * entity to detect collisions, update the hitbox's position, and get a
 * reference to an entity that it has just collided with.
 * 
 * @author Jacob Mann
 */
public class Hitbox {

	private Entity entity;
	private int[] xBound = new int[2];
	private int[] yBound = new int[2];

	public Hitbox(Entity entity, int width, int height, int xOffset, int yOffset) {
		this.entity = entity;
		update(width, height, xOffset, yOffset);
	}

	public void update(int width, int height, int xOffset, int yOffset) {
		xBound[0] = entity.getX() + xOffset;
		xBound[1] = entity.getX() + xOffset + width;
		yBound[0] = entity.getY() + yOffset - height;
		yBound[1] = entity.getY() + yOffset;
	}

	public boolean isColliding(Hitbox other) {
		if (checkIfNull(other)) return false;
		if (checkIfAlignedX(other) && checkIfAlignedY(other)) return true;
		return false;
	}

	public boolean isCollidingBottom(Hitbox other) {
		if (checkIfNull(other)) return false;
		if (!checkIfAlignedX(other)) return false;
		if (yBound[1] == other.yBound[0] || yBound[1] == other.yBound[0] - 1) {
			return true;
		}
		return false;
	}

	public boolean isCollidingTop(Hitbox other) {
		if (checkIfNull(other)) return false;
		if (!checkIfAlignedX(other)) return false;
		if (yBound[0] == other.yBound[1] || yBound[0] == other.yBound[1] + 1) {
			return true;
		}
		return false;
	}

	public boolean isCollidingRight(Hitbox other) {
		if (checkIfNull(other)) return false;
		if (!checkIfAlignedY(other)) return false;
		if (xBound[1] == other.xBound[0] || xBound[1] == other.xBound[0] - 1) {
			return true;
		}
		return false;
	}

	public boolean isCollidingLeft(Hitbox other) {
		if (checkIfNull(other)) return false;
		if (!checkIfAlignedY(other)) return false;
		if (xBound[0] == other.xBound[1] || xBound[0] == other.xBound[1] + 1) {
			return true;
		}
		return false;
	}
	
	private boolean checkIfAlignedX(Hitbox other) {
		// check if this hitbox is horizontally aligned with the other hitbox
		for (int bound : xBound) {
			if (bound >= other.xBound[0] && bound <= other.xBound[1]) {
				return true;
			}
		}
		// check if the other hitbox is horizontally aligned with this hitbox
		for (int bound : other.xBound) {
			if (bound >= xBound[0] && bound <= xBound[1]) {
				return true;
			}
		}
		return false;
	}
	
	private boolean checkIfAlignedY(Hitbox other) {
		// check if this hitbox is vertically aligned with the other hitbox
		for (int bound : yBound) {
			if (bound >= other.yBound[0] && bound <= other.yBound[1]) {
				return true;
			}
		}
		// check if the other hitbox is vertically aligned with this hitbox
		for (int bound : other.yBound) {
			if (bound >= yBound[0] && bound <= yBound[1]) {
				return true;
			}
		}
		return false;
	}
	
	private boolean checkIfNull(Hitbox other) {
		if (other == null) return true;
		return false;
	}

}
