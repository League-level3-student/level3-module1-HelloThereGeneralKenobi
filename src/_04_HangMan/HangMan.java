package _04_HangMan;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class HangMan{
	
	JFrame frame;
	JPanel panel;
	JLabel label;
	JLabel lives;
	
	public static void main(String[] args) {
		HangMan hangMan = new HangMan();
		hangMan.setup();
		
		String answerString = JOptionPane.showInputDialog("Type a random number!");
		int answer = Integer.parseInt(answerString);
		for(int i = 0; i < answer; i++) {
			
		}
		
		}
	
	
	void setup() {
		frame = new JFrame();
		panel = new JPanel();
		label = new JLabel();
		lives = new JLabel();
		frame.setVisible(true);
		frame.add(panel);
		panel.add(label);
		panel.add(lives);
		frame.setSize(500, 500);
	}
	
}
