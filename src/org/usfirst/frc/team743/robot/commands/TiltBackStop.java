package org.usfirst.frc.team743.robot.commands;

import org.usfirst.frc.team743.robot.Robot;

import edu.wpi.first.wpilibj.command.InstantCommand;

/**
 *
 */
public class TiltBackStop extends InstantCommand {

    public TiltBackStop() {
        requires(Robot.tiltBack);
    }

    // Called once when the command executes
    protected void initialize() {
    	Robot.tiltBack.Stop();
    	System.out.println("Tilt Back Stop...");
    }
}
