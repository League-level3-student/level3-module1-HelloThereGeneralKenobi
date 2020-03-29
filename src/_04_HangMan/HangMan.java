package _04_HangMan;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class HangMan implements KeyListener{
	
	JFrame frame;
	JPanel panel;
	JLabel label;
	JLabel livesLabel;
	Stack<String> stack;
	String word;
	int wrong = 0;
	int lives = 15;
	String labelText;
	
	public static void main(String[] args) {
		
		HangMan hangMan = new HangMan();
		hangMan.setup();
		hangMan.readLines();
		hangMan.newWord();
		
		}
		
	
	
	void setup() {
		stack = new Stack<String>();
		frame = new JFrame();
		panel = new JPanel();
		label = new JLabel();
		livesLabel = new JLabel();
		frame.setVisible(true);
		frame.add(panel);
		panel.add(label);
		panel.add(livesLabel);
		frame.addKeyListener(this);
		frame.setSize(500, 500);
		livesLabel.setText("" + lives);
	}
	
	void readLines() {
		String answerString = JOptionPane.showInputDialog("Type a random number!");
		int answer = Integer.parseInt(answerString);
		for(int i = 0; i < answer; i++) {
		stack.add(Utilities.readRandomLineFromFile("dictionary.txt"));
		}
	}
	
	void newWord() {
		word = stack.pop();
		labelText = "";
		for(int i = 0; i < word.length(); i++) {
			labelText = labelText + "_ ";
		}
		label.setText(labelText);
	}



	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		boolean isCorrect = false;
		for(int i = 0; i < word.length(); i++) {
			if(e.getKeyChar() == word.charAt(i)) {
				labelText = labelText.substring(0, 2 * i) + word.charAt(i) + labelText.substring(2 * i + 1, labelText.length());
				label.setText(labelText);
				isCorrect = true;
			}
		}
		if(isCorrect == false) {
			lives--;
			livesLabel.setText(lives + "");
		}
		if(lives == 0) {
			String answer = JOptionPane.showInputDialog("GAME OVER. Type 'play again' to do so");
			if(answer.equalsIgnoreCase("play again")) {
				lives = 15;
				livesLabel.setText(lives + "");
				newWord();
			}
		}
		/*
		if(correctnum >= word.length() + 1) {
			JOptionPane.showMessageDialog(null, "Correct!");
			correctnum = 0;
			lives = 10;
			livesLabel.setText(lives + "");
			newWord();
			
		}
		*/
		int wrongnum = 0;
		for(int j = 0; j < word.length(); j++) {
			if(labelText.charAt(j) == '_') {
				wrongnum++;
			}
		}
		if(wrongnum == 0) {
			JOptionPane.showMessageDialog(null, "Correct!");
			lives = 15;
			livesLabel.setText(lives + "");
			newWord();
		}
	}



	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
