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
public class DownArm extends CommandBase {
    
    public DownArm() {
        // Use requires() here to declare subsystem dependencies
        requires(arm);
        //setTimeout(.4);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        // arm.initializeCounterdown();
        arm.down();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        arm.down();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return arm.isSwitchSetdown();
    }

    // Called once after isFinished returns true
    protected void end() {
        arm.doNothing();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        end();
    }
}
