package br.com.elo7.challenge.probemission.model;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Probe {
	private int x;
	private int y;
	
	List<Direction> dir = new ArrayList<Direction>();
	private Direction currentDirection;
	private int currentDirectionIndex;
	private Pattern commandRegexPattern; 
	
	public Probe(int x, int y, Direction direction) {
		this.x = x;
		this.y = y;
		
		dir.add(Direction.NORTH);
		dir.add(Direction.EAST);
		dir.add(Direction.SOUTH);
		dir.add(Direction.WEST);
		
		currentDirection = direction;
		currentDirectionIndex = 0;
		
		commandRegexPattern = Pattern.compile("[LRM]+");
	}
	
	public Direction getCurrentDirection() {
		return currentDirection;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
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
		if(way.equals(Rotation.RIGHT)) {
			currentDirectionIndex++;
			if(currentDirectionIndex > dir.size() - 1)
				currentDirectionIndex = 0;
		} else {
			currentDirectionIndex--;
			if(currentDirectionIndex < 0)
				currentDirectionIndex = dir.size() -1;
		}
		
		currentDirection = dir.get(currentDirectionIndex);
	}
	
	public void Move() {
		switch(currentDirection) {
			case NORTH:
				y++;
				break;
			case SOUTH:
				y--;
				break;
			case EAST:
				x++;
				break;
			case WEST:
				x--;
				break;
		}
	}
}