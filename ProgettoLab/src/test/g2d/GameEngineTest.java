package test.g2d;

import javax.swing.JFrame;

import model.Coordinate;
import model.GameEngine;
import model.MobsManager;
import model.movement.MobMovingLogic2D;
import model.ships.Ship2D;
import model.spawning.SimpleJans2DSpawner;
import model.spawning.Spawner;
import view2d.assets.Assets;
import view2d.drawers.SpriteDrawer;
import view2d.render.RGameCanvas;
import control.Controller2D;

public class GameEngineTest {
	
	public static void main(String[] args) {
		
		final int width = 1280;
		final int height = (width/16)*9;

		SpriteDrawer shipDrawer = new SpriteDrawer(Assets.SPRITE_SHIP);
		int shipHalfWidth = shipDrawer.getSpriteDimension().width/2;
		int shipHalfHeight = shipDrawer.getSpriteDimension().height/2;
		int y = height - shipHalfHeight;
		Coordinate coo = new Coordinate( width/2, y, 0);
		
		Ship2D ship = new Ship2D(coo, shipDrawer);
		Controller2D control = new Controller2D(ship, width-shipHalfWidth, shipHalfWidth);
		
		MobsManager mobsManager = new MobsManager();
		final MobMovingLogic2D mobMover = new MobMovingLogic2D();
		
		(new Thread( new Spawner(mobsManager, mobMover, new SpriteDrawer(Assets.SPRITE_MOB), new SimpleJans2DSpawner(width)))).start();
		
		Coordinate bounds = new Coordinate(height+200, width, 0);
		
		(new Thread(new GameEngine(mobsManager,ship, bounds))).start();
		
		
		
		JFrame frame = new JFrame();	
		RGameCanvas gameCanvas = new RGameCanvas(width,height,ship, mobsManager);
		
		frame.addKeyListener(control);
		frame.setFocusable(true);		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setVisible(true);
		frame.getContentPane().add(gameCanvas);
		frame.pack();
		gameCanvas.start();
		
	}

}
