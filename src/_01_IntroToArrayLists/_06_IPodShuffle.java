package _01_IntroToArrayLists;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

//Copyright The League of Amazing Programmers, 2015

public class _06_IPodShuffle implements ActionListener {
	JFrame frame;
	JPanel panel;
	JButton button;
	ArrayList<Song> songs;
	Song s;
	Song s2;
	Song s3;

	public _06_IPodShuffle() {
		// 1. Use the Song class the play the demo.mp3 file.
		s = new Song("demo.mp3");
		s2 = new Song("sample2.mp3");
		s3 = new Song("oceanman.mp3");

		/**
		 * 2. Congratulations on completing the sound check! * Now we want to make an
		 * iPod Shuffle that plays random music. * Create an ArrayList of Songs and a
		 * "Surprise Me!" button that will play a random song when it is clicked. * If
		 * you're really cool, you can stop all the songs, before playing a new one on
		 * subsequent button clicks.
		 */
		songs = new ArrayList<Song>();
		songs.add(s);
		songs.add(s2);
		songs.add(s3);
		

	}
	public void CreateUI() {
		frame = new JFrame("Shuffle");
		panel = new JPanel();
		button = new JButton();
		frame.add(panel);
		panel.add(button);
		button.addActionListener(this);
		button.setText("Surprise Me!");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.pack();
	}
	
	public static void main(String[] args) {
		new _06_IPodShuffle().CreateUI();
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Random rand = new Random();
		if (e.getSource() == button) {
			for (int i = 0; i < songs.size(); i++) {
				songs.get(i).stop();
			}
			int i = rand.nextInt(songs.size());
				songs.get(i).play();
			}
		}
	}
