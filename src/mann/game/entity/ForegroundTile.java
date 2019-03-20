package mann.game.entity;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JPanel;

import mann.game.entity.tool.Hitbox;

//
/**
 * @author Christopher Zagurski
 *
 */
public class ForegroundTile extends Entity {
	private Hitbox hitbox;// This might not be used, I just put it here just in-case we want to create an
							// object that helps create an object
	private final Color tileColor = Color.GREEN;
	private ForegroundTileGraphic img;

	public ForegroundTile(int x, int y, Hitbox hitbox) {// I think this is what we want to do.
		super(x, y);
		width = 36;
		height = 36;
		if (hitbox != null) {
			this.hitbox = hitbox;
		} else {
			this.hitbox = null;
		}
		img = new ForegroundTileGraphic(x, y, width, height, tileColor);
	}

	/*
	@Override
	public BufferedImage render() {
		// TODO Auto-generated method stub
		return null;
	}
	*/
	
	public ForegroundTileGraphic getGraphics() {
		return img;
	}
	
	public void render() {
		img.render();
	}
	
	public class ForegroundTileGraphic extends JPanel {
		private Rectangle2D img;
		private Color tileColor;
		
		public ForegroundTileGraphic(int x, int y, int width, int height, Color tileColor) {
			img = new Rectangle2D.Double(x, y, width, height);
			this.tileColor = tileColor;
		}
		
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			Graphics2D g2d = (Graphics2D) g;
			g2d.setColor(tileColor);
			g2d.fill(img);
		}
		
		public void render() {
			repaint();
		}
	}
	
}
