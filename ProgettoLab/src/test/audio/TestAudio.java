package test.audio;

import javax.swing.JFrame;

import assetsPc.Assets;
import assetsPc.audio.LoopedPlayer;

public class TestAudio {
	
	 public static void main(String[] args) {
		   
		   JFrame frame=new JFrame();
		   
		   LoopedPlayer player = new LoopedPlayer(Assets.AUDIO_BGM);
		   player.play();
		   
		  
		   frame.setSize(200, 200);
		   frame.setLocationRelativeTo(null);
		   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		   frame.setTitle("Example");
		   frame.setVisible(true);
	   }
}
