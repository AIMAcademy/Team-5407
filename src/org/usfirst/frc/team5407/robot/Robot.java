package org.usfirst.frc.team5407.robot;

import edu.wpi.first.wpilibj.CameraServer;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import com.ni.vision.NIVision;
import com.ni.vision.NIVision.DrawMode;
import com.ni.vision.NIVision.Image;
import com.ni.vision.NIVision.ShapeMode;

//import edu.wpi.first.wpilibj.CameraServer;
//import edu.wpi.first.wpilibj.SampleRobot;
//import edu.wpi.first.wpilibj.Timer;

import org.usfirst.frc.team5407.robot.commands.DriveStraightAuton;
import org.usfirst.frc.team5407.robot.subsystems.Arm;
import org.usfirst.frc.team5407.robot.subsystems.Chassis;
import org.usfirst.frc.team5407.robot.subsystems.Claw;
import org.usfirst.frc.team5407.robot.subsystems.ClawLift;
import org.usfirst.frc.team5407.robot.subsystems.Winch;
import org.usfirst.frc.team5407.robot.RobotMap;

//import com.ni.vision.NIVision;
//import com.ni.vision.NIVision.DrawMode;
//import com.ni.vision.NIVision.ShapeMode;


/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
	
    int session;
    Image frame;

    public static Winch winch;
    public static Chassis chassis;
	public static Claw claw;
	public static Arm arm;
	public static ClawLift clawlift;
	public static OI oi;
    
	Command autonomousCommand;

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	public void robotInit() {
		RobotMap.init();
		clawlift = new ClawLift();
		arm = new Arm();
		claw = new Claw();
		chassis = new Chassis();
        winch = new Winch();
		oi = new OI();
		
		// instantiate the command used for the autonomous period
		autonomousCommand = new DriveStraightAuton();
		
		// try to use smart dashboard
        // SmartDashboard.putData(winch);
        
//        // for camera
//        frame = NIVision.imaqCreateImage(NIVision.ImageType.IMAGE_RGB, 0);
//
//        // the camera name (ex "cam0") can be found through the roborio web interface
//        session = NIVision.IMAQdxOpenCamera("cam0",
//                NIVision.IMAQdxCameraControlMode.CameraControlModeController);
//        NIVision.IMAQdxConfigureGrab(session);
	}

	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	public void autonomousInit() {
		// schedule the autonomous command (example)
		if (autonomousCommand != null)
			autonomousCommand.start();
	}

	/**
	 * This function is called periodically during autonomous
	 */
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		if (autonomousCommand != null)
			autonomousCommand.cancel();
	}

	/**
	 * This function is called when the disabled button is hit. You can use it
	 * to reset subsystems before shutting down.
	 */
	public void disabledInit() {

	}

	/**
	 * This function is called periodically during operator control
	 */
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
		
//		// for camera control
//        NIVision.IMAQdxStartAcquisition(session);
//
//        /**
//         * grab an image, draw the circle, and provide it for the camera server
//         * which will in turn send it to the dashboard.
//         */
//        NIVision.Rect rect = new NIVision.Rect(10, 10, 100, 100);
//
////        while (isOperatorControl() && isEnabled()) {
//
//            NIVision.IMAQdxGrab(session, frame, 1);
//            NIVision.imaqDrawShapeOnImage(frame, frame, rect,
//                    DrawMode.DRAW_VALUE, ShapeMode.SHAPE_OVAL, 0.0f);
//            
//            CameraServer.getInstance().setImage(frame);
//
//            /** robot code here! **/
//            Timer.delay(0.005);		// wait for a motor update time
////        }
//        NIVision.IMAQdxStopAcquisition(session);
	}

	/**
	 * This function is called periodically during test mode
	 */
	public void testPeriodic() {
		LiveWindow.run();
	}
}
