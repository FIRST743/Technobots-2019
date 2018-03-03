package org.usfirst.frc.team743.robot.commands;

import org.usfirst.frc.team743.robot.Robot;

import edu.wpi.first.wpilibj.command.InstantCommand;

/**
 *
 */
public class RetractSmallPneumatic extends InstantCommand {

    public RetractSmallPneumatic() {
        requires(Robot.climbingMechanism);
    }

    // Called once when the command executes
    protected void initialize() {
    	Robot.climbingMechanism.retractSmallPneumatic();
    	System.out.println("Small Pneumatic - RETRACTING");
    }

}
