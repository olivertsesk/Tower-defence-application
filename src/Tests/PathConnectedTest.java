package Tests;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Logic.Map;
import Logic.Path;
import Logic.PathFactory;
import Logic.PathType;


public class PathConnectedTest {
	
	Map m;
	Path p1; // Will be StraigthWE
	Path p2; // Will be StraigthWE rotated
	Path p3; // Will be StraightNS
	Path p4; // Will be StraigthNS rotated
	Path p5; // Will be TurnEN
	Path p6; // Will be TurnEN rotated
	Path p7; // Will be TurnNW
	Path p8; // Will be TurnNW rotated
	Path p9; // will be TurnSE
	Path p10; // will be TurnSE rotated
	Path p11; // will be TurnWS
	Path p12; // will be TurnWS rotated

	
	//N=0, E=1, S=2, W=3
	PathType straightWE = Map.createPathTileOfType(3,1);
	PathType straightNS =Map.createPathTileOfType(0,2);
	PathType turnEN = Map.createPathTileOfType(1,0);
	PathType turnNW = Map.createPathTileOfType(0,3);
	PathType turnSE = Map.createPathTileOfType(2,1);
	PathType turnWS = Map.createPathTileOfType(3,2);
	
	@Before
	public void setUp() throws Exception {
		m = Map.getInstance();
		m.setMap(10,10);
		p1 = PathFactory.makePath(straightWE,0);
		p2 = PathFactory.makePath(straightWE,0);
		p2.rotate();
		p3 = PathFactory.makePath(straightNS,0);
		p4 = PathFactory.makePath(straightNS,0);
		p4.rotate();
		p5 = PathFactory.makePath(turnEN,0);
		p6 = PathFactory.makePath(turnEN,0);
		p6.rotate();
		p7 = PathFactory.makePath(turnNW,0);
		p8 = PathFactory.makePath(turnNW,0);
		p8.rotate();
		p9 = PathFactory.makePath(turnSE,0);
		p10 = PathFactory.makePath(turnSE,0);
		p10.rotate();
		p11 = PathFactory.makePath(turnWS,0);
		p12 = PathFactory.makePath(turnWS,0);
		p12.rotate();
		/*
		System.out.println(p1.getEntrance());
		System.out.println(p1.getExit());
		System.out.println(m.inValidSpot(p1));
		*/
	}

