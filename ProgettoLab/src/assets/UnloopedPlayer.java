package assets;

import javax.sound.sampled.Clip;

public class UnloopedPlayer implements IAudioPlayer {

	private Clip clip;
	
	public UnloopedPlayer(Clip clip) {
		this.clip = clip;
    }
	
	@Override
	public void play() {
		clip.setFramePosition(0);
		clip.start();
    }
}
