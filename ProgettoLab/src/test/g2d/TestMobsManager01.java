package test.g2d;

import java.awt.Dimension;

import javax.swing.JFrame;

import model.Coordinate;
import model.MobsManager;
import model.mobs.Mob2D;
import model.ships.Ship2D;
import view2d.CircleMobDrawer;
import view2d.Drawer2D;
import view2d.GameCanvas;
import view2d.SquareShipDrawer;
import control.Controller2D;

//Test del controllo 2d della ship. 
public class TestMobsManager01 {
	
	public static void main(String[] args) {
		
		Ship2D ship = new Ship2D(new Coordinate(40, 50, 0), new Dimension(50, 50), new SquareShipDrawer());
		Controller2D control = new Controller2D(ship);
		MobsManager mobsManager = new MobsManager();
		
		Drawer2D mobsDrawer = new CircleMobDrawer();
		//istanziamo un po' di mob
		mobsManager.addMob(new Mob2D(new Coordinate(520, 120, 0),	10, new Dimension(30, 30), mobsDrawer));
		mobsManager.addMob(new Mob2D(new Coordinate(200, 370, 0),	10,	new Dimension(30, 30), mobsDrawer));
			
		
		
				
		JFrame frame = new JFrame();	
		GameCanvas gameCanvas = new GameCanvas(ship, mobsManager);
		frame.setSize(800, 600);
		frame.addKeyListener(control);
		frame.setFocusable(true);		
		
		frame.setVisible(true);
		frame.getContentPane().add(gameCanvas);
		
	}

}
