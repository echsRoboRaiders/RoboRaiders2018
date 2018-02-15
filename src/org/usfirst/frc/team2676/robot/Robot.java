/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team2676.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
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
	private AutoRoutines autoSelected;
	private SendableChooser<AutoRoutines> autoChooser = new SendableChooser<>();
	public static long startTime;
	Drive drive;
	Controls controls;
	AutoTest test;

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		autoChooser.addDefault(AutoRoutines.DriveForward.toString(), AutoRoutines.DriveForward);
		autoChooser.addObject(AutoRoutines.DriveForward.toString(), AutoRoutines.DriveForward);
		autoChooser.addObject(AutoRoutines.PowerCubeSwitch.toString(), AutoRoutines.PowerCubeSwitch);
		autoChooser.addObject(AutoRoutines.DoNothing.toString(), AutoRoutines.DoNothing);
		SmartDashboard.putData("Autonomous Choices", autoChooser);
        drive = new Drive();
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
	@Override
	public void autonomousInit() {
		autoSelected = autoChooser.getSelected();
		 //autoSelected = SmartDashboard.getString("Auto Selector", AutoRoutines.DriveForward);
		System.out.println("Auto selected: " + autoSelected);
		startTime = System.currentTimeMillis();
	}

	/**
	 * This function is called periodically during autonomous.
	 */
	
	@Override
	public void autonomousPeriodic() {
		/*
		switch (autoSelected) {
			case DriveForward:
				// Put custom auto code here
				break;
			default:
				// Put default auto code here
				break;
		}
		*/
		test = new AutoTest();
	}

	/**
	 * This function is called periodically during operator control.
	 */
	@Override
	public void teleopPeriodic() {
		drive.drive(controls.getDrivePowerL(), controls.getDrivePowerR());
	}

	/**
	 * This function is called periodically during test mode.
	 */
	@Override
	public void testPeriodic() {
	}
}
