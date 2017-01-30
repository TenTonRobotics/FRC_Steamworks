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

// Intake class - defines the methods for the robot intake

public class Intake {

	private VictorSP intakeMotorA;
	
	public Intake(VictorSP intakeMotorA) {
		this.intakeMotorA = intakeMotorA;
	}
	
	public void intake() {
		intakeMotorA.set(1.0);
	}
	
	public void extake() {
		intakeMotorA.set(-1.0);
	}

	public void stop() {
		intakeMotorA.set(0);
	}
	
}
