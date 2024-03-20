// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;






import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;



import edu.wpi.first.wpilibj2.command.Command;

import edu.wpi.first.wpilibj2.command.button.JoystickButton;

import frc.robot.Constants.OIConstants;
import frc.robot.commands.IntakeBackoutCmd;
import frc.robot.commands.IntakeFlightsticksCmd;
import frc.robot.commands.ShootFlightsticksCmd;
import frc.robot.commands.SwerveJoystickCmd;
import frc.robot.subsystems.ShooterIntakeSubsystem;
import frc.robot.subsystems.SwerveSubsystem;

public class RobotContainer {

      
    private final SwerveSubsystem swerveSubsystem = new SwerveSubsystem();
    private final ShooterIntakeSubsystem shooterIntakeSubsystem = new ShooterIntakeSubsystem();


    
    private final XboxController driverJoytick = new XboxController(OIConstants.kDriverControllerPort);
    private final Joystick systemsSticks = new Joystick(OIConstants.kSystemsControllerPort);

    public RobotContainer() {
        swerveSubsystem.setDefaultCommand(new SwerveJoystickCmd(
                swerveSubsystem,
                () -> -driverJoytick.getRawAxis(OIConstants.kDriverYAxis),
                () -> driverJoytick.getRawAxis(OIConstants.kDriverXAxis),
                () -> driverJoytick.getRawAxis(OIConstants.kDriverRotAxis),
                () -> !driverJoytick.getRawButton(OIConstants.kDriverFieldOrientedButtonIdx)));

        shooterIntakeSubsystem.setDefaultCommand(new ShootFlightsticksCmd(shooterIntakeSubsystem, false));
        shooterIntakeSubsystem.setDefaultCommand(new IntakeFlightsticksCmd(shooterIntakeSubsystem, false));
        shooterIntakeSubsystem.setDefaultCommand(new IntakeBackoutCmd(shooterIntakeSubsystem, false));
        
        configureButtonBindings();

       
  
    }

    private void configureButtonBindings() {
        new JoystickButton(systemsSticks, OIConstants.kShooterButtonIdx).whileTrue(new ShootFlightsticksCmd(shooterIntakeSubsystem, true));
        new JoystickButton(systemsSticks, OIConstants.kIntakeButtionIdx).whileTrue(new IntakeFlightsticksCmd(shooterIntakeSubsystem, true));
        new JoystickButton(systemsSticks, OIConstants.kBackoutButtionIdx).whileTrue(new IntakeBackoutCmd(shooterIntakeSubsystem, true));
          
     
    }
    

    public Command getAutonomousCommand() {
               return null;
}
}

  