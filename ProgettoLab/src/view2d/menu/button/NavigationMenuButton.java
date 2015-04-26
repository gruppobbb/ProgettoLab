package view2d.menu.button;

import view2d.menu.BMenu;
import view2d.menu.MenuButton;
import view2d.menu.button.interaction.ButtonImageSet;

public class NavigationMenuButton extends MenuButton{
	
	private BMenu parentMenu;
	private BMenu nextMenu;
	
	
	public NavigationMenuButton(BMenu parentMenu, BMenu nextMenu, String buttonName,
			ButtonImageSet imageSet, int fontID, float fontSize) {
		super(buttonName, imageSet, fontID, fontSize);
		this.parentMenu = parentMenu;
		this.nextMenu = nextMenu;
	}

	public NavigationMenuButton(BMenu parentMenu, BMenu nextMenu,String buttonName,
			ButtonImageSet imageSet) {
		super(buttonName, imageSet);
		this.parentMenu = parentMenu;
		this.nextMenu = nextMenu;
	}

	@Override
	public void action() {
		if(parentMenu!= null ){
			parentMenu.setEnabled(false);
			//parentFrame.setVisible(false);
		}
		if(nextMenu != null){
			nextMenu.setVisible(true);
		}
	}
}
