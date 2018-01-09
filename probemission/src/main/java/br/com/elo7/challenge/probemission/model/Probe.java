package br.com.elo7.challenge.probemission.model;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Probe {
	private Position position;
	
	List<Direction> dir = new ArrayList<Direction>();
	private Direction currentDirection;
	private Pattern commandRegexPattern; 
	
	public Probe(Position position, Direction direction) {
		this.position = position;
		currentDirection = direction;
		commandRegexPattern = Pattern.compile("[LRM]+");
	}
	
	public Direction getCurrentDirection() {
		return currentDirection;
	}
	
	public Position getPosition() {
		return position;
	}
	
	public void RunCommand(String command) {
		//command string clean up
		command = command.toUpperCase().replaceAll(" ", "");
		
		Matcher m = commandRegexPattern.matcher(command);
		if(m.matches()) {
			for (char cmd : command.toCharArray()) {
				
				switch(cmd) {
					case 'L':
						this.Rotate(Rotation.LEFT);
						break;
					case 'R':
						this.Rotate(Rotation.RIGHT);
						break;
					case 'M':
						this.Move();
				}
			}
			
		} else {
			return; //invalid command
		}
	}
	
	public void Rotate(Rotation way) {
		currentDirection = currentDirection.getNext(way);
	}
	
	public void Move() {
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