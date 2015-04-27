package assets;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * Classe che rappresenta un singolo Sprite.
 *
 * @author Jan
 *
 */
public class Sprite {
	
	private int width;
	private int height;
	private BufferedImage image;
	
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
	
	public BufferedImage getImage(){
		return image;
	}
	
	public int getHeight() {
		return height;
	}
	
	public int getWidth() {
		return width;
	}
	
}
