package view2d.menu.button;

import view2d.menu.BMenu;
import view2d.menu.ButtonImageSet;
import view2d.menu.MenuButton;

public class ExitMenuButton extends MenuButton{
	
	private BMenu parentMenu;
	
	
	public ExitMenuButton(BMenu parentMenu, String buttonName,
			ButtonImageSet imageSet, int fontID, float fontSize) {
		super(buttonName, imageSet, fontID, fontSize);
		this.parentMenu = parentMenu;
	}

	public ExitMenuButton(BMenu parentMenu,String buttonName,
			ButtonImageSet imageSet) {
		super(buttonName, imageSet);
		this.parentMenu = parentMenu;
	}

	@Override
	public void action() {
		//TODO: fare la chiusura per bene di quello che c'è nel menu... 
		//esempio musiche anche li (?)
		parentMenu.dispose();
	}
}
