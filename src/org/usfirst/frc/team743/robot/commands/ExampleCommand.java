package org.usfirst.frc.team743.robot.commands;

import edu.wpi.first.wpilibj.command.InstantCommand;

/**
 *
 */
public class ExampleCommand extends InstantCommand {

    public ExampleCommand() {
        super();
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called once when the command executes
    protected void initialize() {
    	System.out.println("A button was pressed");
    }

}
