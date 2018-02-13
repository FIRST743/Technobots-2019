package org.usfirst.frc.team743.robot.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class PneumaticsSubsystem extends Subsystem {

	Solenoid pneumaticLeft = new Solenoid(0);
	Solenoid pneumaticRight = new Solenoid(1);
	// Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    
    public void turnOn() {
    	pneumaticLeft.set(true);
    	pneumaticLeft.set(true);
    	pneumaticLeft.set(true);
    	pneumaticLeft.set(true);
    }
}

