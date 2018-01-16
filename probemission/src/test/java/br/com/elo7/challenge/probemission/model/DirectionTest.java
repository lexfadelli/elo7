package br.com.elo7.challenge.probemission.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class DirectionTest {

	@Test
	void getNextTest() {
		assertEquals(Direction.NORTH.getNextRight(), Direction.EAST);
		assertEquals(Direction.NORTH.getNextLeft(), Direction.WEST);
		assertEquals(Direction.WEST.getNextRight(), Direction.NORTH);
		assertEquals(Direction.SOUTH.getNextRight(), Direction.WEST);
	}
}
