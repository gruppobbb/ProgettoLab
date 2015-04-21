package test.g2d.render;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;

import model.Coordinate;
import model.GameEngine;
import model.MobsManager;
import model.mobs.Mob2D;
import model.movement.MobMovingLogic2D;
import model.movement.MovingLogic2D;
import model.ships.Ship2D;
import view2d.drawers.CircleDrawer;
import view2d.drawers.SquareDrawer;
import view2d.render.RGameCanvas;
import view2d.render.RGameCanvas.RenderInfo;
import control.Controller2D;

//Test del controllo 2d della ship. 
public class TestRender01 {
	
	public static void main(String[] args) {
		
		int width = 500;
		int height = 500;
		
		final Ship2D ship = new Ship2D(new Coordinate(250, 250, 0));
		Controller2D controller = new Controller2D(ship, 400, 100);
		final MobsManager mobsManager = new MobsManager();
		final MovingLogic2D mobsMover = new MobMovingLogic2D();
		
		Coordinate bounds = new Coordinate(height+200, width, 0);
		(new Thread(new GameEngine(mobsManager,ship, bounds))).start();
		
		JFrame frame = new JFrame();
		RGameCanvas gameCanvas = new RGameCanvas(width,height,ship, mobsManager);
		frame.addKeyListener(controller);
		MouseAdapter mouse = new MouseAdapter() {
			
			ArrayList<Mob2D> mobs = new ArrayList<Mob2D>();
			
			@Override
			public void mouseDragged(MouseEvent e) {
				this.mobs.add(new Mob2D(new Coordinate(e.getX(), e.getY(), 0), 10, mobsMover));
				ship.setCoordinate(new Coordinate(e.getX(), e.getY(), 0));
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				if(e.getButton() == MouseEvent.BUTTON3){
					mobsManager.removeAllMobs();
					this.mobs = new ArrayList<Mob2D>();
				}else{
					this.mobs.add(new Mob2D(new Coordinate(e.getX(), e.getY(), 0), 10, mobsMover));
				}
				ship.setCoordinate(new Coordinate(e.getX(), e.getY(), 0));
			}
			
			@Override
			public void mouseReleased(MouseEvent e) {
				for (Mob2D mob : mobs) {
					mobsManager.addMob(mob);
				}
			}
			
			@Override
			public void mouseMoved(MouseEvent e) {
				ship.setCoordinate(new Coordinate(e.getX(), e.getY(), 0));
			}
		};
		gameCanvas.addMouseListener(mouse);
		gameCanvas.addMouseMotionListener(mouse);
		
		
		gameCanvas.getRenderinfo().addObserver(new Observer() {
			@Override
			public void update(Observable o, Object arg) {
				System.out.println((RenderInfo)o);
			}
		});
		
		frame.getContentPane().add(gameCanvas);
		frame.setResizable(false);
		frame.setVisible(true);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//gameCanvas.setMobDrawer( new CircleDrawer());
		//gameCanvas.setShipDrawer(new SquareDrawer());
		
		gameCanvas.start();
	}

}
