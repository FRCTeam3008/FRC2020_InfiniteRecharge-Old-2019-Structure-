/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;


import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import frc.robot.commands.talonOff;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class TalonSubsystem extends SubsystemBase {

  static TalonSRX testTalon = new TalonSRX(7);
  /**
   * Creates a new TalonSubsystem.
   */
  public void talonForward() 
  {
    testTalon.set(ControlMode.PercentOutput, 0);    
  }

  public void talonBackward() 
  {
    testTalon.set(ControlMode.PercentOutput, 0);    
  }

  public void talonOff()
  {
    testTalon.set(ControlMode.PercentOutput, 0);   
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
     setDefaultCommand(new talonOff());
  }
}
