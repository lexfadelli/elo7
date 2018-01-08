package br.com.elo7.challenge.probemission;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import br.com.elo7.challenge.probemission.model.Direction;
import br.com.elo7.challenge.probemission.model.MissionController;
import br.com.elo7.challenge.probemission.model.MissionControllerInterface;

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
    	Pattern probeControlPattern = Pattern.compile("^(\\d+)\\s+([LRM]+)$");
    	
    	Scanner sc = new Scanner(System.in);
    	String command;
		while(!(command = sc.nextLine()).equals("quit")) {
			
			//creates plane
			Matcher m = createPlanePattern.matcher(command);
			if(m.matches()) {
				System.out.println("creating plane...");
				int x = Integer.parseInt(m.group(1));
				int y = Integer.parseInt(m.group(2));
				controller.createPlane(x, y);
			}
			
			//adds probe
			m = createProbePattern.matcher(command);
			if(m.matches()) {
				System.out.println("adding probe...");
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
				controller.addProbe(x, y, d);
			}
			
			//controls probe
			m = probeControlPattern.matcher(command);
			if(m.matches()) {
				System.out.println("controlling probe...");
				int probeIndex = Integer.parseInt(m.group(1)) -1;
				String probeCommand = m.group(2);
				try {
					controller.controlProbe(probeIndex, probeCommand);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		sc.close();
    }
}
