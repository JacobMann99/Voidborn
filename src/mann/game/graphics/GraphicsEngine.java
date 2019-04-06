package mann.game.graphics;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

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
	private int xOffset;
	private int yOffset;

	private BufferedImage image;
	private int[] pixels;

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
		canvas.setMinimumSize(new Dimension(width, height));
		canvas.setMaximumSize(new Dimension(width, height));
		canvas.setPreferredSize(new Dimension(width, height));

		frame.setSize(new Dimension(width, height));
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//frame.setUndecorated(true);

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
	public Canvas getCanvas() {
		return canvas;
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
					if (i - xOffset + e.getX() < 0) continue;
					if (i - xOffset + 1 + e.getX() > width) continue;
					int position = (i - xOffset + e.getX()) + (j - yOffset + e.getY() - (e.getHeight() - 1)) * width;
					if (entityPixels[i + j * e.getWidth()] >= 0 && position >= 0 && position < width * height) {
						pixels[position] = entityPixels[i + j * e.getWidth()];
					}
				}
			}
		}
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				int position = i + j * width;
				if (i + xOffset < 0) {
					pixels[position] = 0x000000;
					continue;
				}
				if (i + xOffset + 1 > level.getZone().getWidth()) {
					pixels[position] = 0x000000;
					continue;
				}
				if (j + yOffset < 0) {
					pixels[position] = 0x000000;
					continue;
				}
				if (j + yOffset + 1 > level.getZone().getHeight()) {
					pixels[position] = 0x000000;
					continue;
				}
			}
		}
		Graphics g = bs.getDrawGraphics();
		g.drawImage(image, 0, 0, canvas.getWidth(), canvas.getHeight(), null);

		g.dispose();
		bs.show();
	}
	
	public void setOffset(int xOffset, int yOffset) {
		this.xOffset += xOffset;
		this.yOffset += yOffset;
	}

}
