
package org.usfirst.frc.team2521.robot;

import org.usfirst.frc.team2521.robot.commands.ToggleDriveMode;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {

	private Joystick left;
	private Joystick right;
	private Joystick secondary;

	private JoystickButton toggleDriveModeButton;

	private static OI instance;

	public OI() {
		left = new Joystick(RobotMap.LEFT_STICK_PORT);
		right = new Joystick(RobotMap.RIGHT_STICK_PORT);
		secondary = new Joystick(RobotMap.SECONDARY_STICK_PORT);
	}

	public static OI getInstance() {
		if (instance == null) {
			instance = new OI();
		}

		return instance;
	}

	public Joystick getLeftStick() {
		return left;
	}

	public Joystick getRightStick() {
		return right;
	}

	public Joystick getSecondaryStick() {
		return secondary;
	}

	public void initButtons() {
		toggleDriveModeButton = new JoystickButton(secondary, RobotMap.TOGGLE_DRIVE_MODE_BUTTON);
	}

	public void tieButtons() {
		toggleDriveModeButton.whenPressed(new ToggleDriveMode());
	}
}
