package frc.robot;
/*** Pararameters for robot. e.g PID Contstants */

public class Parameters {
    //FIND THIS!!! 775pro plus mixmatched gearboxes * Currently placeholder value
    public static final int MAX_RPM = 1;
    /*** 
     * Shooter Feed forward term: https://frc-pdr.readthedocs.io/en/latest/control/pid_control.html
     *  (1 / MAX_RPM) * SETPOINT = static power is always applied to get the motor to spin at a constant speed. 
     * **/
    public static final double SHOOTER_F = 1 / MAX_RPM;
    /*** Shooter Proportional Term:
     *  Output is proportional to error. 
     * Error = setpoint - current_poistion
     * Currently placeholder value
     */
    public static final double SHOOTER_P = 1;
    /*** Shooter Integral Term:
     *  Sums past errors to eliminate steady state error (e.g friction) 
     * Sigma(error)
     */
    public static final double SHOOTER_I = 0;
    /*** Shooter Derivative Term:
     *  Dampens control loop to prevent oscillating and overshoot.
     *  Limits rate of change (dy/dx)
     */
    public static final double SHOOTER_D = 0.2;


}