package test.g2d;

import javax.swing.JFrame;

import model.Coordinate;
import model.MobsManager;
import model.ships.Ship2D;
import view2d.drawers.SquareDrawer;
import view2d.render.RGameCanvas;
import control.Controller2D;

//Test del controllo 2d della ship. 
public class TestController01 {
	
	public static void main(String[] args) {
		
		Ship2D ship = new Ship2D(new Coordinate(400, 150, 0));
		Controller2D control = new Controller2D(ship, 700, 100);
		MobsManager mobsManager = new MobsManager();
				
		JFrame frame = new JFrame();
		frame.addKeyListener(control);
		RGameCanvas gameCanvas = new RGameCanvas(800,300,ship, mobsManager);
		
		frame.getContentPane().add(gameCanvas);
		frame.setResizable(false);
		frame.setVisible(true);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		gameCanvas.setShipDrawer(new SquareDrawer());
		
		gameCanvas.start();
		
	}

}
