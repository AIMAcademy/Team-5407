/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc.team5407.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

import edu.wpi.first.wpilibj.Counter;
import edu.wpi.first.wpilibj.DigitalInput;
import org.usfirst.frc.team5407.robot.RobotMap;
import org.usfirst.frc.team5407.robot.commands.ArmDoNothing;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Victor;

/**
 *
 * @author robotics
 */
public class Arm extends Subsystem {
	DigitalInput limitSwitchdown = new DigitalInput(8);
	DigitalInput limitSwitchup = new DigitalInput(9);
	SpeedController motor = new Victor(8);
	Counter counterdown = new Counter(limitSwitchdown);
	Counter counterup = new Counter(limitSwitchup);

	// int stop = 0;
	// public boolean finished = false;

	public boolean isSwitchSetdown() {
		return !limitSwitchdown.get();
	}

	public boolean isSwitchSetup() {
		return !limitSwitchup.get();
	}

	public void initializeCounterdown() {
		// counterdown.reset();
	}

	public void initializeCounterup() {
		// counterup.reset();
	}

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		setDefaultCommand(new ArmDoNothing());
	}

	public void up() {
		motor.set(RobotMap.armSpeed);
		// motor.set(Relay.Value.kForward);
	}

	public void down() {
		motor.set(-RobotMap.armSpeed);
		// motor.set(Relay.Value.kReverse);
	}

	public void doNothing() {
		motor.set(0);
		// motor.set(Relay.Value.kOff);
	}
}
