package org.usfirst.frc.team743.robot.subsystems;

import org.usfirst.frc.team743.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class ClawMechanism extends Subsystem {

	DoubleSolenoid clawPneumatics = new DoubleSolenoid(RobotMap.clawPneumaticOpen,RobotMap.clawPneumaticClose);
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void closeClaw() {
    	clawPneumatics.set(DoubleSolenoid.Value.kForward);
    }
    
    public void openClaw() {
    	clawPneumatics.set(DoubleSolenoid.Value.kReverse);
    }
}