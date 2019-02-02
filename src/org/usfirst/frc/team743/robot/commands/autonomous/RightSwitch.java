package org.usfirst.frc.team743.robot.commands.autonomous;

import org.usfirst.frc.team743.robot.commands.TimedAutonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class RightSwitch extends TimedAutonomous {
	
	private final CommandGroup commandGroup2 = new CommandGroup();

	public RightSwitch(double timeout) {
		super(timeout);
		
//		commandGroup2.addSequential( new MoveX(2.5, -.5));
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void stop_autonomous() {
		// TODO Auto-generated method stub
		commandGroup2.cancel();
	}

	@Override
	protected void start_autonomous() {
		// TODO Auto-generated method stub
		commandGroup2.start();
	}

}
