package org.usfirst.frc.team5407.robot.commands;

import org.usfirst.frc.team5407.robot.OI;
import org.usfirst.frc.team5407.robot.Robot;
import org.usfirst.frc.team5407.robot.RobotMap;

import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

// import org.usfirst.frc.team5407.robot.RobotMap;
// import org.usfirst.frc0.MyRobot.Robot;

// import edu.wpi.first.wpilibj.SpeedController;
// import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class WinchDrive extends Command {
	
    DigitalInput winchLimitTop = RobotMap.winchLimitTop;
    DigitalInput winchLimitBottom = RobotMap.winchLimitBottom;
//    RobotMap.winchLimitTop.get();

    public WinchDrive() {
        // Use requires() here to declare subsystem dependencies
		requires(Robot.winch);
    }
    
//	public boolean isTopSwitchOpen() {
//		return winchLimitTop.get();
//	}
//
//	public boolean isTopSwitchSet() {
//		return limitSwitchup.get();
//	}

    // Called just before this Command runs the first time
    protected void initialize() {
        Robot.winch.disable();
    }
	
	public void execute() {
			if (Math.abs(OI.getStickY()) > 0.1) { //Adds a deadband to the joystick input
			    Robot.winch.driveWinch(OI.getStickY());
			}
			else {
				Robot.winch.driveWinch(0.0);			
			}
	}

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
