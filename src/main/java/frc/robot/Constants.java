package frc.robot;


import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.kinematics.SwerveDriveKinematics;
import edu.wpi.first.math.util.Units;

public final class Constants {

    public static final class ModuleConstants {
        public static final double kWheelDiameterMeters = Units.inchesToMeters(4);
        public static final double kDriveMotorGearRatio = 1 / 6.12;
        public static final double kTurningMotorGearRatio = 1 / 18.0;
        public static final double kDriveEncoderRot2Meter = kDriveMotorGearRatio * Math.PI * kWheelDiameterMeters;
        public static final double kTurningEncoderRot2Rad = kTurningMotorGearRatio * 2 * Math.PI;
        public static final double kDriveEncoderRPM2MeterPerSec = kDriveEncoderRot2Meter / 60;
        public static final double kTurningEncoderRPM2RadPerSec = kTurningEncoderRot2Rad / 60;
        public static final double kPTurning = 0.3;
    }

    public static final class DriveConstants {
        

        public static final double kTrackWidth = Units.inchesToMeters(19);
        // Distance between right and left wheels
        public static final double kWheelBase = Units.inchesToMeters(25);
        // Distance between front and back wheels
        public static final SwerveDriveKinematics kDriveKinematics = new SwerveDriveKinematics(
                new Translation2d(kWheelBase / 2, -kTrackWidth / 2),
                new Translation2d(kWheelBase / 2, kTrackWidth / 2),
                new Translation2d(-kWheelBase / 2, -kTrackWidth / 2),
                new Translation2d(-kWheelBase / 2, kTrackWidth / 2));

        public static final int kFrontLeftDriveMotorPort = 2;
        public static final int kBackLeftDriveMotorPort = 7;
        public static final int kFrontRightDriveMotorPort = 12;
        public static final int kBackRightDriveMotorPort = 20;

        public static final int kFrontLeftTurningMotorPort = 10;
        public static final int kBackLeftTurningMotorPort = 8;
        public static final int kFrontRightTurningMotorPort = 4;
        public static final int kBackRightTurningMotorPort = 6;

        public static final boolean kFrontLeftTurningMotorReversed = false;
        public static final boolean kBackLeftTurningMotorReversed = false;
        public static final boolean kFrontRightTurningMotorReversed = false;
        public static final boolean kBackRightTurningMotorReversed = false;

        public static final boolean kFrontLeftDriveEncoderReversed = true;
        public static final boolean kBackLeftDriveEncoderReversed = false;
        public static final boolean kFrontRightDriveEncoderReversed = false;
        public static final boolean kBackRightDriveEncoderReversed = true;

        public static final int kFrontLeftDriveAbsoluteEncoderPort = 3;
        public static final int kBackLeftDriveAbsoluteEncoderPort = 2;
        public static final int kFrontRightDriveAbsoluteEncoderPort = 0;
        public static final int kBackRightDriveAbsoluteEncoderPort = 1;

        public static final boolean kFrontLeftAbsoluteEncoderReversed = false;
        public static final boolean kBackLeftAbsoluteEncoderReversed = true;
        public static final boolean kFrontRightAbsoluteEncoderReversed = false;
        public static final boolean kBackRightAbsoluteEncoderReversed = false;

        public static final double kFrontLeftAbsoluteEncoderOffset = 0.34;
        public static final double kBackLeftAbsoluteEncoderOffset = 0.72;
        public static final double kFrontRightAbsoluteEncoderOffset = 0;
        public static final double kBackRightAbsoluteEncoderOffset = 0.47;

        public static final double kPhysicalMaxSpeedMetersPerSecond = 7;
        public static final double kPhysicalMaxAngularSpeedRadiansPerSecond = 2 * 2 * Math.PI;

        public final static double kTeleDriveMaxSpeedMetersPerSecond = kPhysicalMaxSpeedMetersPerSecond / 2;
        public static final double kTeleDriveMaxAngularSpeedRadiansPerSecond = //
        kPhysicalMaxAngularSpeedRadiansPerSecond / 1.5;
        public static final double kTeleDriveMaxAccelerationUnitsPerSecond = 8;
        public static final double kTeleDriveMaxAngularAccelerationUnitsPerSecond = 3;

        public static final int kSmartCurrentLimitAmt = 45;
    }


    public static final class OIConstants {
       
        public static final int kDriverControllerPort = 0;
        public static final int kSystemsControllerPort = 1;
        public static final int kDriverYAxis = 1;
        public static final int kDriverXAxis = 0;
        public static final int kDriverRotAxis = 4;
        public static final int kDriverFieldOrientedButtonIdx = 1;

        public static final int kShooterButtonIdx = 1;
        public static final int kIntakeButtionIdx = 5;
        public static final int kBackoutButtionIdx = 9;
        public static final int kHangButtionIdx = 8;
        public static final int kShootampButtonIdx = 4;
        public static final int kDefenceButtionIdx = 2;

        public static final double kDeadband = 0.3;
    }

    public static final class ShooterIntakeConstants{
        
        public static final int ShooterTopID = 9;
        public static final int ShooterBottomID = 13;
        public static final int IntakeID = 11;
        public static final int IntakeLimitSwitchPort = 1;


    }

    public static final class ChainHangConstants{

        public static final int kChainHangerID = 15;
        
    }
 
}