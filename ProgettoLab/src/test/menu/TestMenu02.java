package test.menu;

import java.awt.Color;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

import assetsPc.Assets;
import model2D.SinglePlayer2D;
import view2d.menu.ButtonImageSet;
import view2d.menu.button.GameMenuButton;

public class TestMenu02 {
	
	public static void main(String[] args) {
		
		JFrame frame = new JFrame();
		JPanel menuPanel = new JPanel();
		menuPanel.setLayout(new BoxLayout(menuPanel, BoxLayout.Y_AXIS));
		menuPanel.setBackground(Color.BLACK);
		
		ButtonImageSet imageSet = new ButtonImageSet(	Assets.IMAGE_BUTTON_OUT_FOCUS_B,
				Assets.IMAGE_BUTTON_ONFOCUS_UNPRESSED_B,
				Assets.IMAGE_BUTTON_ONFOCUS_PRESSED_B);
		
		for (int i = 0; i < 5; i++) {
			menuPanel.add(new GameMenuButton(null, new SinglePlayer2D(frame), "Nuova Partita", imageSet,  Assets.FONT_GENERAL, 36f));
		}
		
		frame.getContentPane().add(menuPanel);
		frame.setVisible(true);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
