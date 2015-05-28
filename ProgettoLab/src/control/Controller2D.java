package control;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Timer;
import java.util.TimerTask;

import model.Coordinate;
import model2D.ship.Ship2D;


/**
 * Controllo per una ship in uno spazio bidimensionale.
 * In questo caso non viene considerata la Z.
 * @author Jancarlos
 */
public class Controller2D implements KeyListener{
	
		
	private Ship2D userShip;
	private int directionPressed;
	private Timer timer;
	private boolean started;
	private boolean debug;
	private int rightBound, leftBound;
	
	//costanti, aiutano la leggibilità
	private static final int SX = -1;
	private static final int DX = 1;
	
	/**
	 * Costruisce un controller 2D per una {@link Ship2D}, limitando i movimenti tra leftBound e rightBound.
	 * @param userShip ship da controllare
	 * @param rightBound limite detro
	 * @param leftBound limite sinistro
	 */
	public Controller2D(Ship2D userShip, int rightBound, int leftBound) {
		this.userShip = userShip;
		this.rightBound = rightBound;
		this.leftBound = leftBound;
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
	
	/**
	 * Set del limite destro e sinistro all'interno del quale il controllo muove la nave.
	 * @param leftBound limite sinistro
	 * @param rightBound lmite destro
	 */
	public void setBound( int leftBound, int rightBound ){
		this.leftBound = leftBound;
		this.rightBound = rightBound;
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
		float newX = coo.getX() + userShip.getShiftAmount() *directionPressed;
		if(directionPressed == SX && userShip.getCoordinate().getX() > leftBound || directionPressed == DX && userShip.getCoordinate().getX() < rightBound) {
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
