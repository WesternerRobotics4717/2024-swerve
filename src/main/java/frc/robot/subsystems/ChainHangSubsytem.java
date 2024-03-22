package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.ChainHangConstants;

public class ChainHangSubsytem extends SubsystemBase{
    
    private CANSparkMax ChainLiftMotor = new CANSparkMax(ChainHangConstants.kChainHangerID, MotorType.kBrushless);
    public RelativeEncoder ChainEncoder = ChainLiftMotor.getAlternateEncoder(4060);

    
    public ChainHangSubsytem(){

    }

    @Override
    public void periodic() {

    }


    
    public void Hang(boolean hang){
        ChainLiftMotor.setSmartCurrentLimit(45);
        /*if(hang){
        if(ChainEncoder.getPosition() <= 89){
            ChainLiftMotor.set(0.3);
        }else if(ChainEncoder.getPosition() >= 90){
            ChainLiftMotor.set(0);
        }*/
        if(hang){
            ChainLiftMotor.set(0.3);
        }
    else{
        ChainLiftMotor.set(0);
     }       
    }

    public void EStop(boolean stop){
        ChainLiftMotor.setSmartCurrentLimit(45);
        if(stop){
            ChainLiftMotor.set(0);
        }
    }

    public void Pullvalues(){
        
        SmartDashboard.putNumber("Encoder", ChainEncoder.getPosition());
    
    }
    public void ResetEncoder( boolean rst){
        if(rst){
            ChainEncoder.setPosition(0);
        }
        else{

        }
    }


}
