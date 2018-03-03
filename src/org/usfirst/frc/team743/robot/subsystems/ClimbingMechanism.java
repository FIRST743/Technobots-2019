package org.usfirst.frc.team743.robot.subsystems;

import org.usfirst.frc.team743.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class ClimbingMechanism extends Subsystem {

	DoubleSolenoid bigPneumatic = new DoubleSolenoid(RobotMap.pneumaticClimberBigUp, RobotMap.pneumaticClimberBigDown);
	DoubleSolenoid smallPneumatic = new DoubleSolenoid(RobotMap.pneumaticClimberSmallUp, RobotMap.pneumaticClimberSmallDown);
	// Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    
    public void extendBigPneumatic() {
    	bigPneumatic.set(DoubleSolenoid.Value.kForward);
    	
    }
    
    public void stopBigPneumatic() {
    	bigPneumatic.set(DoubleSolenoid.Value.kOff);
    }
    
    public void retractBigPneumatic() {
    	bigPneumatic.set(DoubleSolenoid.Value.kReverse);
    }
    
    public void extendSmallPneumatic() {
    	smallPneumatic.set(DoubleSolenoid.Value.kForward);
    }
    
    public void stopSmallPneumatic() {
    	smallPneumatic.set(DoubleSolenoid.Value.kOff);
    }
    
    public void retractSmallPneumatic() {
    	smallPneumatic.set(DoubleSolenoid.Value.kReverse);
    }
}