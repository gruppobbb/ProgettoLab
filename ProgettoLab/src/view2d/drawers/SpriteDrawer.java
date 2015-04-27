package view2d.drawers;

import java.awt.Dimension;
import java.awt.Graphics;

import assetsPc.Assets;
import assetsPc.Sprite;
import model.Coordinate;
import view2d.Drawer2D;

/**
 * Drawer che rappresenta l'elemento attraverso lo sprite specificato.
 * @author Jan
 */
public class SpriteDrawer implements Drawer2D{
	
	private Sprite sprite;
	private Dimension spriteDim;
	
	/**
	 * Drawer che usa lo sprite indicato tramite spriteID.
	 * @see Assets
	 * @param spriteID
	 */
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
