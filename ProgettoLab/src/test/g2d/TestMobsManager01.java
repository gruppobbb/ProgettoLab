package test.g2d;

import javax.swing.JFrame;

import model.Coordinate;
import model.MobsManager;
import model.mobs.Mob2D;
import model.movement.MobMovingLogic2D;
import model.movement.MovingLogic2D;
import model.ships.Ship2D;
import view2d.drawers.CircleMobDrawer;
import view2d.drawers.SquareShipDrawer;
import view2d.render.RGameCanvas;
import control.Controller2D;

//Test del controllo 2d della ship. 
public class TestMobsManager01 {
	
	public static void main(String[] args) {
		
		Ship2D ship = new Ship2D(new Coordinate(40, 50, 0));
		Controller2D control = new Controller2D(ship, 735, 0);
		MobsManager mobsManager = new MobsManager();
		MovingLogic2D mobsMover = new MobMovingLogic2D();
		
		//istanziamo un po' di mob
		mobsManager.addMob(new Mob2D(new Coordinate(520, 120, 0),	10, mobsMover));
		mobsManager.addMob(new Mob2D(new Coordinate(200, 370, 0),	10, mobsMover));
		mobsManager.addMob(new Mob2D(new Coordinate(100, 500, 0),	10, mobsMover));
		
				
		JFrame frame = new JFrame();
		frame.addKeyListener(control);
		RGameCanvas gameCanvas = new RGameCanvas(800,600,ship, mobsManager);
		
		frame.getContentPane().add(gameCanvas);
		frame.setResizable(false);
		frame.setVisible(true);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		gameCanvas.setShipDrawer(new SquareShipDrawer());
		gameCanvas.setMobDrawer( new CircleMobDrawer());
		
		gameCanvas.start();
	}

}
