package model.spawning;

import model.MobsManager;
import model.mobs.Mob;

/**
 * Componente che si occupa della gestione dello spawning dei mob.
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
	 * Crea uno spawner, che inserisce nel {@link MobsManager} il {@link Mob} creato,
	 * a cui viene assegnato {@link MovingLogic2D} per determianre come vuoversi,
	 * il tutto secondo l'algoritmo definito in {@link SpawnLogic}.
	 * @param manager
	 * @param mobMover
	 * @param spawnLogic
	 */
	public Spawner(MobsManager manager, SpawnLogic spawnLogic) {
		super();
		this.manager = manager;
		this.spawnLogic = spawnLogic;
		this.sleepTime = 200; //default
		
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
	
	public void onPause() {
        synchronized (mPauseLock) {
            mPaused = true;
        }
    }
	 
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

	public int getSleepTime() {
		return sleepTime;
	}

	public void setSleepTime(int sleepTime) {
		this.sleepTime = sleepTime;
	}
	
	
	
}
