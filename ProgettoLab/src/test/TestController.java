package test;

import model.Coordinate;
import model.Ship;
import control.Controller2D;

public class TestController {
	
	public static void main(String[] args) {
		
		Ship ship = new Ship(new Coordinate(40, 50, 0));
		Controller2D control = new Controller2D(ship);
		
		
	}

}
