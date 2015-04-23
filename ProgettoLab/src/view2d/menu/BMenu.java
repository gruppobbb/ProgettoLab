package view2d.menu;

import java.awt.Color;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Classe per la definizione di un nuovo menu, nel quale inserire {@link MenuButton}.
 * @author Jan
 */
public class BMenu extends JFrame {

	private static final long serialVersionUID = -3982137563997527873L;
	private JPanel menuPanel;
	
	public BMenu(String menuTitle) {
		super();
		this.setTitle(menuTitle);
		menuPanel = new JPanel();
		menuPanel.setLayout(new BoxLayout(menuPanel, BoxLayout.Y_AXIS));
		menuPanel.setBackground(Color.BLACK);
		
		getContentPane().add(menuPanel);
		setResizable(false);
		setVisible(true);
		pack();
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	/**
	 * Metodo per l'aggiunta di N pulsanti.
	 * NOTA: Si usa un BoxLayout verticale.
	 * @param button
	 */
	public void addButtons(MenuButton... button){
		for (MenuButton menuButton : button) {
			menuPanel.add(menuButton);
		}
		pack();
		setLocationRelativeTo(null);
	}
	
	public void addButton(MenuButton button){
		menuPanel.add(button);
		pack();
		setLocationRelativeTo(null);
	}
	
}
