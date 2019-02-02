package org.usfirst.frc.team743.robot.commands;

import org.usfirst.frc.team743.robot.Robot;

import edu.wpi.first.wpilibj.command.InstantCommand;

/**
 *
 */
public class StopSmallActuator extends InstantCommand {

    public StopSmallActuator() {
        requires(Robot.actuators);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called once when the command executes
    @SuppressWarnings("static-access")
	protected void initialize() {
    	Robot.actuators.setSmallActuator(0);
    	Robot.actuators.setSmallActuator(0);
    }

}
