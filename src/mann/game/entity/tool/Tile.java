package mann.game.entity.tool;

import java.awt.Color;

import mann.game.entity.ForegroundTile;

public class Tile {

	private static Tile[] tiles = new Tile[256];
	private static final Tile GRASS = new Tile(0, 0x00ff00, 0, true);
	private static final Tile STONE = new Tile(1, 0xcccccc, 0, true);
	private static final Tile PLAYER = new Tile(0, 0x800080, 0, true);
	
	private int id;
	private int color;
	private int imageColor;
	
	public Tile(int id, int color, int imageColor, boolean isForeground) {
		this.id = id;
		this.color = color;
		this.imageColor = imageColor;
		if (tiles[id] == null) {
			tiles[id] = this;
		} else {
			throw new RuntimeException("Duplicate tile id on " + id);
		}
	}
	
	public int getColor() {
		return color;
	}
	
	public static ForegroundTile buildTileFromMatrix(int id, int x, int y) {
		return new ForegroundTile(x, y, tiles[id].getColor());
	}
	
}
