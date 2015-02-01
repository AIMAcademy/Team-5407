/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc.team5407.robot.commands;

/**
 *
 * @author robotics
 */
public class LeftTurn extends CommandBase {
	private double m_timeout;

	public LeftTurn(double timeout) {
		// Use requires() here to declare subsystem dependencies
		m_timeout = timeout;
		requires(chassis);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		setTimeout(m_timeout);
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		chassis.turnLeft();
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
