package test.junit;

import static org.junit.Assert.assertEquals;
import model.Coordinate;
import model.MobsManager;
import model.mobs.Mob;

import org.junit.Test;

public class Test01{

	@Test
	public void test01() {
		MobsManager mobMan = new MobsManager();
		Mob newMob = null;
		mobMan.addMob(newMob);
		
		
		assertEquals(mobMan.getMobsList().size(), 1);
		assertEquals(newMob, null);
		
		mobMan.removeMob(newMob);
		assertEquals(mobMan.getMobsList().size(), 0);
		assertEquals(newMob, null);
		
		Coordinate coordinate = new Coordinate(1, 1, 1);
		coordinate.setX(1);
		coordinate.setY(2);
		coordinate.setZ(3);
		assertEquals(coordinate.getX(), 1);
		assertEquals(coordinate.getY(), 2);
		assertEquals(coordinate.getZ(), 3);
		
//		newMob.setCoordinate(coordinate);
//		Drawer2D shipDrawer = null;
//		Ship ship = new Ship(coordinate);
//		CollisionChecker checker = new CollisionChecker(mobMan, ship);
//		checker.run();
		
		
	}

}
