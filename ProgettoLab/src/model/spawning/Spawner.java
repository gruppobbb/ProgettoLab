package model.spawning;

import model.MobsManager;
import model.mobs.Mob;

/**
 * Componente che si occupa della gestione dello spawning dei {@link Mob}.
 * @author Max
 */
public class Spawner implements Runnable {
	
	public int sleepTime;
	private MobsManager manager;
	private SpawnLogic spawnLogic;
	private Object mPauseLock;
    private boolean mPaused;
    private boolean mFinished;
	
	/**
	 * @param manager {@link MobsManager} in cui porre i mob istanziati
	 * @param spawnLogic logica di spawning da adottare
	 */
	public Spawner(MobsManager manager, SpawnLogic spawnLogic) {
		super();
		this.manager = manager;
		this.spawnLogic = spawnLogic;
		this.sleepTime = 200; //default
		
		initialize();
	}
	
	/**
	 * @param manager {@link MobsManager} in cui porre i mob istanziati
	 * @param spawnLogic logica di spawning da adottare
	 * @param sleepTime tempo di sleep del thread
	 */
	public Spawner(MobsManager manager, SpawnLogic spawnLogic, int sleepTime) {
		super();
		this.manager = manager;
		this.spawnLogic = spawnLogic;
		this.sleepTime = sleepTime;
		
		initialize();
	}	

	private void initialize() {
		//proprietà iniziali del runnable
		mPauseLock = new Object();
        mPaused = false;
        mFinished = false;
	}
	
	private void spawn() {
		Mob[] mobs = spawnLogic.spawnMob();
		for (int i = 0; i < mobs.length; i++) {
			manager.addMob(mobs[i]);
		}		
	}
	
	/**
	 * Algoritmo principale dell'engine. 
	 * Non dovrebbe mai essere invocato direttamente, ma solo attraverso un {@link Thread}.
	 */
	@Override
	public void run() {
		while(mFinished == false) {
			spawn();
			try {
				Thread.sleep(sleepTime);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
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
	 * Manda in pausa lo spawner.
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
	
	/**
	 * Imposta il flag che indica se il thread è da terminare.
	 */
	public void setToKill(boolean toKill) {
		this.mFinished = toKill;
	}

	/**
	 * Ritorna il tempo di sleep del thread, in millisecondi.
	 * @return tempo di sleep del thread, in ms
	 */
	public int getSleepTime() {
		return sleepTime;
	}

	/**
	 * Imposta il tempo di sleep del thread.
	 * @param sleepTime
	 */
	public void setSleepTime(int sleepTime) {
		this.sleepTime = sleepTime;
	}
	
	
	
}
