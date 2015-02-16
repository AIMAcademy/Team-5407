/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc.team5407.robot.commands;

import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team5407.robot.Robot;
import org.usfirst.frc.team5407.robot.RobotMap;

/**
 * Move the elevator to a given location. This command finishes when it is within
 * the tolerance, but leaves the PID loop running to maintain the position. Other
 * commands using the elevator should make sure they disable PID!
 */
public class SetWinchSetpoint extends Command {
    private double setpoint;
	boolean state;
	boolean finished = true;
    private AnalogPotentiometer potentiometer = RobotMap.winchPotentiometer;
    
    public SetWinchSetpoint(double setpoint) {
//    	double potPoint = potentiometer.get();
    	this.setpoint = setpoint;
        requires(Robot.winch);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        Robot.winch.enable();
        Robot.winch.setSetpoint(setpoint);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Robot.winch.onTarget();
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
