package _01_IntroToArrayLists;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class _02_GuestBook implements ActionListener {
	static // Create a GUI with two buttons. One button reads "Add Name" and the other button reads "View Names". 
	// When the add name button is clicked, display an input dialog that asks the user to enter a name. Add
	// that name to an ArrayList. When the "View Names" button is clicked, display a message dialog that displays
	// all the names added to the list. Format the list as follows:
	// Guest #1: Bob Banders
	// Guest #2: Sandy Summers
	// Guest #3: Greg Ganders
	// Guest #4: Donny Doners
	
	JFrame frame;
	static JPanel panel;
	static JButton addButton;
	static JButton viewButton;
	ArrayList<String> names = new ArrayList<String>();
	
	public static void main(String[] args) {
		_02_GuestBook guestBook = new _02_GuestBook();
		guestBook.setup();
	}
	
	void setup() {
		frame = new JFrame();
		panel = new JPanel();
		addButton = new JButton();
		viewButton = new JButton();
		
		frame.add(panel);
		panel.add(addButton);
		panel.add(viewButton);
		addButton.addActionListener(this);
		viewButton.addActionListener(this);
		frame.setVisible(true);
		frame.setSize(600, 800);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == addButton) {
			names.add(JOptionPane.showInputDialog("Enter a name"));
		}
		if(e.getSource() == viewButton) {
			JOptionPane.showMessageDialog(null, "Guest #1: " + names.get(0));
		}
	}
	
	
	
	
	
}
