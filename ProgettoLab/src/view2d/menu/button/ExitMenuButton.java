package view2d.menu.button;

import view2d.menu.ButtonImageSet;
import view2d.menu.MenuButton;

public class ExitMenuButton extends MenuButton{
	
	
	
	public ExitMenuButton(String buttonName,
			ButtonImageSet imageSet, int fontID, float fontSize) {
		super(buttonName, imageSet, fontID, fontSize);
	}

	public ExitMenuButton(String buttonName,
			ButtonImageSet imageSet) {
		super(buttonName, imageSet);
	}

	@Override
	public void action() {
		System.exit(0);
	}
}
