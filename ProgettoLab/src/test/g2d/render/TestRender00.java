package test.g2d.render;

import java.util.Observable;
import java.util.Observer;

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
import view2d.render.RGameCanvas.RenderInfo;
import control.Controller2D;

//Test del controllo 2d della ship. 
public class TestRender00 {
	
	public static void main(String[] args) {
		
		Ship2D ship = new Ship2D(new Coordinate(40, 50, 0));
		Controller2D control = new Controller2D(ship, 735, 0);
		MobsManager mobsManager = new MobsManager();
		MovingLogic2D mobsMover = new MobMovingLogic2D();
		
		int gap = 50 ;
		
		//istanziamo un po' di mob
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				mobsManager.addMob(new Mob2D(new Coordinate(j*gap, i*gap, 0),	10, mobsMover));
			}
			
		}
		
				
		JFrame frame = new JFrame();
		frame.addKeyListener(control);
		RGameCanvas gameCanvas = new RGameCanvas(500,500,ship, mobsManager);
		
		gameCanvas.getRenderinfo().addObserver(new Observer() {
			
			@Override
			public void update(Observable o, Object arg) {
				System.out.println((RenderInfo)o);
			}
		});
		
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
