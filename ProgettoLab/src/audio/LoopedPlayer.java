package audio;

import javax.sound.sampled.Clip;

public class LoopedPlayer implements IAudioPlayer{
	
	private Clip clip;
	
	public LoopedPlayer(Clip clip) {
		super();
		this.clip = clip;
	}

	@Override
	public void play(){
		clip.setFramePosition(0);
		clip.loop(Clip.LOOP_CONTINUOUSLY);
	}

}
