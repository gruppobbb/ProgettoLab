package test.g2d.render;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;

import model.Coordinate;
import model.MobsManager;
import model2D.mobs.Mob2D;
import model2D.ship.Ship2D;
import view2d.RGameCanvas;
import view2d.RGameCanvas.RenderInfo;
import view2d.drawers.CircleDrawer;
import control.Controller2D;

//Test del controllo 2d della ship. 
public class TestRender00 {
	
	public static void main(String[] args) {
		
		int width = 500;
		int height = 500;
		
		final Ship2D ship = new Ship2D(new Coordinate(250, 250, 0));
		Controller2D controller = new Controller2D(ship, 400, 100);
		final MobsManager mobsManager = new MobsManager();
		
		JFrame frame = new JFrame();
		RGameCanvas gameCanvas = new RGameCanvas(width,height,ship, mobsManager);
		gameCanvas.addKeyListener(controller);
		
		int gap = 50 ;
		
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				mobsManager.addMob(new Mob2D(new Coordinate(25+j*gap,25+ i*gap, 0),	10));
			}
		}
				
		
		
		
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
		
		gameCanvas.setMobDrawer( new CircleDrawer());
		
		gameCanvas.start();
	}

}
