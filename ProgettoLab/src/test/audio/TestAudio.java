package test.audio;

import javax.swing.JFrame;

import audio.AudioPlayer;
import audio.AudioPlayerCanvas;

public class TestAudio {
	
	 public static void main(String[] args) {
		   
		   JFrame frame=new JFrame();
		   
		   AudioPlayer player = new AudioPlayer("res/bgm/win.wav");
		   AudioPlayerCanvas canvas = new AudioPlayerCanvas(player);
		   
		   frame.getContentPane().add(canvas);
		   frame.setSize(400, 400);
		   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		   frame.setTitle("Example");
		   frame.setVisible(true);

	      
	   }

}
