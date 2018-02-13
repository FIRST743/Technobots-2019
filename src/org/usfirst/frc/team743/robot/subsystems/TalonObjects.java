package org.usfirst.frc.team743.robot.subsystems;

import edu.wpi.first.wpilibj.drive.MecanumDrive;

import org.usfirst.frc.team743.robot.RobotMap;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class TalonObjects extends Subsystem {

    private static Talon topRightTalon = new Talon(RobotMap.topRightMotor);
    private static Talon topLeftTalon  = new Talon(RobotMap.topLeftMotor);
    private static Talon bottomRightTalon = new Talon(RobotMap.bottomRightMotor);
    private static Talon bottomLeftTalon = new Talon(RobotMap.bottomLeftMotor);
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    /**
     * description
     * @param speed
     * has to be between -1.0  and 1.0 decimal
     */
    public static void setSpeed(double speed){
    	topRightTalon.set(speed);
    	topLeftTalon.set(speed);
    	bottomLeftTalon.set(speed);
    	bottomRightTalon.set(speed);
    }
    
    public static void setTopSpeed(double speed){
    	topRightTalon.set(speed);
    	topLeftTalon.set(speed);
    }
    
    public static void setBottomSpeed(double speed){
    	topRightTalon.set(speed);
    	topLeftTalon.set(speed);
    }
    
    public static Talon getTopRightTalon() {
  		return topRightTalon;
  	}

  	public static void setTopRightTalon(Talon topRightTalon) {
  		TalonObjects.topRightTalon = topRightTalon;
  	}

  	public static Talon getTopLeftTalon() {
  		return topLeftTalon;
  	}

  	public static void setTopLeftTalon(Talon topLeftTalon) {
  		TalonObjects.topLeftTalon = topLeftTalon;
  	}

  	public static Talon getBottomRightTalon() {
  		return bottomRightTalon;
  	}

  	public static void setBottomRightTalon(Talon bottomRightTalon) {
  		TalonObjects.bottomRightTalon = bottomRightTalon;
  	}

  	public static Talon getBottomLeftTalon() {
  		return bottomLeftTalon;
  	}

  	public static void setBottomLeftTalon(Talon bottomLeftTalon) {
  		TalonObjects.bottomLeftTalon = bottomLeftTalon;
  	}
}

