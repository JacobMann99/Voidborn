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
	
	private final int X_OFFSET, Y_OFFSET;
	private final int WIDTH, HEIGHT;
	
	private Entity e;
	private int[] xBounds = new int[2];
	private int[] yBounds = new int[2];
	
	private Entity collidingEntity = null;
	
	/**
	 * Sole constructor for the hitbox object.  It adds a reference to its paired entity and sets the bounds and
	 * position for the hitbox.
	 * @param e
	 *            The entity with which the hitbox is paired
	 * @param xOffset
	 *            The positive distance between the entity's x position and the left side of the hitbox
	 * @param yOffset
	 *            The positive distance between the entity's y position and the top side of the hitbox
	 * @param width
	 *            The width of the entity's hitbox
	 * @param height
	 *            The height of the entity's hitbox
	 */
	public Hitbox(Entity e, int xOffset, int yOffset, int width, int height) {
		this.e = e;
		this.X_OFFSET = xOffset;
		this.Y_OFFSET = yOffset;
		this.WIDTH = width;
		this.HEIGHT = height;
		updatePosition();
		hitboxArray.add(this);
	}
	
	/**
	 * Method called by the paired entity to update any possible changes in position and clears any saved
	 * collided entities.
	 */
	public void updatePosition() {
		xBounds[0] = e.getX() - X_OFFSET;
		xBounds[1] = e.getX() - X_OFFSET + WIDTH;
		yBounds[0] = e.getY() - Y_OFFSET;
		yBounds[1] = e.getY() - Y_OFFSET + HEIGHT;
		collidingEntity = null;
	}
	
	/**
	 * Returns true if this hitbox is colliding with another hitbox in the x direction, false if not.
	 * If true, the hitbox saves the entity with which it just collided, but this reference is removed
	 * if the updatePosition method is called.
	 * @return true during a collision, false otherwise
	 */
	public boolean isCollidingX() {
		for (Hitbox hitbox : hitboxArray) {
			if (hitbox.yBounds[0] >= this.yBounds[0] || hitbox.yBounds[0] <= this.yBounds[1] ||
					hitbox.yBounds[1] >= this.yBounds[0] || hitbox.yBounds[1] <= this.yBounds[1]) {
				if (hitbox.xBounds[0] == this.xBounds[1] + 1 || hitbox.xBounds[1] == this.xBounds[0] - 1)
					collidingEntity = hitbox.e;
					return true;
			}
		}
		return false;
	}
	
	/**
	 * Returns true if this hitbox is colliding with another hitbox in the y direction, false if not.
	 * If true, the hitbox saves the entity with which it just collided, but this reference is removed
	 * if the updatePosition method is called.
	 * @return true during a collision, false otherwise
	 */
	public boolean isCollidingY() {
		for (Hitbox hitbox : hitboxArray) {
			if (hitbox.xBounds[0] >= this.xBounds[0] || hitbox.xBounds[0] <= this.xBounds[1] ||
					hitbox.xBounds[1] >= this.xBounds[0] || hitbox.xBounds[1] <= this.xBounds[1]) {
				if (hitbox.yBounds[0] == this.yBounds[1] + 1 || hitbox.yBounds[1] == this.yBounds[0] - 1)
					collidingEntity = hitbox.e;
					return true;
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
	
}
