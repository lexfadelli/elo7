package br.com.elo7.challenge.probemission.model;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/***
 * Enum that represents the available movement commands of an 2D object
 * @author lexfadelli
 *
 */
public enum MovementCommand {
	ROTATE_lEFT("L"), ROTATE_RIGHT("R"), MOVE("M");
	
	private String code;
	private static Pattern commandRegexPattern = Pattern.compile("[LRM]+"); 
	
	private MovementCommand(String code) {
		this.code = code;
	}
	
	public String getCode() {
		return code;
	}
	
	/***
	 * Parses the commandline
	 * @param commandline
	 * @return
	 */
	public static List<MovementCommand> parse(String commandline) {
		List<MovementCommand> commandChain = null;
		
		commandline = commandline.toUpperCase().replaceAll(" ", "");
		Matcher m = commandRegexPattern.matcher(commandline);

		if(m.matches()) {
			commandChain = new ArrayList<MovementCommand>();
			
			for (char cmd : commandline.toCharArray()) {
				switch(cmd) {
					case 'L':
						commandChain.add(MovementCommand.ROTATE_lEFT);
						break;
					case 'R':
						commandChain.add(MovementCommand.ROTATE_RIGHT);
						break;
					case 'M':
						commandChain.add(MovementCommand.MOVE);
				}
			}
		}
		return commandChain;
	}
}
