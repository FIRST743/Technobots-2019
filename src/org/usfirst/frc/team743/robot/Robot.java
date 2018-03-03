/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team743.robot;

import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.Talon;
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
import org.usfirst.frc.team743.robot.commands.autonomous.TimedAutonomous;
import org.usfirst.frc.team743.robot.subsystems.Actuators;
import org.usfirst.frc.team743.robot.subsystems.ClawMechanism;
import org.usfirst.frc.team743.robot.subsystems.ClimbingMechanism;
import org.usfirst.frc.team743.robot.subsystems.PushPneumatic;


/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.properties file in the
 * project.
 */
public class Robot extends TimedRobot {
	
	private static final int AUTONOMOUS_MODE_LENGTH = 15;
	
	private static final String DB_STRING_0 = "DB/String 0";
	private static final String DB_STRING_1 = "DB/String 1";
	private static final String DB_STRING_2 = "DB/String 2";
	private static final String DB_STRING_3 = "DB/String 3";
	private static final String DB_STRING_4 = "DB/String 4";
	private static final String DB_STRING_5 = "DB/String 5";
	private static final String DB_STRING_6 = "DB/String 6";
	private static final String DB_STRING_7 = "DB/String 7";
	private static final String DB_STRING_8 = "DB/String 8";
	private static final String DB_STRING_9 = "DB/String 9";

	private static final String DB_BUTTON_0 = "DB/Button 0";
	private static final String DB_BUTTON_1 = "DB/Button 1";
	private static final String DB_BUTTON_2 = "DB/Button 2";
	private static final String DB_BUTTON_3 = "DB/Button 3";

	private static final String DB_SLIDER_0 = "DB/Slider 0";
	private static final String DB_SLIDER_1 = "DB/Slider 1";
	private static final String DB_SLIDER_2 = "DB/Slider 2";
	private static final String DB_SLIDER_3 = "DB/Slider 3";
	
	
	public static final MecanumDrive mecanum = new MecanumDrive(
			DriveSystem.topLeftTalon,
			DriveSystem.topRightTalon, 
			DriveSystem.bottomRightTalon, 
			DriveSystem.bottomLeftTalon);
	public static OI m_oi;

	public static final Actuators actuators = new Actuators();
	
	//public static final ClimbingMechanism climbingMechanism = new ClimbingMechanism();
	
	//public static final ClawMechanism clawMechanism = new ClawMechanism();
	
	//public static final PushPneumatic pushPneumatic = new PushPneumatic();
	
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

		
	  String db_color = SmartDashboard.getString(Robot.DB_STRING_0, "Red");
	  boolean db_station1 = SmartDashboard.getBoolean(Robot.DB_BUTTON_1, false);
	  boolean db_station2 = SmartDashboard.getBoolean(Robot.DB_BUTTON_2, false);
	  boolean db_station3 = SmartDashboard.getBoolean(Robot.DB_BUTTON_3, false);
	  
	
	  System.out.println("Dashboard values:  Color: " + db_color + 
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
		mecanum.driveCartesian(m_oi._xboxController.getX(Hand.kLeft)*.25,
		  m_oi._xboxController.getY(Hand.kLeft)*.25, m_oi._xboxController.getX(Hand.kRight));
	}

	/**
	 * This function is called periodically during test mode.
	 */
	@Override
	public void testPeriodic() {
	}
}
