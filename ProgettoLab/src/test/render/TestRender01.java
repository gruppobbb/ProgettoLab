package test.render;

import javax.swing.JFrame;

import model.Coordinate;
import model.MobsManager;
import model.mobs.Mob2D;
import model.movement.MobMover2D;
import model.movement.Mover;
import model.movement.Mover2D;
import model.ships.Ship2D;
import view2d.CircleMobDrawer;
import view2d.Drawer2D;
import view2d.SquareShipDrawer;
import view2d.render.RGameCanvas;
import control.Controller2D;

//Test del controllo 2d della ship. 
public class TestRender01 {
	
	public static void main(String[] args) {
		
		Ship2D ship = new Ship2D(new Coordinate(40, 300, 0), new SquareShipDrawer());
		Controller2D control = new Controller2D(ship, 735, 0);
		MobsManager mobsManager = new MobsManager();
		
		Drawer2D mobsDrawer = new CircleMobDrawer();
		Mover2D mobsMover = new MobMover2D();
		
		//istanziamo un po' di mob
		mobsManager.addMob(new Mob2D(new Coordinate(300, 20, 0),	10, mobsDrawer, mobsMover));
		mobsManager.addMob(new Mob2D(new Coordinate(200, 20, 0),	10,	mobsDrawer, mobsMover));
		mobsManager.addMob(new Mob2D(new Coordinate(100, 20, 0),	10,	mobsDrawer, mobsMover));
		mobsManager.addMob(new Mob2D(new Coordinate(400, 20, 0),	10,	mobsDrawer, mobsMover));
		mobsManager.addMob(new Mob2D(new Coordinate(500, 20, 0),	10,	mobsDrawer, mobsMover));

		(new Thread(new Mover(mobsManager))).start();
				
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
