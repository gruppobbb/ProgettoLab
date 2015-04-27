package view2d.menu.button;

import view2d.menu.ButtonImageSet;
import view2d.menu.MenuButton;

/**
 * {@link MenuButton} che effettua la chiusura del gioco.
 * @author Jancarlos
 */
public class ExitMenuButton extends MenuButton{

	private static final long serialVersionUID = 5415289309476985932L;

	/**
	 * Crea un pulsante per chiudere il gioco.
	 * @param buttonName
	 * @param imageSet
	 * @param fontID
	 * @param fontSize
	 */
	public ExitMenuButton(String buttonName,
			ButtonImageSet imageSet, int fontID, float fontSize) {
		super(buttonName, imageSet, fontID, fontSize);
	}

	/**
	 * Crea un pulsante per chiudere il gioco.
	 * @param buttonName
	 * @param imageSet
	 */
	public ExitMenuButton(String buttonName,
			ButtonImageSet imageSet) {
		super(buttonName, imageSet);
	}

	@Override
	public void action() {
		System.exit(0);
	}
}
