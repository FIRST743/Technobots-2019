package org.usfirst.frc.team743.robot.commands.autonomous;

import org.usfirst.frc.team743.robot.Robot;

import edu.wpi.first.wpilibj.command.TimedCommand;

public class MoveClaw extends TimedCommand {

	private boolean _open;
	
	public MoveClaw(double timeout, boolean open) {
		super(timeout);
		
		requires(Robot.clawMechanism);
		this._open = open;
	}

    // Called just before this Command runs the first time
    @SuppressWarnings("static-access")
	protected void initialize() {
    	if (this._open) {
    		Robot.clawMechanism.openClaw();
    	}
    	else {
    		Robot.clawMechanism.closeClaw();
    	}
    }
}
