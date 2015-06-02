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
	
	/**
	 * @return Coordinata X
	 */
	public float getX() {
		return x;
	}
	
	/**
	 * @param x Coordinata X
	 */
	public void setX(float x) {
		this.x = x;
	}
	
	/**
	 * @return Coordinata Y
	 */
	public float getY() {
		return y;
	}
	
	/**
	 * @param y Coordinata Y
	 */
	public void setY(float y) {
		this.y = y;
	}
	
	/**
	 * @return Coordinata Z
	 */
	public float getZ() {
		return z;
	}
	
	/**
	 * @param z Coordinata Z
	 */ 
	public void setZ(float z) {
		this.z = z;
	}
}
