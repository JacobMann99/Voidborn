package mann.game.entity.tool;

import java.util.ArrayList;

/**
 * Holds a collection of animation objects and returns the animation raster at the given tickCount
 * of the animation cycle.
 * 
 * @author Jacob Mann
 */
public class AnimationCycle {

	private Animation[] rawAnimations;
	private ArrayList<Animation> animations;
	private int tickCount;
	
	public AnimationCycle(Animation[] animations) {
		this.rawAnimations = animations;
		initialize();
		tickCount = 0;
	}
	
	private void initialize() {
		animations = new ArrayList<Animation>();
		for (Animation a : rawAnimations) {
			for (int i = 0; i < a.frames(); i++) {
				animations.add(a);
			}
		}
	}
	
	/**
	 * Returns the next image raster of the animation cycle.
	 * @return a pixel array image raster
	 */
	public int[] getNewAnimation() {
		int[] pixels = animations.get(tickCount).getPixels();
		tickCount++;
		if (tickCount >= animations.size()) reset();
		return pixels;
	}
	
	/**
	 * Resets the animation sequence for reuse.
	 */
	public void reset() {
		tickCount = 0;
	}
	
}
