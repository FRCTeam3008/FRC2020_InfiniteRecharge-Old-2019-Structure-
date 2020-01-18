/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.OI;
import frc.robot.RobotMap;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import frc.robot.commands.Drive;

/**
 * Add your docs here.
 */
public class Drive_Train_Subsystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  public CANSparkMax MotorR1 = new CANSparkMax(RobotMap.MotorR1ID, MotorType.kBrushless);
  public CANSparkMax MotorR2 = new CANSparkMax(RobotMap.MotorR2ID, MotorType.kBrushless);
  public CANSparkMax MotorR3 = new CANSparkMax(RobotMap.MotorR3ID, MotorType.kBrushless);

  public CANSparkMax MotorL1 = new CANSparkMax(RobotMap.MotorL1ID, MotorType.kBrushless);
  public CANSparkMax MotorL2 = new CANSparkMax(RobotMap.MotorL2ID, MotorType.kBrushless);
  public CANSparkMax MotorL3 = new CANSparkMax(RobotMap.MotorL3ID, MotorType.kBrushless);

  public void theDrive() {
    MotorL1.set(-OI.getLeftStickY());
    MotorL2.set(-OI.getLeftStickY());
    MotorL3.set(-OI.getLeftStickY());

    MotorR1.set(OI.getRightStickY());
    MotorR2.set(OI.getRightStickY());
    MotorR3.set(OI.getRightStickY());
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    setDefaultCommand(new Drive());
  }
}
