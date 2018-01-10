package br.com.elo7.challenge.probemission.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class DirectionTest {

	@Test
	void getNextTest() {
		assertEquals(Direction.NORTH.getNext(Rotation.RIGHT), Direction.EAST);
		assertEquals(Direction.NORTH.getNext(Rotation.LEFT), Direction.WEST);
		assertEquals(Direction.WEST.getNext(Rotation.RIGHT), Direction.NORTH);
		assertEquals(Direction.SOUTH.getNext(Rotation.RIGHT), Direction.WEST);
	}
}
