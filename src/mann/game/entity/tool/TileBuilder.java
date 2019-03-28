package mann.game.entity.tool;

import mann.game.entity.BackgroundTile;
import mann.game.entity.ForegroundTile;
import mann.game.entity.Tile;

/**
 * A tool to easily create and return level tiles from core templates. Only two
 * static methods, different tools to return new level tiles, are public in this class.
 * 
 * @author Jacob Mann
 */
public class TileBuilder {

	private static TileBuilder[] tiles = new TileBuilder[256];
	private static final TileBuilder AIR = new TileBuilder(0, 0xffffff, 0xffffff, false);
	private static final TileBuilder GRASS = new TileBuilder(1, 0x00ff00, 0x00ff00, true);
	private static final TileBuilder STONE = new TileBuilder(2, 0xcccccc, 0xcccccc, true);
	
	private int id;
	private int color;
	private int imageColor;
	private boolean isForeground;
	
	private TileBuilder(int id, int color, int imageColor, boolean isForeground) {
		this.id = id;
		this.color = color;
		this.imageColor = imageColor;
		this.isForeground = isForeground;
		if (tiles[id] == null) {
			tiles[id] = this;
		} else {
			throw new RuntimeException("Duplicate tile id on " + id);
		}
	}
	
	private int getColor() {
		return color;
	}
	
	private int getImageColor() {
		return imageColor;
	}
	
	private boolean isForeground() {
		return isForeground;
	}
	
	/**
	 * Creates and returns a foreground or background tile based on the value of the tile id
	 * entered as a parameter.
	 * @param id the id of the tile
	 * @param x x value of the intended location of the tile
	 * @param y y value of the intended location of the tile
	 * @return a new foreground or background tile
	 */
	public static Tile buildTileFromMatrix(int id, int x, int y) {
		if (tiles[id] == null) return null;
		if (tiles[id].isForeground()) {
			return new ForegroundTile(x, y, tiles[id].getColor());
		} else {
			return new BackgroundTile(x, y, tiles[id].getColor());
		}
	}
	
	/**
	 * Creates and returns a foreground or background tile based on the value of the image
	 * color entered as a parameter.
	 * @param imageColor imageColor associated with a given tile id
	 * @param x x value of the intended location of the tile
	 * @param y y value of the intended location of the tile
	 * @return a new foreground or background tile
	 */
	public static Tile buildTileFromColor(int imageColor, int x, int y) {
		for (TileBuilder t : tiles) {
			if (t.getImageColor() == imageColor) {
				if (t.isForeground()) {
					return new ForegroundTile(x, y, t.getColor());
				} else {
					return new BackgroundTile(x, y, t.getColor());
				}
			}
		}
		return null;
	}
	
}
