package frc.robot.commands.ShooterIntake;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.ShooterIntakeSubsystem;

public class ShootampFlightsticksCmd extends Command{
    
    private final ShooterIntakeSubsystem shooterIntakeSubsystem;
    private final boolean shootamp;

    

    public ShootampFlightsticksCmd(ShooterIntakeSubsystem shooterIntakeSubsystem, boolean shootamp){
        this.shootamp = shootamp;
        this.shooterIntakeSubsystem = shooterIntakeSubsystem;
        addRequirements(shooterIntakeSubsystem);
    }
    @Override
    public void initialize() {
        System.out.println("ShooterIntakecmd started!");
    }

    @Override
    public void execute() {
        shooterIntakeSubsystem.Shootamp(shootamp);
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
