package view2d.assets;

import java.awt.Dimension;
import java.awt.Graphics;

import model.Coordinate;
import view2d.Drawer2D;

public class SpriteDrawer implements Drawer2D{
	
	private Sprite sprite;
	
	public SpriteDrawer(int spriteID) {
		sprite = Assets.getLoader().getSprite(spriteID);
	}
	
	@Override
	public void draw(Graphics g, Coordinate coo){
		g.drawImage(sprite.getImage(), coo.getX()-sprite.getWidth()/2, coo.getY()-sprite.getHeight()/2, null);
	}
	
	@Override
	public Dimension getSpriteDimension() {
		return new Dimension(sprite.getWidth(), sprite.getHeight());
	}
}