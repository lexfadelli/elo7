package br.com.elo7.challenge.probemission.model;

import java.util.ArrayList;
import java.util.List;

public class Plane {
	private List<Probe> probeList;
	private int maxY;
	private int maxX;

	public int getMaxY() {
		return maxY;
	}

	public int getMaxX() {
		return maxX;
	}

	public List<Probe> getProbeList() {
		return probeList;
	}
	
	public Plane(int maxY, int maxX) {
		this.maxX = maxX;
		this.maxY = maxY;
		probeList = new ArrayList<Probe>();
	}
}