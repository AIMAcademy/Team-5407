/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc.team5407.robot.commands;


import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 * @author robotics
 */
public class AutonScoreCan extends CommandGroup {

	public AutonScoreCan() {
		
		// WinchAuton has two variables: (timeout, speed,)
		// DriveRobot has three variables: (timeout, speed, turn)
//		addSequential(new SetWinchSetpoint(0.52));
		addParallel(new WinchAuton(1, 1));  // TODO TEST THIS TO MAKE SURE WINCHAUTON END CODE STOPS THE MOTOR
//		addSequential(new WinchAuton(.1, 0));
		addParallel(new DriveRobot(1, 0.5, 0));
		addSequential(new DriveRobot(4, 0.5, 0));
		addSequential(new DriveRobot(1.5, 0, 0.55));  // 90 degree turn


		// addSequential(new Command2());
		// these will run in order.

		// To run multiple commands at the same time,
		// use addParallel()
		// e.g. addParallel(new Command1());
		// addSequential(new Command2());
		// Command1 and Command2 will run in parallel.
		// A command group will require all of the subsystems that each member
		// would require.
		// e.g. if Command1 requires chassis, and Command2 requires arm,
		// a CommandGroup containing them would require both the chassis and the
		// arm.
	}
}
