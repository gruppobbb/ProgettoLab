package test.g2d;

import javax.swing.JFrame;

import model.games.SinglePlayer2D;

public class TestSinglePlayer01 {
	
	public static void main(String[] args) {
		
		JFrame frame = new JFrame();	
		frame.setSize(1280, 1280*9/16);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//QUI DOVREMO METTERE IL MENU
		//frame.getContentPane().add();    //MENU
		
		//facciamo finta di aver premuto il pulsante di avvio della partita SP
		final SinglePlayer2D sp = new SinglePlayer2D();
					
		frame.getContentPane().add(sp.getGameCanvas());
		
		frame.setVisible(true);
		frame.setFocusable(true);			
		
		
		sp.start();	//INIZIA IL GIOCO!
	
		
				
	}

}
