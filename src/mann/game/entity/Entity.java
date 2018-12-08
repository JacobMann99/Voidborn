package mann.game.entity;

public abstract class Entity {

	private int x, y;
	private int width, height;
	
	public Entity(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
}
