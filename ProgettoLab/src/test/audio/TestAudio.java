package test.audio;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

import assetsPc.Assets;
import assetsPc.audio.AudioPlayer;

public class TestAudio {
	
	 public static void main(String[] args) {
		   
		   JFrame frame=new JFrame();
		   
		   final AudioPlayer player = new AudioPlayer(Assets.AUDIO_BGM, true);
		   
		   frame.setFocusable(true);
		   frame.addKeyListener(new KeyListener() {
			
			
			boolean plaing;
			@Override
			public void keyReleased(KeyEvent e) {
				if(plaing){
					player.stop();
					plaing = false;
				}else{
					player.play();
					plaing = true;
				}
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
			}
			
			@Override
			public void keyTyped(KeyEvent e) {
			}
		});
		   
		  
		   frame.setSize(200, 200);
		   frame.setLocationRelativeTo(null);
		   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		   frame.setTitle("Example");
		   frame.setVisible(true);
	   }
}
