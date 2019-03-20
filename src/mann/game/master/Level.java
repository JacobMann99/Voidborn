package mann.game.master;

import java.util.ArrayList;

import mann.game.entity.Entity;
import mann.game.entity.ForegroundTile;
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
		Hitbox hitbox = new Hitbox();
		Entity testTile = new ForegroundTile(100, 100, hitbox);
		hitbox.init(testTile, 0, 0, 16, 16);
		entityList.add(testTile);
		renderList.add(testTile);
	}
	
	public void tick() {
		int[] array = new int[4];
		int[][] matrix = new int[4][4];
	}
	
	public ArrayList<Entity> getRenderables() {
		return renderList;
	}
	
}
