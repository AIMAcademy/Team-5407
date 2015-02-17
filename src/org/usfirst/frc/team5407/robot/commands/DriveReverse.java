package org.usfirst.frc.team5407.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team5407.robot.OI;
import org.usfirst.frc.team5407.robot.Robot;

/**
 *
 */
public class DriveReverse extends Command {

	boolean finished = false;
	boolean state;

	public DriveReverse(boolean state) {
		// Use requires() here to declare subsystem dependencies
		requires(Robot.chassis);
		this.state = state;
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		System.out.println("Drive Reverse started");
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		Robot.chassis.reverseDrive(state);
		finished = true;
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return finished;
	}

	// Called once after isFinished returns true
	protected void end() {
		System.out.println("Reverse Drive ended");
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
	}
}
