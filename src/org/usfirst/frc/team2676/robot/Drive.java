package org.usfirst.frc.team2676.robot;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
public class Drive {
	public WPI_TalonSRX LeftM, Left1, Left2, RightM, Right1, Right2;
	
	public Drive(){
		LeftM = new WPI_TalonSRX(RobotMap.DriveLeftM);
		LeftS = new WPI_TalonSRX(RobotMap.DriveLeftS);
		LeftS.changeControlMode(WPI_TalonSRX.TalonControlMode.Follower);
		LeftS.set(RobotMap.DriveLeftM);
		RightM = new WPI_TalonSRX(RobotMap.DriveRightM);
		RightS = new WPI_TalonSRX(RobotMap.DriveRightS);
		RightS.changeControlMode(WPI_TalonSRX.TalonControlMode.Follower);
		RightS.set(RobotMap.DriveRightM);
	}
	
	public void drive(double left, double right){
		LeftM.set(left);
		RightM.set(-right);
		}
	}