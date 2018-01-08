package br.com.elo7.challenge.probemission.model;

public class MissionController implements MissionControllerInterface {
	private Plane plane;
	
	@Override
	public void createPlane(int maxX, int maxY) {
		this.plane = new Plane(maxY, maxX);
	}

	@Override
	public void addProbe(int x, int y, Direction direction) {
		//TODO: Verify if we should validate plane boundaries before adding probes
		Probe p = new Probe(x, y, direction);
		this.plane.getProbeList().add(p);
	}

	@Override
	public void controlProbe(int probeIndex, String probeCommand) throws Exception {
		if(probeIndex > -1 && probeIndex <= this.plane.getProbeList().size() -1) {
			this.plane.getProbeList().get(probeIndex).RunCommand(probeCommand);
		}
	}
}