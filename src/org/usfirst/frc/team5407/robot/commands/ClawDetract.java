package org.usfirst.frc.team5407.robot.commands;

import org.usfirst.frc.team5407.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class ClawDetract extends Command{

	public ClawDetract(int i) {
		requires(Robot.claw);
		setTimeout(i);
	}
	protected void initialize() {
		// TODO Auto-generated method stub
		
	}

	protected void execute() {
		Robot.claw.motor.set(-.3);
	}

	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return isTimedOut();
	}

	protected void end() {
		// TODO Auto-generated method stub
		
	}

	protected void interrupted() {
		// TODO Auto-generated method stub
		
	}

}
