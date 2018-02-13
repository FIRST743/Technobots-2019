package org.usfirst.frc.team743.robot.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class ClawPneumatics extends Subsystem {

	Solenoid leftPneumatic = new Solenoid(2);
	Solenoid rightPneumatic = new Solenoid(3);
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

