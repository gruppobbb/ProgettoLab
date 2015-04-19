package view2d.render;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import model.mobs.Mob;

/**
 * Manager per tutti i mob istanziati. Contiene e gestisce le istanze dei mob.
 * @author Max
 * @author Jan
 *
 */
public class BMobsManager{

    private List<Mob> mobs = Collections.synchronizedList(new ArrayList<Mob>());

    
    /**
	 * Aggiunge un nuovo mob alla lista. 
	 * NOTA: deve rimanere sincronizzato.
	 * @param newMob
	 */
    public void addMob(Mob newMob) {
        synchronized (mobs){
            mobs.add(newMob);
        }
    }

    /**
     * Aggiunge piu' mob alla lista in una sola volta.
     * @param entities
     */
    public void addMobs(Mob[] entities){
        synchronized (this.mobs){
            Collections.addAll(this.mobs, entities);
        }
    }

    /**
	 * Restituisce una copia della lista di mobs.
	 * NOTA: deve rimanere sincronizzato.
	 * @return
	 */
    public Mob[] getMobs() {
        synchronized (mobs){
        	Mob[] copy;
            copy = mobs.toArray(new Mob[mobs.size()]);
            return copy;
        }
    }

    /**
     * Elimina tutti i mobs.
     */
    public void clear(){
        synchronized (mobs){
            mobs.clear();
        }
    }

    /**
     * Restituisce il numero di mobs attivi.
     * @return
     */
    public int getCount(){
        synchronized (mobs){
            return mobs.size();
        }
    }
    
    /**
	 * Elimina il mob specificato tramite reference dalla lista.
	 * @param mobToRemove
	 */
    public void remove(Mob mobToRemove){
    	synchronized (mobs) {
			mobs.remove(mobToRemove);
		}
    }
}
