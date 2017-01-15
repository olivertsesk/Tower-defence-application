
package Tests;

import Logic.*;

import static org.junit.Assert.*;

import java.util.*;

import org.junit.*;

import Logic.Map;

public class CritterTest {
	Map m;
	CritterWave wave;
	
	@Before
	public void setUp(){
		m =Map.getInstance();
		m.setMap(5, 5);
		m.setCellToPath(0);
		m.setCellToPath(5);
		m.setCellToPath(10);
		m.setCellToPath(15);
		m.setCellToPath(20);
		m.setCellToPath(21);
		m.setCellToPath(22);
		m.setCellToPath(23);
		m.setCellToPath(24);
		m.finalizePath();
		m.printGrid();
		m.printPath();
		
		wave= new CritterWave();
		wave.setWave(2);
		for (Path p: wave.getPath())
			System.out.println(p.getPos());

		
		for (int i=0;i<50;i++){//gameclock
			System.out.println("Tick #: "+i);
			for (Critter c: wave.getListCritters()){
				c.tick();
			}
		}
		
		
	}
	
	@Test
	public void test() {
		
		//fail("Not yet implemented");
	}

}
