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
	
	 // TODO: Set these values
	 public static final int motorTopLeft = 1;
	 public static final int motorTopRight = 0;
	 public static final int motorBottomLeft = 2;
	 public static final int motorBottomRight = 3;

	 public static final int clawMotorClimb = 0;
	 public static final int clawPneumaticOpen = 0;
	 public static final int clawPneumaticClose = 0;

	 public static final int frontPneumaticUp = 0;
	 public static final int frontPneumaticDown = 0;
	 
	 public static final int backPneumaticUp = 0;
	 public static final int backPneumaticDown = 0;
	 
	 
	 public static final String DB_STRING_0 = "DB/String 0";
	 public static final String DB_STRING_1 = "DB/String 1";
	 public static final String DB_STRING_2 = "DB/String 2";
	 public static final String DB_STRING_3 = "DB/String 3";
	 public static final String DB_STRING_4 = "DB/String 4";
	 public static final String DB_STRING_5 = "DB/String 5";
	 public static final String DB_STRING_6 = "DB/String 6";
	 public static final String DB_STRING_7 = "DB/String 7";
	 public static final String DB_STRING_8 = "DB/String 8";
	 public static final String DB_STRING_9 = "DB/String 9";

	 public static final String DB_BUTTON_0 = "DB/Button 0";
	 public static final String DB_BUTTON_1 = "DB/Button 1";
	 public static final String DB_BUTTON_2 = "DB/Button 2";
	 public static final String DB_BUTTON_3 = "DB/Button 3";

	 public static final String DB_SLIDER_0 = "DB/Slider 0";
	 public static final String DB_SLIDER_1 = "DB/Slider 1";
	 public static final String DB_SLIDER_2 = "DB/Slider 2";
	 public static final String DB_SLIDER_3 = "DB/Slider 3";
	 
}
