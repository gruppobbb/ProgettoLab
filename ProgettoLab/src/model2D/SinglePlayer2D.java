package model2D;

import java.awt.Canvas;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;

import model.Coordinate;
import model.Game;
import model.GameEngine;
import model.MobsManager;
import model.scores.ScoreCalculator;
import model.spawning.Spawner;
import view2d.Drawer2D;
import view2d.RGameCanvas;
import view2d.drawers.SpriteDrawer;
import assetsPc.Assets;
import assetsPc.audio.LoopedPlayer;
import control.Controller2D;

/**
 * Componente che si occupa dell'assemblaggio di tutto ciò che serve per giocare una partita in single player in 2D.
 * @author Max
 */
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
	private GameEngine engine;
	private Spawner spawner;
	private ScoreCalculator scoreCalculator;
	private JFrame gameFrame;
	private JFrame menuFrame;
	private LoopedPlayer bgmPlayer;
	
	private static final int WIDTH = 900;
	private static final int HEIGHT = (WIDTH/7)*8;
	
	public SinglePlayer2D(JFrame menuFrame) {
		this.menuFrame = menuFrame;
	}

	public void setup() {
		
		loadGameElements();	//carica gli elementi che servono per la partita
		
		gameFrame = createGameFrame();
		
		createGameField();	//istanzia canvas + relativo controllo
		
		engine = new GameEngine(mobsManager,ship, viewBounds);
		engine.addObserver(this);
		
		spawner = new Spawner(mobsManager, new MobMovingLogic2D(), new SimpleLanes2DSpawnerM(WIDTH));
		spawner.setSleepTime(400);

		threads.clear();
		threads.add(new Thread(engine));
		threads.add(new Thread(spawner));	//Lo spawner
	}
	
	private JFrame createGameFrame() {
		JFrame frame = new JFrame();
		//Per ora .. piï¿½ in la facciamo che si torna al menu ...
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		return frame;
	}

	private void activateFrame(JFrame frame) {
		frame.setVisible(true);
		frame.pack();
		frame.setLocationRelativeTo(null);
		gameFrame.validate();
	}

	private void createGameField() {
		//istanzio il canvas di gioco
		gameCanvas = new RGameCanvas(WIDTH, HEIGHT, ship, mobsManager, scoreCalculator);
		gameCanvas.setShipDrawer(shipDrawer);
		gameCanvas.setMobDrawer(mobDrawer);
		//istanzio il controllo
		controller = new Controller2D(ship, WIDTH-shipHalfWidth, shipHalfWidth);
		gameCanvas.addKeyListener(controller);
	}

	@Override
	public void start() {
		setup();
		gameFrame.getContentPane().add(gameCanvas);
		activateFrame(gameFrame);
		engine.setToKill(false);
		spawner.setToKill(false);
		gameCanvas.start();
		bgmPlayer.play();
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		scoreCalculator.start();
		for (Thread thread : threads) {
			thread.start();
		}
	}
	
	@Override
	public void pause() {
		//TODO implementazione della pausa... forse più avanti
		
	}
	
	@Override
	public void gameOver() {
		//TODO:bgmPlayer.stop(); ...
		spawner.setToKill(true);	
		engine.setToKill(true);	
		scoreCalculator.stop();
		gameCanvas.removeKeyListener(controller);
		gameCanvas.stop();
		try {Thread.sleep(1);} catch (InterruptedException e) {e.printStackTrace();}
		gameFrame.dispose();
		menuFrame.setEnabled(true);
		menuFrame.toFront();
        menuFrame.repaint();
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
		viewBounds = new Coordinate(WIDTH, HEIGHT+200, 0);
		bgmPlayer = new LoopedPlayer(Assets.AUDIO_BGM);
		mobsManager = new MobsManager();	//Istanzio un nuovo mobs manager
		scoreCalculator = new ScoreCalculator();
	}
}
