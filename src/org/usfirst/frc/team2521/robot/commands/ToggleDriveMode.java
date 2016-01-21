
package org.usfirst.frc.team2521.robot.commands;

import org.usfirst.frc.team2521.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 * This command is used to toggle the drive mode from TankDrive to ArcadeDrive
 * and vice-versa.
 */
public class ToggleDriveMode extends Command {
	
	public ToggleDriveMode() {
		requires(Robot.drivetrain);
	}
	
	protected void initialize() {
	}
	
	protected void execute() {
		Robot.drivetrain.toggleDriveMode();
	}
	
	protected boolean isFinished() {
		return true;
	}
	
	protected void end() {
	}
	
	protected void interrupted() {
	}
}
