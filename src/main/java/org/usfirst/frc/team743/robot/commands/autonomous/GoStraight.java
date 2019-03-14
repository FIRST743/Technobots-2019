package org.usfirst.frc.team743.robot.commands.autonomous;

import org.usfirst.frc.team743.robot.commands.TimedAutonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class GoStraight extends TimedAutonomous {
	
	private final CommandGroup commandGroup3 = new CommandGroup();

	public GoStraight(double timeout) {
		super(timeout);
		commandGroup3.addSequential( new MoveY(1.5,-.75));
//		commandGroup3.addSequential(new MoveY(1.5,-.75));
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void stop_autonomous() {
		// TODO Auto-generated method stub
		commandGroup3.cancel();

	}

	@Override
	protected void start_autonomous() {
		// TODO Auto-generated method stub
		commandGroup3.start();

	}

}