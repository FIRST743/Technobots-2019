package org.usfirst.frc.team743.robot.commands;

import org.usfirst.frc.team743.robot.Robot;

import edu.wpi.first.wpilibj.command.InstantCommand;

/**
 *
 */
public class RetractBigActuator extends InstantCommand {

    public RetractBigActuator() {
    	requires(Robot.actuators);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

	// Called once when the command executes
	@SuppressWarnings("static-access")
	protected void initialize() {
		Robot.actuators.setBigActuator(-1.0);
		System.out.println("Big Actuator - RETRACTING");
	}
}
