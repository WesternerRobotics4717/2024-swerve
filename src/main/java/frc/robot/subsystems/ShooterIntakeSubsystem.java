package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.Constants.ShooterIntakeConstants;
public class ShooterIntakeSubsystem extends SubsystemBase{

    private  CANSparkMax ShooterTop = new CANSparkMax(ShooterIntakeConstants.ShooterTopID, MotorType.kBrushless);
    private  CANSparkMax ShooterBottom = new CANSparkMax(ShooterIntakeConstants.ShooterBottomID, MotorType.kBrushless);
    private  CANSparkMax Intake = new CANSparkMax(ShooterIntakeConstants.IntakeID, MotorType.kBrushless);

    public ShooterIntakeSubsystem(){}

    @Override
    public void periodic() {}

    public void Shoot(boolean shoot){
        ShooterTop.setSmartCurrentLimit(45);
        ShooterBottom.setSmartCurrentLimit(45);



        if(!shoot){
        ShooterBottom.set(0);
        ShooterTop.set(0);
       
        }
        else if(shoot){
        ShooterTop.set(0.75);
        ShooterBottom.set(-0.75);
      
        }
        else{
        ShooterBottom.set(0);
        ShooterTop.set(0);
 
        }
    }

    public void Shootamp(boolean shootamp){
        ShooterTop.setSmartCurrentLimit(45);
        ShooterBottom.setSmartCurrentLimit(45);
   


        if(!shootamp){
        ShooterBottom.set(0);
        ShooterTop.set(0);
       
        }
        else if(shootamp){
        ShooterTop.set(0.45);
        ShooterBottom.set(-0.45);
      
        }
        else{
        ShooterBottom.set(0);
        ShooterTop.set(0);
 
        }
    }
   
    public void Intake(boolean intake){
        Intake.setSmartCurrentLimit(45);
        if(intake){
           Intake.set(0.4);
        }else{
            Intake.set(0);
        }
    
    }

   public void Backout(boolean backout){
    Intake.setSmartCurrentLimit(45);
     if(backout)
      Intake.set(-0.3);
     else
      Intake.set(0);
   }


public void ShootAuto(){      
    ShooterBottom.set(-0.75);
    ShooterTop.set(0.75); 
}
public void In(){
Intake.set(0.5);
}
public void StopA(){
    ShooterBottom.set(0);
    ShooterTop.set(0);
    Intake.set(0);
}
}
