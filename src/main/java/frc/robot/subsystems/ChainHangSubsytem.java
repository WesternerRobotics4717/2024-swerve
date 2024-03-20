package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.ChainHangConstants;

public class ChainHangSubsytem extends SubsystemBase{
    
    private CANSparkMax ChainLiftMotor = new CANSparkMax(ChainHangConstants.ChainHangerID, MotorType.kBrushless);

    public ChainHangSubsytem(){

    }

    @Override
    public void periodic() {

    }

    public void Hang(boolean hang){
        ChainLiftMotor.setSmartCurrentLimit(45);

        if(hang){
            ChainLiftMotor.set(1);
        }else{
            ChainLiftMotor.set(0);
        }
    }
}
