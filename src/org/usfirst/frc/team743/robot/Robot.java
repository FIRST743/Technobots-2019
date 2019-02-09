/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team743.robot;

import org.usfirst.frc.team743.robot.commands.autonomous.*;
import org.usfirst.frc.team743.robot.subsystems.*;

import edu.wpi.cscore.CvSink;
import edu.wpi.cscore.CvSource;
import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.opencv.core.Mat;
import org.opencv.imgproc.Imgproc;


/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.properties file in the
 * project.
 */
public class Robot extends TimedRobot {
	
	
	// TODO:  Enter the time the command will run.
	private static final int AUTONOMOUS_MODE_LENGTH = 15;
	
	//Variables for controlling the wheels during autonomous
	public static double driveX ;
	public static double driveY ;
	public static double driveZ ;
	
	//Constructors with are instantiating the subsystems
	public static final DriveSystem driveSystem = new DriveSystem();
	
	public static final ClawMechanism clawMechanism = new ClawMechanism();
	
	public static final ClawClimbMechanism clawClimbMechanism = new ClawClimbMechanism();
	
	public static final TiltFront tiltFront = new TiltFront(); 
			
	public static final TiltBack tiltBack = new TiltBack(); 
	
	public static final MecanumDrive mecanum = new MecanumDrive(
			driveSystem.topLeftTalon,
			driveSystem.bottomLeftTalon,
			driveSystem.topRightTalon,
			driveSystem.bottomRightTalon);
	
	public static OI m_oi;

	private static final Compressor compressor = new Compressor(0);
	
	//Instantiating the variable containing the autonomous command.
	Command m_autonomousCommand;
	
	//Instantiating the chooser for the SmartDashboard
	SendableChooser<Command> m_chooser = new SendableChooser<>();

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		m_oi = new OI();
		
		compressor.setClosedLoopControl(true);
		new Thread(() -> {
            UsbCamera camera = CameraServer.getInstance().startAutomaticCapture();
            camera.setResolution(640, 480);
            
            CvSink cvSink = CameraServer.getInstance().getVideo();
            CvSource outputStream = CameraServer.getInstance().putVideo("Blur", 820, 820);
            
            Mat source = new Mat();
            Mat output = new Mat();
            
            while(!Thread.interrupted()) {
                cvSink.grabFrame(source);
                Imgproc.cvtColor(source, output, Imgproc.COLOR_BGR2GRAY);
                outputStream.putFrame(output);
            }
        }).start();
		
		//Constructing adding options to the smart dashboard.
//		m_chooser.addObject("Default Auto", new Station1Command(AUTONOMOUS_MODE_LENGTH));
//		m_chooser.addObject("Middle", new Station2Command(AUTONOMOUS_MODE_LENGTH));
//		m_chooser.addObject("Right", new Station3Command(AUTONOMOUS_MODE_LENGTH));
		m_chooser.addDefault("Straight", new GoStraight(AUTONOMOUS_MODE_LENGTH));
		m_chooser.addObject("Nothing", new DoNothing(AUTONOMOUS_MODE_LENGTH));
		
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
	 * 
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
	
		compressor.setClosedLoopControl(true);
		
//		String gameData;
//		gameData = DriverStation.getInstance().getGameSpecificMessage();
//                if(gameData.length() > 0)
//                {
//		  if(gameData.charAt(0) == 'L')
//		  {
//			//Put left auto code here
//		  } else {
//			//Put right auto code here
//		  }
//                }
		
		m_autonomousCommand = m_chooser.getSelected();

//		  boolean db_station1 = SmartDashboard.getBoolean(RobotMap.DB_BUTTON_1, false);
//		  boolean db_station2 = SmartDashboard.getBoolean(RobotMap.DB_BUTTON_2, false);
//		  boolean db_station3 = SmartDashboard.getBoolean(RobotMap.DB_BUTTON_3, false);
//
//		  System.out.println("Dashboard values: " + 
//				  " Station1: " + db_station1 +
//				  " Station2: " + db_station2 +
//				  " Station3: " + db_station3);
//		  
//		  if (db_station1) {
//			  m_autonomousCommand = new Station1Command(Robot.AUTONOMOUS_MODE_LENGTH);
//		  }
//		  else if (db_station2) {
//			  m_autonomousCommand = new Station2Command(Robot.AUTONOMOUS_MODE_LENGTH);			  
//		  }
//		  else if (db_station3) {
//			  m_autonomousCommand = new Station3Command(Robot.AUTONOMOUS_MODE_LENGTH);			  
//		  }		 

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
				driveZ,
				0
		);
	}

	@Override
	public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		compressor.setClosedLoopControl(true);
		
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
				m_oi._xboxController.getX(Hand.kLeft)*.90,
				m_oi._xboxController.getY(Hand.kLeft)*.90, 
				m_oi._xboxController.getRawAxis(2)*.90
		); 
	}
	
	/**
	 * This function is called periodically during test mode.
	 */
	@Override
	public void testPeriodic() {
	}


	
}
