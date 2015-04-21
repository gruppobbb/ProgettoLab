package test.g2d;

import javax.swing.JFrame;

import model.Coordinate;
import model.GameEngine;
import model.MobsManager;
import model.movement.MobMovingLogic2D;
import model.ships.Ship2D;
import model.spawning.SimpleRandom2DSpawnLogic;
import model.spawning.Spawner;
import view2d.drawers.CircleDrawer;
import view2d.drawers.SquareDrawer;
import view2d.render.RGameCanvas;
import control.Controller2D;

public class TestCollisioni01 {
	
	public static void main(String[] args) {
		

		Ship2D ship = new Ship2D(new Coordinate(40, 500, 0));
		Controller2D control = new Controller2D(ship, 735, 0);
		MobsManager mobsManager = new MobsManager();
		
		Coordinate bounds = new Coordinate(1000, 500, 0);	//setto x altissimo, tanto non uscira' mai
		
		(new Thread(new GameEngine(mobsManager,ship, bounds))).start();
		(new Thread(new Spawner(mobsManager, new MobMovingLogic2D(), new SimpleRandom2DSpawnLogic()))).start();
		
		
		JFrame frame = new JFrame();
		frame.addKeyListener(control);
		RGameCanvas gameCanvas = new RGameCanvas(800,600,ship, mobsManager);
		
		frame.getContentPane().add(gameCanvas);
		frame.setResizable(false);
		frame.setVisible(true);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		gameCanvas.setShipDrawer(new SquareDrawer());
		gameCanvas.setMobDrawer( new CircleDrawer());
		
		gameCanvas.start();
		
	}

}
