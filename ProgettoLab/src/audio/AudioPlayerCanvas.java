package audio;

import java.awt.Canvas;

/**
 * Canvas che esegue una traccia audio in loop quando questo è aperto.
 * @author Bianca
 *
 */

public class AudioPlayerCanvas extends Canvas{

	private static final long serialVersionUID = 1L;
	private AudioPlayer audioPlayer;

	public AudioPlayerCanvas(AudioPlayer audio) {
		
		this.audioPlayer = audio;
	   audioPlayer.play();      

	   }
	   
	  

}
