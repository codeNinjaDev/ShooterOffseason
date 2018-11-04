
package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
/** Handles inputs from controller 
 * @category hardware
 * @author Peter I. Chacko, Eric Warner, John Sullivan Jr, Jake Boothby, Elliot
 *         Friedlander
 * 
 * **/
public class ControlBoard extends RemoteControl {
	//Operator Buttons
/** Operator Buttons **/
	public ButtonReader fastestShooterButton, fastShooterButton, mediumShooterButton, slowShooterButton;
	/** Driver joystick axes **/
	private double driverLeftJoyX, driverLeftJoyY, driverRightJoyX, driverRightJoyY;
	/** Operator joystick axes **/
	private double operatorLeftJoyX, operatorLeftJoyY, operatorRightJoyX, operatorRightJoyY;
	private Joystick driverJoy, operatorJoy;

	/** Initializes all controller inputs **/
	public ControlBoard() {
		driverJoy = new Joystick(Ports.DRIVER_JOY_USB_PORT);
		operatorJoy = new Joystick(Ports.OPERATOR_JOY_USB_PORT);

		fastestShooterButton = new ButtonReader(operatorJoy, XBoxMappings.YELLOW_BUTTON, "Shoot Ball 1 Speed");
		fastShooterButton = new ButtonReader(operatorJoy, XBoxMappings.RED_BUTTON, "Shoot Ball 0.8 Speed");
		mediumShooterButton = new ButtonReader(operatorJoy, XBoxMappings.YELLOW_BUTTON, "Shoot Ball 0.5 Speed");
		slowShooterButton = new ButtonReader(operatorJoy, XBoxMappings.YELLOW_BUTTON, "Shoot Ball 0.3 Speed");

		driverLeftJoyX = 0;
		driverLeftJoyY = 0;
		driverRightJoyX = 0;
		driverRightJoyY = 0;

		operatorLeftJoyX = 0;
		operatorLeftJoyY = 0;
		operatorRightJoyX = 0;
		operatorRightJoyY = 0;
	}
	/** Reads all controller inputs **/
	public void readControls() {
		readAllButtons();
		driverLeftJoyX = driverJoy.getRawAxis(XBoxMappings.LEFT_X_AXIS);
		driverLeftJoyY = -driverJoy.getRawAxis(XBoxMappings.LEFT_Y_AXIS);
		driverRightJoyX = driverJoy.getRawAxis(XBoxMappings.RIGHT_X_AXIS);
		driverRightJoyY = -driverJoy.getRawAxis(XBoxMappings.RIGHT_Y_AXIS);

		operatorLeftJoyX = operatorJoy.getRawAxis(XBoxMappings.LEFT_X_AXIS);
		operatorLeftJoyY = -operatorJoy.getRawAxis(XBoxMappings.LEFT_Y_AXIS);
		operatorRightJoyX = operatorJoy.getRawAxis(XBoxMappings.RIGHT_X_AXIS);
		operatorRightJoyY = -operatorJoy.getRawAxis(XBoxMappings.RIGHT_Y_AXIS);
		
	}
	/** Reads all controller buttons **/
	public void readAllButtons() {
		fastestShooterButton.readValue();
		fastShooterButton.readValue();
		mediumShooterButton.readValue();
		slowShooterButton.readValue();

	}

	/** Gets joystick value given joystick  and axe 
	 * 
	 * @param j A Joystick
	 * @param a An Axis
	 * 
	 * **/
	public double getJoystickValue(Joysticks j, Axes a) {
		switch (j) {
		case kDriverJoy:
			if (a == Axes.kLX) {
				return driverLeftJoyX;
			} else if (a == Axes.kLY) {
				return driverLeftJoyY;
			} else if (a == Axes.kRX) {
				return driverRightJoyX;
			} else if (a == Axes.kRY) {
				return driverRightJoyY;
			}
			break;
		case kOperatorJoy:
			if (a == Axes.kLX) {
				return operatorLeftJoyX;
			} else if (a == Axes.kLY) {
				return operatorLeftJoyY;
			} else if (a == Axes.kRX) {
				return operatorRightJoyX;
			} else if (a == Axes.kRY) {
				return operatorRightJoyY;
			}
			break;
		default:
			return 0.0;
		}
		return 0.0;
	}
	
	/*
	 * Commented in RemoteControl.java
	 * (non-Javadoc)
	 * 
	 */
	
	/*** Fastest Speed: 1 Button Y*/
	public boolean isFastestShootDesired() {
		return fastestShooterButton.isDown();
	}
	/*** Fast Speed: 0.8 Button B*/
	public boolean isFastShootDesired() {
		return fastShooterButton.isDown();
	}
	/*** Medium Speed: 0.5 Button A*/
	public boolean isMediumShootDesired() {
		return mediumShooterButton.isDown();
	}
	/*** Slow Speed: 0.3 Button X*/
	public boolean isSlowShootDesired() {
		return slowShooterButton.isDown();
	}
	/*** Gets the value of joystick for value of shooter Joystick: Left Vertical*/
	public double analogShoot() {
		SmartDashboard.putNumber("Shooter Axis", operatorLeftJoyY);
		return operatorLeftJoyY;
	}


}
