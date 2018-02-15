package org.usfirst.frc.team2676.robot;

public class AutoTest {
	
	public void AutoTest1() {
		Drive drive = new Drive();
		//long startTime;
		boolean after1 = false;
		boolean after2 = false;
		
		if((System.currentTimeMillis() - Robot.startTime) > 5000 && !after1 && !after2)
		{
			drive.LeftM.set(0.5);
			drive.RightM.set(0.0);
			Robot.startTime = System.currentTimeMillis();
			after1 = true;
		}
		
		if((System.currentTimeMillis() - Robot.startTime) < 2000 && after1 && !after2)
		{
			drive.LeftM.set(0.4);
			drive.RightM.set(0.4);
		}
		
		if((System.currentTimeMillis() - Robot.startTime) > 2000 && after1 && !after2)
		{
			drive.LeftM.set(0.0);
			drive.RightM.set(0.0);
			Robot.startTime = System.currentTimeMillis();
			after2 = true;
		}
	}
}
