
package org.usfirst.frc.team2521.robot.subsystems;

import org.usfirst.frc.team2521.robot.DriveMode;
import org.usfirst.frc.team2521.robot.OI;
import org.usfirst.frc.team2521.robot.RobotMap;
import org.usfirst.frc.team2521.robot.commands.TeleoperatedDrive;

import edu.wpi.first.wpilibj.CANJaguar;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.RobotDrive.MotorType;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * The Drivetrain subsystem, where we do everything involving the robot's
 * drivetrain.
 */
public class Drivetrain extends Subsystem {
	
	private int driveMode;
	
	private RobotDrive drive;
	
	CANJaguar frontRight, frontLeft, backRight, backLeft;
	
	public Drivetrain() {
		frontRight = new CANJaguar(RobotMap.FRONT_RIGHT_MOTOR);
		frontRight.enableControl();
		
		frontLeft = new CANJaguar(RobotMap.FRONT_RIGHT_MOTOR);
		frontLeft.enableControl();
		
		backRight = new CANJaguar(RobotMap.FRONT_RIGHT_MOTOR);
		backRight.enableControl();
		
		backLeft = new CANJaguar(RobotMap.FRONT_RIGHT_MOTOR);
		backLeft.enableControl();
		
		drive = new RobotDrive(frontLeft, backLeft, frontRight, backRight);
		drive.setInvertedMotor(MotorType.kFrontLeft, true);
		drive.setInvertedMotor(MotorType.kRearLeft, true);
	}
	
	public void tankDrive() {
		double left = OI.getInstance().getLeftStick().getY();
		double right = OI.getInstance().getRightStick().getY();
		drive.tankDrive(left, right);
		
		driveMode = DriveMode.TANK_DRIVE;
	}
	
	public void arcadeDrive() {
		GenericHID left = OI.getInstance().getLeftStick();
		drive.arcadeDrive(left);
		
		driveMode = DriveMode.ARCADE_DRIVE;
	}
	
	public void toggleDriveMode() {
		if (driveMode == DriveMode.TANK_DRIVE) {
			arcadeDrive();
		} else {
			tankDrive();
		}
	}
	
	public void driveForTime(double speedFR, double speedFL, double speedBR, double speedBL, double time) {
		frontRight.set(speedFR);
		frontLeft.set(speedFL);
		backRight.set(speedBR);
		backLeft.set(speedBL);
		
		Timer.delay(time);
		
		frontRight.set(0);
		frontLeft.set(0);
		backRight.set(0);
		backLeft.set(0);
	}
	
	public void stop() {
		frontRight.set(0);
		frontLeft.set(0);
		backRight.set(0);
		backLeft.set(0);
	}
	
	public void teleoperatedDrive() {
		tankDrive();
	}
	
	public void initDefaultCommand() {
		setDefaultCommand(new TeleoperatedDrive());
	}
}
