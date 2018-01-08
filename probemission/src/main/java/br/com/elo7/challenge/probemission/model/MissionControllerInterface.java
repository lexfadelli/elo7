package br.com.elo7.challenge.probemission.model;

public interface MissionControllerInterface {
	public void createPlane(int maxX, int maxY);
	public void addProbe(int x, int y, Direction direction);
	public void controlProbe(int probeIndex, String command) throws Exception;
}