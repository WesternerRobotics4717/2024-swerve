package frc.robot.commands.Chain;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.ChainHangSubsytem;

public class HangCmd extends Command{
    private final ChainHangSubsytem chainHangSubsytem;
    private final boolean hang;


    public HangCmd(ChainHangSubsytem chainHangSubsytem, boolean hang){
        this.chainHangSubsytem = chainHangSubsytem;
        this.hang = hang; 
        addRequirements(chainHangSubsytem);
    }
    @Override
    public void initialize() {
        System.out.println("Hanging!");
    }

    @Override
    public void execute() {
        
        chainHangSubsytem.Hang(hang);
    }
    @Override
    public void end(boolean interrupted) {
        System.out.println("Hung!");
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}
