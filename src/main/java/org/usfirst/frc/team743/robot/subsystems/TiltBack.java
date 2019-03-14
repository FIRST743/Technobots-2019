package org.usfirst.frc.team743.robot.subsystems;

import org.usfirst.frc.team743.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * This is for the Pneumatic that raises/lowers the back of the robot for climbing
 */
public class TiltBack extends Subsystem {
	
	// Double Solenoid used so that the controls can be used for up and down
	DoubleSolenoid backPneumatic = new DoubleSolenoid(RobotMap.backPneumaticUp, RobotMap.backPneumaticDown);
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    public void Up() {
    	backPneumatic.set(DoubleSolenoid.Value.kForward);
    }
    
    public void Down() {
    	backPneumatic.set(DoubleSolenoid.Value.kReverse);
    }

    public void Stop() {
    	backPneumatic.set(DoubleSolenoid.Value.kOff);
    }
}