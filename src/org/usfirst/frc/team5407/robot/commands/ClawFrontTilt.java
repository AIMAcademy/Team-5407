package org.usfirst.frc.team5407.robot.commands;

import org.usfirst.frc.team5407.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ClawFrontTilt extends Command {
	
//    private int tilt;
//	boolean finished = false;

    public ClawFrontTilt() {
        // Use requires() here to declare subsystem dependencies
//    	this.tilt = tilt;
		requires(Robot.claw_front);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        Robot.claw_front.clawFrontTilt();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
//    	Robot.claw_front.motor.set(tilt);
//        Robot.claw_front.clawFrontTilt();
//        finished = true;
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
//    	return finished;
    }

    // Called once after isFinished returns true
    protected void end() {
//    	Robot.claw_front.doNothing();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
