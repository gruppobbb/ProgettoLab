package test.g2d;

import java.util.Random;

import javax.swing.JFrame;

import model.Coordinate;
import model.MobsManager;
import model.collisions.CollisionChecker;
import model.mobs.Mob;
import model.mobs.Mob2D;
import model.movement.MobMovingLogic2D;
import model.movement.Mover;
import model.ships.Ship2D;
import model.spawning.Spawner;
import view2d.assets.Assets;
import view2d.drawers.SpriteDrawer;
import view2d.render.RGameCanvas;
import control.Controller2D;

public class SpriteTest {
	
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
		
		(new Thread( new Spawner(mobsManager, mobMover, new SpriteDrawer(Assets.SPRITE_MOB)){
			
			/*
			private Random rand = new Random();
			private int randX;
			private SpriteDrawer mobDrawer;
			private int N = 0;
			private int mobWidth;
			
			@Override
			protected Mob spawn() {
				//Concetto di corsia ... secondo me migliora di molto la giocabilita...
				//TODO: Se approvato, passare la larghezza dell'area di gioco, per calcolare le corsie ..
				
				mobDrawer = new SpriteDrawer(Assets.SPRITE_MOB);
				if(N==0){
					mobWidth = (int)mobDrawer.getSpriteDimension().getWidth() ;
					N = (int)(width/mobWidth);
				}
				randX = rand.nextInt(N)*mobWidth + mobWidth/2 ;
				Mob mob = new Mob2D(new Coordinate(randX, -200, 0),	10, mobDrawer, mobMover);
				return mob;
			}
			*/
		})
		).start();
		
		Coordinate bounds = new Coordinate(height+200, width, 0);
		
		(new Thread(new Mover(mobsManager))).start();
		(new Thread(new CollisionChecker(mobsManager, ship, bounds))).start();
		
		
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
