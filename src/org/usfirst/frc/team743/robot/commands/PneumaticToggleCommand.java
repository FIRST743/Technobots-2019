package org.usfirst.frc.team743.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.ConditionalCommand;

public class PneumaticToggleCommand extends ConditionalCommand {

	private boolean isExtended = false;
	
	@Override
	public synchronized void start() {
		super.start();
		isExtended = !isExtended;
	}
	
	public PneumaticToggleCommand(Command onTrue) {
		super(onTrue);
		// TODO Auto-generated constructor stub
	}

	public PneumaticToggleCommand(Command onTrue, Command onFalse) {
		super(onTrue, onFalse);
		// TODO Auto-generated constructor stub
	}

	public PneumaticToggleCommand(String name, Command onTrue) {
		super(name, onTrue);
		// TODO Auto-generated constructor stub
	}

	public PneumaticToggleCommand(String name, Command onTrue, Command onFalse) {
		super(name, onTrue, onFalse);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected boolean condition() {
		// TODO Auto-generated method stub
		return isExtended;
	}

}
