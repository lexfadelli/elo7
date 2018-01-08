package br.com.elo7.challenge.probemission.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class ProbeTest {

	@Test
	void rotateTest() {
		Probe p = new Probe(0, 0, Direction.NORTH);
		assertEquals(p.getCurrentDirection(), Direction.NORTH);
		
		p.Rotate(Way.LEFT);
		assertEquals(p.getCurrentDirection(), Direction.WEST);
		
		p.Rotate(Way.LEFT);
		assertEquals(p.getCurrentDirection(), Direction.SOUTH);
		
		p.Rotate(Way.LEFT);
		assertEquals(p.getCurrentDirection(), Direction.EAST);
		
		p.Rotate(Way.RIGHT);
		p.Rotate(Way.RIGHT);
		p.Rotate(Way.RIGHT);
		assertEquals(p.getCurrentDirection(), Direction.NORTH);
	}
	
	@Test
	void moveTest() throws Exception {
		Probe p = new Probe(0, 0, Direction.NORTH);
		assertTrue(p.getX() == 0 && p.getY() == 0);
		
		p.Move(); //north
		assertTrue(p.getX() == 0 && p.getY() == -1);
		
		p.Rotate(Way.RIGHT); //east
		p.Move();
		assertTrue(p.getX() == 1 && p.getY() == -1);
		
		p.Rotate(Way.RIGHT); //south
		p.Move();
		assertTrue(p.getX() == 1 && p.getY() == 0);
		
		p.Rotate(Way.RIGHT); //west
		p.Move();
		p.Move();
		p.Move();
		assertTrue(p.getX() == -2 && p.getY() == 0);
	}
	
	@Test
	void runCommandTest() throws Exception {
		Probe p = new Probe(0, 0, Direction.NORTH);

		try {
			p.RunCommand("LMRX");
		} catch (Exception e) {
		}
		
		p.RunCommand("LMLMLMLMM"); //moving on each direction, and north again.
		assertTrue(p.getX() == 0 && p.getY() == -1);
		
		p.RunCommand("  R r  M     "); //returning to initial position (with some spaces in the command line)
		assertTrue(p.getX() == 0 && p.getY() == 0);
	}	
}
