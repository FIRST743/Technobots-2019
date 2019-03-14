package org.usfirst.frc.team743.robot.commands;

import org.usfirst.frc.team743.robot.Robot;

import edu.wpi.first.wpilibj.command.InstantCommand;

/**
 *
 */
public class TiltBackDown extends InstantCommand {

    public TiltBackDown() {
        requires(Robot.tiltBack);
    }

    // Called once when the command executes
    protected void initialize() {
    	Robot.tiltBack.Down();
    	System.out.println("Tilt Back Down...");
    }
}
