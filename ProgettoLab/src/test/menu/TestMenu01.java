package test.menu;

import javax.swing.JFrame;
import javax.swing.JPanel;

import view2d.render.MenuButton;

public class TestMenu01 {
	
	public static void main(String[] args) {
		
		JFrame frame = new JFrame();
		JPanel menuPanel = new JPanel();
		
		menuPanel.add(new MenuButton("Test", null));
		
		frame.getContentPane().add(menuPanel);
		
		//frame.setResizable(false);
		frame.setVisible(true);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

}
