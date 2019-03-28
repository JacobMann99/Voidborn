package mann.game.graphics;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

import mann.game.entity.Entity;
import mann.game.master.Level;

/**
 * Controls all graphics. Graphics are accepted from the level, and this engine
 * outputs the level's graphics to the frame.
 * 
 * @author Jacob Mann
 */
public class GraphicsEngine {

	private JFrame frame = new JFrame();
	private Canvas canvas = new Canvas();

	private boolean hasLevel = false;
	private Level level;

	private int width;
	private int height;

	private BufferedImage image;
	private int[] pixels;

	int renderCount = 0;

	public GraphicsEngine(int width, int height) {
		this.width = width;
		this.height = height;
		image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		pixels = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();
	}

	/**
	 * Initialize JFrame
	 */
	private void initialize() {
		for (int i = 0; i < pixels.length; i++) {
			pixels[i] = 0xffffff;
		}
		
		canvas.setMinimumSize(new Dimension(width, height));
		canvas.setMaximumSize(new Dimension(width, height));
		canvas.setPreferredSize(new Dimension(width, height));

		frame.setSize(new Dimension(width, height));
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setUndecorated(true);

		frame.add(canvas, BorderLayout.CENTER);
		// for (Entity e : level.getRenderables()) {
		// frame.add(e.getGraphics());
		// }
		frame.pack();
		frame.setVisible(true);
	}

	/**
	 * Returns JFrame. Currently only used to add a key listener to the frame in
	 * InputHandler.
	 * 
	 * @return frame
	 */
	public JFrame getFrame() {
		return frame;
	}

	public void setLevel(Level level) {
		if (hasLevel)
			throw new IllegalArgumentException("Level already initialized!");
		this.level = level;
		initialize();
	}

	public void render() {
		BufferStrategy bs = canvas.getBufferStrategy();
		if (bs == null) {
			canvas.createBufferStrategy(2);
			return;
		}

		for (Entity e : level.getRenderables()) {
			int[] entityPixels = e.render();
			for (int i = 0; i < e.getWidth(); i++) {
				for (int j = 0; j < e.getHeight(); j++) {
					//if ((i + e.getX()) + (j + e.getY() - (e.getHeight() - 1)) * width >= pixels.length) continue;
					//if ((i + e.getX()) + (j + e.getY() - (e.getHeight() - 1)) * width < 0) continue;
					if (entityPixels[i + j * e.getWidth()] > 0) {
						pixels[(i + e.getX()) + (j + e.getY() - (e.getHeight() - 1)) * width] = entityPixels[i
								+ j * e.getWidth()];
					}
				}
			}
		}

		// for (int i = 0; i < pixels.length; i++) {
		// pixels[i] = i / (renderCount + 1);
		// }
		// renderCount++;

		Graphics g = bs.getDrawGraphics();
		g.drawImage(image, 0, 0, canvas.getWidth(), canvas.getHeight(), null);

		g.dispose();
		bs.show();
	}

}
