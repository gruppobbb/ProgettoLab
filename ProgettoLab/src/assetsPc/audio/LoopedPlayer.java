package assetsPc.audio;

import javax.sound.sampled.Clip;

import assetsPc.Assets;

/**
 * Classe che carica una traccia audio da path e la esegue in loop.
 * @author Bianca
 */
public class LoopedPlayer implements IAudioPlayer{
	
	private Clip clip;
	
	public LoopedPlayer(int clipID) {
		this.clip = Assets.getLoader().getClip(clipID);
	}

	@Override
	public void play(){
		clip.setFramePosition(0);
		clip.loop(Clip.LOOP_CONTINUOUSLY);
	}
	
	@Override
	public void stop() {
		clip.stop();
	}

}
