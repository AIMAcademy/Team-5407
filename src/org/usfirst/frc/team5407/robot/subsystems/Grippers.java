package org.usfirst.frc.team5407.robot.subsystems;

import org.usfirst.frc.team5407.robot.RobotMap;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Grippers extends Subsystem {
	
	Solenoid solenoidGrippers = new Solenoid(RobotMap.Solenoid_Grippers);
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
		solenoidGrippers.set(false);
    }
    
	public void grippersOpenClose(boolean state) {
		solenoidGrippers.set(state);
	}
}

