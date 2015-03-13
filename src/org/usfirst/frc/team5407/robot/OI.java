package org.usfirst.frc.team5407.robot;

import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team5407.robot.commands.ClawBackOpenClose;
import org.usfirst.frc.team5407.robot.commands.ClawFrontOpenClose;
import org.usfirst.frc.team5407.robot.commands.ClawFrontTilt;
import org.usfirst.frc.team5407.robot.commands.DownArm;
import org.usfirst.frc.team5407.robot.commands.DriveReverse;
import org.usfirst.frc.team5407.robot.commands.GrippersOpenClose;
import org.usfirst.frc.team5407.robot.commands.OpenClawBack;
import org.usfirst.frc.team5407.robot.commands.UpArm;
import org.usfirst.frc.team5407.robot.commands.GearShift;
import org.usfirst.frc.team5407.robot.commands.SetWinchSetpoint;
import org.usfirst.frc.team5407.robot.commands.WinchDoNothing;
import org.usfirst.frc.team5407.robot.commands.WinchDrive;
import org.usfirst.frc.team5407.robot.subsystems.Winch;
// import org.usfirst.frc.team5407.robot.commands.SetElevatorSetpoint;
// import org.usfirst.frc.team5407.robot.subsystems.Elevator;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	
	// TODO Make all buttons static
	
	// Map Joysticks to ports
	public static final int JOYSTICK_PORT_0 = 0;
	public static final int JOYSTICK_PORT_1 = 1;
	public static final int JOYSTICK_PORT_2 = 2;
	
	// Create variables for Joysticks
	private static Joystick stick0;
	private static Joystick stick1;
	private static Joystick stick2; 

	// Create variables for stick 0 (Logitech Extreme 3D)
	private JoystickButton trigger;
	private JoystickButton b2;
	private JoystickButton b3;
	private JoystickButton b4;
	private JoystickButton b5;
	private JoystickButton b7; 
	private JoystickButton b8; 
	private JoystickButton b9;  
	private JoystickButton b10;  
	private JoystickButton b11;  
	private JoystickButton b12;
	
	// Create variables for stick 1 (Logitech Attack 3)
	private JoystickButton trigger_1;
	private JoystickButton b2_1;
	private JoystickButton b3_1;
	private JoystickButton b5_1; 
	private JoystickButton b6_1; 
	private JoystickButton b7_1; 
	private JoystickButton b8_1; 
	private JoystickButton b9_1;  
	private JoystickButton b10_1;  
	private JoystickButton b11_1;  
	private JoystickButton b12_1; 
	
	// Create variables for stick 2 (Logitech Attack 3)
	private JoystickButton trigger_2;
	private JoystickButton b3_2;
	private JoystickButton b5_2; 
	private JoystickButton b6_2; 
	private JoystickButton b7_2; 
	private JoystickButton b8_2; 
	private JoystickButton b9_2;  
	private JoystickButton b10_2;  
	private JoystickButton b11_2;  
	private JoystickButton b12_2; 
	
	// Create property for Winch
    private static Winch winch;

