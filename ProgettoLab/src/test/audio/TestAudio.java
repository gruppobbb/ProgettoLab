package test.audio;

import javax.swing.JFrame;

import assets.AudioPlayer;

public class TestAudio {
	
	 public static void main(String[] args) {
		   
		   JFrame frame=new JFrame();
		   
		   AudioPlayer player = new AudioPlayer("res/bgm/singleplayer.wav");
		   player.playLoop();
		   
		  
		   frame.setSize(400, 400);
		   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		   frame.setTitle("Example");
		   frame.setVisible(true);

	      
	   }

}
