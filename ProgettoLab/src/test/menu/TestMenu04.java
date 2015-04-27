package test.menu;

import assets.Assets;
import view2d.menu.BMenu;
import view2d.menu.ButtonImageSet;
import view2d.menu.MenuButton;
import view2d.menu.SimpleButtonAnimation;
import view2d.menu.button.GameMenuButton;

public class TestMenu04 {
	
	public static void main(String[] args) {
		BMenu menu = new BMenu("Test");
		
		ButtonImageSet imageSet = new ButtonImageSet(	Assets.IMAGE_BUTTON_OUT_FOCUS_B,
				Assets.IMAGE_BUTTON_ONFOCUS_UNPRESSED_B,
				Assets.IMAGE_BUTTON_ONFOCUS_PRESSED_B);
		
		ButtonImageSet imageSet2 = new ButtonImageSet(	Assets.IMAGE_BUTTON_OUT_FOCUS_F,
				Assets.IMAGE_BUTTON_ONFOCUS_UNPRESSED_F,
				Assets.IMAGE_BUTTON_ONFOCUS_PRESSED_F);
		
		MenuButton[] buttons = new MenuButton[3];
		for (int i = 0; i < 3; i++) {
			buttons[i] = new GameMenuButton(null, null, "Nuova Partita", imageSet);
			buttons[i].setButtonAnimator(new SimpleButtonAnimation(buttons[i],i+1));
			buttons[i].setBFont(Assets.FONT_GENERAL, 32.f);
		}
		menu.addButtons(buttons);
		
		for (int i = 0; i < 3; i++) {
			buttons[i] = new GameMenuButton(null, null, "Nuova Partita", imageSet2);
			//buttons[i].setButtonAnimator(new SimpleButtonAnimation(buttons[i],5));
			buttons[i].setBFont(Assets.FONT_GENERAL, 32.f);
			menu.addButton(buttons[i]);
		}
		
		//#### NOTATEMI ###
		menu.showMenu();
	}
}
