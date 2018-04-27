package org.usfirst.frc.team4015.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

// SUBSYSTEM IMPORTS //

import org.usfirst.frc.team4015.robot.subsystems.Drivetrain;
import org.usfirst.frc.team4015.robot.subsystems.Shooter;
import org.usfirst.frc.team4015.robot.subsystems.Flap;

// ROBOT MODES (COMMAND GROUP) IMPORTS //

import org.usfirst.frc.team4015.robot.robotModes.Teleop;

/* =============================================================================
 * The RoboRIO will automatically run the methods in this class depending on
 * which part of the match is being played.
 * ============================================================================*/

public class Robot extends IterativeRobot
{
	// SUBSYSTEM DECLARATION //
	
	public static Drivetrain drivetrain;
	public static Shooter shooter;
	public static Flap flap;
	
	// DECLARE ROBOT MODES (COMMAND GROUPS) //
	
	Command teleop;

	/* ===================================
	 * This function is run when the robot 
	 * is first started up and should be
	 * used for any initialization code.
	 * ==================================*/
	
	@Override
	public void robotInit()
	{
		// SUBSYSTEM INSTANTIATION //
		
		drivetrain = new Drivetrain();
		shooter = new Shooter();
		flap = new Flap();
		
		// INSTANTIATE ROBOT MODES (COMMAND GROUPS) //
		
		teleop = new Teleop();
	}

	/* =================================================
	 * This function is called once each time the robot 
	 * enters Disabled mode. You can use it to reset any 
	 * subsystem information you want to clear when the 
	 * robot is disabled.
	 * ================================================*/
	
	@Override
	public void disabledInit()
	{

	}

	@Override
	public void disabledPeriodic()
	{
		// Run Scheduler to manage Commands / CommandGroups
		Scheduler.getInstance().run();
	}

	/* =======================================
	 * This function is called once before 
	 * the autonomous period.  It can be used
	 * to select an auto mode.
	 * =======================================*/
	
	@Override
	public void autonomousInit()
	{
		
	}

	/* ======================================================
	 * This function is called periodically during autonomous
	 * =====================================================*/
	
	@Override
	public void autonomousPeriodic()
	{
		
	}

	@Override
	public void teleopInit()
	{	
		// START TELEOP COMMAND GROUP //
		
		if (teleop != null)
		{
			teleop.start();
		}
	}

	/* ===================================================
	 * This function is called periodically during teleop
	 * ==================================================*/
	
	@Override
	public void teleopPeriodic()
	{
		// Run Scheduler to manage Commands / CommandGroups
		Scheduler.getInstance().run();
	}

	/* =====================================================
	 * This function is called periodically during test mode
	 * ====================================================*/
	@Override
	public void testPeriodic()
	{
		LiveWindow.run();
	}
}
