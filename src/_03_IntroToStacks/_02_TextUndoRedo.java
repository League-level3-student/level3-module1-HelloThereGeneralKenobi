package _03_IntroToStacks;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class _02_TextUndoRedo implements KeyListener {
	/*
	 * Create a JFrame with a JPanel and a JLabel.
	 * 
	 * Every time a key is pressed, add that character to the JLabel. It should look
	 * like a basic text editor.
	 * 
	 * Make it so that every time the BACKSPACE key is pressed, the last character
	 * is erased from the JLabel. Save that deleted character onto a Stack of
	 * Characters.
	 * 
	 * Choose a key to be the Undo key. Make it so that when that key is pressed,
	 * the top Character is popped off the Stack and added back to the JLabel.
	 * 
	 */

	JFrame frame;
	JPanel panel;
	JLabel label;
	Stack<Character> stack;

	public static void main(String[] args) {
		_02_TextUndoRedo textUndoRedo = new _02_TextUndoRedo();
		textUndoRedo.setup();
	}

	void setup() {
		stack = new Stack<Character>();
		frame = new JFrame();
		panel = new JPanel();
		label = new JLabel();
		frame.add(panel);
		panel.add(label);
		frame.addKeyListener(this);
		frame.setVisible(true);
		frame.setSize(500, 500);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

		if (e.getKeyChar() == KeyEvent.VK_BACK_SPACE) {
			char chararacter = label.getText().charAt(label.getText().length() - 1);
			label.setText(label.getText().substring(0, label.getText().length() - 1));
			stack.add(chararacter);
		} else if (e.getKeyCode() == KeyEvent.VK_Z) {
			System.out.println("waa");
			char undo = stack.pop();
			label.setText(label.getText() + undo);
		} else {
			label.setText(label.getText() + e.getKeyChar());
		}

		frame.pack();
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

}
