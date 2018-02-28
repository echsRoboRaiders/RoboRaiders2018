package org.usfirst.frc.team2676.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Solenoid;

public class Pneumatics extends IterativeRobot{
     private Joystick DriverStick;
     private Solenoid s1,s2;                             //defines solenoids

     public Pneumatics() {
          DriverStick = new Joystick(1);             // USB port
          Compressor airCompressor = new Compressor();  //Digtial I/O,Relay
          airCompressor.start();                        // Start the air compressor

          s1 = new Solenoid(RobotMap.RightMotionSolenoid);                        // Solenoid port
          s2 = new Solenoid(RobotMap.RightFixedSolenoid);
          //s3 = new Solenoid(RobotMap.LeftFixedSolenoid);
          //s4 = new Solenoid(RobotMap.LeftMotionSolenoid);
     	}
     
     public void operatorControl() {
          if(DriverStick.getRawButton(1) == true)
          {
                s1.set(true);
                s2.set(false);
          }
           if(DriverStick.getRawButton(2) == true)
           {
                s1.set(false);
                s2.set(true);
           }
    }
}