/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc.team5407.robot.subsystems;

import org.usfirst.frc.team5407.robot.commands.ClawDoNothing;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 * @author robotics
 */
public class Claw extends Subsystem {
	SpeedController motor = new Victor(3);

	// here. Call these from Commands.

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		setDefaultCommand(new ClawDoNothing());
	}

	public void open() {
		motor.set(.5);

	}

	public void close() {
		motor.set(-0.5);

	}

	public void doNothing() {
		motor.set(0);

	}
}
