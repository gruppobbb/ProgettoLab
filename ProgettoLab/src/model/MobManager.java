package model;

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
public class MobManager {
	
	private List<Mob> mobs = Collections.synchronizedList(new LinkedList<Mob>());
	

}
