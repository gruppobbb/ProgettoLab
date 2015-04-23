package audio;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 * Classe che carica una traccia audio da stringa e la esegue;
 * @author Bianca
 *
 */
public class AudioPlayer {
	
	private Clip clip;
	
	public AudioPlayer(String filename) {
		try {
	         File file = new File(filename);
	         AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(file);
	         
	         clip = AudioSystem.getClip();
	         clip.open(audioInputStream);
	      } catch (UnsupportedAudioFileException e) {
	         e.printStackTrace();
	      } catch (IOException e) {
	         e.printStackTrace();
	      } catch (LineUnavailableException e) {
	         e.printStackTrace();
	      }
	   }
		
	public void play() {
	     
	         clip.setFramePosition(0); // rewind to the beginning
	         clip.loop(Clip.LOOP_CONTINUOUSLY);     // Start playing
	      
	   }
	
}