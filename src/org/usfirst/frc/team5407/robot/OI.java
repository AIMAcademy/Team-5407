
package org.usfirst.frc.team5407.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

import org.usfirst.frc.team5407.robot.commands.CloseClaw;
import org.usfirst.frc.team5407.robot.commands.DownArm;
import org.usfirst.frc.team5407.robot.commands.OpenClaw;
import org.usfirst.frc.team5407.robot.commands.UpArm;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    public static final int JOYSTICK_PORT = 0;
    private Joystick stick;
    //private JoystickButton trigger; 
    private JoystickButton b4;
    private JoystickButton b5;
    private JoystickButton b3; 
    private JoystickButton b2;
    
   
    
    public OI(){
        stick = new Joystick(JOYSTICK_PORT);
        //trigger = new JoystickButton(stick, Joystick.ButtonType.kTop.value);
        //trigger.whenPressed(new DriveStraightAuton());
        b4 = new JoystickButton(stick, 4);
        b5 = new JoystickButton(stick, 5);
        b4.whenPressed(new OpenClaw());
        b5.whenPressed(new CloseClaw());
        b2 = new JoystickButton(stick, 2);
        b3 = new JoystickButton(stick, 3);
        b2.whileHeld(new UpArm());
        b3.whileHeld(new DownArm());
    }
    public Joystick getJoystick(){
        return stick;
    }
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
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
    
    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:
    
    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());
    
    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());
    
    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());
}

