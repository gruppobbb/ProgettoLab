package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import model.mobs.Mob;

/**
 * Manager per i mob istanziati. Contiene e gestisce le istanze dei mob, garantendo la possibilità di accessi concorrenti.
 * @author Max
 */
public class MobsManager {
	
	private List<Mob> mobs = Collections.synchronizedList(new LinkedList<Mob>());
	
	/**
	 * Aggiunge un nuovo mob alla lista. 
	 * @param newMob
	 */
	public void addMob(Mob newMob) {
		synchronized(mobs) {
			mobs.add(newMob);
		}
	}
	
	/**
	 * Restituisce una copia della lista dei mob.
	 * @return lista dei mob
	 */
	public ArrayList<Mob> getMobsList() {
		ArrayList<Mob> copiedList;
		synchronized(mobs) {
			copiedList = new ArrayList<Mob>(mobs);
		}
		return copiedList;
	}
	
	/**
	 * Elimina il {@link Mob} specificato.
	 * @param mobToRemove
	 */
	public void removeMob(Mob mobToRemove) {
		synchronized (mobs) {
			mobs.remove(mobToRemove);
		}
	}
	
	/**
	 * Elimina tutti i {@link Mob} presenti della lista.
	 */
	public void removeAllMobs(){
		synchronized (mobs) {
			mobs.clear();
		}
	}
	
}
