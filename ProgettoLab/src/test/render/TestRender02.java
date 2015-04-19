package test.render;

import javax.swing.JFrame;

import model.Coordinate;
import model.MobsManager;
import model.Spawner;
import model.collisions.CollisionChecker;
import model.movement.MobMover2D;
import model.movement.Mover;
import model.ships.Ship2D;
import view2d.SquareShipDrawer;
import view2d.render.RGameCanvas;
import control.Controller2D;

public class TestRender02 {
	
	public static void main(String[] args) {
		

		Ship2D ship = new Ship2D(new Coordinate(40, 500, 0), new SquareShipDrawer());
		Controller2D control = new Controller2D(ship, 735, 0);
		MobsManager mobsManager = new MobsManager();
		Spawner spawner = new Spawner(mobsManager, new MobMover2D());
		spawner.newMob();
		
		Coordinate bounds = new Coordinate(1000, 500, 0);	//setto x altissimo, tanto non uscir� mai
		
		(new Thread(new Mover(mobsManager))).start();
		(new Thread(new CollisionChecker(mobsManager, ship, bounds))).start();
		
		
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