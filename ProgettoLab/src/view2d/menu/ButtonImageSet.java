package view2d.menu;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

import view2d.assets.Assets;

/**
 * Classe per la definizione del set di immagini per un {@link MenuButton} dato uno status.
 * @see ButtonStatus
 * @author Jan
 */
public class ButtonImageSet {
	
	public static final int STATUS_ON_FOCUS_UNPRESSED = 1;
	public static final int STATUS_ON_FOCUS_PRESSED = 2;
	
	private ArrayList<BufferedImage> buttonImageset;

	/**
	 * Costruzione di un set di immagini per un {@link MenuButton}.
	 * @see ButtonStatus
	 * @param outFocusImageID
	 * @param onFocusUnpressedImageID
	 * @param onFocusPressedImageID
	 */
	public ButtonImageSet(int outFocusImageID,
			int onFocusUnpressedImageID,
			int onFocusPressedImageID) {
		super();
		
		buttonImageset = new ArrayList<BufferedImage>();
		buttonImageset.add(ButtonStatus.STATUS_OUT_FOCUS,Assets.getLoader().getImage(outFocusImageID));
		buttonImageset.add(ButtonStatus.STATUS_ON_FOCUS_UNPRESSED,Assets.getLoader().getImage(onFocusUnpressedImageID));
		buttonImageset.add(ButtonStatus.STATUS_ON_FOCUS_PRESSED,Assets.getLoader().getImage(onFocusPressedImageID));
	}

	/**
	 * Restituisce una immagine dato uno status definito in {@link ButtonStatus}.
	 * @param status status del {@link MenuButton}
	 * @return l'immagine da apllicare al {@link MenuButton}
	 */
	public BufferedImage getImageFromStatus(int status){
		return buttonImageset.get(status);
	}

	/**
	 * Interfaccia per la definizione degli statuso di un {@link MenuButton}.
	 * @author Jan
	 *
	 */
	public interface ButtonStatus{
		
		/**
		 * Quando il cursore non è sopra il pulsante.
		 */
		public static final int STATUS_OUT_FOCUS = 0;
		
		/**
		 * Quando il cursore è sopra il pulsante, ma non clicca.
		 */
		public static final int STATUS_ON_FOCUS_UNPRESSED = 1;
		
		/**
		 * Quando il cursore è sopra il pulsante e non clicca.
		 */
		public static final int STATUS_ON_FOCUS_PRESSED = 2;
	}
}