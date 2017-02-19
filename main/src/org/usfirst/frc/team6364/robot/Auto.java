package org.usfirst.frc.team6364.robot;

import edu.wpi.first.wpilibj.Spark;

public class Auto {

	Spark rightTopDrive;
	Spark rightFrontDrive;
	Spark rightBackDrive;
	// Drive motors left side
	Spark leftTopDrive;
	Spark leftFrontDrive;
	Spark leftBackDrive;
	
	public Auto(Spark rightTopDrive, Spark rightFrontDrive, Spark rightBackDrive,
			Spark leftTopDrive, Spark leftFrontDrive, Spark leftBackDrive) {
		
	}
	
	public void drive(double speed) {
		rightTopDrive.set(speed);
		rightFrontDrive.set(speed);
		rightBackDrive.set(speed);
		
		leftTopDrive.set(-(speed));
		leftFrontDrive.set(-(speed));
		leftBackDrive.set(-(speed));
	}
	
}
