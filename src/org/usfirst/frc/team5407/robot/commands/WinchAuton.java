package org.usfirst.frc.team5407.robot.commands;

import org.usfirst.frc.team5407.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class WinchAuton extends Command {

	public WinchAuton(int i) {
		requires(Robot.winch);
		setTimeout(i);
	}

	protected void initialize() {
		
		
	}

	protected void execute() {
		Robot.winch.driveWinch(1);
	}

	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return isTimedOut();
	}

	protected void end() {
		
	}

	protected void interrupted() {
		// TODO Auto-generated method stub
		
	}

}
