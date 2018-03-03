package org.usfirst.frc.team743.robot.commands;

import org.usfirst.frc.team743.robot.Robot;

import edu.wpi.first.wpilibj.command.InstantCommand;

/**
 *
 */
public class ExtendBigPneumatic extends InstantCommand {

    public ExtendBigPneumatic() {
        requires(Robot.climbingMechanism);
    }

    // Called once when the command executes
    protected void initialize() {
    	Robot.climbingMechanism.extendBigPneumatic();
    	System.out.println("Big Pneumatic - EXTENDING");
    }
}
