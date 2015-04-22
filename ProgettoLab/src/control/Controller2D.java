package control;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Timer;
import java.util.TimerTask;

import model.Coordinate;
import model.ships.Ship;
import model.ships.Ship2D;


/**
 * Controllo di una ship in uno spazio bidimensionale.
 * In questo caso non viene considerata la Z.
 * @author Jancarlos
 *
 */
public class Controller2D implements KeyListener{
	
		
	private Ship2D userShip;
	private int directionPressed;
	private Timer timer;
	private boolean started = false;
	private boolean debug = false;
	private int right_bound, left_bound;
	
	//costanti, aiutano la leggibilità
	private static final int SX = -1;
	private static final int DX = 1;
	

	public Controller2D(Ship2D userShip, int right_bound, int left_bound) {
		this.userShip = userShip;
		this.right_bound = right_bound;
		this.left_bound = left_bound;
	}
	

	@Override
	public void keyPressed(KeyEvent e) {
		
			directionPressed =  getDirection( e.getKeyCode()  );
			
			if(!started){
				started = true;
				timer = new Timer();
				
				TimerTask moveTask = new TimerTask() {
					@Override
					public void run() {
						moveXAxis();
					}
				};
				timer.scheduleAtFixedRate( moveTask, 0, 10);
			}
		}
	
	public void setBound( int left_bound, int right_bound ){
		this.left_bound = left_bound;
		this.right_bound = right_bound;
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		started = false;
		timer.cancel();
	}
	
	
	/**
	 * Spostamento lungo l'asse X.
	 */
	public void moveXAxis() {
		Coordinate coo= userShip.getCoordinate();
		int newX = coo.getX() + Ship.SHIFT_AMOUNT*directionPressed;
		if(directionPressed == SX && userShip.getCoordinate().getX() > left_bound || directionPressed == DX && userShip.getCoordinate().getX() < right_bound) {
			userShip.setCoordinate(new Coordinate(newX, coo.getY(), 0));
			if(debug){
				System.out.println(coo);
			}
		}
	}
	
	
	
	//Metodo utilizzato per la selezione della direzione verso cui muoversi.
	private int getDirection( int keyCode ){
		switch ( keyCode ) {
			case KeyEvent.VK_LEFT:	return SX;
			case KeyEvent.VK_RIGHT:	return DX;
			default:	return 0;
		}
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
	}
	
	
}
