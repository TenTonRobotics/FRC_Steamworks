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
	private Gyro gyro = new AnalogGyro(0);
	
	private VictorSP intakeMotor = new VictorSP(4);
	private Solenoid transmissionSol = new Solenoid(1);
	private Solenoid sol2 = new Solenoid(2);

	
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
		myRobot.arcadeDrive(driveStick.getRawAxis(1), driveStick.getRawAxis(4));
		double angle = gyro.getAngle();
		System.out.println(angle);
		
		solenoidControl();
		
		if (driveStick.getRawButton(3)) {
			intakeMotor.set(0.9);
		} else if (driveStick.getRawButton(2)) {
			intakeMotor.set(-0.9);
		} else {
			intakeMotor.set(0);
		}
	}

	private void solenoidControl() {
		if (driveStick.getRawButton(1)) {
			transmissionSol.set(true);
			sol2.set(false);
		}
		if (driveStick.getRawButton(4)) {
			sol2.set(true);
			transmissionSol.set(false);
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