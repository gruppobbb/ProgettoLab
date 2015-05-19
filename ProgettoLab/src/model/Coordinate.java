package model;

/**
 * Classe che rappresenta le coordinate a 3 dimensioni.
 * @author Jan
 */
public class Coordinate {

	private float x;
	private float y;
	private float z;
	
	public Coordinate(float x, float y, float z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public float getX() {
		return x;
	}
	public void setX(float x) {
		this.x = x;
	}
	public float getY() {
		return y;
	}
	public void setY(float y) {
		this.y = y;
	}
	public float getZ() {
		return z;
	}
	public void setZ(float z) {
		this.z = z;
	}
	
	@Override
	public String toString() {
		return String.format("x: %s y: %s z: %s", x,y,z);
	}
}
