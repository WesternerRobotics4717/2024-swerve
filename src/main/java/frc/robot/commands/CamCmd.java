package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.CameraSubsystem;

public class CamCmd extends Command{
    private final CameraSubsystem CameraSubsystem;


    public CamCmd(CameraSubsystem cameraSubsystem){
        this.CameraSubsystem = cameraSubsystem; 
        addRequirements(cameraSubsystem);
    }
    @Override
    public void initialize() {
        System.out.println("camOn!");
        CameraSubsystem.RunCams();
    }

    @Override
    public void execute() {
       
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
