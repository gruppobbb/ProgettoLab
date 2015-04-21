package test.g2d;

import javax.swing.JFrame;

import model.Coordinate;
import model.GameEngine;
import model.MobsManager;
import model.movement.MobMovingLogic2D;
import model.ships.Ship2D;
import model.spawning.SimpleRandom2DSpawnLogic;
import model.spawning.Spawner;
import view2d.drawers.CircleMobDrawer;
import view2d.drawers.SquareShipDrawer;
import view2d.render.RGameCanvas;
import control.Controller2D;

public class TestRender02 {
	
	public static void main(String[] args) {
		
		final int width = 1280;
		final int height = (width/16)*9;

		Ship2D ship = new Ship2D(new Coordinate(40, 500, 0), new SquareShipDrawer());
		Controller2D control = new Controller2D(ship, 735, 0);
		MobsManager mobsManager = new MobsManager();
			
		Coordinate bounds = new Coordinate(height+200, width, 0);
		
		(new Thread(new GameEngine(mobsManager,ship, bounds))).start();
		(new Thread(new Spawner(mobsManager, new MobMovingLogic2D(), new CircleMobDrawer(), new SimpleRandom2DSpawnLogic()))).start();
		
		
		JFrame frame = new JFrame();	
		RGameCanvas gameCanvas = new RGameCanvas(800,600,ship, mobsManager);
		frame.setSize(800, 600);
		frame.addKeyListener(control);
		frame.setFocusable(true);		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setVisible(true);
		frame.getContentPane().add(gameCanvas);
		gameCanvas.start();
		
	}

}
