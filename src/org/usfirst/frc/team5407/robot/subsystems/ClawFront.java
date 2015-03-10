package org.usfirst.frc.team5407.robot.subsystems;

import org.usfirst.frc.team5407.robot.OI;
import org.usfirst.frc.team5407.robot.RobotMap;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class ClawFront extends Subsystem {
	public SpeedController motor = new VictorSP(RobotMap.VictorSP_Claw);
	Solenoid solenoidClaw = new Solenoid(RobotMap.Solenoid_Claw_Back);
    DigitalInput clawLimitRetract = RobotMap.clawLimitRetract;
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
	public void driveClaw(double speed) {
//		  motor.set(speed);
			if(OI.getStick2Y() < -0.1){
				motor.set(speed);
			}
			else if(OI.getStick2Y() > 0.1){
				if(RobotMap.clawLimitRetract.get() == false) {
					motor.set(0);
				}
				else {
					motor.set(speed);
				}
			}
			else {
				motor.set(0);
			}
	}
		
	public void doNothing() {
		motor.set(0);
	}

	public void clawClose(boolean state) {
		solenoidClaw.set(state);
	}
		
}



