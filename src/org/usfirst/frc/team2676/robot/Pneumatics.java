package org.usfirst.frc.team2676.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Solenoid;

public class Pneumatics extends IterativeRobot{
     private Joystick DriverStick;
     private Solenoid s1,s2;                             //defines solenoids
     DoubleSolenoid rightsolenoid;
 	 DoubleSolenoid leftsolenoid;

     public Pneumatics() {
          DriverStick = new Joystick(1);             // USB port
          Compressor airCompressor = new Compressor(6);  //Digtial I/O,Relay
          airCompressor.start();                        // Start the air compressor
          //s1 = new Solenoid(RobotMap.RightMotionSolenoid);                        // Solenoid port
          //s2 = new Solenoid(RobotMap.RightFixedSolenoid);
          //s3 = new Solenoid(RobotMap.LeftFixedSolenoid);
          //s4 = new Solenoid(RobotMap.LeftMotionSolenoid);
          rightsolenoid = new DoubleSolenoid(6,4,5);
  	      leftsolenoid = new DoubleSolenoid(6,6,7);
     	}
     
     public void operatorControl() {
          if(DriverStick.getRawButton(1) == true)
          {
                //rightsolenoid.set(DoubleSolenoid.Value.kForward);
                //leftsolenoid.set(DoubleSolenoid.Value.kReverse);
        	  rightsolenoid.set(DoubleSolenoid.Value.kReverse);
       	   leftsolenoid.set(DoubleSolenoid.Value.kReverse);
          }
           if(DriverStick.getRawButton(2) == true)
           {
        	  // rightsolenoid.set(DoubleSolenoid.Value.kReverse);
        	   //leftsolenoid.set(DoubleSolenoid.Value.kForward);
        	   
        	   rightsolenoid.set(DoubleSolenoid.Value.kForward);
               leftsolenoid.set(DoubleSolenoid.Value.kForward);
           }
    }
}