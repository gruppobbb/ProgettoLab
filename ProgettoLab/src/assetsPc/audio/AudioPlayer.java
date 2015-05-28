package assetsPc.audio;

import javax.sound.sampled.Clip;

import assetsPc.Assets;

/**
 * Classe che carica una traccia audio da path e la esegue in loop.
 * @author Bianca
 */
public class AudioPlayer {
	
	private Clip clip;
	private boolean loop;
	
	/**
	 * @param clipID identificatore della risorsa audio da associare al player
	 * @param loop specifica se la traccia debba essere eseguita il loop
	 */
	public AudioPlayer(int clipID, boolean loop) {
		this.clip = Assets.getLoader().getClip(clipID);
		this.loop = loop;
	}

	/**
	 * Esegue la traccia audio.
	 */
	public void play(){
		clip.setFramePosition(0);
		if(loop) {
			clip.loop(Clip.LOOP_CONTINUOUSLY);
		} else {
			clip.start();
		}
		
	}
	
	/**
	 * Ferma la riproduzione della traccia audio.
	 */
	public void stop() {
		clip.stop();
	}

}
