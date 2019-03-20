package mann.game.master;

import mann.game.graphics.GraphicsEngine;

/**
 * 
 * @author Jacob Mann
 *
 */
public class VoidbornApplication implements Runnable {

	public static VoidbornApplication game;
	
	public InputHandler input;
	public Level level;
	public GraphicsEngine graphics;
	
	public boolean running = false;
	
	public synchronized void start() {
		running = true;
		new Thread(this).start();
	}
	
	public synchronized void stop() {
		running = false;
	}
	
	@Override
	public void run() {
		long lastTime = System.nanoTime();
		double nsPerTick = 1000000000D / 60D;
		
		int ticks = 0;
		int frames = 0;
		
		long lastTimer = System.currentTimeMillis();
		double delta = 0;
		
		init();
		
		while (running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / nsPerTick;
			lastTime = now;
			boolean shouldRender = true;
			
			while (delta >= 1) {
				ticks++;
				level.tick();
				delta -= 1;
				shouldRender = true;
			}
			
			try {
				Thread.sleep(2);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if (shouldRender) {
				frames++;
				graphics.render();
			}
			
			try {
				Thread.sleep(2);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			if (System.currentTimeMillis() - lastTimer >= 1000) {
				lastTimer += 1000;
				System.out.println(ticks + " ticks, " + frames + " frames");
				ticks = 0;
				frames = 0;
			}
		}
	}
	
	public void init() {
		final int WIDTH = 1080;
		final int HEIGHT = WIDTH * 9 / 12;
		
		level = new Level();
		graphics = new GraphicsEngine(WIDTH, HEIGHT);
		input = new InputHandler(graphics);
		level.initialize(graphics, input);
		
	}
	
	public static void main(String[] args) {
		
		new VoidbornApplication().start();

	}

}
