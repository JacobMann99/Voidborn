package mann.game.entity.tool;

import java.awt.Color;

import mann.game.entity.ForegroundTile;

public class Tile {

	private static Tile[] tiles = new Tile[256];
	private static final Tile GRASS = new Tile(0, Color.GREEN, 0);
	private static final Tile STONE = new Tile(1, Color.LIGHT_GRAY, 0);
	
	private int id;
	private Color color;
	private int imageColor;
	
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
		return new ForegroundTile(x, y, tiles[id].getColor());
	}
	
}
