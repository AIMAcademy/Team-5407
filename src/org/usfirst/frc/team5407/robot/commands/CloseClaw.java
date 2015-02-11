/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc.team5407.robot.commands;

import org.usfirst.frc.team5407.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 * @author robotics
 */
public class CloseClaw extends Command { //import command remove commandbase

	public CloseClaw() {
		// Use requires() here to declare subsystem dependencies
		requires(Robot.claw); //TODO Robot.claw and import Robot
		setTimeout(.4);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		Robot.claw.close();
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return isTimedOut();
	}

	// Called once after isFinished returns true
	protected void end() {
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
	}
}
