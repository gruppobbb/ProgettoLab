package test.menu;

import java.awt.Color;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

import view2d.assets.Assets;
import view2d.menu.ButtonImageSet;
import view2d.menu.MenuButton;
import view2d.menu.SimpleButtonAnimation;
import view2d.menu.button.GameMenuButton;

public class TestMenu03 {
	public static void main(String[] args) {
		
		JFrame frame = new JFrame();
		JPanel menuPanel = new JPanel();
		menuPanel.setLayout(new BoxLayout(menuPanel, BoxLayout.Y_AXIS));
		menuPanel.setBackground(Color.BLACK);
		ButtonImageSet imageSet = new ButtonImageSet(	Assets.IMAGE_BUTTON_OUT_FOCUS_B,
														Assets.IMAGE_BUTTON_ONFOCUS_UNPRESSED_B,
														Assets.IMAGE_BUTTON_ONFOCUS_PRESSED_B);
		
		for (int i = 0; i < 5; i++) {
			MenuButton newGameButton = new GameMenuButton(null, null, "Nuova Partita", imageSet);
			newGameButton.setButtonAnimator(new SimpleButtonAnimation(newGameButton,5));
			newGameButton.setBFont(Assets.FONT_BUTTON_NAME, 32.f);
			menuPanel.add(newGameButton);
		}
		
		frame.getContentPane().add(menuPanel);
		frame.setVisible(true);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
