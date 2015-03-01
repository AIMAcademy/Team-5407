/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc.team5407.robot.subsystems;

import org.usfirst.frc.team5407.robot.OI;
import org.usfirst.frc.team5407.robot.RobotMap;
import org.usfirst.frc.team5407.robot.commands.ClawDoNothing;
import org.usfirst.frc.team5407.robot.commands.ClawDrive;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 * @author robotics
 */
public class Claw extends Subsystem {
	public SpeedController motor = new VictorSP(3);
	Solenoid solenoid_claw_close = new Solenoid(2);
    DigitalInput clawLimitRetract = RobotMap.clawLimitRetract;

	// here. Call these from Commands.

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		setDefaultCommand(new ClawDrive());
	}

//	public void open() {
//		motor.set(.5);
//	}
//
//	public void close() {
//		motor.set(-0.5);
//	}

	public void driveClaw(double speed) {
//	  motor.set(speed);
		if(OI.getStick2Y() < -0.1){
			motor.set(speed);
		}
		else if(OI.getStick2Y() > 0.1){
			if(RobotMap.clawLimitRetract.get() == false) {
				motor.set(0);
			}
			else {
				motor.set(speed);
			}
		}
		else {
			motor.set(0);
		}
}

	
	public void doNothing() {
		motor.set(0);
	}

	public void clawClose(boolean state) {
		solenoid_claw_close.set(state);
	}
}
