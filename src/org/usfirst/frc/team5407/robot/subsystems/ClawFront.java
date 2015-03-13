package org.usfirst.frc.team5407.robot.subsystems;

import org.usfirst.frc.team5407.robot.OI;
import org.usfirst.frc.team5407.robot.RobotMap;
import org.usfirst.frc.team5407.robot.commands.ClawBackDrive;
import org.usfirst.frc.team5407.robot.commands.ClawFrontTilt;

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
		setDefaultCommand(new ClawFrontTilt());  	
    }
	
//	public void clawFrontTilt(int tilt) {
//		motor.set(tilt);
//	}
	
	public void clawFrontTilt() {
		if(OI.get2_1() == true){
			motor.set(1);
		}
		else if(OI.get3_1() == true){
			motor.set(-1);
		}
		else {
			motor.set(0);
		}
	}
	
	public void clawCloseFront(boolean state) {
		solenoidClawFront.set(state);
	}
	
	public void doNothing() {
		motor.set(0);
	}
}



