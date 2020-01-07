/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team743.robot;

import org.usfirst.frc.team743.robot.commands.autonomous.DoNothing;
import org.usfirst.frc.team743.robot.commands.autonomous.GoStraight;
import org.usfirst.frc.team743.robot.subsystems.ClawClimbMechanism;
import org.usfirst.frc.team743.robot.subsystems.ClawMechanism;
import org.usfirst.frc.team743.robot.subsystems.TiltBack;
import org.usfirst.frc.team743.robot.subsystems.TiltFront;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.SpeedControllerGroup;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.properties file in the
 * project.
 */
public class Robot extends TimedRobot {
	
	private static final int AUTONOMOUS_MODE_LENGTH = 15;
	public static double driveX = 0.0;
	public static double driveY = 0.0;
	public static double driveZ = 0.0;

	// Pneumatics
	public static final ClawMechanism clawMechanism = new ClawMechanism();
	public static final TiltFront tiltFront = new TiltFront(); 		
	public static final TiltBack tiltBack = new TiltBack(); 

	// Motors
	public static final ClawClimbMechanism clawClimbMechanism = new ClawClimbMechanism();

	// Drive system
	public static final SpeedControllerGroup leftTalonGroup = new SpeedControllerGroup(
		new Talon(RobotMap.motorLeftFirst), new Talon(RobotMap.motorLeftSecond));
	public static final SpeedControllerGroup rightTalonGroup = new SpeedControllerGroup(
		new Talon(RobotMap.motorRightFirst), new Talon(RobotMap.motorRightSecond));
	public static final DifferentialDrive drive = new DifferentialDrive(
		leftTalonGroup, rightTalonGroup
	);

	public static OI m_oi;

	private static final Compressor compressor = new Compressor(RobotMap.compressorPort);
	
	//Instantiating the variable containing the autonomous command.
	Command m_autonomousCommand;
	
	//Instantiating the chooser for the SmartDashboard
	SendableChooser<Command> m_chooser = new SendableChooser<>();


	private void checkDriverStationInputs() {
		boolean db_station1 = SmartDashboard.getBoolean(RobotMap.DB_BUTTON_1, false);
		boolean db_station2 = SmartDashboard.getBoolean(RobotMap.DB_BUTTON_2, false);
		boolean db_station3 = SmartDashboard.getBoolean(RobotMap.DB_BUTTON_3, false);

		System.out.println("Dashboard values: " + 
				" Station1: " + db_station1 +
				" Station2: " + db_station2 +
				" Station3: " + db_station3);
/*
		if (db_station1) {
			m_autonomousCommand = new Station1Command(Robot.AUTONOMOUS_MODE_LENGTH);
		}
		else if (db_station2) {
			m_autonomousCommand = new Station2Command(Robot.AUTONOMOUS_MODE_LENGTH);			  
		}
		else if (db_station3) {
			m_autonomousCommand = new Station3Command(Robot.AUTONOMOUS_MODE_LENGTH);			  
		}
*/
	}
	private void controlledRobotInit() {
		this.checkDriverStationInputs();
	}
	private void controlledRobotPeriodic() {
		Scheduler.getInstance().run();

		double x = -m_oi._xboxController.getY(Hand.kLeft);
		double y = -m_oi._xboxController.getY(Hand.kRight);

		double speedAdjust = .75;
		drive.tankDrive(x* speedAdjust,y*speedAdjust);
	}


	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		m_oi = new OI();

		try {
			UsbCamera camera = CameraServer.getInstance().startAutomaticCapture("Claw", 0);
			camera.setResolution(320, 240);
			camera.setFPS(15);
			
			UsbCamera camera2 = CameraServer.getInstance().startAutomaticCapture("Motion",1);             
			camera.setResolution(320, 240);
			camera.setFPS(10);
		}
		catch (Exception e) {
			System.out.println("An error occurred while setting up the cameras");
			System.out.println(e);
		}
		// m_chooser.addDefault("Straight", new GoStraight(AUTONOMOUS_MODE_LENGTH));
		// m_chooser.addObject("Nothing", new DoNothing(AUTONOMOUS_MODE_LENGTH));
		
		SmartDashboard.putData("Auto mode", m_chooser);
	}


	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	@Override
	public void disabledInit() {
		System.out.println("disabledInit... Initializing Disabled Mode");
		this.checkDriverStationInputs();
	}
	/*
	 * This occurs periodically while the robot is disabled
	 */
	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
		compressor.setClosedLoopControl(false);
	}

	/**
	 * This function is called when initializing Autonomous mode
	 */
	@Override
	public void autonomousInit() {
		System.out.println("autonomousInit... Initializing Autonomous Mode");

		m_autonomousCommand = m_chooser.getSelected();

		if (m_autonomousCommand != null) {
			m_autonomousCommand.start();
		}
	}
	/**
	 * This function is called periodically during autonomous.
	 */
	@Override
	public void autonomousPeriodic() {
		this.controlledRobotPeriodic();
	}


	/*
	 * This function is called when initializing TeleOperated mode
	 */
	@Override
	public void teleopInit() {
		System.out.println("teleopInit... Initializing TeleOperator Mode");
		this.controlledRobotInit();
	}
	/**
	 * This get called perioidically during TeleOperated mode
	 */
	@Override
	public void teleopPeriodic() {
		this.controlledRobotPeriodic();
	}
	
	/*
	 * This function is called when initializing Test mode
	 */
	@Override
	public void testInit() {
		System.out.println("testInit... Initializing Test Mode");
		this.controlledRobotInit();	
	}
	/**
	 * This function is called periodically during Test mode
	 */
	@Override
	public void testPeriodic() {
		this.controlledRobotPeriodic();
	}
}
