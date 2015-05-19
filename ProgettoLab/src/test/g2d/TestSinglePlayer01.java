package test.g2d;

import javax.swing.JFrame;

import model2D.SinglePlayer2D;

public class TestSinglePlayer01 {
	
	public static void main(String[] args) {
		//QUI DOVREMO METTERE IL MENU
		//frame.getContentPane().add();    //MENU
		SinglePlayer2D sp = new SinglePlayer2D(new JFrame());
		sp.start();	//INIZIA IL GIOCO!
	}
}
