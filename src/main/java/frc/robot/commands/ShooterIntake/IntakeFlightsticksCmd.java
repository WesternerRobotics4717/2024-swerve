package frc.robot.commands.ShooterIntake;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.ShooterIntakeSubsystem;

public class IntakeFlightsticksCmd extends Command{
    
    private final ShooterIntakeSubsystem shooterIntakeSubsystem;
    private final boolean intake;

    public IntakeFlightsticksCmd(ShooterIntakeSubsystem shooterIntakeSubsystem, boolean intake){
        this.shooterIntakeSubsystem = shooterIntakeSubsystem;
        this.intake = intake;
        addRequirements(shooterIntakeSubsystem);
    }
    @Override
    public void initialize() {
        System.out.println("IntakeCmd started!");
    }

    @Override
    public void execute() {
        shooterIntakeSubsystem.Intake(intake);
    }

    @Override
    public void end(boolean interrupted) {
        System.out.println("IntakeCmd ended!");
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}
