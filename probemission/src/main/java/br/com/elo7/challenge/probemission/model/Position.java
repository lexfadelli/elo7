package br.com.elo7.challenge.probemission.model;

import java.util.Objects;

/***
 * Class that represents the 2D position of an object in a plane
 * @author lexfadelli
 *
 */
public class Position {
	private int x;
	private int y;
	
	public Position(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	
	@Override
	public boolean equals(Object o) {
	    if (this == o)
	        return true;
	    
	    if (o == null)
	        return false;

	    if (getClass() != o.getClass())
	        return false;
	    
	    Position p = (Position) o;
	    return Objects.equals(x, p.x)
	            && Objects.equals(y, p.y);
	}
}
