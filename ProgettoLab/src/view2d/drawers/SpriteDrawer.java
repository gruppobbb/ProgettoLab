package view2d.drawers;

import java.awt.Dimension;
import java.awt.Graphics;

import assets.Assets;
import model.Coordinate;
import view2d.Drawer2D;
import view2d.assets.Sprite;

/**
 * Drawer che rappresenta l'elemento attraverso la sprite specificata.
 * @author Jan
 *
 */
public class SpriteDrawer implements Drawer2D{
	
	private Sprite sprite;
	private Dimension spriteDim;
	
	public SpriteDrawer(int spriteID) {
		sprite = Assets.getLoader().getSprite(spriteID);
		spriteDim = new Dimension(sprite.getWidth(), sprite.getHeight());
	}
	
	@Override
	public void draw(Graphics g, Coordinate coo){
		g.drawImage(sprite.getImage(), coo.getX()-sprite.getWidth()/2, coo.getY()-sprite.getHeight()/2, null);
	}
	
	@Override
	public Dimension getSpriteDimension() {
		return spriteDim;
	}
}
