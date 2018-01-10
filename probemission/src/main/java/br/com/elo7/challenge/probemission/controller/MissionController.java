package br.com.elo7.challenge.probemission.controller;

import br.com.elo7.challenge.probemission.model.Direction;
import br.com.elo7.challenge.probemission.model.Plane;
import br.com.elo7.challenge.probemission.model.Position;
import br.com.elo7.challenge.probemission.model.Probe;

public class MissionController implements MissionControllerInterface {
	private Plane plane;
	
	
	public void createPlane(int maxX, int maxY) {
		this.plane = new Plane(new Position(maxX, maxY));
	}

	public Probe addProbe(int x, int y, Direction direction) {
		
		//TODO: Verify if we should validate plane boundaries before adding probes
		if(this.plane != null) {
			Probe p = new Probe(new Position(x, y), direction);
			this.plane.getProbeList().add(p);
			return p;
		}
		
		return null;
	}

	public void controlProbe(Probe probe, String probeCommand) {
		probe.RunCommand(probeCommand);
	}

	public String getProbeStatus(Probe probe) {
		String status = probe.getPosition().getX() + " " + probe.getPosition().getY() + " " + probe.getCurrentDirection();
		return status;
	}
}