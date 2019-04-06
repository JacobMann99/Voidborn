package mann.game.entity.tool;

public class Animation {

	private int[] pixels;
	private int frames;
	
	protected Animation(int[] pixels, int frames) {
		this.pixels = pixels;
		this.frames = frames;
	}
	
	protected int[] getPixels() {
		return pixels;
	}
	
	protected int frames() {
		return frames;
	}
	
}
