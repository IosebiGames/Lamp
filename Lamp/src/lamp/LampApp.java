package lamp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.sound.sampled.*;
import java.io.*;

import Screen.Window;

public class LampApp {
	
	public JLabel lampLabel;
	public Window w;
	private Sound s;
	
	private LampApp() {
		w = new Window();
        s = new Sound();
		lampLabel = new JLabel("");
		lampLabel.setBackground(Color.white);
		lampLabel.setOpaque(true);
		lampLabel.setBounds(43, 47, 261, 245);
		lampLabel.setIcon(new ImageIcon(getClass().getResource("/images/lamp_empty.png")));
		lampLabel.setFocusable(false);
		lampLabel.setVisible(true);
		lampLabel.addMouseListener(new LampBehaviour());
		w.attach(lampLabel);
	}
	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			  new LampApp();
		});
	}
	private class LampBehaviour extends MouseAdapter {
		@Override
		public void mousePressed(MouseEvent e) {
			s.play();
			lampLabel.setBounds(23, 47, 261, 245);
			lampLabel.setIcon(new ImageIcon(getClass().getResource("/images/lamp_glowing.png")));
		}
		@Override
		public void mouseExited(MouseEvent e) {
			lampLabel.setBounds(43, 47, 261, 245);
			lampLabel.setIcon(new ImageIcon(getClass().getResource("/images/lamp_empty.png")));
		}
	}
	private class Sound {
		private static Clip clip;
		public void play() {
			try {
				clip = AudioSystem.getClip();
				clip.open(AudioSystem.getAudioInputStream(getClass().getResource("/sound/click_sound.wav")));
				clip.start();
			}catch(Exception e) {
				IO.println("Failed to load:" + e.getMessage());
			}
		}
	}
}
