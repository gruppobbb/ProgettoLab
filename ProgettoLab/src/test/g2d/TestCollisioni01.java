package test.g2d;

import javax.swing.JFrame;

import model.Coordinate;
import model.GameEngine;
import model.MobsManager;
import model.spawning.Spawner;
import model2D.MobMovingLogic2D;
import model2D.Ship2D;
import model2D.SimpleRandom2DSpawnLogic;
import view2d.RGameCanvas;
import view2d.drawers.CircleDrawer;
import view2d.drawers.SquareDrawer;
import control.Controller2D;

public class TestCollisioni01 {
	
	public static void main(String[] args) {
		

		Ship2D ship = new Ship2D(new Coordinate(400, 500, 0));
		Controller2D control = new Controller2D(ship,775, 25);
		MobsManager mobsManager = new MobsManager();
		
		Coordinate bounds = new Coordinate(800, 600, 0);	//setto x altissimo, tanto non uscira' mai
		
		(new Thread(new GameEngine(mobsManager,ship, bounds))).start();
		(new Thread(new Spawner(mobsManager, new MobMovingLogic2D(), new SimpleRandom2DSpawnLogic()))).start();
		
		
		JFrame frame = new JFrame();
		
		RGameCanvas gameCanvas = new RGameCanvas(800,600,ship, mobsManager);
		gameCanvas.addKeyListener(control);
		
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
