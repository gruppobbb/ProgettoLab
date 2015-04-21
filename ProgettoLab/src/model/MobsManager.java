package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import model.mobs.Mob;

/**
 * Manager per tutti i mob istanziati. Contiene e gestisce le istanze dei mob.
 * @author Max
 *
 */

//Questa classe dovrebbe gestire tutte le concorrenze per l'accesso alla lista dei mob.
public class MobsManager {
	
	private List<Mob> mobs = Collections.synchronizedList(new LinkedList<Mob>());
	
	/**
	 * Aggiunge un nuovo mob alla lista. 
	 * NOTA: deve rimanere sincronizzato.
	 * @param newMob
	 */
	public void addMob(Mob newMob) {
		synchronized(mobs) {
			mobs.add(newMob);
		}
	}
	
	/**
	 * Restituisce una copia della lista dei mob.
	 * NOTA: deve rimanere sincronizzato.
	 * @return
	 */
	public ArrayList<Mob> getMobsList() {
		ArrayList<Mob> copiedList;
		synchronized(mobs) {
			copiedList = new ArrayList<Mob>(mobs);
		}
		return copiedList;
	}
	
	/**
	 * Elimina il mob specificato tramite reference dalla lista.
	 * @param mobToRemove
	 */
	public void removeMob(Mob mobToRemove) {
		synchronized (mobs) {
			mobs.remove(mobToRemove);
		}
	}
	
	public void removeAllMobs(){
		synchronized (mobs) {
			mobs.clear();
		}
	}
	
}
