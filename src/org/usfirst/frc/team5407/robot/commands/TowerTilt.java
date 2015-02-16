package org.usfirst.frc.team5407.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team5407.robot.Robot;

/**
 *
 */
public class TowerTilt extends Command {

	boolean finished = false;
	boolean state;

	public TowerTilt(boolean state) {
		// Use requires() here to declare subsystem dependencies
		requires(Robot.winch);
		this.state = state;
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		System.out.println("TowerTilt started");
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		Robot.winch.towerTilt(state);
		finished = true;
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return finished;
	}

	// Called once after isFinished returns true
	protected void end() {
		System.out.println("TowerTilt ended");
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
	}
}
