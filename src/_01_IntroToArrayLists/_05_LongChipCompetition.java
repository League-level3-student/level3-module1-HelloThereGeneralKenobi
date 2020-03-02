package _01_IntroToArrayLists;

import java.util.ArrayList;
import java.util.Random;

import javax.swing.JOptionPane;

public class _05_LongChipCompetition {
	/**
	 * The Beatles are eating lunch and playing a game to see who has the longest
	 * chip. (In England, french fries are called "chips".) * Find the Beatle with
	 * the longest chip. You may not edit the Chip or Beatle classes. Make sure to
	 * initialize The Beatles before you start your search. *
	 **/

	private ArrayList<Beatle> theBeatles = new ArrayList<Beatle>();

	double longest = 0;
	static String longestBeatle = "";

	public static void main(String[] args) {
		_05_LongChipCompetition lcc = new _05_LongChipCompetition();

		lcc.initializeBeatles();
		lcc.findLongestChip();
		System.out.println(longestBeatle);
		
	}

	private void initializeBeatles() {
		Beatle george = new Beatle("George");
		Beatle john = new Beatle("John");
		Beatle paul = new Beatle("Paul");
		Beatle ringo = new Beatle("Ringo");
		theBeatles.add(george);
		theBeatles.add(john);
		theBeatles.add(paul);
		theBeatles.add(ringo);
	}

	public ArrayList<Beatle> getTheBand() {
		return theBeatles;
	}

	void findLongestChip() {
		for (int i = 0; i < theBeatles.size(); i++) {
			ArrayList<Chip> chips = theBeatles.get(i).getChips();
			for (int k = 0; k < chips.size(); k++) {
				if (longest < chips.get(k).getLength()) {
					longest = chips.get(k).getLength();
					longestBeatle = theBeatles.get(i).getName();
					
				}
			}

		}
	}
}

class Beatle {
	private String name;
	private ArrayList<Chip> chips = new ArrayList<Chip>();

	public Beatle(String name) {
		this.name = name;
		initializePlateOfChips();
	}

	private void initializePlateOfChips() {
		int numberOfChips = new Random().nextInt(100);
		for (int i = 0; i < numberOfChips; i++) {
			chips.add(new Chip(new Random().nextDouble() * 10));
		}
	}

	public ArrayList<Chip> getChips() {
		return this.chips;
	}

	public String getName() {
		return this.name;
	}
}

class Chip {
	private double length;

	public double getLength() {
		return length;
	}

	Chip(double d) {
		this.length = d;
	}
}
