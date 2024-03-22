package frc.robot.commands.Chain;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.ChainHangSubsytem;

public class PullvaluesCmd extends Command{
        private final ChainHangSubsytem chainHangSubsytem;



    public PullvaluesCmd(ChainHangSubsytem chainHangSubsytem){
        this.chainHangSubsytem = chainHangSubsytem;
 
        addRequirements(chainHangSubsytem);
    }
    @Override
    public void initialize() {

    }

    @Override
    public void execute() {
        
        chainHangSubsytem.Pullvalues();;
    }
    @Override
    public void end(boolean interrupted) {
        System.out.println("no vales !");
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}
