package model;

import java.util.ArrayList;
import java.util.Observable;

import model.mobs.Mob;
import model.movement.Moveable;
import model.scores.ScoreCalculator;
import model.ships.Ship;
import assetsPc.audio.AudioPlayer;

/**
 * Componente che si occupa di far progredire il gioco muovendo i mob, calcolando il punteggio e controllando le collisioni dei mob con la ship.
 * Le collisioni sono gestite attraverso un pattern Observer, secondo cui gli osservatori di {@link GameEngine} vengono informati a seguito di un'avvenuta collisione.
 * @author Max
 */
public class GameEngine extends Observable implements Runnable {
	
	private long sleepTime;
	private MobsManager mobsManager;
	private Ship ship;
	private Coordinate bounds;
	private boolean collided;
	private AudioPlayer explosionPlayer;
	private ScoreCalculator scoreCalculator;
	private int scoreUpdateCounter;
	private int scoreUpdateCounterLimit;
	private Object mPauseLock;
    private boolean mPaused;
    private boolean mFinished;   
	
    /**
     * @param mobsManager {@link MobsManager} che contiene i mob su cui il motore deve agire
     * @param ship {@link Ship} dell'utente
     * @param viewBounds {@link Coordinate} che specifica gli estremi, lungo i tre assi, al di fuori dei quali un mob deve essere eliminato
     */
	public GameEngine(MobsManager mobsManager, Ship ship, Coordinate viewBounds) {
		this.mobsManager = mobsManager;
		this.ship = ship;
		this.bounds = viewBounds;
		this.sleepTime = 10; //default
		this.scoreCalculator = new ScoreCalculator();
		
		scoreUpdateCounterLimit = (int)(1000 / sleepTime);	//aggiorna il punteggio ogni secondo
		
		//propriet� iniziali del runnable
		mPauseLock = new Object();
        mPaused = false;
        mFinished = false;
	}	
	
	/**
	 * Algoritmo principale dell'engine. 
	 * Non dovrebbe mai essere invocato direttamente, ma solo attraverso un {@link Thread}.
	 */
	public void run() {
		while(mFinished == false) {
			ArrayList<Mob> mobs = mobsManager.getMobsList();
			
			float shipX = ship.getCoordinate().getX();
			float shipY = ship.getCoordinate().getY();
			float shipZ = ship.getCoordinate().getZ();
			double shipCollisionRay = ship.getCollisionRay();
			
			for (Mob mob : mobs) {
				Moveable m = (Moveable) mob;
				m.move();
				
				//controllo collisione del mob con la navicella
				
				removeOutOfBoundsMobs(mob);	//questo metodo deve essere invocato prima del check delle collisioni
											//(inutile controllare se collide quando � fuori dal campo)
				
				checkCollisionWithShip(shipX, shipY, shipZ, shipCollisionRay,
						mob);
			}
			
			if(scoreUpdateCounter == scoreUpdateCounterLimit) {
				scoreCalculator.updateScore();
				scoreUpdateCounter = 0;
			}
			scoreUpdateCounter ++;
			
			try {
				Thread.sleep(sleepTime);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			synchronized (mPauseLock) {
	            while (mPaused) {
	                try {
	                    mPauseLock.wait();
	                } catch (InterruptedException e) {
	                }
	            }
	        }			
		}
	}
	
	/**
	 * Manda in pausa l'engine.
	 */
	public void onPause() {
        synchronized (mPauseLock) {
            mPaused = true;
        }
    }
	 
	/**
	 * Riattiva l'engine.
	 */
	public void onResume() {
        synchronized (mPauseLock) {
            mPaused = false;
            mPauseLock.notifyAll();
        }
    }
	
	//controlla la collisione con la ship
	private void checkCollisionWithShip(float shipX, float shipY, float shipZ,
			double shipCollisionRay, Mob mob) {
		float mobX = mob.getCoordinate().getX();
		float mobY = mob.getCoordinate().getY();
		float mobZ = mob.getCoordinate().getZ();
		double mobCollisionRay = mob.getCollisionRay();
		double distance = Math.sqrt(	(mobX - shipX) * (mobX - shipX) +	
										(mobY - shipY) * (mobY - shipY) +	
										(mobZ - shipZ) * (mobZ - shipZ));

		if(distance < shipCollisionRay + mobCollisionRay) {
			if(explosionPlayer != null ){
				explosionPlayer.play();
			}
			setCollided(true);
		}
	}

	//rimuove i mob che sono fuori dai confini specificati (da bounds)
	private void removeOutOfBoundsMobs(Mob mob) {
		if(	mob.getCoordinate().getX() > bounds.getX() || 
			mob.getCoordinate().getY() > bounds.getY() || 
			mob.getCoordinate().getZ() > bounds.getZ()) {
			mobsManager.removeMob(mob);
		}
	}
	
	/**
	 * Imposta il player per l'esplosione.
	 * @param explosionPlayer
	 */
	public void setExplosionPlayer(AudioPlayer explosionPlayer) {
		this.explosionPlayer = explosionPlayer;
	}

	/**
	 * Ritorna true se � stata rilevata una collisione.
	 * @return
	 */
	public boolean isCollided() {
		return collided;
	}

	/**
	 * Imposta il flag che indica il rilevamento di una collisione e informa gli osservatori.
	 * @param collided
	 */
	public void setCollided(boolean collided) {
		this.collided = collided;
		scoreCalculator.convalidateScore();
		setChanged();
		notifyObservers();
	}

	/**
	 * Imposta il flag che indica se il thread � da terminare.
	 */
	public void setToKill(boolean toKill) {
		this.mFinished = toKill;
	}

	/**
	 * Ritorna il tempo di sleep del thread, in millisecondi.
	 * @return tempo di sleep del thread, in ms
	 */
	public long getSleepTime() {
		return sleepTime;
	}

	/**
	 * Imposta il tempo di sleep del thread.
	 * @param sleepTime
	 */
	public void setSleepTime(long sleepTime) {
		this.sleepTime = sleepTime;
		scoreUpdateCounterLimit = (int)(1000 / sleepTime);
	}
	
	/**
	 * Ritorna il reference allo @ScoreCalculator correntemente utilizzato.
	 * @see ScoreCalculator
	 * @return reference al calcolatore del punteggio attualmente in uso
	 */
	public ScoreCalculator getScoreCalculator() {
		return scoreCalculator;
	}
	
}