	@Test
	public void test() {
		
		/*
		 *  Case 1: See if can recognize expecting out of bounds from top left corner
		 *   a) For StriaightWE
		 *   b) For StraightNS
		 *   c) For TurnEN
		 *   d) For TurnNW 
		 *   e) For TurnSE (should be true)
		 *   f) For TurnWS
		 *   Each one of these has to be repeated for a rotated form of the path as well
		 */

		assertFalse("Case 1-a: did not work.",m.inValidSpot(p1));
		assertFalse("Case 1-a(r): did not work.",m.inValidSpot(p2));
		assertFalse("Case 1-b: did not work.",m.inValidSpot(p3));
		assertFalse("Case 1-b(r): did not work.", m.inValidSpot(p4));
		assertFalse("Case 1-c: did not work.",m.inValidSpot(p5));
		assertFalse("Case 1-c(r): did not work.",m.inValidSpot(p6));
		
		//There was a mistake in turnSE and turnNW
		assertFalse("Case 1-d: did not work.",m.inValidSpot(p7));
		assertFalse("Case 1-d(r): did not work.",m.inValidSpot(p8));
		assertTrue("Case 1-e: did not work.",m.inValidSpot(p9));
		assertTrue("Case 1-e(r): did not work.", m.inValidSpot(p10));
		
		assertFalse("Case 1-f: did not work.", m.inValidSpot(p11));
		assertFalse("Case 1-f(r): did not work.",m.inValidSpot(p12));
		// worked
		
		/*
		 *  Case 2: See if can recognize expecting out of bounds from top right corner
		 *   a) For StriaightWE
		 *   b) For StraightNS
		 *   c) For TurnEN
		 *   d) For TurnNW
		 *   e) For TurnSE
		 *   f) For TurnWS (Should be true)
		 *   Each one of these has to be repeated for a rotated form of the path as well
		 */
		
		// Position 9 is the top right of a 10x10 grid
		p1 = PathFactory.makePath(straightWE,9);
		p2 = PathFactory.makePath(straightWE,9);
		p2.rotate();
		p3 = PathFactory.makePath(straightNS,9);
		p4 = PathFactory.makePath(straightNS,9);
		p4.rotate();
		p5 = PathFactory.makePath(turnEN,9);
		p6 = PathFactory.makePath(turnEN,9);
		p6.rotate();
		p7 = PathFactory.makePath(turnNW,9);
		p8 = PathFactory.makePath(turnNW,9);
		p8.rotate();
		p9 = PathFactory.makePath(turnSE,9);
		p10 = PathFactory.makePath(turnSE,9);
		p10.rotate();
		p11 = PathFactory.makePath(turnWS,9);
		p12 = PathFactory.makePath(turnWS,9);
		p12.rotate();
		
		assertFalse("Case 2-a: did not work.",m.inValidSpot(p1));
		assertFalse("Case 2-a(r): did not work.",m.inValidSpot(p2));
		assertFalse("Case 2-b: did not work.",m.inValidSpot(p3));
		assertFalse("Case 2-b(r): did not work.", m.inValidSpot(p4));
		assertFalse("Case 2-c: did not work.",m.inValidSpot(p5));
		assertFalse("Case 2-c(r): did not work.",m.inValidSpot(p6));
		assertFalse("Case 2-d: did not work.",m.inValidSpot(p7));
		assertFalse("Case 2-d(r): did not work.",m.inValidSpot(p8));
		assertFalse("Case 2-e: did not work.",m.inValidSpot(p9));
		assertFalse("Case 2-e(r): did not work.", m.inValidSpot(p10));
		assertTrue("Case 2-f: did not work.", m.inValidSpot(p11));
		assertTrue("Case 2-f(r): did not work.",m.inValidSpot(p12));
		//worked
		
		/*
		 *  Case 3: See if can recognize expecting out of bounds from bottom left corner
		 *   a) For StriaightWE
		 *   b) For StraightNS
		 *   c) For TurnEN (Should be true)
		 *   d) For TurnNW
		 *   e) For TurnSE
		 *   f) For TurnWS 
		 *   Each one of these has to be repeated for a rotated form of the path as well
		 */
		
		// Position 90 is the top right of a 10x10 grid
		p1 = PathFactory.makePath(straightWE,90);
		p2 = PathFactory.makePath(straightWE,90);
		p2.rotate();
		p3 = PathFactory.makePath(straightNS,90);
		p4 = PathFactory.makePath(straightNS,90);
		p4.rotate();
		p5 = PathFactory.makePath(turnEN,90);
		p6 = PathFactory.makePath(turnEN,90);
		p6.rotate();
		p7 = PathFactory.makePath(turnNW,90);
		p8 = PathFactory.makePath(turnNW,90);
		p8.rotate();
		p9 = PathFactory.makePath(turnSE,90);
		p10 = PathFactory.makePath(turnSE,90);
		p10.rotate();
		p11 = PathFactory.makePath(turnWS,90);
		p12 = PathFactory.makePath(turnWS,90);
		p12.rotate();
		
		assertFalse("Case 3-a: did not work.",m.inValidSpot(p1));
		assertFalse("Case 3-a(r): did not work.",m.inValidSpot(p2));
		assertFalse("Case 3-b: did not work.",m.inValidSpot(p3));
		assertFalse("Case 3-b(r): did not work.", m.inValidSpot(p4));
		assertTrue("Case 3-c: did not work.",m.inValidSpot(p5));
		assertTrue("Case 3-c(r): did not work.",m.inValidSpot(p6));
		assertFalse("Case 3-d: did not work.",m.inValidSpot(p7));
		assertFalse("Case 3-d(r): did not work.",m.inValidSpot(p8));
		assertFalse("Case 3-e: did not work.",m.inValidSpot(p9));
		assertFalse("Case 3-e(r): did not work.", m.inValidSpot(p10));
		assertFalse("Case 3-f: did not work.", m.inValidSpot(p11));
		assertFalse("Case 3-f(r): did not work.",m.inValidSpot(p12));
		// worked
		
		/*
		 *  Case 4: See if can recognize expecting out of bounds from bottom right corner
		 *   a) For StriaightWE
		 *   b) For StraightNS
		 *   c) For TurnEN 
		 *   d) For TurnNW (Should be true)
		 *   e) For TurnSE 
		 *   f) For TurnWS 
		 *   Each one of these has to be repeated for a rotated form of the path as well
		 */
		
		// Position 99 is the top right of a 10x10 grid
		p1 = PathFactory.makePath(straightWE,99);
		p2 = PathFactory.makePath(straightWE,99);
		p2.rotate();
		p3 = PathFactory.makePath(straightNS,99);
		p4 = PathFactory.makePath(straightNS,99);
		p4.rotate();
		p5 = PathFactory.makePath(turnEN,99);
		p6 = PathFactory.makePath(turnEN,99);
		p6.rotate();
		p7 = PathFactory.makePath(turnNW,99);
		p8 = PathFactory.makePath(turnNW,99);
		p8.rotate();
		p9 = PathFactory.makePath(turnSE,99);
		p10 = PathFactory.makePath(turnSE,99);
		p10.rotate();
		p11 = PathFactory.makePath(turnWS,99);
		p12 = PathFactory.makePath(turnWS,99);
		p12.rotate();
		
		assertFalse("Case 4-a: did not work.",m.inValidSpot(p1));
		assertFalse("Case 4-a(r): did not work.",m.inValidSpot(p2));
		assertFalse("Case 4-b: did not work.",m.inValidSpot(p3));
		assertFalse("Case 4-b(r): did not work.", m.inValidSpot(p4));
		assertFalse("Case 4-c: did not work.",m.inValidSpot(p5));
		assertFalse("Case 4-c(r): did not work.",m.inValidSpot(p6));
		
		//Changed from the fix as in case1
		assertTrue("Case 4-d: did not work.",m.inValidSpot(p7));
		assertTrue("Case 4-d(r): did not work.",m.inValidSpot(p8));
		assertFalse("Case 4-e: did not work.",m.inValidSpot(p9));
		assertFalse("Case 4-e(r): did not work.", m.inValidSpot(p10));
		
		assertFalse("Case 4-f: did not work.", m.inValidSpot(p11));
		assertFalse("Case 4-f(r): did not work.",m.inValidSpot(p12));
		// Worked
		
		/*
		 *  Case 5: See if can recognize expecting out of bounds from top (excluding corners)
		 *   a) For StriaightWE
		 *   b) For StraightNS (false)
		 *   c) For TurnEN (false)
		 *   d) For TurnNW (shouldn't this be false too?)
		 *   e) For TurnSE (false)-- and this should be true
		 *   f) For TurnWS 
		 *   Each one of these has to be repeated for a rotated form of the path as well
		 */
		
		// Position 1-8 is the top of a 10x10 grid (excludes the corners)
		p1 = PathFactory.makePath(straightWE,1);
		p2 = PathFactory.makePath(straightWE,2);
		p2.rotate();
		p3 = PathFactory.makePath(straightNS,3);
		p4 = PathFactory.makePath(straightNS,4);
		p4.rotate();
		p5 = PathFactory.makePath(turnEN,5);
		p6 = PathFactory.makePath(turnEN,6);
		p6.rotate();
		p7 = PathFactory.makePath(turnNW,7);
		p8 = PathFactory.makePath(turnNW,8);
		p8.rotate();
		p9 = PathFactory.makePath(turnSE,1);
		p10 = PathFactory.makePath(turnSE,2);
		p10.rotate();
		p11 = PathFactory.makePath(turnWS,3);
		p12 = PathFactory.makePath(turnWS,4);
		p12.rotate();
				
		assertTrue("Case 5-a: did not work.",m.inValidSpot(p1));
		assertTrue("Case 5-a(r): did not work.",m.inValidSpot(p2));
		assertFalse("Case 5-b: did not work.",m.inValidSpot(p3));
		assertFalse("Case 5-b(r): did not work.", m.inValidSpot(p4));
		assertFalse("Case 5-c: did not work.",m.inValidSpot(p5));
		assertFalse("Case 5-c(r): did not work.",m.inValidSpot(p6));
		
		//Changes to review
		assertFalse("Case 5-d: did not work.",m.inValidSpot(p7));
		assertFalse("Case 5-d(r): did not work.",m.inValidSpot(p8));
		assertTrue("Case 5-e: did not work.",m.inValidSpot(p9));
		assertTrue("Case 5-e(r): did not work.", m.inValidSpot(p10));
		
		assertTrue("Case 5-f: did not work.", m.inValidSpot(p11));
		assertTrue("Case 5-f(r): did not work.",m.inValidSpot(p12));
		// worked
		
		/*
		 *  Case 6: See if can recognize expecting out of bounds from bottom (excluding corners)
		 *   a) For StriaightWE
		 *   b) For StraightNS (false)
		 *   c) For TurnEN 
		 *   d) For TurnNW 
		 *   e) For TurnSE (false)
		 *   f) For TurnWS (false)
		 *   Each one of these has to be repeated for a rotated form of the path as well
		 */
		
		// Position 91-98 is the top of a 10x10 grid (excludes the corners)
		p1 = PathFactory.makePath(straightWE,98);
		p2 = PathFactory.makePath(straightWE,97);
		p2.rotate();
		p3 = PathFactory.makePath(straightNS,96);
		p4 = PathFactory.makePath(straightNS,95);
		p4.rotate();
		p5 = PathFactory.makePath(turnEN,94);
		p6 = PathFactory.makePath(turnEN,93);
		p6.rotate();
		p7 = PathFactory.makePath(turnNW,92);
		p8 = PathFactory.makePath(turnNW,91);
		p8.rotate();
		p9 = PathFactory.makePath(turnSE,98);
		p10 = PathFactory.makePath(turnSE,97);
		p10.rotate();
		p11 = PathFactory.makePath(turnWS,96);
		p12 = PathFactory.makePath(turnWS,95);
		p12.rotate();
				
		assertTrue("Case 6-a: did not work.",m.inValidSpot(p1));
		assertTrue("Case 6-a(r): did not work.",m.inValidSpot(p2));
		assertFalse("Case 6-b: did not work.",m.inValidSpot(p3));
		assertFalse("Case 6-b(r): did not work.", m.inValidSpot(p4));
		assertTrue("Case 6-c: did not work.",m.inValidSpot(p5));
		assertTrue("Case 6-c(r): did not work.",m.inValidSpot(p6));
		assertTrue("Case 6-d: did not work.",m.inValidSpot(p7));
		assertTrue("Case 6-d(r): did not work.",m.inValidSpot(p8));
		assertFalse("Case 6-e: did not work.",m.inValidSpot(p9));
		assertFalse("Case 6-e(r): did not work.", m.inValidSpot(p10));
		assertFalse("Case 6-f: did not work.", m.inValidSpot(p11));
		assertFalse("Case 6-f(r): did not work.",m.inValidSpot(p12));
		// worked
		
		/*
		 *  Case 7: See if can recognize expecting out of bounds from left side (excluding corners)
		 *   a) For StriaightWE (false)
		 *   b) For StraightNS
		 *   c) For TurnEN
		 *   d) For TurnNW (false)
		 *   e) For TurnSE 
		 *   f) For TurnWS (false)
		 *   Each one of these has to be repeated for a rotated form of the path as well
		 */
		
		// Position 10 in increments of 10 is the left side of a 10x10 grid (excludes the corners)
		p1 = PathFactory.makePath(straightWE,10);
		p2 = PathFactory.makePath(straightWE,20);
		p2.rotate();
		p3 = PathFactory.makePath(straightNS,30);
		p4 = PathFactory.makePath(straightNS,40);
		p4.rotate();
		p5 = PathFactory.makePath(turnEN,50);
		p6 = PathFactory.makePath(turnEN,60);
		p6.rotate();
		p7 = PathFactory.makePath(turnNW,70);
		p8 = PathFactory.makePath(turnNW,80);
		p8.rotate();
		p9 = PathFactory.makePath(turnSE,10);
		p10 = PathFactory.makePath(turnSE,20);
		p10.rotate();
		p11 = PathFactory.makePath(turnWS,30);
		p12 = PathFactory.makePath(turnWS,40);
		p12.rotate();
				
		assertFalse("Case 7-a: did not work.",m.inValidSpot(p1));
		assertFalse("Case 7-a(r): did not work.",m.inValidSpot(p2));
		assertTrue("Case 7-b: did not work.",m.inValidSpot(p3));
		assertTrue("Case 7-b(r): did not work.", m.inValidSpot(p4));
		assertTrue("Case 7-c: did not work.",m.inValidSpot(p5));
		assertTrue("Case 7-c(r): did not work.",m.inValidSpot(p6));
		assertFalse("Case 7-d: did not work.",m.inValidSpot(p7));
		assertFalse("Case 7-d(r): did not work.",m.inValidSpot(p8));
		assertTrue("Case 7-e: did not work.",m.inValidSpot(p9));
		assertTrue("Case 7-e(r): did not work.", m.inValidSpot(p10));
		assertFalse("Case 7-f: did not work.", m.inValidSpot(p11));
		assertFalse("Case 7-f(r): did not work.",m.inValidSpot(p12));
		//worked
		
		
		
/*
 * TEST #2: for the connected path 
 * Make sure the tiles are properly connected 
 * entry 2 = exit 1
 * 
 * There will be 4 cases, where a  Tile is placed:
 * 1)on the top 
 * 2)on the right
 * 3)on the left
 * 4)on the bottom
 * 
 * The tiles will be tested in their original position
 * (i.e without rotating)
 * 
 * These are the positions where the tiles would be
 * 		    |01|		
 * 		|10||11||12|	
 * 		    |21|		
 *
 */
		
	//Path tiles of different types are initialized to the 11th Tile
		p1 = PathFactory.makePath(straightWE,11);
		p3 = PathFactory.makePath(straightNS,11);
		p5 = PathFactory.makePath(turnEN,11);
		p7 = PathFactory.makePath(turnNW,11);
		p9 = PathFactory.makePath(turnSE,11);
		p11 = PathFactory.makePath(turnWS,11);

		
	/*
	 * CASE#1:Test placing the other tile at the top
	 * note: the order in which the tiles are compared is very important 
	 * the function "compare" has as first argument the initial position 
	 * and the second argument is the final position
	 * Therefore we need to make sure the directions of the tiles are also correct 
	 */
		p2 = PathFactory.makePath(straightWE,1);
		p4 = PathFactory.makePath(straightNS,1);
		p6 = PathFactory.makePath(turnEN,1);
		p8 = PathFactory.makePath(turnNW,1);
		p10 = PathFactory.makePath(turnSE,1);
		p12 = PathFactory.makePath(turnWS,1);
		
		
		assertTrue("Case 1 NS-NS: did not work.",m.connected(p4,p3));
		assertFalse("Case 1 WE-NS: did not work.",m.connected(p2,p3));
		assertFalse("Case 1 turnEN-NS: did not work.",m.connected(p6,p3));
		assertFalse("Case 1 turnNW-NS: did not work.",m.connected(p8, p3));
		assertFalse("Case 1 turnSE-NS: did not work.",m.connected(p10, p3));
		assertTrue("Case 1 turnWS-NS: did not work.",m.connected(p12, p3));
		
		assertFalse("Case 1 WE-WE: did not work.",m.connected(p2,p1));
		assertFalse("Case 1 turnEN-WE: did not work.",m.connected(p6,p1));
		assertFalse("Case 1 turnNW-WE	: did not work.",m.connected(p8,p1));
		assertFalse("Case 1 turnSE-WE: did not work.",m.connected(p10,p1));
		assertFalse("Case 1 turnWS-WE: did not work.",m.connected(p12,p1));
		
		assertFalse("Case 1 turnEN-turnEN: did not work.",m.connected(p5, p6));
		assertFalse("Case 1 turnEN-turnNW: did not work.",m.connected(p5, p8));
		assertTrue("Case 1 turnEN-turnSE: did not work.",m.connected(p5, p10));
		assertFalse("Case 1 turnEN-turnWS: did not work.",m.connected(p5, p12));
		
		assertFalse("Case 1 turnNW-turnNW: did not work.",m.connected(p8, p7));
		assertFalse("Case 1 turnNW-turnSE: did not work.",m.connected(p10, p7));
		assertTrue("Case 1 turnNW-turnWS: did not work.",m.connected(p12, p7));		
	
		assertFalse("Case 1 turnSE-turnSE: did not work.",m.connected(p10, p9));
		assertFalse("Case 1 turnSE-turnWS: did not work.",m.connected(p12, p9));	
		
		assertFalse("Case 1 turnWS-turnWS: did not work.",m.connected(p12, p11));	
	
		
	/*
	 * CASE#2:Test placing the other tile at the right
	 * note: the order in which the tiles are compared is very important 
	 * the function "compare" has as first argument the initial position 
	 * and the second argument is the final position
	 * Therefore we need to make sure the directions of the tiles are also correct 
	 */
		p2 = PathFactory.makePath(straightWE,12);
		p4 = PathFactory.makePath(straightNS,12);
		p6 = PathFactory.makePath(turnEN,12);
		p8 = PathFactory.makePath(turnNW,12);
		p10 = PathFactory.makePath(turnSE,12);
		p12 = PathFactory.makePath(turnWS,12);
		
		
		assertFalse("Case 2 NS-NS: did not work.",m.connected(p4,p3));
		assertFalse("Case 2 WE-NS: did not work.",m.connected(p2,p3));
		assertFalse("Case 2 turnEN-NS: did not work.",m.connected(p6,p3));
		assertFalse("Case 2 turnNW-NS: did not work.",m.connected(p8, p3));
		assertFalse("Case 2 turnSE-NS: did not work.",m.connected(p10, p3));
		assertFalse("Case 2 turnWS-NS: did not work.",m.connected(p12, p3));
			
		assertTrue("Case 2 WE-WE: did not work.",m.connected(p1,p2));
		assertFalse("Case 2 turnEN-WE: did not work.",m.connected(p1,p6));
		assertFalse("Case 2 turnNW-WE	: did not work.",m.connected(p1,p8));
		assertFalse("Case 2 turnSE-WE: did not work.",m.connected(p1,p10));
		assertTrue("Case 2 turnWS-WE: did not work.",m.connected(p1,p12));
			
		assertFalse("Case 2 turnEN-turnEN: did not work.",m.connected(p5, p6));
		assertTrue("Case 2 turnEN-turnNW: did not work.",m.connected(p8, p5));
		assertFalse("Case 2 turnEN-turnSE: did not work.",m.connected(p5, p10));
		assertFalse("Case 2 turnEN-turnWS: did not work.",m.connected(p5, p12));
		
		assertFalse("Case 2 turnNW-turnNW: did not work.",m.connected(p8, p7));
		assertFalse("Case 2 turnNW-turnSE: did not work.",m.connected(p10, p7));
		assertFalse("Case 2 turnNW-turnWS: did not work.",m.connected(p12, p7));		
		
		assertFalse("Case 2 turnSE-turnSE: did not work.",m.connected(p10, p9));
		assertTrue("Case 2 turnSE-turnWS: did not work.",m.connected(p9, p12));	
			
		assertFalse("Case 2 turnWS-turnWS: did not work.",m.connected(p12, p11));	
		
		
		
	/*
	 * CASE#3:Test placing the other tile at the left
	 * note: the order in which the tiles are compared is very important 
	 * the function "compare" has as first argument the initial position 
	 * and the second argument is the final position
	 * Therefore we need to make sure the directions of the tiles are also correct 
	*/
		p2 = PathFactory.makePath(straightWE,10);
		p4 = PathFactory.makePath(straightNS,10);
		p6 = PathFactory.makePath(turnEN,10);
		p8 = PathFactory.makePath(turnNW,10);
		p10 = PathFactory.makePath(turnSE,10);
		p12 = PathFactory.makePath(turnWS,10);
		
		
		assertFalse("Case 3 WE-NS: did not work.",m.connected(p2,p3));
		assertFalse("Case 3 turnEN-NS: did not work.",m.connected(p6,p3));
		assertFalse("Case 3 turnNW-NS: did not work.",m.connected(p8, p3));
		assertFalse("Case 3 turnSE-NS: did not work.",m.connected(p10, p3));
		assertFalse("Case 3 turnWS-NS: did not work.",m.connected(p12, p3));
				
		assertFalse("Case 3 turnEN-WE: did not work.",m.connected(p1,p6));
		assertFalse("Case 3 turnNW-WE	: did not work.",m.connected(p1,p8));
		assertTrue("Case 3 turnSE-WE: did not work.",m.connected(p10,p1));
		assertFalse("Case 3 turnWS-WE: did not work.",m.connected(p1,p12));
				
		assertFalse("Case 3 turnEN-turnNW: did not work.",m.connected(p8, p5));
		assertFalse("Case 3 turnEN-turnSE: did not work.",m.connected(p5, p10));
		assertFalse("Case 3 turnEN-turnWS: did not work.",m.connected(p5, p12));
			
		assertFalse("Case 3 turnNW-turnSE: did not work.",m.connected(p10, p7));
		assertFalse("Case 3 turnNW-turnWS: did not work.",m.connected(p12, p7));		
		
		assertFalse("Case 3 turnSE-turnWS: did not work.",m.connected(p9, p12));	
				

	/*
	 * CASE#4: Test placing the other tile at the bottom
	 * note: the order in which the tiles are compared is very important 
	 * the function "compare" has as first argument the initial position 
	 * and the second argument is the final position
	 * Therefore we need to make sure the directions of the tiles are also correct 
	*/
		p2 = PathFactory.makePath(straightWE,21);
		p4 = PathFactory.makePath(straightNS,21);
		p6 = PathFactory.makePath(turnEN,21);
		p8 = PathFactory.makePath(turnNW,21);
		p10 = PathFactory.makePath(turnSE,21);
		p12 = PathFactory.makePath(turnWS,21);
		
			
		assertFalse("Case 4 WE-NS: did not work.",m.connected(p2,p3));
		assertFalse("Case 4 turnEN-NS: did not work.",m.connected(p6,p3));
		assertTrue("Case 4 turnNW-NS: did not work.",m.connected(p3, p8));
		assertFalse("Case 4 turnSE-NS: did not work.",m.connected(p10, p3));
		assertFalse("Case 4 turnWS-NS: did not work.",m.connected(p12, p3));
					
		assertFalse("Case 4 turnEN-WE: did not work.",m.connected(p1,p6));
		assertFalse("Case 4 turnNW-WE	: did not work.",m.connected(p1,p8));
		assertFalse("Case 4 turnSE-WE: did not work.",m.connected(p1,p10));
		assertFalse("Case 4 turnWS-WE: did not work.",m.connected(p1,p12));
				
		assertFalse("Case 4 turnEN-turnNW: did not work.",m.connected(p8, p5));
		assertFalse("Case 4 turnEN-turnSE: did not work.",m.connected(p5, p10));
		assertFalse("Case 4 turnEN-turnWS: did not work.",m.connected(p5, p12));
				
		assertFalse("Case 4 turnNW-turnSE: did not work.",m.connected(p10, p7));
		assertFalse("Case 4 turnNW-turnWS: did not work.",m.connected(p12, p7));		
			
		assertFalse("Case 4 turnSE-turnWS: did not work.",m.connected(p9, p12));	
		
		
		
		
		
		//TESTING NEW METHOD CONNECTED_ROTATE
		p1=PathFactory.makePath(straightWE,25);
		p2=PathFactory.makePath(straightWE,26);
		p2.rotate();
		
	//	assertTrue("connected Rotate didnt work", m.connectedRotate(p1, p2));
		assertFalse("connected properly didnt work", m.connected(p1, p2));
		
		

	}

}
