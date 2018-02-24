package org.usfirst.frc.team743.robot.commands;

import org.usfirst.frc.team743.robot.Robot;

import edu.wpi.first.wpilibj.command.InstantCommand;

/**
 *
 */
public class ExtendSmallPneumatic extends InstantCommand {

    public ExtendSmallPneumatic() {
        requires(Robot.climbingMechanism);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called once when the command executes
    protected void initialize() {
    	Robot.climbingMechanism.extendSmallPneumatic();
    	System.out.println("Small Pneumatic - EXTENDING");
    }

}
