package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.ShooterIntakeSubsystem;

public class IntakeBackoutCmd extends Command {
    private final ShooterIntakeSubsystem shooterIntakeSubsystem;
    private final boolean backout;

    public IntakeBackoutCmd(ShooterIntakeSubsystem shooterIntakeSubsystem, boolean backout){
        this.shooterIntakeSubsystem = shooterIntakeSubsystem;
        this.backout = backout;
        addRequirements(shooterIntakeSubsystem);
    }
    @Override
    public void initialize() {
        System.out.println("BackoutCmd started!");
    }

    @Override
    public void execute() {
        shooterIntakeSubsystem.Backout(backout);
    }
    @Override
    public void end(boolean interrupted) {
        System.out.println("BackoutCmd ended!");
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}
