
package org.usfirst.frc.team2521.robot.commands;

import org.usfirst.frc.team2521.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 * This command has the robot drive at a single speed for a certain amount of
 * time.
 */
public class DriveForTime extends Command {
	
	double time;
	double speedFR, speedFL, speedBR, speedBL;
	
	public DriveForTime(double speedFR, double speedFL, double speedBR, double speedBL, double time) {
		requires(Robot.drivetrain);
		this.time = time;
		this.speedFR = speedFR;
		this.speedFL = speedFL;
		this.speedBR = speedBR;
		this.speedBL = speedBL;
	}
	
	protected void initialize() {
	}
	
	protected void execute() {
		Robot.drivetrain.driveForTime(speedFR, speedFL, speedBR, speedBL, time);
	}
	
	protected boolean isFinished() {
		return (this.timeSinceInitialized() >= time);
	}
	
	protected void end() {
		// redundant stop just in case
		Robot.drivetrain.stop();
	}
	
	protected void interrupted() {
	}
}
