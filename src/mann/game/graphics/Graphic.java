package mann.game.graphics;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.text.html.parser.Entity;

import javax.imageio.ImageIO;

/**
 * Simple object designed to read an image file, store the color data from its pixels, and keep
 * record of the image width and height.
 * 
 * @author Jacob Mann
 */
public class Graphic {
	
	private int width;
	private int height;
	
	private int[] pixels;
	
	public Graphic(String path) {
		BufferedImage image = null;
		
		try {
			image = ImageIO.read(this.getClass().getResourceAsStream(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		this.width = image.getWidth();
		this.height = image.getHeight();
		
		pixels = image.getRGB(0, 0, width, height, null, 0, width);
		
		for (int i = 0; i < pixels.length; i++) {
			if (pixels[i] != 0 && (pixels[i] & 0xffffff) == 0) {
				pixels[i] = -1;
			} else {	
				pixels[i] = pixels[i] & 0xffffff;
			}
		}
	}
	
	/**
	 * @return an array of the rgb values from each pixel in the array
	 */
	public int[] getPixels() {
		return pixels;
	}
	
	/**
	 * @return the width of the image
	 */
	public int getWidth() {
		return width;
	}
	
	/**
	 * @return the height of the image
	 */
	public int getHeight() {
		return height;
	}
	
}
