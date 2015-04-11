package org.usfirst.frc.team5407.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutonGrabStepCanSlowBump extends CommandGroup {
    
    public  AutonGrabStepCanSlowBump() {
    	addSequential(new ClawBackOpenClose(true));		// open claw
    	addSequential(new DriveRobot(0.25, 1, 0));		// drive forwards into creates
    	addSequential(new DriveRobot(0.1, 0, 0));		// pause for .1 seconds
    	addSequential(new ClawBackAuton(1.6, -1));		// extend claw back 
    	addSequential(new ClawBackOpenClose(false));	// close claw
    	addSequential(new DriveRobot(0.25, 0, 0));		// pause for .25 seconds
    	addSequential(new ClawBackAuton(1.25, 1));		// retract claw 
    	addSequential(new DriveRobot(7.5, -.5, 0));		// drive backwards for 6 seconds
		addSequential(new DriveRobot(1.5, 0, 0.6));  	// 90 degree turn right
		addSequential(new DriveRobot(0.50, 0.5, 0)); 	// drive robot forwards 

        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    }
}
