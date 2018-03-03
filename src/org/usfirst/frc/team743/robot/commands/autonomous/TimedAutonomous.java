package org.usfirst.frc.team743.robot.commands.autonomous;

import org.usfirst.frc.team743.robot.Robot;

import edu.wpi.first.wpilibj.command.TimedCommand;

/**
 *
 */
public abstract class TimedAutonomous extends TimedCommand {

    public TimedAutonomous(double timeout) {
        super(timeout);
        requires(Robot.actuators);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);//
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	this.run_sequence();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Called once after timeout
    protected void end() {
    	this.stop_autonomous();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	this.stop_autonomous();
    }
    
    // this is the command that we should execute any time we want to stop the autonomous command
    protected abstract void stop_autonomous();
    
    // this is the command the should be actually execute the sequence of commands during autonomous mode
    protected abstract void run_sequence();
}
