package test.menu;

import java.awt.Color;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

import model.games.SinglePlayer2D;
import view2d.assets.Assets;
import view2d.menu.MenuButton;

public class TestMenu02 {
	
	public static void main(String[] args) {
		
		JFrame frame = new JFrame();
		JPanel menuPanel = new JPanel();
		menuPanel.setLayout(new BoxLayout(menuPanel, BoxLayout.Y_AXIS));
		menuPanel.setBackground(Color.BLACK);
		
		for (int i = 0; i < 5; i++) {
			menuPanel.add(new MenuButton(frame, new SinglePlayer2D(), "Nuova Partita",  Assets.FONT_BUTTON_NAME, 36f));
		}
		
		
		
		frame.getContentPane().add(menuPanel);
		
		//frame.setResizable(false);
		frame.setVisible(true);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

}
