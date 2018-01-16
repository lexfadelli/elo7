package br.com.elo7.challenge.probemission.model;

/***
 * Enum that represents the cardinal points
 * @author lexfadelli
 *
 */
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
	
	/***
	 * returns the next direction to the left
	 * @return
	 */
	public Direction getNextLeft() {
		return this.getNext(-90);
	}
	
	/***
	 * returns the next direction to the right
	 * @return
	 */
	public Direction getNextRight() {
		return this.getNext(90);
	}
	
	/***
	 * returns next direction according to the rotation degree
	 * @param way
	 * @return
	 */
	private Direction getNext(int degrees) {
		int nextDegrees = this.degrees + degrees;
		
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