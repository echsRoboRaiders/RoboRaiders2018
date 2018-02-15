package org.usfirst.frc.team2676.robot;

public enum AutoRoutines {
	PowerCubeSwitch("Power Cube Switch"),
	DriveForward("Drive Straight"),
	DoNothing("Doing Absolutely Nothing");
	
	private final String autoPaths;
	AutoRoutines(String autoPaths){
		this.autoPaths = autoPaths;
	}
	
	public String toString() {
		return autoPaths;
	}
}