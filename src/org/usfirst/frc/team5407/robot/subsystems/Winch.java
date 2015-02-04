package org.usfirst.frc.team5407.robot.subsystems;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Winch extends Subsystem {
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new doNothing());
    }
    
    public Winch() {
    	SpeedController motor = new VictorSP(2);
    	//  button8 = Winch1up
    	//  button9 = Winch1down
    	
    	
    }
}

