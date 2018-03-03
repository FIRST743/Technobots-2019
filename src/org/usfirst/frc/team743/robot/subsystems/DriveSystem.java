package org.usfirst.frc.team743.robot.subsystems;

import org.usfirst.frc.team743.robot.RobotMap;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class DriveSystem extends Subsystem {

    public Talon topRightTalon = new Talon(RobotMap.motorTopRight);
    public Talon topLeftTalon  = new Talon(RobotMap.motorTopLeft);
    public Talon bottomRightTalon = new Talon(RobotMap.motorBottomRight);
    public Talon bottomLeftTalon = new Talon(RobotMap.motorBottomLeft);
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    /**
     * Sets the direction and speed of all wheel motors
     * @param speed
     * has to be between -1.0  and 1.0 decimal
     */
    public void setSpeed(double speed){
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
    public void setTopSpeed(double speed){
    	topRightTalon.set(speed);
    	topLeftTalon.set(speed);
    }
    
    /**
     * Sets the direction and speed of all bottom wheel motors
     * @param speed
     * has to be between -1.0 and 1.0 decimal
     */
    public void setBottomSpeed(double speed){
    	topRightTalon.set(speed);
    	topLeftTalon.set(speed);
    }
    
    /**
     * Sets the direction and speed of all right wheel motors
     * @param speed
     * has to be between -1.0 and 1.0 decimal
     */
    public void setRightSpeed(double speed){
    	topRightTalon.set(speed);
    	bottomRightTalon.set(speed);
    }

    /**
     * Sets the direction and speed of all left wheel motors
     * @param speed
     * has to be between -1.0 and 1.0 decimal
     */
    public void setLeftSpeed(double speed){
    	topLeftTalon.set(speed);
    	bottomLeftTalon.set(speed);
    }
}