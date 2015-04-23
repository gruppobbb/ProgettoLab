package test.menu;

import view2d.assets.Assets;
import view2d.menu.BMenu;
import view2d.menu.ButtonImageSet;
import view2d.menu.MenuButton;
import view2d.menu.SimpleButtonAnimation;

public class TestMenu04 {
	
	public static void main(String[] args) {
		BMenu menu = new BMenu("Test");
		
		ButtonImageSet imageSet = new ButtonImageSet(	Assets.IMAGE_BUTTON_OUT_FOCUS,
				Assets.IMAGE_BUTTON_ONFOCUS_UNPRESSED,
				Assets.IMAGE_BUTTON_ONFOCUS_PRESSED);
		
		MenuButton[] buttons = new MenuButton[2];
		for (int i = 0; i < 2; i++) {
			buttons[i] = new MenuButton(null, null, "Nuova Partita", imageSet);
			buttons[i].setButtonAnimator(new SimpleButtonAnimation(buttons[i],5));
			buttons[i].setBFont(Assets.FONT_BUTTON_NAME, 32.f);
		}
		menu.addButtons(buttons);
		
		for (int i = 0; i < 2; i++) {
			buttons[i] = new MenuButton(null, null, "Nuova Partita", imageSet);
			buttons[i].setButtonAnimator(new SimpleButtonAnimation(buttons[i],5));
			buttons[i].setBFont(Assets.FONT_BUTTON_NAME, 32.f);
			menu.addButton(buttons[i]);
		}
	}
}
