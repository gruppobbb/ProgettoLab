package model.ships;

import java.awt.Dimension;
import java.awt.Graphics;

import model.Coordinate;

public class Ship2D {

	private Ship ship;
	private ShipDrawer2D shipDrawer;
	private Dimension dimension;
	
	public Ship2D(Coordinate coordinates, ShipDrawer2D shipDrawer) {
		this.shipDrawer = shipDrawer;
		ship = new Ship(coordinates);
		
		//default dimensions
		setDimension(new Dimension(50, 50));
			
	}

	public int getAmmo() {
		return ship.getAmmo();
	}
	
	public void setAmmo(int ammo) {
		ship.setAmmo(ammo);
	}

	public Coordinate getCoordinate() {
		return ship.getCoordinate();
	}

	public void setCoordinate(Coordinate coordinate) {
		ship.setCoordinate(coordinate);
	}
	
	public Dimension getDimension() {
		return dimension;
	}

	private void setDimension(Dimension dimension) {
		this.dimension = dimension;
	}

	public void draw(Graphics g){
		shipDrawer.draw(g, ship.getCoordinate(), getDimension());
	}
	
}
