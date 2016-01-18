
package org.usfirst.frc.team2521.robot;

import org.usfirst.frc.team2521.robot.commands.Autonomous;
import org.usfirst.frc.team2521.robot.subsystems.Drivetrain;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
	
	public static Drivetrain drivetrain;
	
	public static OI oi;
	
	Command autonomousCommand;
	
	public void robotInit() {
		drivetrain = new Drivetrain();
		
		oi = new OI();
	}
	
	public void disabledInit() {
	
	}
	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}
	
	public void autonomousInit() {
		autonomousCommand = new Autonomous();
		
		autonomousCommand.start();
	}
	
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}
	
	public void teleopInit() {
		if (autonomousCommand != null) {
			autonomousCommand.cancel();
		}
	}
	
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
	}
	
	public void testPeriodic() {
		LiveWindow.run();
	}
}
