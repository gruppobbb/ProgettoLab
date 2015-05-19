package model2D;


/** 
 * Astrazione dell'algoritmo secondo cui si muove un mob in 2D.
 * @author Max
 */
public interface MovingLogic2D {
	
	/**
	 * Muove il mob.
	 * @param mob
	 */
	public void move(Mob2D mob);

}
