package test.g2d;

import javax.swing.JFrame;

import model.Coordinate;
import model.GameEngine;
import model.MobsManager;
import model.mobs.Mob2D;
import model.movement.MobMovingLogic2D;
import model.movement.MovingLogic2D;
import model.ships.Ship2D;
import view2d.Drawer2D;
import view2d.drawers.CircleMobDrawer;
import view2d.drawers.SquareShipDrawer;
import view2d.render.RGameCanvas;
import control.Controller2D;

//Test del controllo 2d della ship. 
public class TestRender01 {
	
	public static void main(String[] args) {
		
		final int width = 1280;
		final int height = (width/16)*9;
		
		Ship2D ship = new Ship2D(new Coordinate(40, 300, 0), new SquareShipDrawer());
		Controller2D control = new Controller2D(ship, 735, 0);
		MobsManager mobsManager = new MobsManager();
		
		Drawer2D mobsDrawer = new CircleMobDrawer();
		MovingLogic2D mobsMover = new MobMovingLogic2D();
		
		//istanziamo un po' di mob
		mobsManager.addMob(new Mob2D(new Coordinate(300, 20, 0),	10, mobsDrawer, mobsMover));
		mobsManager.addMob(new Mob2D(new Coordinate(200, 20, 0),	10,	mobsDrawer, mobsMover));
		mobsManager.addMob(new Mob2D(new Coordinate(100, 20, 0),	10,	mobsDrawer, mobsMover));
		mobsManager.addMob(new Mob2D(new Coordinate(400, 20, 0),	10,	mobsDrawer, mobsMover));
		mobsManager.addMob(new Mob2D(new Coordinate(500, 20, 0),	10,	mobsDrawer, mobsMover));

		Coordinate bounds = new Coordinate(height+200, width, 0);
		(new Thread(new GameEngine(mobsManager,ship, bounds))).start();
				
		JFrame frame = new JFrame();	
		
		frame.setSize(800, 600);
		frame.addKeyListener(control);
		frame.setFocusable(true);		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setVisible(true);
		RGameCanvas gameCanvas = new RGameCanvas(800,600, ship, mobsManager);
		frame.getContentPane().add(gameCanvas);
		gameCanvas.start();
		
	}

}
