
package org.usfirst.frc.team2521.robot.commands;

import org.usfirst.frc.team2521.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 * This command initiates TeleoperatedDrive.
 */
public class TeleoperatedDrive extends Command {
	
	public TeleoperatedDrive() {
		requires(Robot.drivetrain);
	}
	
	protected void initialize() {
	}
	
	protected void execute() {
		Robot.drivetrain.teleoperatedDrive();
	}
	
	protected boolean isFinished() {
		return false;
	}
	
	protected void end() {
	}
	
	protected void interrupted() {
		end();
	}
}
