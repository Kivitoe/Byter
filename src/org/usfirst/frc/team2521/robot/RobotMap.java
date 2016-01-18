
package org.usfirst.frc.team2521.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	
	// Buttons
	public static final int TOGGLE_DRIVE_MODE_BUTTON = 3;
	
	// Ports
	public static final int LEFT_STICK_PORT = 0;
	public static final int RIGHT_STICK_PORT = 1;
	public static final int SECONDARY_STICK_PORT = 2;
	
	public static final int FRONT_LEFT_MOTOR = 31;
	public static final int FRONT_RIGHT_MOTOR = 10;
	public static final int REAR_LEFT_MOTOR = 12;
	public static final int REAR_RIGHT_MOTOR = 13;
}
