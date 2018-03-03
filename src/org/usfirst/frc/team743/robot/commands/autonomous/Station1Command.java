package org.usfirst.frc.team743.robot.commands.autonomous;

import org.usfirst.frc.team743.robot.commands.*;

import edu.wpi.first.wpilibj.command.CommandGroup;


public class Station1Command extends TimedAutonomous {

	private final CommandGroup groupCommand = new CommandGroup();
	
	public Station1Command(double timeout) {
		super(timeout);
		// TODO Auto-generated constructor stub
		
//		groupCommand.addSequential(new MoveY(2, .2));
//		groupCommand.addSequential(new MoveY(2, -.2));
		groupCommand.addSequential(new MoveBigActuator(2, 1));
		groupCommand.addSequential(new MoveBigActuator(2, -1));
		groupCommand.addSequential(new MoveClaw(1, true));
		groupCommand.addSequential(new MoveClaw(1, false));
	}

	@Override
	protected void stop_autonomous() {
		// TODO Auto-generated method stub

		groupCommand.cancel();
		
	}

	@Override
	protected void start_autonomous() {
		
		groupCommand.start();
		
		// TODO Auto-generated method stub

	}

}
