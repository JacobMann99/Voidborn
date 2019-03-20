package mann.game.master;

import java.util.ArrayList;

import mann.game.entity.Entity;
import mann.game.entity.ForegroundTile;
import mann.game.entity.Tile;
import mann.game.entity.tool.Hitbox;
import mann.game.graphics.GraphicsEngine;

/**
 * Controls game logic; represented by the main class's tick() method. All processes besides graphics
 * respond to this class.
 * @author Jacob Mann
 */
public class Level {

	private GraphicsEngine graphics;
	private InputHandler input;
	private ArrayList<Entity> entityList = new ArrayList<Entity>();
	private ArrayList<Entity> renderList = new ArrayList<Entity>();
	
	public Level() {
		init();
	}
	
	public void initialize(GraphicsEngine g, InputHandler input) {
		this.graphics = g;
		this.input = input;
		graphics.setLevel(this);
	}
	
	public void init() {
		Entity testTile = Tile.buildTileFromMatrix(0, 100, 100);
		Entity testTile2 = Tile.buildTileFromMatrix(1, 136, 100);
		entityList.add(testTile);
		renderList.add(testTile);
		entityList.add(testTile2);
		renderList.add(testTile2);
	}
	
	public void tick() {
		
	}
	
	public ArrayList<Entity> getRenderables() {
		return renderList;
	}
	
}
