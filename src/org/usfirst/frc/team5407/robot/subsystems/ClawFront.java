package org.usfirst.frc.team5407.robot.subsystems;

import org.usfirst.frc.team5407.robot.OI;
import org.usfirst.frc.team5407.robot.RobotMap;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class ClawFront extends Subsystem {
	public SpeedController motor = new VictorSP(RobotMap.VictorSP_Claw_Front);
	Solenoid solenoidClawFront = new Solenoid(RobotMap.Solenoid_Claw_Front);
  
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
	public void doNothing() {
		motor.set(0);
	}

	public void clawCloseFront(boolean state) {
		solenoidClawFront.set(state);
	}
	
	public void clawFrontTilt(int tilt) {
		motor.set(tilt);
	}
		
}



