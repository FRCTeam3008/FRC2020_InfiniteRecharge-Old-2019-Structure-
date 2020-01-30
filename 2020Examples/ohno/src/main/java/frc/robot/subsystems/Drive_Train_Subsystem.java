/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import frc.robot.Constants;
import frc.robot.RobotContainer;

// import for tank drive
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import frc.robot.commands.ExampleCommand;
import edu.wpi.first.wpilibj.smartdashboard.*;
import frc.robot.commands.TankDriveCommand;
import edu.wpi.first.wpilibj.MotorSafety;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

public class Drive_Train_Subsystem extends SubsystemBase {
  private CANSparkMax MotorR1, MotorR2, MotorR3, MotorL1, MotorL2, MotorL3;

  public DifferentialDrive m_myRobot;
  private SpeedControllerGroup leftMotor, rightMotor;
  
  // Create 6 motors for drivetrain
  public Drive_Train_Subsystem()
  {
    //MotorR1 = new CANSparkMax(Constants.MotorR1ID, MotorType.kBrushless);
    MotorR2 = new CANSparkMax(Constants.MotorR2ID, MotorType.kBrushless);
    MotorR3 = new CANSparkMax(Constants.MotorR3ID, MotorType.kBrushless);
  
    MotorL1 = new CANSparkMax(Constants.MotorL1ID, MotorType.kBrushless);
    MotorL2 = new CANSparkMax(Constants.MotorL2ID, MotorType.kBrushless);
    MotorL3 = new CANSparkMax(Constants.MotorL3ID, MotorType.kBrushless);
    
    leftMotor = new SpeedControllerGroup(MotorL1, MotorL2, MotorL3);
    rightMotor = new SpeedControllerGroup(MotorR2, MotorR3);
    m_myRobot = new DifferentialDrive(leftMotor, rightMotor);
  }

  public void driveOff()
  {
    MotorL1.set(0);
    MotorL2.set(0);
    MotorL3.set(0);

  //MotorR1.set(0);
   MotorR2.set(0);
   MotorR3.set(0);
  }

  public void tankDrive(double speedL, double speedR)
  {
    m_myRobot.tankDrive(speedL, speedR);
  }
}
