package org.usfirst.frc.team743.robot.subsystems;

import org.usfirst.frc.team743.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class ClimbingMechanism extends Subsystem {
	
	DoubleSolenoid smallPneumatic = new DoubleSolenoid(RobotMap.pneumaticClimberSmallUp, RobotMap.pneumaticClimberSmallDown);
	
	private static Talon climbingActuator = new Talon(RobotMap.actuatorClimb);
	
	// Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
public static void setClimbingActuator(double speed) {
    	
    	climbingActuator.set(speed);
    	
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