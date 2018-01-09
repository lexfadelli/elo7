package br.com.elo7.challenge.probemission.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class ProbeTest {

	@Test
	void rotateTest() {
		Probe p = new Probe(new Position(0, 0), Direction.NORTH);
		assertEquals(p.getCurrentDirection(), Direction.NORTH);
		
		p.Rotate(Rotation.LEFT);
		assertEquals(p.getCurrentDirection(), Direction.WEST);
		
		p.Rotate(Rotation.LEFT);
		assertEquals(p.getCurrentDirection(), Direction.SOUTH);
		
		p.Rotate(Rotation.LEFT);
		assertEquals(p.getCurrentDirection(), Direction.EAST);
		
		p.Rotate(Rotation.RIGHT);
		p.Rotate(Rotation.RIGHT);
		p.Rotate(Rotation.RIGHT);
		assertEquals(p.getCurrentDirection(), Direction.NORTH);
	}
	
	@Test
	void moveTest() throws Exception {
		Probe p = new Probe(new Position(0,0), Direction.NORTH);
		assertTrue(p.getPosition().getX() == 0 && p.getPosition().getY() == 0);
		
		p.Move(); //north
		assertTrue(p.getPosition().getX() == 0 && p.getPosition().getY() == 1);
		
		p.Rotate(Rotation.RIGHT); //east
		p.Move();
		assertTrue(p.getPosition().getX() == 1 && p.getPosition().getY() == 1);
		
		p.Rotate(Rotation.RIGHT); //south
		p.Move();
		assertTrue(p.getPosition().getX() == 1 && p.getPosition().getY() == 0);
		
		p.Rotate(Rotation.RIGHT); //west
		p.Move();
		p.Move();
		p.Move();
		assertTrue(p.getPosition().getX() == -2 && p.getPosition().getY() == 0);
	}
	
	@Test
	void runCommandTest() throws Exception {
		Probe p = new Probe(new Position(1, 2), Direction.NORTH);
		p.RunCommand("LMLMLMLMM");
		assertTrue(p.getPosition().getX() == 1 && p.getPosition().getY() == 3 && p.getCurrentDirection() == Direction.NORTH);
		
		p = new Probe(new Position(3, 3), Direction.EAST);
		p.RunCommand("MMRMMRMRRM");
		assertTrue(p.getPosition().getX() == 5 && p.getPosition().getY() == 1 && p.getCurrentDirection() == Direction.EAST);
		
		p = new Probe(new Position(0, 0), Direction.NORTH);
		p.RunCommand("LMRX"); //invalid command, ignore
		assertTrue(p.getPosition().getX() == 0 && p.getPosition().getY() == 0);
		
		p.RunCommand("LMLMLMLMM"); //moving on each direction, and north again.
		assertTrue(p.getPosition().getX() == 0 && p.getPosition().getY() == 1);
		
		p.RunCommand("  R r  M     "); //returning to initial position (with some spaces in the command line)
		assertTrue(p.getPosition().getX() == 0 && p.getPosition().getY() == 0);
	}	
}
