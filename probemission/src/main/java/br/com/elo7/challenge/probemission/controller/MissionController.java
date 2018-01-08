package br.com.elo7.challenge.probemission.controller;

import br.com.elo7.challenge.probemission.model.Direction;
import br.com.elo7.challenge.probemission.model.Plane;
import br.com.elo7.challenge.probemission.model.Probe;

public class MissionController implements MissionControllerInterface {
	private Plane plane;
	
	@Override
	public void createPlane(int maxX, int maxY) {
		this.plane = new Plane(maxY, maxX);
	}

	@Override
	public Probe addProbe(int x, int y, Direction direction) {
		
		//TODO: Verify if we should validate plane boundaries before adding probes
		if(this.plane != null) {
			Probe p = new Probe(x, y, direction);
			this.plane.getProbeList().add(p);
			return p;
		}
		
		return null;
	}

	@Override
	public void controlProbe(Probe probe, String probeCommand) {
		probe.RunCommand(probeCommand);
	}

	@Override
	public String getProbeStatus(Probe probe) {
		String status = probe.getX() + " " + probe.getY() + " " + probe.getCurrentDirection();
		return status;
	}
}