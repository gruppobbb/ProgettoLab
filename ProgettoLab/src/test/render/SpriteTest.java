package test.render;

import java.util.Random;

import javax.swing.JFrame;

import model.Coordinate;
import model.MobsManager;
import model.Spawner;
import model.collisions.CollisionChecker;
import model.mobs.Mob;
import model.mobs.Mob2D;
import model.movement.MobMover2D;
import model.movement.Mover;
import model.ships.Ship2D;
import view2d.SquareShipDrawer;
import view2d.assets.Assets;
import view2d.assets.SpriteDrawer;
import view2d.render.RGameCanvas;
import control.Controller2D;

public class SpriteTest {
	
	public static void main(String[] args) {
		
		final int width = 800;
		final int height = (width/16)*9;

		SpriteDrawer shipDrawer = new SpriteDrawer(Assets.SPRITE_SHIP);
		int shipHalfWidth = shipDrawer.getSpriteDimension().width/2;
		int shipHalfHeight = shipDrawer.getSpriteDimension().height/2;
		int y = height - shipHalfHeight;
		Coordinate coo = new Coordinate( width/2, y, 0);
		
		Ship2D ship = new Ship2D(coo, shipDrawer);
		Controller2D control = new Controller2D(ship, width-shipHalfWidth, 0);
		
		MobsManager mobsManager = new MobsManager();
		final MobMover2D mobMover = new MobMover2D();
		
		Spawner spawner = new Spawner(mobsManager, mobMover){
			
			private Random rand = new Random();
			private int randX;
			private SpriteDrawer mobDrawer;
			private int N = 5;
			
			@Override
			protected Mob spawn() {
				//Concetto di corsia ... secondo me migliora di molto la giocabilita...
				//TODO: Se approvato, passare la larghezza dell'area di gioco, per calcolare le corsie ..
				
				mobDrawer = new SpriteDrawer(Assets.SPRITE_MOB);
				N = (int)(width/mobDrawer.getSpriteDimension().getWidth());
				int delta = width/N;
				randX = rand.nextInt(N)*delta + delta/2 ;
				Mob mob = new Mob2D(new Coordinate(randX, -200, 0),	10, mobDrawer, mobMover);
				return mob;
			}
		};
		
		spawner.start();
		
		Coordinate bounds = new Coordinate(1000, 500, 0);
		
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
