package view2d.assets;

import java.util.HashMap;

public class Assets {
	
	private static final Assets loader = new Assets();
	private HashMap<Integer,Sprite> sprites = new HashMap<Integer, Sprite>();
	
	private Assets(){
		loadSprites();
	}
	
	public static Assets getLoader(){
		return loader;
	}
	
	public Sprite getSprite(int spriteID){
		return sprites.get(spriteID);
	}
	
	private void loadSprites(){
		sprites.put(SPRITE_DEFAULT, new Sprite("res/sprites/default.png"));
		sprites.put(SPRITE_SHIP, new Sprite("res/sprites/static_ship.png"));
		sprites.put(SPRITE_MOB, new Sprite("res/sprites/mob.png"));
	}
	
	
	
	public static final int SPRITE_DEFAULT = 0;
	public static final int SPRITE_SHIP = 1;
	public static final int SPRITE_MOB = 2;
	

}
