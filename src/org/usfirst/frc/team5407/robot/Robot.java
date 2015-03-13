package org.usfirst.frc.team5407.robot;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import com.ni.vision.NIVision;
import com.ni.vision.NIVision.DrawMode;
import com.ni.vision.NIVision.Image;
import com.ni.vision.NIVision.ShapeMode;

//import edu.wpi.first.wpilibj.CameraServer;
//import edu.wpi.first.wpilibj.SampleRobot;
//import edu.wpi.first.wpilibj.Timer;








import org.usfirst.frc.team5407.robot.commands.AutonDoNothing;
import org.usfirst.frc.team5407.robot.commands.AutonDriveFromLandfillToAuto;
import org.usfirst.frc.team5407.robot.commands.AutonScoreToteAndCan;
import org.usfirst.frc.team5407.robot.subsystems.Arm;
import org.usfirst.frc.team5407.robot.subsystems.Chassis;
import org.usfirst.frc.team5407.robot.subsystems.ClawBack;
import org.usfirst.frc.team5407.robot.subsystems.ClawFront;
import org.usfirst.frc.team5407.robot.subsystems.Grippers;
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

    CameraServer server;

    public static Winch winch;
    public static Chassis chassis;
	public static ClawBack claw_back;
	public static Arm arm;
	public static OI oi;
	public static ClawFront claw_front;
	public static Grippers grippers;
    
	Command autonomousCommand;
	SendableChooser autoChooser; 
	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	public void robotInit() {
		RobotMap.init();
		arm = new Arm();
		claw_back = new ClawBack();
		claw_front = new ClawFront();
		chassis = new Chassis();
        winch = new Winch();
        grippers = new Grippers();
		oi = new OI();
		
		
		autoChooser = new SendableChooser();
		autoChooser.addDefault("Default DoNothin", new AutonDoNothing());
		autoChooser.addObject("Drive Landfill to Auto", new AutonDriveFromLandfillToAuto());
		autoChooser.addObject("Score tote and can", new AutonScoreToteAndCan());  
		SmartDashboard.putData("Autonomous mode chooser", autoChooser);
		
		// Camera settings to show on Smart Dashboard
//        server = CameraServer.getInstance();
//        server.setQuality(50);
        //the camera name (ex "cam0") can be found through the roborio web interface
//        server.startAutomaticCapture("cam0");
        
		
		// instantiate the command used for the autonomous period
//		autonomousCommand = new AutonScoreCan();
//		autonomousCommand = new AutonDriveStraight();
		autonomousCommand = new AutonDoNothing();
        
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
	        autonomousCommand = (Command) autoChooser.getSelected();	
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
