package mann.game.entity;

public abstract class Tile extends Entity {

	public Tile(int x, int y, int color) {
		super(x, y, 36, 36);
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				pixels[i + j * width] = color;
			}
		}
	}
	
	public void tick() {
		return;
	}
	
	public int[] render() {
		return pixels;
	}

}
