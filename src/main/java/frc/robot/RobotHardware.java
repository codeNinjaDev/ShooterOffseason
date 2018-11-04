package frc.robot;


import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.BuiltInAccelerometer;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.I2C.Port;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.VictorSP;

import edu.wpi.first.wpilibj.can.CANStatus;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.interfaces.Accelerometer;
import edu.wpi.*;

/*** Hardware (motors, pneumatics, sensors) for robot ***/
public class RobotHardware extends Subsystem {
	

	/*
	 * TODO boolean enabled = c.enabled(); boolean pressureSwitch =
	 * c.getPressureSwitchValue(); double current = c.getCompressorCurrent();
	 */
	/*** Initalizes all hardware ***/

	Talon shooterMotor;

	public RobotHardware() {
		shooterMotor = new Talon(Ports.SHOOTER_PORT);

	}

	
	public void setShooterSpeed(double speed) {
		shooterMotor.set(speed);
	}

	
	public double getShooterSpeed() {
		
		return shooterMotor.getSpeed();
	}

	

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}

}
