package org.usfirst.frc.team743.robot.subsystems;

import org.usfirst.frc.team743.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class ClawClimbMechanism extends Subsystem {
	
	// TODO: find an appropriate speed 
	public final double speed = 0.1;
	
	public Talon climbMotor = new Talon(RobotMap.clawMotorClimb);
	

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    public void Up() {
    	climbMotor.set(speed);
    }
    public void Down() {
    	climbMotor.set(-speed);
    }
    public void Stop() {
    	climbMotor.set(0);
    }
}
