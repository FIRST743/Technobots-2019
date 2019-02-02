package org.usfirst.frc.team743.robot.subsystems;

import org.usfirst.frc.team743.robot.RobotMap;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Actuators extends Subsystem {

	private static Talon bigActuator = new Talon(RobotMap.actuatorBig);
	private static Talon smallActuator = new Talon(RobotMap.actuatorSmall);
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    public static void setBigActuator(double speed) {
    	bigActuator.set(speed);
    }
    
    public static void setSmallActuator(double speed) {
    	smallActuator.set(speed);
    }
}

