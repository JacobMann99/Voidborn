package mann.game.entity.player;

import mann.game.entity.Mob;
import mann.game.master.InputHandler;

public class Player extends Mob {

	InputHandler input;
	
	public Player(int x, int y, int width, int height, String filepath, InputHandler input) {
		super(x, y, width, height, width - 6, height - 6, 3, 6, filepath);
		this.input = input;
	}
	
	public void tick() {
		
	}

	public int[] render() {
		return graphic.getPixels();
	}

}
