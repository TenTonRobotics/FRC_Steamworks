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

// Class for controlling the gear shifter on the 2 speed pnumatic drive transmission

public class GearShift {

	private Solenoid leftSol;
	private Solenoid rightSol;
	
	public GearShift(Solenoid leftSol, Solenoid rightSol) {
		this.leftSol = leftSol;
		this.rightSol = rightSol;
	}
	
	public void shiftUp() {
		leftSol.set(true);
		rightSol.set(false);
	}
	
	public void shiftDown() {
		leftSol.set(false);
		rightSol.set(true);
	}
	
}
