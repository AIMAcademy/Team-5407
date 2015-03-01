/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc.team5407.robot.subsystems;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Talon;

import org.usfirst.frc.team5407.robot.OI;
import org.usfirst.frc.team5407.robot.Robot;
import org.usfirst.frc.team5407.robot.commands.DriveWithJoystick;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 * @author robotics
 */
public class Chassis extends Subsystem {
	RobotDrive drive;
	Talon talonLeft, talonRight;
	Solenoid solenoid_gear_shift = new Solenoid(0);
	boolean reverseState = false;

	// Put methods for controlling this subsystem
	// here. Call these from Commands.

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		setDefaultCommand(new DriveWithJoystick());
		solenoid_gear_shift.set(false);
	}

	public Chassis() {
		talonLeft = new Talon(0);
		talonRight = new Talon(1);
		drive = new RobotDrive(talonLeft, talonRight);// defines rearLeft,rearRight Motors
		drive.setInvertedMotor(RobotDrive.MotorType.kRearLeft, true);
		drive.setInvertedMotor(RobotDrive.MotorType.kRearRight, true);
		drive.setSafetyEnabled(false);
	}

	public void straightFull() {
		drive.arcadeDrive(-1, 0.0);
	}
	
	public void straight75() {
		drive.arcadeDrive(-0.75, 0.0);
	}
	
	public void pivotRight() {
		drive.tankDrive(-.25, -.5);
	}

	public void turnLeft() {
		drive.arcadeDrive(0.0, -0.5);
	}

	public void turnRight() {
		drive.arcadeDrive(0.0, 0.5);
	}

	public void driveBackwards75() {
		drive.arcadeDrive(0.75, 0.0);
	}
	
	public void driveTurn90() {
		drive.arcadeDrive(0, -1);
	}
	
	public void doNothing() {
		drive.arcadeDrive(0, 0.0);
	}
	
	public void reverseDrive(boolean state) {
		if(state == false){ // can also be (!state)
			reverseState = false;
			drive.setInvertedMotor(RobotDrive.MotorType.kRearLeft, true);
			drive.setInvertedMotor(RobotDrive.MotorType.kRearRight, true);
		}
		else if(state == true){  // can also be (state)
			reverseState = true;
			drive.setInvertedMotor(RobotDrive.MotorType.kRearLeft, false);
			drive.setInvertedMotor(RobotDrive.MotorType.kRearRight, false);
		}
		else {
			reverseState = false;
			drive.setInvertedMotor(RobotDrive.MotorType.kRearLeft, true);
			drive.setInvertedMotor(RobotDrive.MotorType.kRearRight, true);
		}
	}

	public void driveWithJoystick(Joystick stick0) {
		if(reverseState==true) {
			drive.arcadeDrive(stick0.getY(), -stick0.getX());
		}
		else {
			drive.arcadeDrive(stick0);
		}
	}

	boolean lockLowGear = false; // Allows other systems to override gear selection and force to use low gear.

	public void setGear(boolean state) {
		solenoid_gear_shift.set(lockLowGear ? true : state);
	}

}
