package test.g2d;

import javax.swing.JFrame;

import model.Coordinate;
import model.MobsManager;
import model.mobs.Mob2D;
import model.movement.MobMovingLogic2D;
import model.movement.MovingLogic2D;
import model.ships.Ship2D;
import view2d.drawers.CircleDrawer;
import view2d.drawers.SquareDrawer;
import view2d.render.RGameCanvas;
import control.Controller2D;

//Test del controllo 2d della ship. 
public class TestMobsManager01 {
	
	public static void main(String[] args) {
		
		Ship2D ship = new Ship2D(new Coordinate(400, 500, 0));
		Controller2D control = new Controller2D(ship, 775, 25);
		MobsManager mobsManager = new MobsManager();
		MovingLogic2D mobsMover = new MobMovingLogic2D();
		
		//istanziamo un po' di mob
		mobsManager.addMob(new Mob2D(new Coordinate(520, 120, 0),	10, mobsMover));
		mobsManager.addMob(new Mob2D(new Coordinate(200, 370, 0),	10, mobsMover));
		mobsManager.addMob(new Mob2D(new Coordinate(100, 500, 0),	10, mobsMover));
		
				
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
