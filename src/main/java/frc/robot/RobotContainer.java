// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;






import java.util.List;

import com.pathplanner.lib.auto.AutoBuilder;
import com.pathplanner.lib.auto.NamedCommands;
import com.pathplanner.lib.commands.PathPlannerAuto;
import com.pathplanner.lib.path.GoalEndState;
import com.pathplanner.lib.path.PathConstraints;
import com.pathplanner.lib.path.PathPlannerPath;

import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.util.Units;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

import frc.robot.Constants.OIConstants;
import frc.robot.commands.CamCmd;
import frc.robot.commands.SwerveJoystickCmd;
import frc.robot.commands.Chain.HangCmd;
import frc.robot.commands.Chain.HangESTOPCmd;
import frc.robot.commands.Chain.PullvaluesCmd;
import frc.robot.commands.ShooterIntake.IntakeBackoutCmd;
import frc.robot.commands.ShooterIntake.IntakeFlightsticksCmd;
import frc.robot.commands.ShooterIntake.ShootFlightsticksCmd;
import frc.robot.subsystems.CameraSubsystem;
import frc.robot.subsystems.ChainHangSubsytem;
import frc.robot.subsystems.ShooterIntakeSubsystem;
import frc.robot.subsystems.SwerveSubsystem;

public class RobotContainer {

      
    private final SwerveSubsystem swerveSubsystem = new SwerveSubsystem();
    private final ShooterIntakeSubsystem shooterIntakeSubsystem = new ShooterIntakeSubsystem();
    private final ChainHangSubsytem chainHangSubsytem = new ChainHangSubsytem();
    private final CameraSubsystem cameraSubsystem = new CameraSubsystem();

     private final SendableChooser<Command> autoChooser;
    
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
        chainHangSubsytem.setDefaultCommand(new HangCmd(chainHangSubsytem, false));
        chainHangSubsytem.setDefaultCommand(new HangESTOPCmd(chainHangSubsytem, false));
        chainHangSubsytem.setDefaultCommand(new PullvaluesCmd(chainHangSubsytem));
        cameraSubsystem.setDefaultCommand(new CamCmd(cameraSubsystem, true));


        //autos
        NamedCommands.registerCommand("marker1", Commands.print("Passed marker 1"));
        NamedCommands.registerCommand("marker2", Commands.print("Passed marker 2"));
        NamedCommands.registerCommand("print hello", Commands.print("hello"));
         autoChooser = AutoBuilder.buildAutoChooser(); // Default auto will be `Commands.none()`
        SmartDashboard.putData("Auto Mode", autoChooser);
        configureButtonBindings();
    }

    private void configureButtonBindings() {
        new JoystickButton(systemsSticks, OIConstants.kShooterButtonIdx).whileTrue(new ShootFlightsticksCmd(shooterIntakeSubsystem, true));
        new JoystickButton(systemsSticks, OIConstants.kIntakeButtionIdx).whileTrue(new IntakeFlightsticksCmd(shooterIntakeSubsystem, true));
        new JoystickButton(systemsSticks, OIConstants.kBackoutButtionIdx).whileTrue(new IntakeBackoutCmd(shooterIntakeSubsystem, true));
        //new JoystickButton(systemsSticks, OIConstants.kHangButtionIdx).toggleOnTrue(new HangCmd(chainHangSubsytem, true));
       // new JoystickButton(systemsSticks, 0).toggleOnTrue(new HangESTOPCmd(chainHangSubsytem, true));


       //auto
          SmartDashboard.putData("Example Auto", new PathPlannerAuto("Example Auto"));

    // Add a button to run pathfinding commands to SmartDashboard
    SmartDashboard.putData("Pathfind to Pickup Pos", AutoBuilder.pathfindToPose(
      new Pose2d(14.0, 6.5, Rotation2d.fromDegrees(0)), 
      new PathConstraints(
        4.0, 4.0, 
        Units.degreesToRadians(360), Units.degreesToRadians(540)
      ), 
      0, 
      2.0
    ));
    SmartDashboard.putData("Pathfind to Scoring Pos", AutoBuilder.pathfindToPose(
      new Pose2d(2.15, 3.0, Rotation2d.fromDegrees(180)), 
      new PathConstraints(
        4.0, 4.0, 
        Units.degreesToRadians(360), Units.degreesToRadians(540)
      ), 
      0, 
      0
    ));

    // Add a button to SmartDashboard that will create and follow an on-the-fly path
    // This example will simply move the robot 2m in the +X field direction
    SmartDashboard.putData("On-the-fly path", Commands.runOnce(() -> {
      Pose2d currentPose = swerveSubsystem.getPose();
      
      // The rotation component in these poses represents the direction of travel
      Pose2d startPos = new Pose2d(currentPose.getTranslation(), new Rotation2d());
      Pose2d endPos = new Pose2d(currentPose.getTranslation().plus(new Translation2d(2.0, 0.0)), new Rotation2d());

      List<Translation2d> bezierPoints = PathPlannerPath.bezierFromPoses(startPos, endPos);
      PathPlannerPath path = new PathPlannerPath(
        bezierPoints, 
        new PathConstraints(
          4.0, 4.0, 
          Units.degreesToRadians(360), Units.degreesToRadians(540)
        ),  
        new GoalEndState(0.0, currentPose.getRotation())
      );

      // Prevent this path from being flipped on the red alliance, since the given positions are already correct
      path.preventFlipping = true;

      AutoBuilder.followPath(path).schedule();
    }));
    }
    

    public Command getAutonomousCommand() {
        return autoChooser.getSelected();
    }
}