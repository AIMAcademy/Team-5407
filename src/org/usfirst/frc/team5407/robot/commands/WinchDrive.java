package org.usfirst.frc.team5407.robot.commands;

// import org.usfirst.frc.team5407.robot.RobotMap;
// import org.usfirst.frc0.MyRobot.Robot;

// import edu.wpi.first.wpilibj.SpeedController;
// import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class WinchDrive extends CommandBase {

    public WinchDrive() {
        // Use requires() here to declare subsystem dependencies
		requires(winch);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }
	
	public void execute() {
	    winch.driveWinch(oi.getStick1());
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
