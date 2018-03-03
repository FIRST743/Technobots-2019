/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team743.robot;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team743.robot.subsystems.DriveSystem;
import org.usfirst.frc.team743.robot.commands.autonomous.Station1Command;
import org.usfirst.frc.team743.robot.commands.autonomous.Station2Command;
import org.usfirst.frc.team743.robot.commands.autonomous.Station3Command;
import org.usfirst.frc.team743.robot.subsystems.Actuators;
import org.usfirst.frc.team743.robot.subsystems.ClawMechanism;
import org.usfirst.frc.team743.robot.subsystems.ClimbingMechanism;


/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.properties file in the
 * project.
 */
public class Robot extends TimedRobot {
	
	// TODO:  Enter the time the command will run.
	private static final int AUTONOMOUS_MODE_LENGTH = 10;
	
	public static double driveX = 0;
	public static double driveY = 0;

	public static final Actuators actuators = new Actuators();
	public static final DriveSystem driveSystem = new DriveSystem();
	public static final ClawMechanism clawMechanism = new ClawMechanism();
	public static final ClimbingMechanism climbingMechanism = new ClimbingMechanism();

	
	public static final MecanumDrive mecanum = new MecanumDrive(
			driveSystem.topLeftTalon,
			driveSystem.topRightTalon, 
			driveSystem.bottomRightTalon, 
			driveSystem.bottomLeftTalon);
	
	public static OI m_oi;

	private static final Compressor compressor = new Compressor(0);
	
	
	Command m_autonomousCommand;
	SendableChooser<Command> m_chooser = new SendableChooser<>();

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		m_oi = new OI();
		//m_chooser.addDefault("Default Auto", new ExampleCommand());
		//m_chooser.addObject("My Auto", new ExampleCommand());
		SmartDashboard.putData("Auto mode", m_chooser);
		compressor.setClosedLoopControl(true);
	}

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	@Override
	public void disabledInit() {
		
	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString code to get the auto name from the text box below the Gyro
	 *
	 * <p>You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons
	 * to the switch structure below with additional strings & commands.
	 */
	@Override
	public void autonomousInit() {
		m_autonomousCommand = m_chooser.getSelected();

		  boolean db_station1 = SmartDashboard.getBoolean(RobotMap.DB_BUTTON_1, false);
		  boolean db_station2 = SmartDashboard.getBoolean(RobotMap.DB_BUTTON_2, false);
		  boolean db_station3 = SmartDashboard.getBoolean(RobotMap.DB_BUTTON_3, false);

		  System.out.println("Dashboard values: " + 
				  " Station1: " + db_station1 +
				  " Station2: " + db_station2 +
				  " Station3: " + db_station3);
		  
		  if (db_station1) {
			  m_autonomousCommand = new Station1Command(Robot.AUTONOMOUS_MODE_LENGTH);
		  }
		  else if (db_station2) {
			  m_autonomousCommand = new Station2Command(Robot.AUTONOMOUS_MODE_LENGTH);			  
		  }
		  else if (db_station3) {
			  m_autonomousCommand = new Station3Command(Robot.AUTONOMOUS_MODE_LENGTH);			  
		  }		 

		// schedule the autonomous command (example)
		if (m_autonomousCommand != null) {
			m_autonomousCommand.start();
		}
	}

	/**
	 * This function is called periodically during autonomous.
	 */
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
		
		mecanum.driveCartesian(
				driveX,
				driveY, 
				0,
				0
		);
	}

	@Override
	public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		if (m_autonomousCommand != null) {
			m_autonomousCommand.cancel();
		}
		
	}

	/**
	 * This function is called periodically during operator control.
	 */
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
		mecanum.driveCartesian(
				m_oi._xboxController.getX(Hand.kLeft)*.5,
				m_oi._xboxController.getY(Hand.kLeft)*.5, 
				0,
				0
		);
	}
	
	/**
	 * This function is called periodically during test mode.
	 */
	@Override
	public void testPeriodic() {
	}


	
}
