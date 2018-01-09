package br.com.elo7.challenge.probemission.model;

public enum Direction {
	NORTH("N", 0), SOUTH("S", 180), EAST("E", 90), WEST("W", 270);
    
    private String code;
    private int degrees;
    
	private Direction(String code, int degrees) {
		this.code = code;
		this.degrees = degrees;
	}
	
	public String getCode() {
		return code;
	}
	
	public Direction getNext(Rotation way) {
		int nextDegrees;
		
		if(way.equals(Rotation.RIGHT)) {
			nextDegrees = this.degrees + 90;
		} else {
			nextDegrees = this.degrees - 90;
		}
		
		if(nextDegrees < 0) {
			nextDegrees = nextDegrees + 360;
		} else if(nextDegrees == 360) {
			nextDegrees = 0;
		}
		
		for(Direction dir : Direction.values()){
			if(dir.degrees == nextDegrees) {
				return dir;
			}
		}
		
		return null;
	}
	
	public static Direction getByCode(String code) {
		for(Direction dir : Direction.values()){
			if(dir.code == code) {
				return dir;
			}
		}
		return null;
	}
}