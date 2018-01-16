package br.com.elo7.challenge.probemission.model;

import java.util.ArrayList;
import java.util.List;

/***
 * Class that represents a 2D plane
 * @author lexfadelli
 *
 */
public class Plane {
	private List<Probe> probeList;
	private Position size;

	public Position getSize() {
		return size;
	}

	public List<Probe> getProbeList() {
		return probeList;
	}
	
	public Plane(Position size) {
		probeList = new ArrayList<Probe>();
		this.size = size;
	}
}