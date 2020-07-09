package _04_HangMan;

import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import _03_IntroToStacks._02_TextUndoRedo;

public class HangMan implements KeyListener {
	JFrame frame;
	JLabel label;
	JLabel wrong;
	Stack<String> game;
	String s;
	JLabel life;
	int lives;
	static HangMan hangman;

	public static void main(String[] args) {
		hangman = new HangMan();
		hangman.createUI();
		hangman.startup();
	}

	public void createUI() {
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500, 500);
		frame.setVisible(true);
		JPanel panel = new JPanel();
		frame.add(panel, BorderLayout.NORTH);
		label = new JLabel();
		panel.add(label, BorderLayout.NORTH);
		wrong = new JLabel();
		frame.add(wrong, BorderLayout.CENTER);
		wrong.setText("");
		life = new JLabel();
		frame.add(life, BorderLayout.SOUTH);
		
		frame.addKeyListener(this);

	}

	public void startup() {
		String hangman = JOptionPane.showInputDialog("Enter a number");
		game = new Stack<String>();
		int word = Integer.parseInt(hangman);
		for (int i = 0; i < word; i++) {
			game.push(Utilities.readRandomLineFromFile("dictionary.txt"));

		}
		s = game.pop();
		label.setText("");
		for (int i = 0; i < s.length(); i++) {
			label.setText(label.getText() + " _");
		}
		lives = 6;
		life.setText("Lives: " + lives);
		

	}

	public void nextWord() {
		if (game.size() > 0) {
			lives = 6;
			life.setText("Lives: " + lives);
			s = game.pop();
			label.setText("");
			for (int i = 0; i < s.length(); i++) {
				label.setText(label.getText() + " _");
			}
		} else {
			JOptionPane.showMessageDialog(null, "You win!");
			frame.dispose();
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		String text = label.getText().replace(" ", "");
		boolean found = false;
		label.setText("");

		for (int i = 0; i < s.length(); i++) {
			if (e.getKeyChar() == s.charAt(i)) {
				char d = s.charAt(i);
				label.setText(label.getText() + " " + d);
				found = true;
			} else {
				label.setText(label.getText() + " " + text.charAt(i));
			}
		}
		if (found == false) {
			lives--;
			if (lives > 0) {
				life.setText("lives: " +lives);
				wrong.setText(wrong.getText() + " " + e.getKeyChar());
			}
		}
		if (lives <= 0) {
			JOptionPane.showMessageDialog(null, "The word was '" + s + "'");
			frame.dispose();
		}

		String word = label.getText();
		if (word.contains("_")) {

		} else {
			hangman.nextWord();
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}
