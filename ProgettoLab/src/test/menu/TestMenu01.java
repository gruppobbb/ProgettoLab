package test.menu;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

import view2d.assets.Assets;
import view2d.menu.MenuButton;

public class TestMenu01 {
	
	public static void main(String[] args) {
		
		JFrame frame = new JFrame();
		JPanel menuPanel = new JPanel();
		menuPanel.setLayout(new BoxLayout(menuPanel, BoxLayout.Y_AXIS));
		
		for (int i = 0; i < 5; i++) {
			menuPanel.add(new MenuButton(null, "Nuova Partita",  Assets.FONT_BUTTON_NAME, 36f));
		}
		
		frame.getContentPane().add(menuPanel);
		
		//frame.setResizable(false);
		frame.setVisible(true);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

}
