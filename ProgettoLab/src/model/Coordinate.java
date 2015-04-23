package model;

/**
 * Classe che rappresenta le coordinate a 3 dimensioni.
 * @author Jan
 *
 */
public class Coordinate {

	private int x;
	private int y;
	private int z;
	
	public Coordinate(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getZ() {
		return z;
	}
	public void setZ(int z) {
		this.z = z;
	}
	
	@Override
	public String toString() {
		return String.format("x: %s y: %s z: %s", x,y,z);
	}
	
	
	
}
