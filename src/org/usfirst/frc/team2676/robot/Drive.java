package org.usfirst.frc.team2676.robot;

import edu.wpi.first.wpilibj.CANTalon;

public class Drive {
	public CANTalon LeftM, Left1, Left2, RightM, Right1, Right2;
	
	public Drive(){
		LeftM = new CANTalon(RobotMap.DriveLeftM);
		LeftS = new CANTalon(RobotMap.DriveLeftS);
		LeftS.changeControlMode(CANTalon.TalonControlMode.Follower);
		LeftS.set(RobotMap.DriveLeftM);
		RightM = new CANTalon(RobotMap.DriveRightM);
		RightS = new CANTalon(RobotMap.DriveRightS);
		RightS.changeControlMode(CANTalon.TalonControlMode.Follower);
		RightS.set(RobotMap.DriveRightM);
	}
	
	public void drive(double left, double right){
		LeftM.set(left);
		RightM.set(-right);
		}
	}