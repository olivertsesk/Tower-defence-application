package Tests;
import static org.junit.Assert.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

import org.junit.Before;
import org.junit.Test;

import Logic.Map;


public class MapTest {
//	Initialize variables 
	Map m;
		
	@Before
	public void setUp()throws Exception{
		m=Map.getInstance();
		m.setMap(5,5);	
		
		
	}
	

	@Test
	public void test() {
//		STEP#1: map has been created, but no tiles have been initialized
		System.out.println("Step#1:");
//			a)entryPoint=exitPoint=NULL
			assertTrue("the entryPoint and/or exitPoint aren't define properly",(m.getEntryPoint()==null&&m.getExitPoint()==null));
//			b)linked list isEmpty
			assertTrue("LinkedList is not empty", m.getPath().isEmpty());
//			c)grid should be initialized all to null
			m.printGrid();
//			d)check if the following methods can handle this condition 
//				-FINALIZE (does nothing)
				m.finalizePath();
				assertTrue("Error: Path has been finalize",m.getExitPoint()==null);
//				-DELETE	(does nothing)
				m.deleteLastPathTile();
//				-ADD(adds entryPoint)
				m.setCellToPath(0);
//		STEP#2: only the start point has been assigned
		System.out.println("Step#2:");
//			a)entryPoint!=NULL && exitPoint=NULL
			assertTrue("the entryPoint and/or exitPoint aren't define properly",(m.getEntryPoint()!= null && m.getExitPoint()== null));
//			b)linked list isEmpty
			assertTrue("LinkedList is not empty", m.getPath().isEmpty());
//			c)grid should be initialized all to null, expect entryPoint
			m.printGrid();
//			d)check if the following methods can handle this condition 
//				-FINALIZE (does nothing)
				m.finalizePath();
				assertTrue("Error: Path has been finalize",m.getExitPoint()==null);
//				-DELETE (deletes entryPoint)
				m.deleteLastPathTile();
				assertTrue("Entry point isn't deleted correctly",(m.getEntryPoint()==null));
				System.out.println();
				m.printGrid();
//				-ADD(adds other tiles)
				m.setCellToPath(0);
				m.setCellToPath(1);
				m.setCellToPath(6);
//		STEP#3: other tiles have been initialized 
		System.out.println("Step#3:");
//			a)entryPoint!=NULL && exitPoint=NULL
			assertTrue("the entryPoint and/or exitPoint aren't define properly",(m.getEntryPoint()!=null&&m.getExitPoint()==null));
//			b)linked list !isEmpty
			assertFalse("LinkedList is not empty", m.getPath().isEmpty());
			System.out.print("This is the linked list: ");
			m.printPath();
			System.out.println();
//			c)path on the grid should be initialized, rest should be null
			m.printGrid();
//			e)check if the following methods can handle this condition 
//				-DELETE (deletes last)
				m.deleteLastPathTile();
				System.out.print("This is the linked list after deleting: ");
				m.printPath();
				System.out.println();
				m.printGrid();
//				-ADD
//				~not connected
				m.setCellToPath(20);
//				~intersections				
				m.setCellToPath(2);
				m.setCellToPath(7);
				m.setCellToPath(6);
				m.setCellToPath(1);
//				~going back
				m.setCellToPath(7);
				m.setCellToPath(2);
				
				m.setCellToPath(11);
				
				System.out.print("This is the linked list after trying to insert invalid and valid positions: ");
				m.printPath();
				System.out.println();
				m.printGrid();
				System.out.println();	
//				-FINALIZE (ends path)	--> next case
				m.finalizePath();

			
//		STEP#4: Finalize Path
		System.out.println("Step#4");
//			a)entryPoint!=NULL && exitPoint!=NULL
			assertTrue("the entryPoint and/or exitPoint aren't define properly",(m.getEntryPoint()!=null&&m.getExitPoint()!=null));
//			b)linked list !isEmpty
			assertFalse("LinkedList is not empty", m.getPath().isEmpty());
			System.out.print("This is the linked list of the finalized Path: ");
			m.printPath();
			System.out.println();
//			c)path on the grid should be initialized, rest should be null
			m.printGrid();
//			e)check if the following methods can handle this condition 
//				-FINALIZE (can't finalize twice)
				m.finalizePath();
//				-ADD (does not do anything)
				m.setCellToPath(10);
				System.out.println("After trying to finalize the path again, and add another Path Tile");
				m.printGrid();
				System.out.println();
//				-DELETE (can delete -- begin to edit again)
				m.deleteLastPathTile();
				m.setCellToPath(10);
				m.setCellToPath(15);
				m.finalizePath();
				System.out.println("Editing Path after finalizing it");
				System.out.print("Linked List: ");
				m.printPath();
				System.out.println();
				m.printGrid();
				System.out.println();
//		STEP#5:Set rest to scenery 	
		System.out.println("Step#5");
//			a)entryPoint!=NULL && exitPoint!=NULL
			assertTrue("the entryPoint and/or exitPoint aren't define properly",(m.getEntryPoint()!=null&&m.getExitPoint()!=null));
//			b)linked list !isEmpty
			assertFalse("LinkedList is not empty", m.getPath().isEmpty());
//			c)path on the grid should be initialized, rest should be scenery
			m.setRemainingToScenery();
			System.out.println("Map after setting rest to Scenery");
			System.out.print("Linked List: ");
			m.printPath();
			System.out.println();
			m.printGrid();
			System.out.println();
			

//		STEP#6: Edit Path once it has been finalized and rest has been set to scenery
		System.out.println("Step#6");
//			can't add right away
//			must delete first
			m.deleteLastPathTile();
			m.deleteLastPathTile();
			m.deleteLastPathTile();
//			ADD
			m.setCellToPath(16);
			m.setCellToPath(21);
			m.setCellToPath(22);

//			a)entryPoint!=NULL && exitPoint=NULL
			assertTrue("the entryPoint and/or exitPoint aren't define properly",(m.getEntryPoint()!=null&&m.getExitPoint()==null));
//			b)linked list !isEmpty
			assertFalse("LinkedList is not empty", m.getPath().isEmpty());
//			c)path on the grid should be initialized +mix of scenery and null

			System.out.println("Map after editing w/o finalizing");
			System.out.print("Linked List: ");
			m.printPath();
			System.out.println();
			m.printGrid();
			System.out.println();
//		STEP#7:Final outcome (set to scenery) 
			System.out.println("Step#7");
			m.finalizePath();
			m.setRemainingToScenery();
			assertTrue("the entryPoint and/or exitPoint aren't define properly",(m.getEntryPoint()!=null&&m.getExitPoint()!=null));
			System.out.println("After finalizing and setting rest to scenery");
			System.out.println("Entry Point:"+ m.getEntryPoint().getPos());
			System.out.println("Exit Point:"+ m.getExitPoint().getPos());
			m.printPath();
			System.out.println();
			m.printGrid();
			
			
//STEP #8 : SAVING CREATED MAP
		//m.saveMap("test1");
		System.out.println("done saving");


		m.deleteLastPathTile();
		m.setCellToPath(23);
		m.setCellToPath(24);
		m.setCellToPath(19);
		m.finalizePath();
		m.printGrid();
		//m.saveMap("test2");
		System.out.println("done saving");
		
		m.deleteLastPathTile();
		m.setCellToPath(14);
		m.setCellToPath(9);
		m.setCellToPath(4);
		m.finalizePath();
		m.printGrid();
		m.saveMap("test3");
		System.out.println("done saving");

	}

}
