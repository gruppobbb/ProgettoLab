package test.g2d;

import javax.swing.JFrame;

import model.Coordinate;
import model.GameEngine;
import model.MobsManager;
import model.ships.Ship2D;
import view2d.GameCanvas;
import view2d.drawers.SquareShipDrawer;
import control.Controller2D;

public class TestSpawner {
	
	public static void main(String[] args) {
		
		final int width = 1280;
		final int height = (width/16)*9;

		Ship2D ship = new Ship2D(new Coordinate(40, 500, 0), new SquareShipDrawer());
		Controller2D control = new Controller2D(ship, 735, 0);
		MobsManager mobsManager = new MobsManager();
		
		Coordinate bounds = new Coordinate(height+200, width, 0);
		
		(new Thread(new GameEngine(mobsManager,ship, bounds))).start();
		
		
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
