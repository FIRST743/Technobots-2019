package org.usfirst.frc.team743.robot.subsystems;

import edu.wpi.first.wpilibj.drive.MecanumDrive;

import org.usfirst.frc.team743.robot.RobotMap;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class TalonObjects extends Subsystem {

    private Talon topRightTalon = new Talon(RobotMap.topRightMotor);
    private Talon topLeftTalon  = new Talon(RobotMap.topLeftMotor);
    private Talon bottomRightTalon = new Talon(RobotMap.bottomRightMotor);
    private Talon bottomLeftTalon = new Talon(RobotMap.bottomLeftMotor);
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    /**
     * description
     * @param speed
     * has to be between -1.0  and 1.0 decimal
     */
    public void setSpeed(double speed){
    	topRightTalon.set(speed);
    	topLeftTalon.set(speed);
    	bottomLeftTalon.set(speed);
    	bottomRightTalon.set(speed);
    }
    
    public void setTopSpeed(double speed){
    	topRightTalon.set(speed);
    	topLeftTalon.set(speed);
    }
    
    public void setBottomSpeed(double speed){
    	topRightTalon.set(speed);
    	topLeftTalon.set(speed);
    }
    
    public Talon getTopRightTalon() {
  		return topRightTalon;
  	}

  	public void setTopRightTalon(Talon topRightTalon) {
  		this.topRightTalon = topRightTalon;
  	}

  	public Talon getTopLeftTalon() {
  		return topLeftTalon;
  	}

  	public void setTopLeftTalon(Talon topLeftTalon) {
  		this.topLeftTalon = topLeftTalon;
  	}

  	public Talon getBottomRightTalon() {
  		return bottomRightTalon;
  	}

  	public void setBottomRightTalon(Talon bottomRightTalon) {
  		this.bottomRightTalon = bottomRightTalon;
  	}

  	public Talon getBottomLeftTalon() {
  		return bottomLeftTalon;
  	}

  	public void setBottomLeftTalon(Talon bottomLeftTalon) {
  		this.bottomLeftTalon = bottomLeftTalon;
  	}
}

