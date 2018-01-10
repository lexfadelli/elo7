package br.com.elo7.challenge.probemission.model;

public enum ProbeCommand {
	ROTATE_lEFT("L"), ROTATE_RIGHT("R"), MOVE("M");
	
	private String code;
    
	private ProbeCommand(String code) {
		this.code = code;
	}
	
	public String getCode() {
		return code;
	}
}
