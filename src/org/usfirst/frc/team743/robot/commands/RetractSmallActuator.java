package org.usfirst.frc.team743.robot.commands;

import org.usfirst.frc.team743.robot.Robot;

import edu.wpi.first.wpilibj.command.InstantCommand;

/**
 *
 */
public class RetractSmallActuator extends InstantCommand {

    public RetractSmallActuator() {
        
    	requires(Robot.actuators);
        
    }

    // Called once when the command executes
    @SuppressWarnings("static-access")
	protected void initialize() {
    	Robot.actuators.setSmallActuator(-1);
    	Robot.actuators.setBigActuator(-1);
    	System.out.println("Small Actuator - RETRACTING");
    }

}
