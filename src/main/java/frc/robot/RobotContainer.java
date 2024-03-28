package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

import frc.robot.Constants.OIConstants;
import frc.robot.commands.CamCmd;
import frc.robot.commands.SwerveJoystickCmd;
import frc.robot.commands.ShooterIntake.IntakeBackoutCmd;
import frc.robot.commands.ShooterIntake.ShootampFlightsticksCmd;
import frc.robot.commands.ShooterIntake.IntakeFlightsticksCmd;
import frc.robot.commands.ShooterIntake.ShootFlightsticksCmd;
import frc.robot.subsystems.CameraSubsystem;
import frc.robot.subsystems.ShooterIntakeSubsystem;
import frc.robot.subsystems.SwerveSubsystem;

public class RobotContainer {

      
    private final SwerveSubsystem swerveSubsystem = new SwerveSubsystem();
    private final ShooterIntakeSubsystem shooterIntakeSubsystem = new ShooterIntakeSubsystem();
    private final CameraSubsystem cameraSubsystem = new CameraSubsystem();

    private final XboxController driverJoytick = new XboxController(OIConstants.kDriverControllerPort);
    private final Joystick systemsSticks = new Joystick(OIConstants.kSystemsControllerPort);

    public RobotContainer() {
        swerveSubsystem.setDefaultCommand(new SwerveJoystickCmd(
                swerveSubsystem,
                () -> -driverJoytick.getRawAxis(OIConstants.kDriverYAxis),
                () -> -driverJoytick.getRawAxis(OIConstants.kDriverXAxis),
                () -> driverJoytick.getRawAxis(OIConstants.kDriverRotAxis),
                () -> driverJoytick.getRawButton(OIConstants.kDriverFieldOrientedButtonIdx)));

        shooterIntakeSubsystem.setDefaultCommand(new ShootFlightsticksCmd(shooterIntakeSubsystem, false));
        shooterIntakeSubsystem.setDefaultCommand(new ShootampFlightsticksCmd(shooterIntakeSubsystem, false));
        shooterIntakeSubsystem.setDefaultCommand(new IntakeFlightsticksCmd(shooterIntakeSubsystem, false));
        shooterIntakeSubsystem.setDefaultCommand(new IntakeBackoutCmd(shooterIntakeSubsystem, false));
 
        cameraSubsystem.setDefaultCommand(new CamCmd(cameraSubsystem));


        configureButtonBindings();
    }

    private void configureButtonBindings() {
        new JoystickButton(systemsSticks, OIConstants.kShooterButtonIdx).whileTrue(new ShootFlightsticksCmd(shooterIntakeSubsystem, true));
        new JoystickButton(systemsSticks, OIConstants.kShootampButtonIdx).whileTrue(new ShootampFlightsticksCmd(shooterIntakeSubsystem, true));
        new JoystickButton(systemsSticks, OIConstants.kIntakeButtionIdx).whileTrue(new IntakeFlightsticksCmd(shooterIntakeSubsystem, true));
        new JoystickButton(systemsSticks, OIConstants.kBackoutButtionIdx).whileTrue(new IntakeBackoutCmd(shooterIntakeSubsystem, true));
        new JoystickButton(systemsSticks, OIConstants.kShooterButtonIdx).whileFalse(new ShootFlightsticksCmd(shooterIntakeSubsystem, false));
        new JoystickButton(systemsSticks, OIConstants.kShootampButtonIdx).whileFalse(new ShootampFlightsticksCmd(shooterIntakeSubsystem, false));
    }

    public Command getAutonomousCommand() {
        return new Command(){

        };
    }
}