/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.RightJoystick;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

/**
 * Add your docs here.
 */
public class RDriveTrain_Subsystem extends Subsystem {
  public CANSparkMax MotorR1 = new CANSparkMax(RobotMap.MotorR1ID, MotorType.kBrushless);
  public CANSparkMax MotorR2 = new CANSparkMax(RobotMap.MotorR2ID,MotorType.kBrushless);
  public CANSparkMax MotorR3 = new CANSparkMax(RobotMap.MotorR3ID,MotorType.kBrushless);
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new RightJoystick());
  }
}
