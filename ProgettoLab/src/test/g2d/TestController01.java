package test.g2d;

import javax.swing.JFrame;

import model.Coordinate;
import model.MobsManager;
import model.ships.Ship2D;
import view2d.RGameCanvas;
import view2d.drawers.SquareDrawer;
import control.Controller2D;

//Test del controllo 2d della ship. 
public class TestController01 {
	
	public static void main(String[] args) {
		
		Ship2D ship = new Ship2D(new Coordinate(400, 150, 0));
		Controller2D control = new Controller2D(ship, 775, 25);
		MobsManager mobsManager = new MobsManager();
				
		JFrame frame = new JFrame();
		RGameCanvas gameCanvas = new RGameCanvas(800,300,ship, mobsManager);
		gameCanvas.addKeyListener(control);
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
