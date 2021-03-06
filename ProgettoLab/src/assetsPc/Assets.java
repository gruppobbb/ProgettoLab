package assetsPc;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.imageio.ImageIO;
import javax.sound.sampled.Clip;

import assetsPc.audio.AudioLoader;

/**
 * Classe per la gestone degli Assets del gioco. 
 * @author Jan
 */
//SINGLETON
public class Assets {
	
	private static final Assets loader = new Assets();
	private HashMap<Integer,Sprite> sprites = new HashMap<Integer, Sprite>();
	private HashMap<Integer, BufferedImage> images = new HashMap<Integer, BufferedImage>();
	private HashMap<Integer,BFont> fonts = new HashMap<Integer,BFont>();
	private HashMap<Integer, Clip> clips = new HashMap<Integer, Clip>();
	
	private Assets(){
		loadSprites();
		loadImages();
		loadFonts();
		loadClips();
	}
	
	/**
	 * Restituisce l'istanza corrente di Assets.
	 * @return istanza di {@link Assets}
	 */
	public static Assets getLoader(){
		return loader;
	}
	
	/**
	 * Restituisce la sprite associata all'identificatore spriteID.
	 * @param spriteID identificatore della sprite
	 * @return {@link Sprite} associata a spriteID
	 */
	public Sprite getSprite(int spriteID){
		return sprites.get(spriteID);
	}
	
	/**
	 * Restituisce l'immagine associata all'identificatore imageID.
	 * @param imageID identificatore dell'immagine
	 * @return {@link BufferedImage} associata a imageID
	 */
	public BufferedImage getImage(int imageID){
		return images.get(imageID);
	}
	
	/**
	 * Restituisce il font associato all'identificatore fontID.
	 * @param fontID identificatore del font
	 * @return {@link BFont} associato a fontID
	 */
	public BFont getFont(int fontID){
		return fonts.get(fontID);
	}
	
	/**
	 * Restituisce la clip associata all'identificatore fontID.
	 * @param clipID identificatore della clip
	 * @return {@link Clip} associata a clipID
	 */
	public Clip getClip(int clipID){
		return clips.get(clipID);
	}
	
	/**
	 * Carica gli sprite necessari.
	 */
	private void loadSprites(){
		sprites.put(SPRITE_DEFAULT, new Sprite("res/sprites/default.png"));
		sprites.put(SPRITE_SHIP, new Sprite("res/sprites/static_ship.png"));
		sprites.put(SPRITE_MOB, new Sprite("res/sprites/mob.png"));
	}
	
	private void loadImages(){
		try {
			images.put(IMAGE_BUTTON_OUT_FOCUS_B, ImageIO.read(new File ("res/menu/buttons/bounded/outFocusBoundedGreenButton.png")));
			images.put(IMAGE_BUTTON_ONFOCUS_UNPRESSED_B, ImageIO.read(new File("res/menu/buttons/bounded/onFocusBoundedGreenButtonUnpressed.png")));
			images.put(IMAGE_BUTTON_ONFOCUS_PRESSED_B, ImageIO.read(new File("res/menu/buttons/bounded/onFocusBoundedGreenButtonPressed.png")));
			images.put(IMAGE_BUTTON_OUT_FOCUS_F, ImageIO.read(new File ("res/menu/buttons/fullGreen/outFocusfullGreenButton.png")));
			images.put(IMAGE_BUTTON_ONFOCUS_UNPRESSED_F, ImageIO.read(new File("res/menu/buttons/fullGreen/onFocusFullGreenButtonUnpressed.png")));
			images.put(IMAGE_BUTTON_ONFOCUS_PRESSED_F, ImageIO.read(new File("res/menu/buttons/fullGreen/onFocusFullGreenButtonPressed.png")));
			
			images.put(IMAGE_BACKGROUND, ImageIO.read(new File("res/menu/background/space.jpg")));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void loadFonts(){
		fonts.put(FONT_GENERAL, new BFont("res/fonts/origami.ttf"));
	}
	
	private void loadClips(){
		AudioLoader loader = new AudioLoader();
		clips.put(AUDIO_EXPLOSION, loader.loadClip("res/bgm/ship_explosion.wav"));
		clips.put(AUDIO_BGM, loader.loadClip("res/bgm/theme.wav"));
	}
	
	
	public static final int SPRITE_DEFAULT = 0;
	public static final int SPRITE_SHIP = 1;
	public static final int SPRITE_MOB = 2;
	
	
	public static final int IMAGE_BUTTON_OUT_FOCUS_B = 0;
	public static final int IMAGE_BUTTON_ONFOCUS_PRESSED_B = 1;
	public static final int IMAGE_BUTTON_ONFOCUS_UNPRESSED_B = 2;
	public static final int IMAGE_BUTTON_OUT_FOCUS_F = 3;
	public static final int IMAGE_BUTTON_ONFOCUS_PRESSED_F = 4;
	public static final int IMAGE_BUTTON_ONFOCUS_UNPRESSED_F = 5;
	public static final int IMAGE_BACKGROUND = 6;
	
	public static final int FONT_GENERAL = 0;
	
	public static final int AUDIO_BGM = 0;
	public static final int AUDIO_EXPLOSION = 1;

}
