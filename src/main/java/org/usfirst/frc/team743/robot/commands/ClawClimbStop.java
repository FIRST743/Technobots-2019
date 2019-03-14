package org.usfirst.frc.team743.robot.commands;

import org.usfirst.frc.team743.robot.Robot;

import edu.wpi.first.wpilibj.command.InstantCommand;

/**
 *
 */
public class ClawClimbStop extends InstantCommand {

    public ClawClimbStop() {
        requires(Robot.clawClimbMechanism);
    }

    // Called once when the command executes
    protected void initialize() {
    	Robot.clawClimbMechanism.Stop();
    	System.out.println("Claw climbing stopped...");
    }
}
