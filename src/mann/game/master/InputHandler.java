package mann.game.master;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import mann.game.graphics.GraphicsEngine;

/**
 * Accepts Key Events from the user and raises flags so the level can tell when the user wants to do something.
 * @author Jacob Mann
 */
public class InputHandler implements KeyListener {

	/**
	 * Adds the KeyListener to the frame upon initialization
	 * @param graphics
	 *            GraphicsEngine class passed in from the VoidbornApplication main class
	 */
	public InputHandler(GraphicsEngine graphics) {
		graphics.getFrame().addKeyListener(this);
	}
	
	@Override
	public void keyPressed(KeyEvent arg0) {
		// Prints KEY EVENT to console when any key is pressed.
		System.out.println("KEY EVENT");
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// Probably will be unnecessary, but this method's presence is required for every KeyListener interface
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// Probably will be unnecessary, but this method's presence is required for every KeyListener interface
	}

}
