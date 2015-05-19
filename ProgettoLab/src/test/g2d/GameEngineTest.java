package test.g2d;

import javax.swing.JFrame;

import assetsPc.Assets;
import model.Coordinate;
import model.GameEngine;
import model.MobsManager;
import model.spawning.Spawner;
import model2D.MobMovingLogic2D;
import model2D.Ship2D;
import model2D.SimpleLanes2DSpawnerJ;
import view2d.RGameCanvas;
import view2d.drawers.SpriteDrawer;
import control.Controller2D;

public class GameEngineTest {
	
	public static void main(String[] args) {
		
		final int width = 1280;
		final int height = (width/16)*9;

		SpriteDrawer shipDrawer = new SpriteDrawer(Assets.SPRITE_SHIP);
		SpriteDrawer mobDrawer = new SpriteDrawer(Assets.SPRITE_MOB);
		
		int shipHalfWidth = shipDrawer.getSpriteDimension().width/2;
		int shipHalfHeight = shipDrawer.getSpriteDimension().height/2;
		int y = height - shipHalfHeight;
		Coordinate coo = new Coordinate( width/2, y, 0);
		
		Ship2D ship = new Ship2D(coo);
		Controller2D control = new Controller2D(ship, width-shipHalfWidth, shipHalfWidth);
		
		MobsManager mobsManager = new MobsManager();
		MobMovingLogic2D mobMover = new MobMovingLogic2D();
		
		(new Thread( new Spawner(mobsManager, mobMover, new SimpleLanes2DSpawnerJ(width)))).start();
		
		Coordinate bounds = new Coordinate(width,height+200, 0);
		
		(new Thread(new GameEngine(mobsManager,ship, bounds))).start();
		
		
		
		JFrame frame = new JFrame();
		RGameCanvas gameCanvas = new RGameCanvas(width,height,ship, mobsManager);
		gameCanvas.addKeyListener(control);
		frame.getContentPane().add(gameCanvas);
		frame.setResizable(false);
		frame.setVisible(true);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		gameCanvas.setShipDrawer(shipDrawer);
		gameCanvas.setMobDrawer( mobDrawer);
		
		gameCanvas.start();
		
	}

}
