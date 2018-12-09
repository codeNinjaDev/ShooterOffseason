package frc.robot;

/*** Abstract class for all input for robot functionality ***/
public abstract class RemoteControl {
	/*** Whose controllers (driver or operator)
	 * 
	 * @author peter
	 *
	 */
	public enum Joysticks {
		kDriverJoy, kOperatorJoy
	};
	/*** What joystick axes (left x or right y) ***/
	public enum Axes {
		kLX, kLY, kRX, kRY
	};
	/*** Update Values ***/
	public abstract void readControls();
	/*** Update button values ***/
	public abstract void readAllButtons();
	/*** Get value of joystick axis ***/
	public abstract double getJoystickValue(Joysticks j, Axes a);

	/*** Fastest Speed: 1 Button Y*/
	public abstract boolean isFastestShootDesired();
	/*** Fast Speed: 0.8 Button B*/
	public abstract boolean isFastShootDesired();
	/*** Medium Speed: 0.5 Button A*/
	public abstract boolean isMediumShootDesired();
	/*** Slow Speed: 0.3 Button X*/
	public abstract boolean isSlowShootDesired();
	/*** Gets the value of joystick for value of shooter Joystick: Left Vertical*/
	public abstract double analogShoot();
	public abstract void update();


	
}
