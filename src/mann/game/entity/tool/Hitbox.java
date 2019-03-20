package mann.game.entity.tool;

import java.util.ArrayList;

import mann.game.entity.Entity;

/**
 * This object, intended to be paired to a single entity, is designed to allow detection for collision with
 * other entities. It holds methods allowing the entity to detect collisions, update the hitbox's position,
 * and get a reference to an entity that it has just collided with.
 * @author Jacob Mann
 */
public class Hitbox {

	private static ArrayList<Hitbox> hitboxArray = new ArrayList<Hitbox>();
	
	private Entity e;
	private int[] xBounds = new int[2];
	private int[] yBounds = new int[2];
	
	private Entity collidingEntity = null;
	
	/**
	 * Sole constructor for the hitbox object.  It adds a reference to its paired entity and sets the bounds and
	 * position for the hitbox.
	 * @param e The entity with which the hitbox is paired
	 * @param xOffset The difference from the entity's x position and the left side of the hitbox
	 * @param yOffset The difference from the entity's y position and the top side of the hitbox
	 * @param width The width of the entity's hitbox
	 * @param height The height of the entity's hitbox
	 */
	public Hitbox() {
		hitboxArray.add(this);
	}
	
	public void init(Entity e, int xOffset, int yOffset, int width, int height) {
		this.e = e;
		updatePosition(xOffset, yOffset, width, height);
	}
	
	/**
	 * Updates the position of the hitbox's bounds with an xOffset, yOffset, width, and height
	 * given by the object
	 * 
	 * @param xOffset
	 * @param yOffset
	 * @param width
	 * @param height
	 */
	public void updatePosition(int xOffset, int yOffset, int width, int height) {
		xBounds[0] = e.getX() + xOffset;
		xBounds[1] = e.getX() + xOffset + width;
		yBounds[0] = e.getY() + yOffset;
		yBounds[1] = e.getY() + yOffset + height;
		collidingEntity = null;
	}
	
	/**
	 * Returns true if this hitbox is colliding with another hitbox in the x direction, false if not.
	 * If true, the hitbox saves the entity with which it just collided, but this reference is removed
	 * if the updatePosition method is called.
	 * @param dir Should be passed in as true for left, false for right
	 * @return true during a collision, false otherwise
	 */
	public boolean isCollidingX(boolean dir) {
		for (Hitbox hitbox : hitboxArray) {
			if (hitbox.yBounds[0] >= this.yBounds[0] || hitbox.yBounds[0] <= this.yBounds[1] ||
					hitbox.yBounds[1] >= this.yBounds[0] || hitbox.yBounds[1] <= this.yBounds[1]) {
				if (dir && hitbox.xBounds[0] == this.xBounds[1] + 1) {
					collidingEntity = hitbox.e;
					return true;
				} else if (!dir && hitbox.xBounds[1] == this.xBounds[0] - 1) {
					collidingEntity = hitbox.e;
					return true;
				}
			}
		}
		return false;
	}
	
	/**
	 * Returns true if this hitbox is colliding with another hitbox in the y direction, false if not.
	 * If true, the hitbox saves the entity with which it just collided, but this reference is removed
	 * if the updatePosition method is called.
	 * @param dir Should be passed in as true for down, false for up
	 * @return true during a collision, false otherwise
	 */
	public boolean isCollidingY(boolean dir) {
		for (Hitbox hitbox : hitboxArray) {
			if (hitbox.xBounds[0] >= this.xBounds[0] || hitbox.xBounds[0] <= this.xBounds[1] ||
					hitbox.xBounds[1] >= this.xBounds[0] || hitbox.xBounds[1] <= this.xBounds[1]) {
				if (dir && hitbox.yBounds[0] == this.yBounds[1] + 1) {
					collidingEntity = hitbox.e;
					return true;
				} else if (!dir && hitbox.yBounds[1] == this.yBounds[0] - 1) {
					collidingEntity = hitbox.e;
					return true;
				}
			}
		}
		return false;
	}
	
	/**
	 * Returns a reference to the entity that the hitbox has just collided with.
	 * @return a collided entity
	 */
	public Entity getCollidedEntity() {
		return collidingEntity;
	}
	
	/**
	 * Removes hitbox from the arrayList when it is no longer needed.
	 * @param hitbox hitbox to be removed
	 */
	public static void deleteHitbox(Hitbox hitbox) {
		for (Hitbox box : hitboxArray) {
			if (box == hitbox) {
				hitboxArray.remove(box);
				return;
			}
		}
	}
	
}
