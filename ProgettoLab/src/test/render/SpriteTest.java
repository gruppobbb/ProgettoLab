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
		
		int width = 800;
		int height = 600;

		SpriteDrawer shipDrawer = new SpriteDrawer(Assets.SPRITE_SHIP);
		int y = height - shipDrawer.getSpriteDimension().height;
		Coordinate coo = new Coordinate( width/2, y, 0);
		
		Ship2D ship = new Ship2D(coo, shipDrawer);
		Controller2D control = new Controller2D(ship, 735, 0);
		
		MobsManager mobsManager = new MobsManager();
		final MobMover2D mobMover = new MobMover2D();
		
		Spawner spawner = new Spawner(mobsManager, mobMover){
			
			private Random rand = new Random();
			private int randX;
			
			@Override
			protected Mob spawn() {
				
				randX = rand.nextInt((700 - 200) +1) +200;
				
				Mob mob = new Mob2D(new Coordinate(randX, 20, 0),	10, 
						new SpriteDrawer(Assets.SPRITE_MOB), 
						mobMover);
				
				return mob;
				
			}
		};
		
		spawner.start();
		
		Coordinate bounds = new Coordinate(1000, 500, 0);	//setto x altissimo, tanto non uscirà mai
		
		(new Thread(new Mover(mobsManager))).start();
		(new Thread(new CollisionChecker(mobsManager, ship, bounds))).start();
		
		
		JFrame frame = new JFrame();	
		RGameCanvas gameCanvas = new RGameCanvas(800,600,ship, mobsManager);
		frame.setSize(800, 600);
		frame.addKeyListener(control);
		frame.setFocusable(true);		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setVisible(true);
		frame.getContentPane().add(gameCanvas);
		gameCanvas.start();
		
	}

}
