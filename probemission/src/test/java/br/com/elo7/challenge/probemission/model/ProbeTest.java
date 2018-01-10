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
		
		p.Move(); //north
		assertEquals(new Position(0, 1), p.getPosition());
		
		p.Rotate(Rotation.RIGHT); //east
		p.Move();
		assertEquals(new Position(1, 1), p.getPosition());
		
		p.Rotate(Rotation.RIGHT); //south
		p.Move();
		assertEquals(new Position(1, 0), p.getPosition());
		
		p.Rotate(Rotation.RIGHT); //west
		p.Move();
		p.Move();
		p.Move();
		assertEquals(new Position(-2, 0), p.getPosition());
	}
	
	@Test
	void runCommandTest() throws Exception {
		Probe p = new Probe(new Position(1, 2), Direction.NORTH);
		p.RunCommand("LMLMLMLMM");
		assertTrue(p.getPosition().equals(new Position(1,3)) && p.getCurrentDirection() == Direction.NORTH);
		
		p = new Probe(new Position(3, 3), Direction.EAST);
		p.RunCommand("MMRMMRMRRM");
		assertTrue(p.getPosition().equals(new Position(5,1)) && p.getCurrentDirection() == Direction.EAST);
		
		p = new Probe(new Position(0, 0), Direction.NORTH);
		p.RunCommand("LMRX"); //invalid command, ignore
		assertTrue(p.getPosition().equals(new Position(0, 0)));
		
		p.RunCommand("LMLMLMLMM"); //moving on each direction, and north again.
		assertTrue(p.getPosition().equals(new Position(0, 1)));
		
		p.RunCommand("  R r  M     "); //returning to initial position (with some spaces in the command line)
		assertTrue(p.getPosition().equals(new Position(0, 0)));
	}	
}
