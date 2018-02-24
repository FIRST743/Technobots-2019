package org.usfirst.frc.team743.robot.subsystems;

import org.usfirst.frc.team743.robot.RobotMap;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class ClawMechanism extends Subsystem {

	Solenoid leftPneumatic = new Solenoid(RobotMap.pneumaticClawLeft);
	Solenoid rightPneumatic = new Solenoid(RobotMap.pneumaticClawRight);
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void closeClaw() {
    	leftPneumatic.set(true);
    	rightPneumatic.set(true);
    }
    
    public void openClaw() {
    	leftPneumatic.set(false);
    	rightPneumatic.set(false);
    }
}

