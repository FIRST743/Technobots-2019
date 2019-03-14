package org.usfirst.frc.team743.robot.commands;

import edu.wpi.first.wpilibj.command.TimedCommand;

/**
 *
 */
public abstract class TimedAutonomous extends TimedCommand {

    public TimedAutonomous(double timeout) {
        super(timeout);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	this.start_autonomous();
    	
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
    // this is the command the we should use to run the autonomous mode
    protected abstract void start_autonomous();
}
