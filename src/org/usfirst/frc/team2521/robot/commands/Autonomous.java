
package org.usfirst.frc.team2521.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 * This CommandGroup consists of all of the robot's autonomous mode commands.
 */
public class Autonomous extends CommandGroup {
	
	public Autonomous() {
		addSequential(new DriveForTime(0.4, 0.4, 0.4, 0.4, 2.5));
		addSequential(new WaitCommand(0.1));
		addSequential(new DriveForTime(-0.3, 0.3, -0.3, 0.3, 1.5));
	}
}
