package mann.game.entity.player;

import mann.game.entity.Mob;
import mann.game.entity.tool.Hitbox;
import mann.game.master.InputHandler;
import mann.game.world.Zone;

public class Player extends Mob {

	InputHandler input;
	
	public Player(int x, int y, int width, int height, String filepath, InputHandler input, Hitbox hitbox, Zone zone) {
		super(x, y, width, height, width - 22, height - 6, 9, -1, filepath, zone);
		this.input = input;
	}
	
	public void tick() {
		if (input.up.isPressed()) move(0, -2);
		//if (input.up.isPressed()) moveY(-1);
		if (input.down.isPressed()) move(0, 2);
		//if (input.down.isPressed()) moveY(1);
		if (input.left.isPressed()) move(-2, 0);
		//if (input.left.isPressed()) moveX(-1);
		if (input.right.isPressed()) move(2, 0);
		//if (input.right.isPressed()) moveX(1);
	}

	public int[] render() {
		return graphic.getPixels();
	}
	
	public boolean setZone(Zone zone, int spawn) {
		try {
			int[] spawnpoint = zone.getSpawn(spawn);
			this.zone = zone;
			this.x = spawnpoint[0];
			this.y = spawnpoint[1];
		} catch (Exception e) {
			return false;
		}
		return true;
	}

}
