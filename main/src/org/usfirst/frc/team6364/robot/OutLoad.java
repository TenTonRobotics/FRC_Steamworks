package org.usfirst.frc.team6364.robot;

import edu.wpi.first.wpilibj.VictorSP;

public class OutLoad {

	VictorSP outLoadMotor;
	int channel;
	
	public OutLoad(VictorSP outLoadMotor, int channel) {
		this.outLoadMotor = outLoadMotor;
		this.channel = channel;
	}
	
}
