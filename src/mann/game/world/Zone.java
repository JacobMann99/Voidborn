package mann.game.world;

import mann.game.entity.Entity;
import mann.game.entity.Tile;
import mann.game.entity.tool.TileBuilder;
import mann.game.graphics.Graphic;

public class Zone {
	
	private int width;
	private int height;
	private Tile[] tiles;
	
	public Zone(String path) {
		Graphic graphic = new Graphic(path);
		int[] tileColors = graphic.getPixels();
		width = graphic.getWidth();
		height = graphic.getHeight();
		tiles = new Tile[tileColors.length];
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				tiles[i + j * width] = TileBuilder.buildTileFromColor(tileColors[i + j * width], i * 36, (j + 1) * 36 - 1);
			}
		}
	}
	
	public Zone(int[][] idMatrix) {
		width = idMatrix[0].length;
		height = idMatrix.length;
		tiles = new Tile[width * height];
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				tiles[i + j * width] = TileBuilder.buildTileFromMatrix(idMatrix[i][j], i * 36, (j + 1) * 36 - 1);
			}
		}
	}
	
	public Entity[] getEntities() {
		return tiles;
	}
	
	public int getWidth() {
		return width * 36;
	}
	
	public int getHeight() {
		return height * 36;
	}
	
	public int[] getSpawn(int spawnNumber) {
		return new int[]{0, 0};
	}
	
}
