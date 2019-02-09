package org.usfirst.frc.team743.robot.commands;

import org.usfirst.frc.team743.robot.Robot;

import edu.wpi.first.wpilibj.command.InstantCommand;

/**
 *
 */
public class TiltBackUp extends InstantCommand {

    public TiltBackUp() {
        requires(Robot.tiltBack);
    }

    // Called once when the command executes
    protected void initialize() {
    	Robot.tiltBack.Up();
    	System.out.println("Tilt Back Up...");
    }
}
