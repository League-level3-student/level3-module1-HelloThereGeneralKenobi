package _01_IntroToArrayLists;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


//Copyright The League of Amazing Programmers, 2015

public class _06_IPodShuffle implements ActionListener{
	
	JFrame frame;
	JPanel panel;
	JButton button;
	Random randgen;
	
	Song demo;
	Song scatmansWorld;
	ArrayList<Song> Songs;
	
	public _06_IPodShuffle() {
		// 1. Use the Song class the play the demo.mp3 file.
		
				
		/**
		 * 2. Congratulations on completing the sound check! * Now we want to make an
		 * iPod Shuffle that plays random music. * Create an ArrayList of Songs and a
		 * "Surprise Me!" button that will play a random song when it is clicked. * If
		 * you're really cool, you can stop all the songs, before playing a new one on
		 * subsequent button clicks.
		 */
		
	}
	
	public static void main(String[] args) {
		_06_IPodShuffle iPod = new _06_IPodShuffle();
		iPod.setup();
		
	}
	
	void setup() {
		randgen = new Random();
		demo = new Song("demo.mp3");
		scatmansWorld = new Song("https://youtu.be/n14fp5V5UXc");
		Songs = new ArrayList<Song>();
		
		Songs.add(demo);
		Songs.add(scatmansWorld);
		 
		frame = new JFrame();
		panel = new JPanel();
		button = new JButton();
		
		frame.setVisible(true);		
		frame.add(panel);
		frame.setSize(300, 300);
		panel.add(button);
		button.setText("Surprise me!");
		button.addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		for(int i = 0; i < Songs.size(); i++) {
			if(i == randgen.nextInt(Songs.size())) {
				Songs.get(i).play();;
			}
				
		}
	}
}