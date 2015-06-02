package view2d.menu.button;

import model2D.SinglePlayer2D;
import view2d.menu.BMenu;
import view2d.menu.ButtonImageSet;
import view2d.menu.MenuButton;

/**
 * {@link MenuButton} per l'avvio di una modalità.
 * @author Jancarlos
 *
 */
public class GameMenuButton extends MenuButton{
	
	private static final long serialVersionUID = 6711130114931024959L;
	private BMenu parentMenu;
	private SinglePlayer2D game;
	
	/**
	 * Crea un pulsante per l'avvio della modalià game.
	 * @param parentMenu
	 * @param game
	 * @param buttonName
	 * @param imageSet
	 * @param fontID
	 * @param fontSize
	 */
	public GameMenuButton(BMenu parentMenu, SinglePlayer2D game, String buttonName,
			ButtonImageSet imageSet, int fontID, float fontSize) {
		super(buttonName, imageSet, fontID, fontSize);
		this.parentMenu = parentMenu;
		this.game = game;
	}

	/**
	 * Crea un pulsante per l'avvio della modalià game.
	 * @param parentMenu
	 * @param game
	 * @param buttonName
	 * @param imageSet
	 */
	public GameMenuButton(BMenu parentMenu, SinglePlayer2D game, String buttonName,
			ButtonImageSet imageSet) {
		super(buttonName, imageSet);
		this.parentMenu = parentMenu;
		this.game = game;
	}

	/**
	 * @see MenuButton
	 */
	@Override
	public void action() {
		if(parentMenu!= null ){
			//Per ora metto disable, ma l'idea è di fare sparire... o di fare un morph del panel :3
			parentMenu.setEnabled(false);
			//parentFrame.setVisible(false);
		}
		if(game != null){
			game.start();
		}
	}
}
