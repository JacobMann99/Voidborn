package mann.game.master;

import java.util.ArrayList;

import mann.game.entity.Entity;
import mann.game.entity.ForegroundTile;
import mann.game.entity.tool.Hitbox;
import mann.game.entity.tool.TileBuilder;
import mann.game.graphics.GraphicsEngine;
import mann.game.world.Zone;

/**
 * Controls game logic; represented by the main class's tick() method. All processes besides graphics
 * respond to this class.
 * 
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
		Zone test = new Zone("/testimages/Untitled-2.png");
		for (Entity e : test.getEntities()) {
			entityList.add(e);
			renderList.add(e);
		}
	}
	
	public void tick() {
		for (Entity e : entityList) {
			e.tick();
		}
		
	}
	
	public ArrayList<Entity> getRenderables() {
		return renderList;
	}
}
