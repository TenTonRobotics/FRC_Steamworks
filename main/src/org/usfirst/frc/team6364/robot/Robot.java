package org.usfirst.frc.team6364.robot;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.interfaces.Gyro;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

public class Robot extends IterativeRobot {
	RobotDrive myRobot = new RobotDrive(1, 0, 3, 2);
	Joystick driveStick = new Joystick(0);
	Timer timer = new Timer();
	
	// Sensor init
	private Gyro gyro = new AnalogGyro(0);
	
	// Actuator init
	private VictorSP intakeMotor = new VictorSP(4);
	private Solenoid leftSol = new Solenoid(1);
	private Solenoid rightSol = new Solenoid(2);
	
	// Object init
	private Intake intake = new Intake(intakeMotor);
	private GearShift shifter= new GearShift(leftSol, rightSol);

	
	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
	}

	/**
	 * This function is run once each time the robot enters autonomous mode
	 */
	@Override
	public void autonomousInit() {
		timer.reset();
		timer.start();
	}

	/**
	 * This function is called periodically during autonomous
	 */
	@Override
	public void autonomousPeriodic() {
		// Drive for 2 seconds
		if (timer.get() < 2.0) {
			myRobot.drive(-0.5, 0.0); // drive forwards half speed
		} else {
			myRobot.drive(0.0, 0.0); // stop robot
		}
	}

	/**
	 * This function is called once each time the robot enters tele-operated
	 * mode
	 */
	@Override
	public void teleopInit() {
		System.out.println("Teleop INIT");
	}

	/**
	 * This function is called periodically during operator control
	 */
	@Override
	public void teleopPeriodic() {
		// set drive mode to arcade - also reverse stick
		myRobot.arcadeDrive(driveStick.getRawAxis(1), driveStick.getRawAxis(4));
		double angle = gyro.getAngle();
		
		// Control pnumatics
		solenoidControl();
		// Control intake for balls
		intakeControl();
	}

	// Control intake forthe balls
	private void intakeControl() {
		if (driveStick.getRawButton(3)) {
			intake.intake();
		} else if (driveStick.getRawButton(2)) {
			intake.extake();
		} else {
			intake.stop();
		}
	}
	
	// Control solenoids for gear shift and for the cog intake
	private void solenoidControl() {
		if (driveStick.getRawButton(1)) {
			shifter.shiftUp();
		}
		if (driveStick.getRawButton(4)) {
			shifter.shiftDown();
		}
	}
	
	/**
	 * This function is called periodically during test mode
	 */
	@Override
	public void testPeriodic() {
		LiveWindow.run();
	}
}