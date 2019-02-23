package org.usfirst.frc.team743.robot.subsystems;

import org.usfirst.frc.team743.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * This is for the Pneumatic that raises/lowers the front of the robot for climbing
 */
public class TiltFront extends Subsystem {
	
	// Double Solenoid used so that the controls can be used for up and down
	DoubleSolenoid frontPneumatic = new DoubleSolenoid(RobotMap.frontPneumaticUp, RobotMap.frontPneumaticDown);
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
   
    }
    public void Up() {
    	frontPneumatic.set(DoubleSolenoid.Value.kForward);
    }
    
    public void Down() {
    	frontPneumatic.set(DoubleSolenoid.Value.kReverse);
    }

    public void Stop() {
    	frontPneumatic.set(DoubleSolenoid.Value.kOff);
    }
    
}