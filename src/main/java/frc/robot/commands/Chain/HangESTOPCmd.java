package frc.robot.commands.Chain;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.ChainHangSubsytem;

public class HangESTOPCmd extends Command{
      private final ChainHangSubsytem chainHangSubsytem;
      private final boolean stop;


    public HangESTOPCmd(ChainHangSubsytem chainHangSubsytem, boolean stop){
        this.chainHangSubsytem = chainHangSubsytem;
        this.stop = stop; 
        addRequirements(chainHangSubsytem);
    }
    @Override
    public void initialize() {
        System.out.println("STOP!");
    }

    @Override
    public void execute() {
        chainHangSubsytem.EStop(stop);
    }
    @Override
    public void end(boolean interrupted) {
        System.out.println("STOP!");
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}
