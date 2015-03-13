package org.usfirst.frc.team5407.robot.commands;

import org.usfirst.frc.team5407.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class WinchAuton extends Command {
	
	private double m_timeout;
	private double speed;

	public WinchAuton(double timeout, double speed) {
		m_timeout = timeout;
		this.speed = speed;
		setTimeout(m_timeout);
		requires(Robot.winch);
	}

	protected void initialize() {
	}

	protected void execute() {
		Robot.winch.driveWinch(speed);
	}

	protected boolean isFinished() {
		return isTimedOut();
	}

	protected void end() {
	}

	protected void interrupted() {
		// TODO Auto-generated method stub
	}

}
