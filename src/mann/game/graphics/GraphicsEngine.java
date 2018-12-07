package mann.game.graphics;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

import mann.game.master.Level;

public class GraphicsEngine {

	private boolean hasLevel = false;
	private Level level;
	
	private int width;
	private int height;
	
	public GraphicsEngine(int width, int height) {
		this.width = width;
		this.height = height;
		initialize();
	}
	
	/**
	 * Initialize JFrame
	 */
	private void initialize() {
		JFrame frame = new JFrame();
		frame.setSize(new Dimension(width, height));
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		//frame.setUndecorated(true);
		frame.setVisible(true);
		BufferedImage img = null;
		try {
			img = ImageIO.read(new File("./resources/testimages/Rai_Concept_2.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Graphics2D g2d = (Graphics2D) frame.getGraphics().create();
		if (img != null) {
			g2d.drawImage(img, (width - img.getWidth()) / 2, (height / 2 - img.getHeight()) / 2, null);
		}
	}
	
	public void setLevel(Level level) {
		if (hasLevel) throw new IllegalArgumentException("Level already initialized!");
		this.level = level;
	}
	
	public void render() {
		
	}
	
}
