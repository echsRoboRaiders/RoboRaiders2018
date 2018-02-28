package org.usfirst.frc.team2676.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

public class Drive {
	public WPI_TalonSRX LeftM, LeftS, RightM, RightS;
	
	public Drive(){
		LeftM = new WPI_TalonSRX(RobotMap.DriveLeftM);
		LeftS = new WPI_TalonSRX(RobotMap.DriveLeftS);
		LeftS.follow(LeftM);
		RightM = new WPI_TalonSRX(RobotMap.DriveRightM);
		RightS = new WPI_TalonSRX(RobotMap.DriveRightS);
		RightS.follow(RightM);
	}
	
	public void drive(double left, double right){
		LeftM.set(left);
		RightM.set(-right);
		}
	}