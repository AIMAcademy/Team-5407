package org.usfirst.frc.team5407.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team5407.robot.commands.CloseClaw;
import org.usfirst.frc.team5407.robot.commands.DownArm;
import org.usfirst.frc.team5407.robot.commands.OpenClaw;
import org.usfirst.frc.team5407.robot.commands.UpArm;
import org.usfirst.frc.team5407.robot.commands.GearShift;
import org.usfirst.frc.team5407.robot.commands.SetWinchSetpoint;
import org.usfirst.frc.team5407.robot.commands.WinchDoNothing;
import org.usfirst.frc.team5407.robot.commands.WinchDrive;
// import org.usfirst.frc.team5407.robot.commands.SetElevatorSetpoint;
// import org.usfirst.frc.team5407.robot.subsystems.Elevator;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	public static final int JOYSTICK_PORT = 0;
	public static final int JOYSTICK_PORT_1 = 1;
	private static Joystick stick; //TODO make all static
	private static Joystick stick1;
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
	
	// create variables for stick 1
	private JoystickButton b5_1; 
	private JoystickButton b7_1; 
	private JoystickButton b8_1; 
	private JoystickButton b9_1;  
	private JoystickButton b10_1;  
	private JoystickButton b11_1;  
	private JoystickButton b12_1; 

	
	public double liftSpeed = 0.75;

	
	public OI() {
		
		stick = new Joystick(JOYSTICK_PORT);
		stick1 = new Joystick(JOYSTICK_PORT_1);

		// create buttons on stick 0
		trigger = new JoystickButton(stick, 1);
//		b2 = new JoystickButton(stick, 2);
//		b3 = new JoystickButton(stick, 3);
//		b4 = new JoystickButton(stick, 4);
//		b5 = new JoystickButton(stick, 5);
//		b7 = new JoystickButton(stick, 7);
//		b8 = new JoystickButton(stick, 8);
//		b9 = new JoystickButton(stick, 9);
//		b10 = new JoystickButton(stick, 10);
//		b11 = new JoystickButton(stick, 11);
//		b12 = new JoystickButton(stick, 12);
		
		// run commands on stick 0
		trigger.whenPressed(new GearShift(true));
		trigger.whenReleased(new GearShift(false));
//		b2.whileHeld(new UpArm());
//		b3.whileHeld(new DownArm());
//		b4.whenPressed(new OpenClaw());
//		b5.whenPressed(new CloseClaw());
//		b7.whenPressed(new SetWinchSetpoint(0));
//		b8.whenPressed(new SetWinchSetpoint(0.2));
//		b9.whenPressed(new SetWinchSetpoint(0.4));
//		b10.whenPressed(new SetWinchSetpoint(0.6));
//		b11.whenPressed(new SetWinchSetpoint(0.8));
//		b12.whenPressed(new SetWinchSetpoint(1));
		
		// create buttons on stick 1
		b5_1 = new JoystickButton(stick1, 5);
		b7_1 = new JoystickButton(stick1, 7);
		b8_1 = new JoystickButton(stick1, 8);
		b9_1 = new JoystickButton(stick1, 9);
//		b10_1 = new JoystickButton(stick1, 10);
//		b11_1 = new JoystickButton(stick1, 11);
//		b12_1 = new JoystickButton(stick1, 12);
		
		// run commands on stick 1
		b5_1.whenPressed(new WinchDoNothing());
		b7_1.whenPressed(new SetWinchSetpoint(0));
		b8_1.whenPressed(new SetWinchSetpoint(0.2));
		b9_1.whenPressed(new SetWinchSetpoint(0.4));
//		b10_1.whenPressed(new SetWinchSetpoint(0.6));
//		b11_1.whenPressed(new SetWinchSetpoint(0.8));
//		b12_1.whenPressed(new SetWinchSetpoint(1));
		
    	// Put buttons on the SmartDashboard
        SmartDashboard.putData("Winch 1 Tote", new SetWinchSetpoint(0.1));
        SmartDashboard.putData("Winch 2 Totes", new SetWinchSetpoint(0.2));
        SmartDashboard.putData("Winch 3 Totes", new SetWinchSetpoint(0.4));
	}

	public static Joystick getJoystick() {
		return stick;
	}
	
	public static double getStickY() {
	    return stick1.getY(); //TODO Invert with minus sign if needed
	}
	
	
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
