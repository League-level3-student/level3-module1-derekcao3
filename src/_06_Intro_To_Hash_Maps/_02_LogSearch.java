package _06_Intro_To_Hash_Maps;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class _02_LogSearch implements ActionListener {
	JButton entry;
	JButton search;
	HashMap<Integer, String> log;
	int number;
	String name;

	public void createUI() {
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		entry = new JButton();
		frame.add(panel);
		panel.add(entry);
		entry.addActionListener(this);
		entry.setText("Add Entry");
		search = new JButton();
		panel.add(search);
		search.setText("Search by ID");
		search.addActionListener(this);
		frame.pack();
		log = new HashMap<Integer, String>();
	}

	public static void main(String[] args) {
		_02_LogSearch logSearch = new _02_LogSearch();
		logSearch.createUI();
	}

	/*
	 * Crate a HashMap of Integers for the keys and Strings for the values. Create a
	 * GUI with three buttons.
	 * 
	 * Button 1: Add Entry When this button is clicked, use an input dialog to ask
	 * the user to enter an ID number. After an ID is entered, use another input
	 * dialog to ask the user to enter a name. Add this information as a new entry
	 * to your HashMap.
	 * 
	 * Button 2: Search by ID When this button is clicked, use an input dialog to
	 * ask the user to enter an ID number. If that ID exists, display that name to
	 * the user. Otherwise, tell the user that that entry does not exist.
	 * 
	 * Button 3: View List When this button is clicked, display the entire list in a
	 * message dialog in the following format: ID: 123 Name: Harry Howard ID: 245
	 * Name: Polly Powers ID: 433 Name: Oliver Ortega etc...
	 * 
	 * When this is complete, add a fourth button to your window. Button 4: Remove
	 * Entry When this button is clicked, prompt the user to enter an ID using an
	 * input dialog. If this ID exists in the HashMap, remove it. Otherwise, notify
	 * the user that the ID is not in the list.
	 *
	 */

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == entry) {
			String ID = JOptionPane.showInputDialog("Enter an ID number");
			number = Integer.parseInt(ID);
			name = JOptionPane.showInputDialog("Enter a name");
			log.put(number, name);
		}
		if (e.getSource() == search) {
			String Detect = JOptionPane.showInputDialog("Enter an ID number");
			int detect = Integer.parseInt(Detect);
			if(log.containsKey(detect)) {
					JOptionPane.showMessageDialog(null, log.get(detect));
			}
			else {
				JOptionPane.showMessageDialog(null, "Entry does not exist");
			}
		}

	}

}
