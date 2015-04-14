package test;

import javax.swing.JFrame;

import model.Coordinate;
import model.ships.Ship2D;
import view2d.GameCanvas;
import view2d.SquareShipDrawer;
import control.Controller2D;

//Test del controllo 2d della ship. 
public class TestController {
	
	public static void main(String[] args) {
		
		Ship2D ship = new Ship2D(new Coordinate(40, 50, 0), new SquareShipDrawer());
		Controller2D control = new Controller2D(ship);
		
		JFrame frame = new JFrame();	
		GameCanvas gameCanvas = new GameCanvas(ship);
		frame.setSize(800, 600);
		frame.addKeyListener(control);
		frame.setFocusable(true);		
		
		frame.setVisible(true);
		frame.getContentPane().add(gameCanvas);
		
	}

}
