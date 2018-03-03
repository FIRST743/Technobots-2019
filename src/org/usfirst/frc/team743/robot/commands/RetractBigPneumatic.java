package org.usfirst.frc.team743.robot.commands;

import org.usfirst.frc.team743.robot.Robot;

import edu.wpi.first.wpilibj.command.InstantCommand;

/**
 *
 */
public class RetractBigPneumatic extends InstantCommand {

    public RetractBigPneumatic() {
        requires(Robot.climbingMechanism);
    }

    // Called once when the command executes
    protected void initialize() {
    	Robot.climbingMechanism.retractBigPneumatic();
    	System.out.println("Big Pneumatic - RETRACTING");
	}
}
