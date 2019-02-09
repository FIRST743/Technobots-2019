package org.usfirst.frc.team743.robot.commands;

import org.usfirst.frc.team743.robot.Robot;

import edu.wpi.first.wpilibj.command.InstantCommand;

/**
 *
 */
public class TiltFrontDown extends InstantCommand {

    public TiltFrontDown() {
        requires(Robot.tiltFront);
    }

    // Called once when the command executes
    protected void initialize() {
    	Robot.tiltFront.Down();
    	System.out.println("Tilt Front Down...");
    }
}
