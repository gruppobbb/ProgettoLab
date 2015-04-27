package assetsPc.audio;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 * Componente che carica una clip audio .wav
 * @author Bianca
 */
public class AudioLoader {
	
private Clip clip;

	public Clip loadClip(String soundPath) {
		try {
	         File file = new File(soundPath);
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
		return clip;
	}
}
