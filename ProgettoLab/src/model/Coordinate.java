package model;

/**
 * Classe che rappresenta le coordinate a 3 dimensioni.
 * @author Jancarlos
 */
public class Coordinate {

	private float x;
	private float y;
	private float z;
	
	/**
	 * @param x Coordinata X
	 * @param y Coordinata Y
	 * @param z Coordinata Z
	 */
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
}
