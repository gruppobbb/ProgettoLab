package view2d.menu.button;

import view2d.menu.BMenu;
import view2d.menu.MenuButton;
import view2d.menu.button.interaction.ButtonImageSet;
import model.Game;

public class GameMenuButton extends MenuButton{
	
	private BMenu parentMenu;
	private Game game;
	
	
	public GameMenuButton(BMenu parentMenu, Game game, String buttonName,
			ButtonImageSet imageSet, int fontID, float fontSize) {
		super(buttonName, imageSet, fontID, fontSize);
		this.parentMenu = parentMenu;
		this.game = game;
	}

	public GameMenuButton(BMenu parentMenu, Game game, String buttonName,
			ButtonImageSet imageSet) {
		super(buttonName, imageSet);
		this.parentMenu = parentMenu;
		this.game = game;
	}

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
