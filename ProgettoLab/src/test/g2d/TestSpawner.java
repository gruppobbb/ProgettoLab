package test.g2d;

import javax.swing.JFrame;

import model.Coordinate;
import model.MobsManager;
import model.movement.MobMover2D;
import model.movement.Mover;
import model.ships.Ship2D;
import model.spawning.Spawner;
import view2d.GameCanvas;
import view2d.drawers.CircleMobDrawer;
import view2d.drawers.SquareShipDrawer;
import control.Controller2D;

public class TestSpawner {
	
	public static void main(String[] args) {
		

		Ship2D ship = new Ship2D(new Coordinate(40, 500, 0), new SquareShipDrawer());
		Controller2D control = new Controller2D(ship, 735, 0);
		MobsManager mobsManager = new MobsManager();
		
		(new Thread(new Spawner(mobsManager, new MobMover2D() , new CircleMobDrawer()))).start();;		
		(new Thread(new Mover(mobsManager))).start();
		
		
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
