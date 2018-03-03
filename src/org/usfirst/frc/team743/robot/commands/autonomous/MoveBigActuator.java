package org.usfirst.frc.team743.robot.commands.autonomous;

import org.usfirst.frc.team743.robot.Robot;

import edu.wpi.first.wpilibj.command.TimedCommand;

public class MoveBigActuator extends TimedCommand {

	private double _speed;
	
	public MoveBigActuator(double timeout, double speed) {
		super(timeout);
		
		requires(Robot.actuators);
		this._speed = speed;
	}
	
    // Called just before this Command runs the first time
    @SuppressWarnings("static-access")
	protected void initialize() {
    	Robot.actuators.setBigActuator(this._speed);
    }

    // Called once after timeout
    @SuppressWarnings("static-access")
    protected void end() {
    	Robot.actuators.setBigActuator(0);
    }

//    // Called when another command which requires one or more of the same
//    // subsystems is scheduled to run
//    @SuppressWarnings("static-access")
//	protected void interrupted() {
//    	Robot.actuators.setBigActuator(0);
//    }
}
