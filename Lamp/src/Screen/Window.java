package Screen;

import javax.swing.*;
import java.awt.*;

public class Window {
	private JFrame window;
	{
		window = new JFrame("Lamp");
		window.getContentPane().setLayout(null);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
		window.setPreferredSize(new Dimension(322, 381));
		window.pack();
		window.setLocationRelativeTo(null);
		window.getContentPane().setBackground(Color.white);
		window.setVisible(true);
		window.setIconImage(new ImageIcon(getClass().getResource("/images/lamp_glowing.png")).getImage());
	}
	public void attach(Component c) { 
		window.getContentPane().add(c);
	}
}
