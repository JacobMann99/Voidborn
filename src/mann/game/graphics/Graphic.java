package mann.game.graphics;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JPanel;

/**
 * 
 * @author Jacob Mann
 *
 */
public class Graphic extends JPanel {

	private Rectangle2D img;
	private Color color;
	
	public Graphic(int x, int y, int width, int height, Color color) {
		img = new Rectangle2D.Double(x, y, width, height);
		this.color = color;
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(color);
		g2d.fill(img);
	}
	
	public void render() {
		repaint();
	}
	
}
