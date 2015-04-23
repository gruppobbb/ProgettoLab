package view2d.assets;

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
	
	public Font getSizedFont(float size){
		return myFont.deriveFont(size);
	}
}