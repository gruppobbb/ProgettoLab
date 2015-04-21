package test.g2d.render;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;

import model.Coordinate;
import model.GameEngine;
import model.MobsManager;
import model.movement.MobMovingLogic2D;
import model.ships.Ship2D;
import model.spawning.SimpleJans2DSpawner;
import model.spawning.Spawner;
import view2d.assets.Assets;
import view2d.drawers.CircleDrawer;
import view2d.drawers.SpriteDrawer;
import view2d.drawers.SquareDrawer;
import view2d.render.RGameCanvas;
import view2d.render.RGameCanvas.RenderInfo;
import control.Controller2D;

public class SpriteTest {
	
	public static void main(String[] args) {
		
		int width = 600;
		int height = (width/16)*9;

		SpriteDrawer shipDrawer = new SpriteDrawer(Assets.SPRITE_SHIP);
		int shipHalfWidth = shipDrawer.getSpriteDimension().width/2;
		int shipHalfHeight = shipDrawer.getSpriteDimension().height/2;
		int y = height - shipHalfHeight;
		Coordinate coo = new Coordinate( width/2, y, 0);
		
		Ship2D ship = new Ship2D(coo);
		Controller2D control = new Controller2D(ship, width-shipHalfWidth, shipHalfWidth);
		
		MobsManager mobsManager = new MobsManager();
		MobMovingLogic2D mobMover = new MobMovingLogic2D();
		
		(new Thread( new Spawner(mobsManager, mobMover, new SimpleJans2DSpawner(width)))).start();
		
		Coordinate bounds = new Coordinate(height+200, width, 0);
		
		(new Thread(new GameEngine(mobsManager,ship, bounds))).start();
		
		JFrame frame = new JFrame();
		frame.addKeyListener(control);
		RGameCanvas gameCanvas = new RGameCanvas(width,height,ship, mobsManager);
		
		frame.getContentPane().add(gameCanvas);
		frame.setResizable(false);
		frame.setVisible(true);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		gameCanvas.setShipDrawer( new SquareDrawer());
		gameCanvas.setMobDrawer( new CircleDrawer());
		
		gameCanvas.getRenderinfo().addObserver(new Observer() {
			@Override
			public void update(Observable o, Object arg) {
				System.out.println( ((RenderInfo)o).toString());
			}
		});
		gameCanvas.start();
	}

}
