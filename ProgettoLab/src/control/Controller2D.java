package control;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Timer;
import java.util.TimerTask;

import model.Coordinate;
import model.Ship;


/**
 * Controllo di una ship in uno spazio bidimensionale.
 * In questo caso non viene considerata la Z.
 * @author Jancarlos
 *
 */
public class Controller2D implements KeyListener{
	
		
	private Ship userShip;
	private int directionPressed;
	private Timer timer;
	private boolean started = false;
	private boolean debug = false;

	public Controller2D(Ship userShip) {
		this.userShip = userShip;

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
		int newX = coo.getX() + userShip.SHIFT_AMOUNT*directionPressed;
		userShip.setCoordinate(new Coordinate(newX, coo.getY(), 0));
		if(debug){
			System.out.println(coo);
		}
	}
	
	
	
	//Metodo utilizzato per la selezione della direzione verso cui muoversi.
	private int getDirection( int keyCode ){
		int dx = 1;
		int sx = -1;
		switch ( keyCode ) {
			case KeyEvent.VK_LEFT:	return sx;
			case KeyEvent.VK_RIGHT:	return dx;
			default:	return 0;
		}
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
	}
	
	
}
