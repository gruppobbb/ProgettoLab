package test.g2d;

import java.awt.Dimension;

import javax.swing.JFrame;

import model.Coordinate;
import model.MobsManager;
import model.ships.Ship2D;
import view2d.GameCanvas;
import view2d.SquareShipDrawer;
import control.Controller2D;

//Test del controllo 2d della ship. 
public class TestController01 {
	
	public static void main(String[] args) {
		
		Ship2D ship = new Ship2D(new Coordinate(40, 50, 0), new Dimension(50, 50), new SquareShipDrawer());
		Controller2D control = new Controller2D(ship);
		MobsManager mobsManager = new MobsManager();
				
		JFrame frame = new JFrame();	
		GameCanvas gameCanvas = new GameCanvas(ship, mobsManager);
		frame.setSize(800, 600);
		frame.addKeyListener(control);
		frame.setFocusable(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setVisible(true);
		frame.getContentPane().add(gameCanvas);
		
	}

}
