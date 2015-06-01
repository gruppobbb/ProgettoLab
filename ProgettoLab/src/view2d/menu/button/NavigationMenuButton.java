package view2d.menu.button;

import view2d.menu.BMenu;
import view2d.menu.ButtonImageSet;
import view2d.menu.MenuButton;

/**
 * {@link MenuButton} per il passaggio da un menu ad un altro.
 * @author Jancarlos
 *
 */
public class NavigationMenuButton extends MenuButton{
	
	private static final long serialVersionUID = -7833156248543889287L;
	private BMenu parentMenu;
	private BMenu nextMenu;
	
	/**
	 * Crea un pulsante per il passaggio verso nextMenu.
	 * @param parentMenu
	 * @param nextMenu
	 * @param buttonName
	 * @param imageSet
	 * @param fontID
	 * @param fontSize
	 */
	public NavigationMenuButton(BMenu parentMenu, BMenu nextMenu, String buttonName,
			ButtonImageSet imageSet, int fontID, float fontSize) {
		super(buttonName, imageSet, fontID, fontSize);
		this.parentMenu = parentMenu;
		this.nextMenu = nextMenu;
	}

	/**
	 * @param parentMenu
	 * @param nextMenu
	 * @param buttonName
	 * @param imageSet
	 */
	public NavigationMenuButton(BMenu parentMenu, BMenu nextMenu,String buttonName,
			ButtonImageSet imageSet) {
		super(buttonName, imageSet);
		this.parentMenu = parentMenu;
		this.nextMenu = nextMenu;
	}

	/**
	 * @see MenuButton
	 */
	@Override
	public void action() {
		if(nextMenu != null){
			nextMenu.showMenu();
			parentMenu.hideMenu();
		}
	}
}
