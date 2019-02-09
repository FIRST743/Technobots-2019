package org.usfirst.frc.team743.robot.commands;

import org.usfirst.frc.team743.robot.Robot;

import edu.wpi.first.wpilibj.command.InstantCommand;

/**
 *
 */
public class ClawClimbUp extends InstantCommand {

    public ClawClimbUp() {
        requires(Robot.clawClimbMechanism);
    }

    // Called once when the command executes
    protected void initialize() {
    	Robot.clawClimbMechanism.Up();
    	System.out.println("Claw climbing up...");
    }
}
