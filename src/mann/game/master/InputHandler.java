package mann.game.master;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

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
	 VK_LEFT, VK_DOWN, VK_RIGHT, VK_UP*/
	public InputHandler(GraphicsEngine graphics) {
		graphics.getCanvas().addKeyListener(this);
	}

	public class Key {
		private int numTimesPressed = 0;
		public boolean pressed = false;
		
		public int getNumTimesPressed() {
			return numTimesPressed;
		}

		public boolean isPressed() {
			return pressed;
		}
		
		public void toggleSwitch() {
			if (!pressed) {
				pressed = true;
			} else {
				pressed = false;
			}
			System.out.println(pressed);
		}

		public void toggle(boolean isPressed) {
			pressed = isPressed;
			if (pressed) {
				numTimesPressed++;
			}
		}
	}
	
	public List<Key>keys = new ArrayList<Key>();
	
	public Key up = new Key();
	public Key down = new Key();
	public Key left = new Key();
	public Key right = new Key();
	public Key shift = new Key();
	public Key control = new Key();
	public Key space = new Key();
	public Key escape = new Key();

	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() != KeyEvent.VK_ESCAPE) {
			toggleKey(e.getKeyCode(), true);
		} else {
			escape.toggleSwitch();
		}
	}

	public void keyReleased(KeyEvent e) {
		toggleKey(e.getKeyCode(), false);
	}

	public void keyTyped(KeyEvent e) {
		
	}
	
	public void toggleKey(int keyCode, boolean isPressed) {
		if (keyCode == KeyEvent.VK_W) {
			up.toggle(isPressed);
		}
		if (keyCode == KeyEvent.VK_S) {
			down.toggle(isPressed);
		}
		if (keyCode == KeyEvent.VK_A) {
			left.toggle(isPressed);
		}
		if (keyCode == KeyEvent.VK_D) {
			right.toggle(isPressed);
		}
		if (keyCode == KeyEvent.VK_SHIFT) {
			shift.toggle(isPressed);
		}
		if (keyCode == KeyEvent.VK_CONTROL) {
			control.toggle(isPressed);
		}
		if (keyCode == KeyEvent.VK_SPACE) {
			space.toggle(isPressed);
		}
	}

}