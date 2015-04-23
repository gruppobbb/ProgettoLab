package test.menu;

import java.awt.Color;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

import view2d.assets.Assets;
import view2d.menu.ButtonImageSet;
import view2d.menu.MenuButton;

public class TestMenu01 {
	
	public static void main(String[] args) {
		
		JFrame frame = new JFrame();
		JPanel menuPanel = new JPanel();
		menuPanel.setLayout(new BoxLayout(menuPanel, BoxLayout.Y_AXIS));
		menuPanel.setBackground(Color.BLACK);
		
		ButtonImageSet imageSet = new ButtonImageSet(	Assets.IMAGE_BUTTON_OUT_FOCUS,
				Assets.IMAGE_BUTTON_ONFOCUS_UNPRESSED,
				Assets.IMAGE_BUTTON_ONFOCUS_PRESSED);
		
		menuPanel.add(new MenuButton(null, null, "Nuova Partita",  imageSet));
		
		frame.getContentPane().add(menuPanel);
		
		frame.setVisible(true);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

}
