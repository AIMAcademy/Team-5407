package org.usfirst.frc.team5407.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team5407.robot.OI;
import org.usfirst.frc.team5407.robot.subsystems.Arm;
import org.usfirst.frc.team5407.robot.subsystems.Chassis;
import org.usfirst.frc.team5407.robot.subsystems.Claw;
import org.usfirst.frc.team5407.robot.subsystems.ClawLift;
import org.usfirst.frc.team5407.robot.subsystems.Winch;

/**
 * The base for all commands. All atomic commands should subclass CommandBase.
 * CommandBase stores creates and stores each control system. To access a
 * subsystem elsewhere in your code in your code use
 * CommandBase.exampleSubsystem
 * 
 * @author Author
 */
public abstract class CommandBase extends Command {

	public static OI oi;
	// Create a single static instance of all of your subsystems
	public static Chassis chassis = new Chassis();
	public static Claw claw = new Claw();
	public static Arm arm = new Arm();
	public static Winch winch = new Winch();
	public static ClawLift clawlift = new ClawLift();

	public static void init() {
		// This MUST be here. If the OI creates Commands (which it very likely
		// will), constructing it during the construction of CommandBase (from
		// which commands extend), subsystems are not guaranteed to be
		// yet. Thus, their requires() statements may grab null pointers. Bad
		// news. Don't move it.
		oi = new OI();

		// Show what command your subsystem is running on the SmartDashboard
		// SmartDashboard.putData(claw);
	}

	public CommandBase(String name) {
		super(name);
	}

	public CommandBase() {
		super();
	}

	static class chassis {

		public chassis() {
		}
	}

	static class claw {

		public claw() {
		}
	}

	static class arm {

		public arm() {
		}
	}
	
	static class winch {

		public winch() {
		}
	}
	
	static class clawlift {

		public clawlift() {
		}
	}
	
}
