package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.CameraSubsystem;

public class CamCmd extends Command{
    private final CameraSubsystem CameraSubsystem;
    private final boolean turn;

    public CamCmd(CameraSubsystem cameraSubsystem, boolean turn){
        this.CameraSubsystem = cameraSubsystem;
        this.turn = turn; 
        addRequirements(cameraSubsystem);
    }
    @Override
    public void initialize() {
        System.out.println("camOn!");
    }

    @Override
    public void execute() {
        CameraSubsystem.RunCams(turn);
    }
    @Override
    public void end(boolean interrupted) {
        System.out.println("Oh No Cams Off!");
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}
