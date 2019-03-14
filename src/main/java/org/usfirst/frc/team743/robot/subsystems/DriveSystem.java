package org.usfirst.frc.team743.robot.subsystems;

import org.usfirst.frc.team743.robot.RobotMap;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class DriveSystem extends Subsystem {

    public Talon leftFirstTalon = new Talon(RobotMap.motorLeftFirst);
    public Talon leftSecondTalon  = new Talon(RobotMap.motorLeftSecond);
    
    public Talon rightFirstTalon = new Talon(RobotMap.motorRightFirst);
    public Talon rightSecondTalon = new Talon(RobotMap.motorRightSecond);
    
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
    	leftFirstTalon.set(speed); 
    	leftSecondTalon.set(speed);
    	rightFirstTalon.set(speed);
    	rightSecondTalon.set(speed);
    }
    
    /**
     * Sets the direction and speed of all top wheel motors
     * @param speed
     * has to be between -1.0 and 1.0 decimal
     */
    public void setTopSpeed(double speed){
    	leftFirstTalon.set(speed); 
    	leftSecondTalon.set(speed);
    	rightFirstTalon.set(speed);
    	rightSecondTalon.set(speed);
    }
    
    /**
     * Sets the direction and speed of all bottom wheel motors
     * @param speed
     * has to be between -1.0 and 1.0 decimal
     */
    public void setBottomSpeed(double speed){
    	leftFirstTalon.set(speed); 
    	leftSecondTalon.set(speed);
    	rightFirstTalon.set(speed);
    	rightSecondTalon.set(speed);
    }
    
    /**
     * Sets the direction and speed of all right wheel motors
     * @param speed
     * has to be between -1.0 and 1.0 decimal
     */
    public void setRightSpeed(double speed){
    	
    	rightFirstTalon.set(speed);
    	rightSecondTalon.set(speed);
    }

    /**
     * Sets the direction and speed of all left wheel motors
     * @param speed
     * has to be between -1.0 and 1.0 decimal
     */
    public void setLeftSpeed(double speed){
    	leftFirstTalon.set(speed); 
    	leftSecondTalon.set(speed);
    }
}