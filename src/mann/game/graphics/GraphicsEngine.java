package mann.game.graphics;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

import mann.game.entity.Entity;
import mann.game.master.Level;

/**
 * Controls all graphics. Graphics are accepted from the level, and this engine outputs the level's graphics
 * to the frame.
 * @author Jacob Mann
 */
public class GraphicsEngine {

	private JFrame frame = new JFrame();
	private BufferedImage canvas;
	
	private boolean hasLevel = false;
	private Level level;
	
	private int width;
	private int height;
	
	public GraphicsEngine(int width, int height) {
		this.width = width;
		this.height = height;
	}
	
	/**
	 * Initialize JFrame
	 */
	private void initialize() {
		frame.setSize(new Dimension(width, height));
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		//frame.setUndecorated(true);
		for (Entity e : level.getRenderables()) {
			frame.add(e.getGraphics());
		}
		frame.setVisible(true);
	}
	
	/**
	 * Returns JFrame. Currently only used to add a key listener to the frame in InputHandler.
	 * @return frame
	 */
	public JFrame getFrame() {
		return frame;
	}
	
	public void setLevel(Level level) {
		if (hasLevel) throw new IllegalArgumentException("Level already initialized!");
		this.level = level;
		initialize();
	}
	
	public void render() {
		for (Entity e : level.getRenderables()) {
			e.render();
		}
	}
	
}
