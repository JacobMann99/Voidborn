package mann.game.master;

import java.util.ArrayList;

import mann.game.entity.Entity;
import mann.game.entity.ForegroundTile;
import mann.game.entity.player.Player;
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
	private Zone zone;
	private Player player;
	
	public void initialize(GraphicsEngine g, InputHandler input) {
		this.graphics = g;
		this.input = input;
		graphics.setLevel(this);
		init();
	}
	
	public void init() {
		zone = new Zone("/testimages/Untitled-4.png");
		player = new Player(600, 600, 76, 164, "/testimages/player_test.png", this.input, null);
		for (Entity e : zone.getEntities()) {
			entityList.add(e);
			renderList.add(e);
		}
		entityList.add(player);
		renderList.add(player);
	}
	
	public void tick() {
		for (Entity e : entityList) {
			e.tick();
		}
		graphics.setOffset(player.getX(), player.getY() - player.getHeight() * 2 / 3);
	}
	
	public ArrayList<Entity> getRenderables() {
		return renderList;
	}
	
	public Zone getZone() {
		return zone;
	}
}
