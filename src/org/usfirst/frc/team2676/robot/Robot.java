/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team2676.robot;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.PWMTalonSRX;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.properties file in the
 * project.
 */
public class Robot extends IterativeRobot {
	private static final String kDefaultAuto = "Default";
	private static final String kCustomAuto = "My Auto";
	private String m_autoSelected;
	private SendableChooser<String> m_chooser = new SendableChooser<>();
	//Drive drive;
	Controls controls;
	DifferentialDrive dDrive;
	Talon left;
	Talon right;
	Talon climber;
	PWMTalonSRX arm1;
	XboxController driveStick;
	XboxController operateStick;
	Solenoid armSolenoid;
	Timer timer;
	Pneumatics pneumatics;
	//DoubleSolenoid rightsolenoid;
	//DoubleSolenoid leftsolenoid;
	
	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		timer = new Timer();
		timer.start();
		left = new Talon(0);
		right = new Talon(1);
		climber = new Talon(4);
		
		arm1 = new PWMTalonSRX(2);
		arm1.set(0);
		left.set(.6);
		right.set(0.60);
		
		dDrive = new DifferentialDrive(left, right);
		
		driveStick = new XboxController(0);
		operateStick = new XboxController(1);
		pneumatics = new Pneumatics();
		//armSolenoid = new Solenoid(1); // PCM ID of Solenoid 
		//rightsolenoid = new DoubleSolenoid(4,5);
	    //leftsolenoid = new DoubleSolenoid(6,7);

		m_chooser.addDefault("Default Auto", kDefaultAuto);
		m_chooser.addObject("My Auto", kCustomAuto);
		SmartDashboard.putData("Auto choices", m_chooser);
		CameraServer.getInstance().startAutomaticCapture();
        //drive = new Drive();
        controls = new Controls();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString line to get the auto name from the text box below the Gyro
	 *
	 * <p>You can add additional auto modes by adding additional comparisons to
	 * the switch structure below with additional strings. If using the
	 * SendableChooser make sure to add them to the chooser code above as well.
	 */
	long autoStart = 0;
	@Override
	public void autonomousInit() {
		//m_autoSelected = m_chooser.getSelected();
		//autoSelected = SmartDashboard.getString("Auto Selector", "defaultAuto");
		//System.out.println("Auto selected: " + m_autoSelected);
	    autoStart = System.currentTimeMillis();
	}

	/**
	 * This function is called periodically during autonomous.
	 */
	
	@Override
	public void autonomousPeriodic() {
		//switch (m_autoSelected) {
			//case kCustomAuto:
				// Put custom auto code here
				//break;
			//case kDefaultAuto:
				//if (timer.get()<3)
				//{
					//dDrive.arcadeDrive(0.5, 0);	
				//}
				//else
				//{
					//dDrive.arcadeDrive(0, 0);
				//}
			//default:
				
				//break;
		double speed = 1.0, timeout = 3;
        if (System.currentTimeMillis() - autoStart < (timeout * 1000)) {
            java.util.Arrays.stream((new Object[]{ left})).forEach((Object s) -> ((edu.wpi.first.wpilibj.SpeedController)s).set(.5));
            java.util.Arrays.stream((new Object[]{ right})).forEach((Object s) -> ((edu.wpi.first.wpilibj.SpeedController)s).set(-.5));
        }
	}
	

	/**
	 * This function is called periodically during operator control.
	 */
	@Override
	public void teleopPeriodic() {
		//drive.drive(controls.getDrivePowerL());
		//drive.drive(controls.getDrivePowerL(), controls.getDrivePowerR());
		dDrive.arcadeDrive(-driveStick.getRawAxis(1), driveStick.getRawAxis(4));
		pneumatics.operatorControl();
		if(operateStick.getTriggerAxis(Hand.kRight )>.2) {
			arm1.set(.3);

		}
		
		else if (operateStick.getTriggerAxis(Hand.kLeft)>.2) {
		arm1.set(-.3);
		}
		else {
			arm1.set(0);
		}
		if(operateStick.getYButton()) {
			climber.set(.5);
		}
		else
		{
			climber.set(0);
		}
	}

	/**
	 * This function is called periodically during test mode.
	 */
	@Override
	public void testPeriodic() {
	}
}
