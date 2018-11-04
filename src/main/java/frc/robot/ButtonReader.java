package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
/** Debounces and reads controller values 
 * @category hardware
 * @author Peter I. Chacko, Eric Warner, John Sullivan Jr, Jake Boothby, Elliot
 *         Friedlander
 *         **/
public class ButtonReader {
	/*** The joystick on which the button resides. Either driver or operator */
	private Joystick joystick;
	/*** XBox Controller numerical mapping for button (found in XBoxMappings) ***/
	private int buttonNum;
	/** Last state of the button **/
	private boolean lastState;
	/** Current state of the button **/
	private boolean currState;

	/*** Description of Button ***/
	private String buttonPurpose;
	/** Initializes controller variables 
	 * @param joystick The controller joystick
	 * @param buttonNum The controller button number
	 * @param buttonPurpose Describes function of the button **/
	public ButtonReader(Joystick joystick, int buttonNum, String buttonPurpose) {
		this.joystick = joystick;
		this.buttonNum = buttonNum;
		this.buttonPurpose = buttonPurpose + "_BUTTON";
		currState = this.joystick.getRawButton(buttonNum);
		lastState = currState;
	}
	/** Reads button value **/
	public void readValue() {
		lastState = currState;
		currState = joystick.getRawButton(buttonNum);
	}
	/** Checks if the button is down **/
	public boolean isDown() {
		SmartDashboard.putBoolean(buttonPurpose, currState);
		return currState;
	}
	/** Checks if the button was just pressed **/
	public boolean wasJustPressed() {
		return (lastState == false && currState == true);
	}
	/** Checks if the button was just released **/
	public boolean wasJustReleased() {
		return (lastState == true && currState == false);
	}
	/** Checks if the button state has changed **/
	public boolean stateJustChanged() {
		return (lastState != currState);
	}

}


