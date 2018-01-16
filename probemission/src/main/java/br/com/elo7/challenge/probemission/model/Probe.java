package br.com.elo7.challenge.probemission.model;

import java.util.ArrayList;
import java.util.List;

/***
 * Class that represents the probe
 * @author lexfadelli
 *
 */
public class Probe {
	private Position position;
	
	List<Direction> dir = new ArrayList<Direction>();
	private Direction currentDirection;
	
	
	public Probe(Position position, Direction direction) {
		this.position = position;
		currentDirection = direction;
	}
	
	public Direction getCurrentDirection() {
		return currentDirection;
	}
	
	public Position getPosition() {
		return position;
	}
	
	/***
	 * Executes the commandline
	 * @param command
	 */
	public void runCommand(String command) {
		List<MovementCommand> commandChain = MovementCommand.parse(command);

		if(commandChain != null) {
			for (MovementCommand cmd : commandChain) {
				switch(cmd) {
					case ROTATE_lEFT:
						this.rotateLeft();
						break;
					case ROTATE_RIGHT:
						this.rotateRight();
						break;
					case MOVE:
						this.move();
				}
			}
		} else {
			return; //invalid command
		}
	}
	
	public void rotateLeft() {
		currentDirection = currentDirection.getNextLeft();
	}
	
	public void rotateRight() {
		currentDirection = currentDirection.getNextRight();
	}
	
	public void move() {
		switch(currentDirection) {
			case NORTH:
				this.position.setY(this.position.getY() + 1);
				break;
			case SOUTH:
				this.position.setY(this.position.getY() - 1);
				break;
			case EAST:
				this.position.setX(this.position.getX() + 1);
				break;
			case WEST:
				this.position.setX(this.position.getX() - 1);
				break;
		}
	}
}