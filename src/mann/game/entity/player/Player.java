package mann.game.entity.player;

import mann.game.entity.Mob;
import mann.game.entity.tool.Hitbox;
import mann.game.master.InputHandler;

public class Player extends Mob {

	InputHandler input;
	
	public Player(int x, int y, int width, int height, String filepath, InputHandler input, Hitbox hitbox) {
		super(x, y, width, height, width - 6, height - 6, 3, 6, filepath);
		this.input = input;
	}
	
	public void tick() {
		if (input.up.isPressed()) moveY(-4);
		if (input.down.isPressed()) moveY(4);
		if (input.left.isPressed()) moveX(-4);
		if (input.right.isPressed()) moveX(4);
	}

	public int[] render() {
		return graphic.getPixels();
	}

}
