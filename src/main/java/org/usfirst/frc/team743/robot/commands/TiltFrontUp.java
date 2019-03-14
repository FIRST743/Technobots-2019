package org.usfirst.frc.team743.robot.commands;

import org.usfirst.frc.team743.robot.Robot;

import edu.wpi.first.wpilibj.command.InstantCommand;

/**
 *
 */
public class TiltFrontUp extends InstantCommand {

    public TiltFrontUp() {
        requires(Robot.tiltFront);
    }

    // Called once when the command executes
    protected void initialize() {
    	Robot.tiltFront.Up();
    	System.out.println("Tilt Front Up...");
    }
}
