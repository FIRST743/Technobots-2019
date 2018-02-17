package org.usfirst.frc.team743.robot.subsystems;

import edu.wpi.first.wpilibj.drive.MecanumDrive;

import org.usfirst.frc.team743.robot.RobotMap;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class DriveSystem extends Subsystem {

    public static Talon topRightTalon = new Talon(RobotMap.topRightMotor);
    public static Talon topLeftTalon  = new Talon(RobotMap.topLeftMotor);
    public static Talon bottomRightTalon = new Talon(RobotMap.bottomRightMotor);
    public static Talon bottomLeftTalon = new Talon(RobotMap.bottomLeftMotor);
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    /**
     * Sets the direction and speed of all wheel motors
     * @param speed
     * has to be between -1.0  and 1.0 decimal
     */
    public static void setSpeed(double speed){
    	topRightTalon.set(speed);
    	topLeftTalon.set(speed);
    	bottomLeftTalon.set(speed);
    	bottomRightTalon.set(speed);
    }
    
    /**
     * Sets the direction and speed of all top wheel motors
     * @param speed
     * has to be between -1.0 and 1.0 decimal
     */
    public static void setTopSpeed(double speed){
    	topRightTalon.set(speed);
    	topLeftTalon.set(speed);
    }
    
    /**
     * Sets the direction and speed of all bottom wheel motors
     * @param speed
     * has to be between -1.0 and 1.0 decimal
     */
    public static void setBottomSpeed(double speed){
//    	topRightTalon.set(speed);
//    	topLeftTalon.set(speed);
    }
    
    
}

