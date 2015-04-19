package model;

/**
 * Classe che rappresenta le coordinate a 3 dimensioni.
 * @author Jan
 *
 */
public class Coordinate {

	
	public static final Coordinate INITIAL_SHIP_2D_COORDINATE = new Coordinate(560, 540, 0);
	public static final int MOB_2D_SPAW_Y = -150;
	public static final int MOB_2D_SPAW_Z = 0;
	public static final int MOB_2D_MIN_X = 100;	//meta' sprite del mob.
	public static final int MOB_2D_MAX_X = 1180;
	public static final int MOB_2D_MAX_Y = 1430;
	
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
