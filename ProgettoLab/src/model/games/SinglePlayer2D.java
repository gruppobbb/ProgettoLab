package model.games;

import java.awt.Canvas;
import java.util.ArrayList;

import model.Coordinate;
import model.Game;
import model.GameEngine;
import model.MobsManager;
import model.movement.MobMovingLogic2D;
import model.ships.Ship2D;
import model.spawning.SimpleRandom2DSpawnLogic;
import model.spawning.Spawner;
import view2d.Drawer2D;
import view2d.assets.Assets;
import view2d.drawers.SpriteDrawer;
import view2d.render.RGameCanvas;
import control.Controller2D;

public class SinglePlayer2D implements Game {

	private ArrayList<Thread> threads = new ArrayList<Thread>();	//contiene i thread che dovranno essere lanciati, messi in pausa e fermati
	private MobsManager mobsManager;
	private Coordinate viewBounds;
	private Drawer2D shipDrawer;
	private Drawer2D mobDrawer;
	private Controller2D controller;
	private RGameCanvas gameCanvas;
	
	private static final int WIDTH = 1280;
	private static final int HEIGHT = (WIDTH/16)*9;
	
	
	
	public SinglePlayer2D() {

		//istanzio gli elementi del gioco
		shipDrawer = new SpriteDrawer(Assets.SPRITE_SHIP);
		mobDrawer = new SpriteDrawer(Assets.SPRITE_MOB);
		int shipHalfWidth = shipDrawer.getSpriteDimension().width/2;
		int y = HEIGHT - shipDrawer.getSpriteDimension().height;
		Ship2D ship = new Ship2D(new Coordinate( WIDTH/2, y, 0));
		viewBounds = new Coordinate(HEIGHT+200, WIDTH, 0);
		
		mobsManager = new MobsManager();	//Istanzio un nuovo mobs manager
		
		//istanzio il canvas di gioco
		gameCanvas = new RGameCanvas(WIDTH, HEIGHT, ship, mobsManager);
		gameCanvas.setShipDrawer(shipDrawer);
		gameCanvas.setMobDrawer(mobDrawer);
		
		//istanzio il controllo
		controller = new Controller2D(ship, WIDTH-shipHalfWidth, shipHalfWidth);
		gameCanvas.addKeyListener(controller);
						
		threads.add(new Thread(new GameEngine(mobsManager,ship, viewBounds)));
		threads.add(new Thread(new Spawner(mobsManager, new MobMovingLogic2D(), new SimpleRandom2DSpawnLogic())));	//Lo spawner
				
	}	
	
	@Override
	public void start() {
		for (Thread thread : threads) {
			thread.start();
		}
		gameCanvas.start();
	}
	
	@Override
	public void pause() {
		//TODO implementazione della pausa
		
	}
	
	@Override
	public void gameOver() {
		// TODO implementazione gameover
		
	}
	
	public Canvas getGameCanvas() {
		return gameCanvas;
	}
}
