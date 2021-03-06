package assetsPc;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * Classe che rappresenta un singolo Sprite.
 * @author Jan
 *
 */
public class Sprite {
	
	private int width;
	private int height;
	private BufferedImage image;
	
	/**
	 * @param path Path della sprite
	 */
	public Sprite(String path) {
		File file = new File(path);
		if( file.exists() ){
			load(file);
		}
	}
	
	private void load(File file){
		try {
			image = ImageIO.read( file );
		} catch (IOException e) {
			e.printStackTrace();
		}
		width = image.getWidth();
		height = image.getHeight();
	}
	
	/**
	 * Restituisce la {@link BufferedImage} della sprite.
	 * @return immagine della sprite
	 */
	public BufferedImage getImage(){
		return image;
	}
	
	/**
	 * Restituisce l'altezza della sprite.
	 * @return altezza della sprite
	 */
	public int getHeight() {
		return height;
	}
	
	/**
	 * Restituisce la larghezza della sprite.
	 * @return larghezza della sprite
	 */
	public int getWidth() {
		return width;
	}
	
}