//	public double liftSpeed = 0.75;
		
	public OI() {
		
		// Joysticks in ports 0 and 1
		stick0 = new Joystick(JOYSTICK_PORT_0);
		stick1 = new Joystick(JOYSTICK_PORT_1);
		stick2 = new Joystick(JOYSTICK_PORT_2);
		
		// Set winch variable to the Winch subsystem
		winch = Robot.winch;

		// Create buttons on stick 0
		trigger = new JoystickButton(stick0, 1);
		b2 = new JoystickButton(stick0, 2);
		b3 = new JoystickButton(stick0, 3);
//		b4 = new JoystickButton(stick, 4);
//		b5 = new JoystickButton(stick, 5);
//		b7 = new JoystickButton(stick, 7);
//		b8 = new JoystickButton(stick, 8);
//		b9 = new JoystickButton(stick, 9);
//		b10 = new JoystickButton(stick, 10);
//		b11 = new JoystickButton(stick, 11);
//		b12 = new JoystickButton(stick, 12);
		
		// Run commands on stick 0
		trigger.whenPressed(new GearShift(true));
		trigger.whenReleased(new GearShift(false));
//		b2.whileHeld(new UpArm());
		b2.whenPressed(new DriveReverse(true));
		b2.whenReleased(new DriveReverse(false));
		b3.whenPressed(new GrippersOpenClose(true));
		b3.whenReleased(new GrippersOpenClose(false));
//		b4.whenPressed(new OpenClaw());
//		b5.whenPressed(new CloseClaw());
//		b7.whenPressed(new SetWinchSetpoint(0));
//		b8.whenPressed(new SetWinchSetpoint(0.2));
//		b9.whenPressed(new SetWinchSetpoint(0.4));
//		b10.whenPressed(new SetWinchSetpoint(0.6));
//		b11.whenPressed(new SetWinchSetpoint(0.8));
//		b12.whenPressed(new SetWinchSetpoint(1));
		
		// Create buttons on stick 1
		trigger_1 = new JoystickButton(stick1, 1);
		b2_1 = new JoystickButton(stick1, 2); 
		b3_1 = new JoystickButton(stick1, 3);
		b5_1 = new JoystickButton(stick1, 5);
		b6_1 = new JoystickButton(stick1, 6);
		b7_1 = new JoystickButton(stick1, 7);
		b8_1 = new JoystickButton(stick1, 8);
		b9_1 = new JoystickButton(stick1, 9);
//		b10_1 = new JoystickButton(stick1, 10);
//		b11_1 = new JoystickButton(stick1, 11);
//		b12_1 = new JoystickButton(stick1, 12);
		
		// Run commands on stick 1
		trigger_1.whenPressed(new ClawFrontOpenClose(true));
		trigger_1.whenReleased(new ClawFrontOpenClose(false));
//		b2_1.whileHeld(new ClawFrontTilt());
//		b2_1.whenReleased(new ClawFrontTilt());
//      b3_1.whileHeld(new ClawFrontTilt());
//      b3_1.whenReleased(new ClawFrontTilt());
//		b5_1.whenPressed(new WinchDoNothing());
//		b6_1.whileHeld(holdWinchPotPoint());
		b6_1.whileHeld(new SetWinchSetpoint(0.3));
		b7_1.whileHeld(new SetWinchSetpoint(0.3));
		b8_1.whileHeld(new SetWinchSetpoint(0.4));
		b9_1.whileHeld(new SetWinchSetpoint(0.5));
//		b10_1.whenPressed(new SetWinchSetpoint(0.6));
//		b11_1.whenPressed(new SetWinchSetpoint(0.8));
//		b12_1.whenPressed(new SetWinchSetpoint(1));
		
		// Create buttons on stick 2
		trigger_2 = new JoystickButton(stick2, 1);
//		b3_2 = new JoystickButton(stick2, 3);
//		b6_2 = new JoystickButton(stick2, 6);
//		b7_2 = new JoystickButton(stick2, 7);
//		b8_2 = new JoystickButton(stick2, 8);
//		b9_2 = new JoystickButton(stick2, 9);
		
		// Run commands on stick 2
		trigger_2.whenPressed(new ClawBackOpenClose(true));
		trigger_2.whenReleased(new ClawBackOpenClose(false));
//		b3_2.whenPressed(new GrippersOpenClose(true));
//		b3_2.whenReleased(new GrippersOpenClose(false));		
		
    	// Put buttons on the SmartDashboard
//        SmartDashboard.putData("Winch 1 Tote", new SetWinchSetpoint(0.3));
//        SmartDashboard.putData("Winch 2 Totes", new SetWinchSetpoint(0.45));
//        SmartDashboard.putData("Winch 3 Totes", new SetWinchSetpoint(0.6));
	}

	public static Joystick getJoystick0() {
		return stick0;
	}
	
	public static double getStickY() {
	    return stick1.getY(); // Invert with minus sign if needed
	}
	
	public static double getStick2Y() {
	    return stick2.getY(); // Invert with minus sign if needed
	}
	
	public static boolean get2_1() {
	    return stick1.getRawButton(2);
	}
	
	public static boolean get3_1() {
	    return stick1.getRawButton(3);
	}
	
	
//	private Command holdWinchPotPoint() {
////	    double currentPotPoint = winch.returnPIDInput();
////	    SmartDashboard.putNumber("Potentiometer currentPotPoint", currentPotPoint);
////	    return new SetWinchSetpoint(currentPotPoint);
////	    return new WinchDoNothing();
////	    return new WinchGetSetPosition();
//	    return new WinchGetPotPosition();
//	}
	
	// // CREATING BUTTONS
	// One type of button is a joystick button which is any button on a
	// joystick.
	// You create one by telling it which joystick it's on and which button
	// number it is.
	// Joystick stick = new Joystick(port);
	// Button button = new JoystickButton(stick, buttonNumber);

	// Another type of button you can create is a DigitalIOButton, which is
	// a button or switch hooked up to the cypress module. These are useful if
	// you want to build a customized operator interface.
	// Button button = new DigitalIOButton(1);

	// There are a few additional built in buttons you can use. Additionally,
	// by subclassing Button you can create custom triggers and bind those to
	// commands the same as any other Button.

	// // TRIGGERING COMMANDS WITH BUTTONS
	// Once you have a button, it's trivial to bind it to a button in one of
	// three ways:

	// Start the command when the button is pressed and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenPressed(new GearShift());

	// Run the command while the button is being held down and interrupt it once
	// the button is released.
	// button.whileHeld(new GearShift());

	// Start the command when the button is released and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenReleased(new GearShift());
}
