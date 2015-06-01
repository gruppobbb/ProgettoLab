package assetsPc;

import java.awt.Font;
import java.awt.FontFormatException;
import java.io.File;
import java.io.IOException;

/**
 * Classe per la semplificazione di caricamento di un dato font.
 * @author Jan
 *
 */
public class BFont {
	private Font myFont;
	
	/**
	 * @param path Path del font
	 */
	public BFont(String path) {
		File f = new File(path);
		try {
			this.myFont = Font.createFont(Font.TRUETYPE_FONT, f);
		} catch (FontFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Restituisce il font ridimensionato alla dimensione size.
	 * @param size dimensione del font
	 * @return font con dimensione size
	 */
	public Font getSizedFont(float size){
		return myFont.deriveFont(size);
	}
}