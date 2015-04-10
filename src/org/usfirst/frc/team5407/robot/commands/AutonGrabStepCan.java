package org.usfirst.frc.team5407.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutonGrabStepCan extends CommandGroup {
    
    public  AutonGrabStepCan() {
    	addSequential(new ClawBackOpenClose(true));
    	addSequential(new DriveRobot(0.25, 1, 0));
    	addSequential(new ClawBackAuton(1.85, -1));
    	addSequential(new ClawBackOpenClose(false));
    	addSequential(new ClawBackAuton(1.50, 1));
    	addSequential(new DriveRobot(3, -.75, 0));
		addSequential(new DriveRobot(1.5, 0, -0.55));  // 90 degree turn left
		addSequential(new DriveRobot(0.50, 0.5, 0));

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
