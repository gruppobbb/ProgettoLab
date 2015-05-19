package assetsPc.audio;

import javax.sound.sampled.Clip;

import model.audio.IAudioPlayer;
import assetsPc.Assets;

/**
 * Classe che carica una traccia audio da path e la esegue senza loop.
 * @author Bianca
 */
public class UnloopedPlayer implements IAudioPlayer {

	private Clip clip;
	
	public UnloopedPlayer(int clipID) {
		this.clip = Assets.getLoader().getClip(clipID);
    }
	
	@Override
	public void play() {
		clip.setFramePosition(0);
		clip.start();
    }
	
	
	@Override
	public void stop() {
		clip.stop();
	}
}
