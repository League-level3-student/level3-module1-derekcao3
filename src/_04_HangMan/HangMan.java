package _04_HangMan;

import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class HangMan{
	public static void main(String[] args) {
	
	}
	public void createUI() {
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
	}
	public void startup() {
		String hangman = JOptionPane.showInputDialog("Enter a number");
		Stack<String> game = new Stack<String>();
		int word = Integer.parseInt(hangman);
		for (int i = 0; i < word; i++) {
		game.push(Utilities.readRandomLineFromFile("dictionary.txt"));
		}
		
	}
	
}
