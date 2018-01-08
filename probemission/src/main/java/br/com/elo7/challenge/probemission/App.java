package br.com.elo7.challenge.probemission;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import br.com.elo7.challenge.probemission.controller.MissionController;
import br.com.elo7.challenge.probemission.controller.MissionControllerInterface;
import br.com.elo7.challenge.probemission.model.Direction;
import br.com.elo7.challenge.probemission.model.Probe;

/**
 * Main Class
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	MissionControllerInterface controller = new MissionController();
    	
    	Pattern createPlanePattern = Pattern.compile("^(\\d+)\\s+(\\d+)$");
    	Pattern createProbePattern = Pattern.compile("^(\\d+)\\s+(\\d+)\\s+([NWSE])$");
    	Pattern probeControlPattern = Pattern.compile("^([LRM]+)$");
    	
    	Scanner sc = new Scanner(System.in);
    	String command;
    	
    	Probe currentProbe = null;
		while(!(command = sc.nextLine()).equals("quit")) {
			
			Matcher m = createPlanePattern.matcher(command);
			if(m.matches()) {
				
				//creates plane
				System.out.println("creating plane...");
				int x = Integer.parseInt(m.group(1));
				int y = Integer.parseInt(m.group(2));
				controller.createPlane(x, y);
				
			} else {
				
				m = createProbePattern.matcher(command);
				if(m.matches()) {
					
					//adds probe
					int x = Integer.parseInt(m.group(1));
					int y = Integer.parseInt(m.group(2));
					
					String dir = m.group(3);
					Direction d = null;
					switch(dir) {
						case "N":
							d = Direction.NORTH;
							break;
						case "W":
							d = Direction.WEST;
							break;
						case "S":
							d = Direction.SOUTH;
							break;
						case "E":
							d = Direction.EAST;
							break;
					}
					currentProbe = controller.addProbe(x, y, d);
					if(currentProbe == null) {
						System.out.println("command failed!");
					}
					
				} else {
					
					//controls probe
					m = probeControlPattern.matcher(command);
					if(m.matches()) {
						String probeCommand = m.group(1);
						controller.controlProbe(currentProbe, probeCommand);
						System.out.println(controller.getProbeStatus(currentProbe));
					}
					
				}

			}
			
		}
		
		sc.close();
		
    }
}
