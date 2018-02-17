package org.usfirst.frc.team743.robot.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class ClimbingMechanism extends Subsystem {

	/*Solenoid bigPneumatic = new Solenoid(0);
	Solenoid smallPneumatic = new Solenoid(1);*/
	// Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    
    public void extendBigPneumatic() {
//    	bigPneumatic.set(true);
    }
    
    public void retractBigPneumatic() {
//    	bigPneumatic.set(false);
    }
    
    public void extendSmallPneumatic() {
//    	smallPneumatic.set(true);
    }
    
    public void retractSmallPneumatic() {
//    	smallPneumatic.set(false);
    }
    
    public void extendBothPneumatics() {
//    	bigPneumatic.set(true);
//    	smallPneumatic.set(true);
    }
    
    public void retractBothPneumatics() {
//    	bigPneumatic.set(false);
//    	smallPneumatic.set(false);
    }
}

