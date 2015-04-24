package model.games;

import java.awt.Canvas;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import audio.AudioPlayer;
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

public class SinglePlayer2D implements Game, Observer {

	private ArrayList<Thread> threads = new ArrayList<Thread>();	//contiene i thread che dovranno essere lanciati, messi in pausa e fermati
	private MobsManager mobsManager;
	private Coordinate viewBounds;
	private Drawer2D shipDrawer;
	private Drawer2D mobDrawer;
	private Controller2D controller;
	private RGameCanvas gameCanvas;
	private Ship2D ship;
	private int shipHalfWidth;
	
	private static final int WIDTH = 1280;
	private static final int HEIGHT = (WIDTH/16)*9;
	
	
	
	public SinglePlayer2D() {

		loadGameElements();	//carica gli elementi che servono per la partita
		
		createGameField();	//istanzia canvas + relativo controllo
		
		GameEngine engine = new GameEngine(mobsManager,ship, viewBounds);
		engine.addObserver(this);
		
		threads.add(new Thread(engine));
		threads.add(new Thread(new Spawner(mobsManager, new MobMovingLogic2D(), new SimpleRandom2DSpawnLogic())));	//Lo spawner

		playGameSound();

	}

	private void createGameField() {
		//istanzio il canvas di gioco
		gameCanvas = new RGameCanvas(WIDTH, HEIGHT, ship, mobsManager);
		gameCanvas.setShipDrawer(shipDrawer);
		gameCanvas.setMobDrawer(mobDrawer);
		
		//istanzio il controllo
		controller = new Controller2D(ship, WIDTH-shipHalfWidth, shipHalfWidth);
		gameCanvas.addKeyListener(controller);
	}

	private void playGameSound() {
		//istanzio BGM del gioco
		AudioPlayer player = new AudioPlayer("res/bgm/singleplayer.wav");
		player.playLoop();
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
		System.out.println("GAME OVER");
		
	}
	
	public Canvas getGameCanvas() {
		return gameCanvas;
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		gameOver();
		
	}
	
	private void loadGameElements() {
		//istanzio gli elementi del gioco
		shipDrawer = new SpriteDrawer(Assets.SPRITE_SHIP);
		mobDrawer = new SpriteDrawer(Assets.SPRITE_MOB);
		shipHalfWidth = shipDrawer.getSpriteDimension().width/2;
		int y = HEIGHT - shipDrawer.getSpriteDimension().height;
		ship = new Ship2D(new Coordinate( WIDTH/2, y, 0));
		viewBounds = new Coordinate(HEIGHT+200, WIDTH, 0);
		
		mobsManager = new MobsManager();	//Istanzio un nuovo mobs manager
	}
}
