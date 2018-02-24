package org.usfirst.frc.team743.robot.commands;

import org.usfirst.frc.team743.robot.Robot;

import edu.wpi.first.wpilibj.command.InstantCommand;

/**
 *
 */
public class CloseClaw extends InstantCommand {

    public CloseClaw() {
        requires(Robot.clawMechanism);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called once when the command executes
    protected void initialize() {
    	Robot.clawMechanism.closeClaw();
    	System.out.println("Closing claw...");
    }

}
