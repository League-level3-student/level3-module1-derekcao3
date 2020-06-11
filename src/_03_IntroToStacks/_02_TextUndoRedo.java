package _03_IntroToStacks;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class _02_TextUndoRedo implements KeyListener{
	JFrame frame;
	JPanel panel;
	JLabel label;
	Stack<Character> text = new Stack<Character>();
	Stack<Character> undo = new Stack<Character>();
	/* 
	 * Create a JFrame with a JPanel and a JLabel.
	 * 
	 * Every time a key is pressed, add that character to the JLabel. It should look like a basic text editor.
	 * 
	 * Make it so that every time the BACKSPACE key is pressed, the last character is erased from the JLabel.
	 * Save that deleted character onto a Stack of Characters.
	 * 
	 * Choose a key to be the Undo key. Make it so that when that key is pressed, the top Character is popped 
	 * off the Stack and added back to the JLabel.
	 * 
	 * */
	public static void main(String[] args) {
		new _02_TextUndoRedo().frame();
	}
	
	void frame() {
		frame = new JFrame();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel = new JPanel();
		frame.add(panel);
		label = new JLabel();
		panel.add(label);
		frame.addKeyListener(this);
	}
	
	private void makeLabelForStack() {
		String word = "";
	for (int i = 0; i < text.size(); i++) {
		word += (text.get(i));
	}	
	label.setText(word);
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyChar()== KeyEvent.VK_BACK_SPACE) {
			if(text.size()>0) {
			undo.push(text.pop());
			}
		}
		else {
		text.push(e.getKeyChar());
		}
		makeLabelForStack();
		frame.pack();
		frame.repaint();
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode()== 17) {
			System.out.println("eeqw");
			if(undo.size()>0) {
			text.push(undo.pop());
			}
		}
		makeLabelForStack();
		frame.pack();
		frame.repaint();
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
