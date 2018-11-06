package frc.robot;


import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.BuiltInAccelerometer;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.I2C.Port;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.can.CANStatus;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.interfaces.Accelerometer;
import edu.wpi.*;

/*** Hardware (motors, pneumatics, sensors) for robot ***/
public class RobotHardware extends Subsystem {
	

	/*** Initalizes all hardware ***/

	/*** 775 pro connected to a Talon motor controller */
	Talon shooterMotor;
	/*** <h3>Wierd encoder Aaron talked about</h3>
	 *  An encoder measures the rotation of an object.
	 * We will use this encoder to measure the speed of the wheel.
	 * We will use the speed as input into a PID feedback loop
	*/
	Encoder shooterEncoder;

	/*** PID Controller manages the speed of the shooter towards a setpoint
	 */
	PIDController shooterPID;
	public RobotHardware() {
		shooterMotor = new Talon(Ports.SHOOTER_MOTOR_PORT);
		// Gives shooter ports, does not reverse direction, and sets to a resultion suitable for a high RPM
		shooterEncoder = new Encoder(Ports.SHOOTER_ENCODER_PORTS[0], Ports.SHOOTER_ENCODER_PORTS[1], false, EncodingType.k1X);

		// Set the encoder to focus on speed, not displacement
		shooterEncoder.setPIDSourceType(PIDSourceType.kRate);
		shooterPID = new PIDController(0, 0, 0, 0, shooterEncoder, shooterMotor);
		shooterPID.setSetpoint(0);


	}

	public void setShooterVelocity(double RPM) {
		shooterPID.setPID(Parameters.SHOOTER_P, Parameters.SHOOTER_I, Parameters.SHOOTER_D, Parameters.SHOOTER_F);
		shooterPID.setSetpoint(RPM);
		shooterPID.enable();
	}

	public double getShooterError() {
		return shooterPID.getSetpoint() - getShooterVelocity();
	}

	public void setShooterPower(double power) {
		shooterMotor.set(power);
	}

	public void stopShooter() {
		setShooterPower(0);
	}
	
	public double getShooterPower() {
		return shooterMotor.getSpeed();
	}

	public double getShooterVelocity() {
		return shooterEncoder.getRate();
	}

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}

}
