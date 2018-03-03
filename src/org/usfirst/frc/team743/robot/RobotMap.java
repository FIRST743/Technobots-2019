/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team743.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	
	 public static int motorTopLeft = 1;
	 public static int motorTopRight = 0;
	 public static int motorBottomLeft = 2;
	 public static int motorBottomRight = 3;
	 
	 public static int actuatorBig = 4;
	 public static int actuatorSmall = 5;
	 
	 public static int rangefinderPort = 7;
	 public static int rangefinderModule = 8;
	 
	 public static int pneumaticClawLeft = 0;
	 public static int pneumaticClawRight = 2;
	 
	 public static int pneumaticClimberBig = 3;
	 public static int pneumaticClimberSmall = 4;
	 
	 public static int pneumaticClawPush = 5;
	 
}
