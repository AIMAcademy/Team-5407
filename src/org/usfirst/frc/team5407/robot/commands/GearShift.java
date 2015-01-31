
package org.usfirst.frc.team5407.robot.commands;

/**
 *
 */
public class GearShift extends CommandBase {

	
	boolean finished=false;
	boolean state;
    public GearShift(boolean state) {
        // Use requires() here to declare subsystem dependencies
        requires(chassis);
        this.state = state;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	System.out.println("GearShift started");
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	chassis.setGear(state);
    	finished=true;
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return finished;
    }

    // Called once after isFinished returns true
    protected void end() {
    	System.out.println("GearShift ended");
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
