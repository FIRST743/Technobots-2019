package org.usfirst.frc.team743.robot.subsystems;

import org.usfirst.frc.team743.robot.RobotMap;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.SpeedControllerGroup;

/**
 *
 */
public class ClawClimbMechanism extends Subsystem {
	
	public final double speed = 0.3;
	
    public static final SpeedControllerGroup speedGroup = new SpeedControllerGroup(
		new Talon(RobotMap.clawMotorClimb1), new Talon(RobotMap.clawMotorClimb2));


    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    public void Up() {
    	speedGroup.set(speed);
    }
    public void Down() {
    	speedGroup.set(-speed);
    }
    public void Stop() {
    	speedGroup.set(0);
    }
}
