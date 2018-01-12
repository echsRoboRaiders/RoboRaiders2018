package org.usfirst.frc.team2676.robot;

import edu.wpi.first.wpilibj.Joystick;

public class Controls {
	 Joystick controller;
	 
	 public Controls(){
		 controller = new Joystick(0); 
	 }
	 
	 public double getDrivePowerL(){
		 return -controller.getRawAxis(1);
	 }
	 
	 public double getDrivePowerR(){
		 return -controller.getRawAxis(5);
	 }
	 
	 public boolean getLTurnButton(){
		 return controller.getRawButton(5);
	 }
	 
	 public boolean getRTurnButton(){
		 return controller.getRawButton(6);
	 }
	 
	 public boolean getEjectButton(){
		 return controller.getRawButton(4);
	 }
	 
	 public boolean getInsertButton(){
		 return controller.getRawButton(1);
	 }
	 public boolean getStopButton(){
		 return controller.getRawButton(2);
	 }
}