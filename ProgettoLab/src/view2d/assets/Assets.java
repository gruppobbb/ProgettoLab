package view2d.assets;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.imageio.ImageIO;

/**
 * Classe per la gestone degli Assets del gioco.
 * @author Jan
 *
 */
public class Assets {
	
	private static final Assets loader = new Assets();
	private HashMap<Integer,Sprite> sprites = new HashMap<Integer, Sprite>();
	private HashMap<Integer, BufferedImage> images = new HashMap<Integer, BufferedImage>();
	private HashMap<Integer,BFont> fonts = new HashMap<Integer,BFont>();
	
	
	private Assets(){
		loadSprites();
		loadImages();
		loadFonts();
	}
	
	public static Assets getLoader(){
		return loader;
	}
	
	public Sprite getSprite(int spriteID){
		return sprites.get(spriteID);
	}
	
	public BufferedImage getImage(int imageID){
		return images.get(imageID);
	}
	
	public BFont getFont(int fontID){
		return fonts.get(fontID);
	}
	
	private void loadSprites(){
		sprites.put(SPRITE_DEFAULT, new Sprite("res/sprites/default.png"));
		sprites.put(SPRITE_SHIP, new Sprite("res/sprites/static_ship.png"));
		sprites.put(SPRITE_MOB, new Sprite("res/sprites/mob.png"));
	}
	
	private void loadImages(){
		try {
			images.put(IMAGE_BUTTON_OUT_FOCUS, ImageIO.read(new File ("res/menu/greenButtonOutFocus.png")));
			images.put(IMAGE_BUTTON_ONFOCUS_UNPRESSED, ImageIO.read(new File("res/menu/onFocusGreenButtonUnpressed.png")));
			images.put(IMAGE_BUTTON_ONFOCUS_PRESSED, ImageIO.read(new File("res/menu/onFocusGreenButtonPressed.png")));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	private void loadFonts(){
		fonts.put(FONT_BUTTON_NAME, new BFont("res/fonts/origami.ttf"));
	}
	
	
	public static final int SPRITE_DEFAULT = 0;
	public static final int SPRITE_SHIP = 1;
	public static final int SPRITE_MOB = 2;
	
	
	public static final int IMAGE_BUTTON_OUT_FOCUS = 0;
	public static final int IMAGE_BUTTON_ONFOCUS_PRESSED = 1;
	public static final int IMAGE_BUTTON_ONFOCUS_UNPRESSED = 2;
	
	
	public static final int FONT_BUTTON_NAME = 0;

}
