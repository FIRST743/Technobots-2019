package org.usfirst.frc.team743.robot.commands;

import org.usfirst.frc.team743.robot.Robot;

import edu.wpi.first.wpilibj.command.InstantCommand;

/**
 *
 */
public class ExtendBigActuator extends InstantCommand {

	public ExtendBigActuator() {
		requires(Robot.actuators);
	}

	// Called once when the command executes
	@SuppressWarnings("static-access")
	protected void initialize() {
		Robot.actuators.setBigActuator(1);
		System.out.println("Big Actuator - EXTENDING");
	}
}
