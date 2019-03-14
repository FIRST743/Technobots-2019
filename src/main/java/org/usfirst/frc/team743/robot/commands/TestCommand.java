package org.usfirst.frc.team743.robot.commands;

import edu.wpi.first.wpilibj.command.InstantCommand;

/**
 *
 */
public class TestCommand extends InstantCommand {

    String commandButton = "";

    public TestCommand(String button) {
        this.commandButton = button;
    }

    // Called once when the command executes
    protected void initialize() {
    	System.out.println("Command running - " + this.commandButton);
    }
}
