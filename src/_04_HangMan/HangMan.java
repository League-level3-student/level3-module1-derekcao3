package _04_HangMan;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import _03_IntroToStacks._02_TextUndoRedo;

public class HangMan implements KeyListener{
	JLabel label;
	Stack<String> game;
	String s;
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
		
		System.out.println(s);
		int lives = 5;
		
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		String text = label.getText().replace(" ", "");
		label.setText("");
		for (int i = 0; i < s.length(); i++) {
			if(e.getKeyChar()==s.charAt(i)) {
				char d = s.charAt(i);
				label.setText(label.getText() + " " +d);
			}
			else {
				label.setText(label.getText() + " " + text.charAt(i));
			}
			
		}
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
