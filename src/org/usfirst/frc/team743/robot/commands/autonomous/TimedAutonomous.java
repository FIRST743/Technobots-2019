package org.usfirst.frc.team743.robot.commands.autonomous;

import edu.wpi.first.wpilibj.command.TimedCommand;

/**
 *
 */
public class TimedAutonomous extends TimedCommand {

    public TimedAutonomous(double timeout) {
        super(timeout);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);//
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
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
    protected void stop_autonomous() {
    	
    }
}
