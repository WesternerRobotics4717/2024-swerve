package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.Constants.ShooterIntakeConstants;
public class ShooterIntakeSubsystem extends SubsystemBase{


    private  CANSparkMax ShooterTop = new CANSparkMax(ShooterIntakeConstants.ShooterTopID, MotorType.kBrushless);
    private  CANSparkMax ShooterBottom = new CANSparkMax(ShooterIntakeConstants.ShooterBottomID, MotorType.kBrushless);
    private  CANSparkMax Intake = new CANSparkMax(ShooterIntakeConstants.IntakeID, MotorType.kBrushless);

    private  DigitalInput IntakeLimitSwitch = new DigitalInput(ShooterIntakeConstants.IntakeLimitSwitchPort);


    
    public ShooterIntakeSubsystem(){

    }

    
    @Override
    public void periodic() {

    }

        

    public void Shoot(boolean shoot){
        ShooterTop.setSmartCurrentLimit(45);
        ShooterBottom.setSmartCurrentLimit(45);
        Intake.setSmartCurrentLimit(45);



        if(shoot){
        ShooterTop.set(0.75);
        ShooterBottom.set(-0.75);
        new WaitCommand(1);
        Intake.set(0.7);
        }else{
        ShooterBottom.set(0.3);
        ShooterTop.set(-0.3);
        Intake.set(0);
        }
    }
   
    public void Intake(boolean intake){
        Intake.setSmartCurrentLimit(45);
        if(intake){
            if(IntakeLimitSwitch.get()){
                Intake.set(0);
            }else{
                Intake.set(0.5);
            }
        }else{
            Intake.set(0);
        }
    
    }

    public void Backout(boolean backout){
        Intake.setSmartCurrentLimit(45);
        if(backout)
            Intake.set(-0.5);
        else
            Intake.set(0);
    }

    

}
