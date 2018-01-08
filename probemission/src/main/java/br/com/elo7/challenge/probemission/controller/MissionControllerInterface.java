package br.com.elo7.challenge.probemission.controller;

import br.com.elo7.challenge.probemission.model.Direction;
import br.com.elo7.challenge.probemission.model.Probe;

public interface MissionControllerInterface {
	
	public void createPlane(int maxX, int maxY);
	public Probe addProbe(int x, int y, Direction direction);
	public void controlProbe(Probe probe, String command);
	public String getProbeStatus(Probe probe);

}