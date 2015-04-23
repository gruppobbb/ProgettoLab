package audio;

import javax.sound.sampled.Clip;

/**
 * Classe che carica una traccia audio da stringa e la esegue;
 * @author Bianca
 *
 */
public class AudioPlayer {
	
private Clip clip;
	
	public AudioPlayer(String filename) {
		AudioLoader loader = new AudioLoader(filename);
		clip = loader.getClip();
	   }
		
	public void play() {
	     
	         clip.setFramePosition(0); // rewind to the beginning
	         clip.start();     // Start playing
	      
	   }
	
	public void playLoop(){
		clip.setFramePosition(0);
		clip.loop(Clip.LOOP_CONTINUOUSLY);
	}
	
}