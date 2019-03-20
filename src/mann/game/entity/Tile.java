package mann.game.entity;

import java.awt.Color;

public class Tile {

	public static Tile[] tiles = new Tile[256];
	public static final Tile GRASS = new Tile(0, Color.GREEN, 0);
	public static final Tile STONE = new Tile(1, Color.LIGHT_GRAY, 0);
	
	int id;
	Color color;
	int imageColor;
	
	public Tile(int id, Color color, int imageColor) {
		this.id = id;
		this.color = color;
		this.imageColor = imageColor;
		if (tiles[id] == null) {
			tiles[id] = this;
		} else {
			throw new RuntimeException("Duplicate tile id on " + id);
		}
	}
	
	public Color getColor() {
		return color;
	}
	
	public static ForegroundTile buildTileFromMatrix(int id, int x, int y) {
		return new ForegroundTile(x, y, tiles[id].color);
	}
	
}
