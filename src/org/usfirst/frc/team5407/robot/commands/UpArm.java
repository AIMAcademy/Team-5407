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
public class UpArm extends CommandBase {
    
    public UpArm() {
        // Use requires() here to declare subsystem dependencies
        requires(arm);
        // setTimeout(.4);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        // arm.initializeCounterup();
        arm.up();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        arm.up();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return arm.isSwitchSetup();
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
