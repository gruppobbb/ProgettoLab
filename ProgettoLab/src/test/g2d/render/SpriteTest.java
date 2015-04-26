package test.g2d.render;

import java.util.Observable;
import java.util.Observer;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;

import model.Coordinate;
import model.MobsManager;
import model.ships.Ship2D;
import view2d.RGameCanvas;
import view2d.RGameCanvas.RenderInfo;
import view2d.assets.Assets;
import view2d.drawers.SpriteDrawer;
import control.Controller2D;

public class SpriteTest {
	
	public static void main(String[] args) {
		
		final int width = 800;
		final int height = 200;

		Coordinate coo = new Coordinate( width/2, height/2, 0);
		
		Ship2D ship = new Ship2D(coo);
		final Controller2D control = new Controller2D(ship, width-100, 100);
		
		MobsManager mobsManager = new MobsManager();
		
		JFrame frame = new JFrame();
		
		final RGameCanvas gameCanvas = new RGameCanvas(width,height,ship, mobsManager);
		gameCanvas.addKeyListener(control);
		
		frame.getContentPane().add(gameCanvas);
		frame.setResizable(false);
		frame.setVisible(true);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		gameCanvas.getRenderinfo().addObserver(new Observer() {
			@Override
			public void update(Observable o, Object arg) {
				System.out.println( ((RenderInfo)o).toString());
			}
		});
		
		
		Timer timer = new Timer();
		timer.scheduleAtFixedRate(new TimerTask() {
			int index = 0;
			SpriteDrawer[] drawer = { 	new SpriteDrawer(Assets.SPRITE_DEFAULT),
										new SpriteDrawer(Assets.SPRITE_SHIP),
										new SpriteDrawer(Assets.SPRITE_MOB)
					};
			@Override
			public void run() {
				gameCanvas.setShipDrawer(drawer[index]);
				index = ++index%drawer.length;
			}
		}, 0, 100);
		
		gameCanvas.start();
	}

}
