package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.ShooterIntakeSubsystem;

public class ShootFlightsticksCmd extends Command{
    
    private final ShooterIntakeSubsystem shooterIntakeSubsystem;
    private final boolean shoot;
    

    public ShootFlightsticksCmd(ShooterIntakeSubsystem shooterIntakeSubsystem, boolean shoot){
        this.shoot = shoot;
        this.shooterIntakeSubsystem = shooterIntakeSubsystem;
        addRequirements(shooterIntakeSubsystem);
    }
    @Override
    public void initialize() {
        System.out.println("ShooterIntakecmd started!");
    }

    @Override
    public void execute() {
        shooterIntakeSubsystem.Shoot(shoot);
    }


    @Override
    public void end(boolean interrupted) {
        System.out.println("IntakeSetCmd ended!");
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}
