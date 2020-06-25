package _04_HangMan;

import java.util.ArrayList;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import _03_IntroToStacks._02_TextUndoRedo;

public class HangMan{
	JLabel label;
	Stack<String> game;
	public static void main(String[] args) {
		HangMan hangman = new HangMan();
		hangman.createUI();
		hangman.startup();
	}
	public void createUI() {
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500,500);
		frame.setVisible(true);
		JPanel panel = new JPanel();
		frame.add(panel);
		label = new JLabel();
		panel.add(label);
		
	
	}
	public void startup() {
		String hangman = JOptionPane.showInputDialog("Enter a number");
		game = new Stack<String>();
		int word = Integer.parseInt(hangman);
		for (int i = 0; i < word; i++) {
		game.push(Utilities.readRandomLineFromFile("dictionary.txt"));
		
		}
		String s = game.pop();
		label.setText("_");
		for (int i = 0; i < s.length(); i++) {
			label.setText(label.getText() + " _");
		}
		
	}
	
}
