package _01_IntroToArrayLists;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class _02_GuestBook implements ActionListener {
	JButton add;
	JButton view;
	JFrame frame;
	JPanel panel;
	ArrayList<String> guests = new ArrayList<String>();
	
	void Construct() {
		JFrame frame = new JFrame();
		add = new JButton();
		view = new JButton();
		JPanel panel = new JPanel();

		frame.setSize(500, 200);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panel);
		panel.add(add);
		add.setText("Add names");
		add.addActionListener(this);
		panel.add(view);
		view.addActionListener(this);
		view.setText("View Names");
		
	}

	public static void main(String[] args) {
		_02_GuestBook book = new _02_GuestBook();
		book.Construct();
	}
	// Create a GUI with two buttons. One button reads "Add Name" and the other
	// button reads "View Names".
	// When the add name button is clicked, display an input dialog that asks the
	// user to enter a name. Add
	// that name to an ArrayList. When the "View Names" button is clicked, display a
	// message dialog that displays
	// all the names added to the list. Format the list as follows:
	// Guest #1: Bob Banders
	// Guest #2: Sandy Summers
	// Guest #3: Greg Ganders
	// Guest #4: Donny Doners

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if (e.getSource() == add) {
			String addname = JOptionPane.showInputDialog("Add guest's name");
			guests.add(addname);
		}
		if (e.getSource() == view) {
			for (int i = 0; i < guests.size(); i++) {
				guests.get(i);
				int i2=i+1;
				JOptionPane.showMessageDialog(null, "Guest #" + i2 + " " + guests.get(i));
			}
			
				
			
			
			
		}

	}
}
