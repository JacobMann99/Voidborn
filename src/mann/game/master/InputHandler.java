package mann.game.master;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import mann.game.graphics.GraphicsEngine;

/**
 * Accepts Key Events from the user and raises flags so the level can tell when the user wants to do something.
 * @author Jacob Mann
 */

public class InputHandler implements KeyListener {
	private Boolean movementUp;
	private Boolean movementDown;
	private Boolean movementLeft;
	private Boolean movementRight;
	/**
	 * Adds the KeyListener to the frame upon initialization
	 * @param graphics
	 *            GraphicsEngine class passed in from the VoidbornApplication main class
	 VK_LEFT, VK_DOWN, VK_RIGHT, VK_UP*/
	public InputHandler(GraphicsEngine graphics) {
		graphics.getFrame().addKeyListener(this);
	}
	
	@Override
	public void keyPressed(KeyEvent arg0) {
		// Prints KEY EVENT to console when any key is pressed.
		System.out.println("KEY EVENT");
		getMovementUp(arg0);
		getMovementDown(arg0);
		getMovementLeft(arg0);
		getMovementRight(arg0);
		
		}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// Probably will be unnecessary, but this method's presence is required for every KeyListener interface
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// Probably will be unnecessary, but this method's presence is required for every KeyListener interface
	}
	@SuppressWarnings("unlikely-arg-type")
	public Boolean getMovementUp(KeyEvent arg0) {
		if(arg0.equals(KeyEvent.VK_UP)||(arg0.equals(KeyEvent.VK_W))) {
			movementUp = true;
			return movementUp;
		}else {
			movementUp = false;
			return movementUp;
		}
	}
	@SuppressWarnings("unlikely-arg-type")
	public Boolean getMovementDown(KeyEvent arg0) {
		if(arg0.equals(KeyEvent.VK_DOWN)||(arg0.equals(KeyEvent.VK_S))) {
			movementDown = true;
			return movementDown;
		}else {
			movementDown = false;
			return movementDown;
		}
	}
	@SuppressWarnings("unlikely-arg-type")
	public Boolean getMovementLeft(KeyEvent arg0) {
		if(arg0.equals(KeyEvent.VK_LEFT)||(arg0.equals(KeyEvent.VK_A))) {
			movementLeft = true;
			return movementLeft;
		}else {
			movementLeft = false;
			return movementLeft;
		}
	}
	@SuppressWarnings("unlikely-arg-type")
	public Boolean getMovementRight(KeyEvent arg0) {
		if(arg0.equals(KeyEvent.VK_RIGHT)||arg0.equals(KeyEvent.VK_D)) {
			movementRight = true;
			return movementRight;
		}else {
			movementRight = false;
			return movementRight;
		}
	}
}